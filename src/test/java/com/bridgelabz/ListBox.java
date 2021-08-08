package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ListBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        listBoxExample(driver);
        listBoxInSortedOrder(driver);
        uniqueElementInTheListBox(driver);
    }

    public static void listBoxExample(WebDriver driver) {
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\ListBox.html");
        WebElement list = driver.findElement(By.id("mtr"));
        //Create an object of Select class and pass the address of list box as an argument
        Select s = new Select(list);
        //getOptions() method returns a list of all the elements of the list box
        List<WebElement> options = s.getOptions();
        int size = options.size();
        System.out.println("Number of elements present inside the listbox is : " + size);
        //Print all the elements present in the list box
        for (WebElement webElement : options) {
            String text = webElement.getText();
            System.out.println(text);
        }
        //selectByIndex() selects an element based on the Index, here index starts with 0
        s.selectByIndex(0);
        //selectByValue() method selects an element based on its value attribute.
        s.selectByValue("v");
        /*selectByVisibleText() method selects an element based on the actual text that is
        visible to the user. For instance, if there are multiple Poori present inside the listbox ,
        it will select all the Poori elements.*/
        s.selectByVisibleText("POORI");
        System.out.println("************Print all selected options***********");
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        int size2 = allSelectedOptions.size();
        System.out.println("Number of items that is selected in the list box is : " + size2);
        System.out.println(" Selected items are printed below ");
        for (WebElement webElement : allSelectedOptions) {
            System.out.println(webElement.getText());
        }
        System.out.println("check whether it is a multiple select listbox or not");
        boolean multiple = s.isMultiple();
        System.out.println(multiple + " yes , it is multi select");
        if (multiple) {
            //Print the first selected option in the list box
            WebElement firstSelectedOption = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption.getText() + " is the first selected item in the list box");
            //deselect the item present in 0th index.
            s.deselectByIndex(0);
            //Print the first selected option in the list box
            WebElement firstSelectedOption1 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption1.getText() + " is the first selected item");
            //deselect an item which has an attribute called value and its value is "v"
            s.deselectByValue("v");
            //Print the first selected option in the list box
            WebElement firstSelectedOption2 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption2.getText() + " is the first selected item");
            s.deselectByVisibleText("POORI");
            driver.close();
        }
    }

    public static void listBoxInSortedOrder(WebDriver driver) {
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\ListBox.html");
        WebElement listElement = driver.findElement(By.id("mtr"));
        Select s = new Select(listElement);
        List<WebElement> allOptions = s.getOptions();
        int count = allOptions.size();
        System.out.println(count);
        System.out.println("-----print the values in the list ----");
        ArrayList<String> list = new ArrayList<>();
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(text);
            list.add(text);
        }
        Collections.sort(list);

        System.out.println("-----print the value in sorted order----");
        for (String value : list) {
            System.out.println(value);
        }
        Collections.reverse(list);
        System.out.println("-----print the value in reverse sorted order----");
        for (String value : list) {
            System.out.println(value);
        }
    }

    public static void uniqueElementInTheListBox(WebDriver driver) {
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\ListBox.html");
        WebElement listElement = driver.findElement(By.id("mtr"));
        Select s = new Select(listElement);
        List<WebElement> allOptions = s.getOptions();
        int count = allOptions.size();
        System.out.println(count);
        System.out.println("-----print the values in the list ----");
        HashSet<String> allElements = new HashSet<>();
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(text);
            allElements.add(text);
        }
        System.out.println(allElements);
    }
}
