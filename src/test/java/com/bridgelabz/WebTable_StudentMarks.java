package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

public class WebTable_StudentMarks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\WebTable_StudentMarks.html");
//        sumOfMarks(driver);
//        sumWithHashMap(driver);
        sum(driver);
    }

    public static void sumWithHashMap(WebDriver driver) {
        //Subjects and marks hash map
        HashMap<String, Integer> map = new HashMap<>();
        List<WebElement> subjects = driver.findElements(By.xpath("//td[2]"));
        List<WebElement> marks = driver.findElements(By.xpath("//td[3]"));
        int mark = 0;
        for (int index = 0; index <= subjects.size()-1; index++ ) {
            String subject = subjects.get(index).getText();
            String stringMark = marks.get(index).getText();
            try {
                mark = Integer.parseInt(stringMark);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put(subject, mark);
        }
        System.out.println(map);
        int sum = 0;
        for (int f : map.values()) {
            if(f == map.get("Total")){
                continue;
            }
            sum += f;
        }
        System.out.println("Total SUM :" + sum);
        if(sum == map.get("Total")){
            System.out.println("Total SUM of subjects marks equals total");
        }else{
            System.out.println("Total SUM of subjects marks not equals total");
        }
        driver.close();
    }

    public static void sumOfMarks(WebDriver driver) {
//        Count Total number of rows present in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :"+ totalRows);
        //count total number of columns

        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("Total number of columns in the table is :" + totalColumns);

        //Count number of cells present in the table
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is :" + totalCells);

        List<WebElement> marksCols = driver.findElements(By.xpath("//td[3]"));
        int sum = 0;
        for (WebElement value : marksCols){
            String colValue = value.getText();
            try{
                int number = Integer.parseInt(colValue);
                if(number == 100){
                    break;
                }
                System.out.println(" "+number);
                sum = sum + number;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total SUM :" + sum);
        driver.close();
    }
    public static void sum(WebDriver driver){
        //Count Total number of rows present in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :"+ totalRows);
        int sum = 0;
        for(int index = 2; index<= totalRows-1; index++) {
            WebElement markCol = driver.findElement(By.xpath("//tr["+index+"]/td[3]"));
            String mark = markCol.getText();
            try {
                int number = Integer.parseInt(mark);
                System.out.println(" "+number);
                sum = sum + number;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total SUM :" + sum);
        WebElement total = driver.findElement(By.xpath("//tr["+totalRows+"]/td[3]"));
        String totalString = total.getText();
        int totalInt = Integer.parseInt(totalString);
        if(sum == totalInt){
            System.out.println("Total SUM of subjects marks equals total");
        }
        driver.close();
    }
}