package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("https://www.google.com/");
        Thread.sleep(500);
        //Enter Selenium in google search text box
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(2000);
        List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        int count = allOptions.size();
        System.out.println("Number of values present in the dropdown is :"+count);
        String expectedValue="selenium interview questions";
        //Print all the auto suggestion values
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(" "+text);
            //Click on Java Interview Questions
            if (text.equalsIgnoreCase(expectedValue)) {
                option.click();
                break;
            }
        }
    }
}
//div[@role='option']