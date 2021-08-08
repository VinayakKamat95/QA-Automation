package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\page2.html");
        driver.switchTo().frame(0);
        driver.findElement(By.id("t1")).sendKeys("a");
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.id("t2")).sendKeys("a");
//using id attribute of the frame -string
        driver.switchTo().frame("f1");
        Thread.sleep(1000);
        driver.findElement(By.id("t1")).sendKeys("b");
//        driver.switchTo().defaultContent();
//        Thread.sleep(1000);
//        driver.findElement(By.id("t2")).sendKeys("b");
//using name attribute of the frame -string
//        driver.switchTo().frame("n1");
//        Thread.sleep(1000);
//        driver.findElement(By.id("t1")).sendKeys("c");
//        driver.switchTo().defaultContent();
//        Thread.sleep(1000);
//        driver.findElement(By.id("t2")).sendKeys("c");
////using address of the frame -webelement
//        WebElement f = driver.findElement(By.className("c1"));
//        driver.switchTo().frame(f);
//        Thread.sleep(1000);
//        driver.findElement(By.id("t1")).sendKeys("d");
//        driver.switchTo().defaultContent();
//        Thread.sleep(1000);
//        driver.findElement(By.id("t2")).sendKeys("d");
//        driver.close();
    }
}