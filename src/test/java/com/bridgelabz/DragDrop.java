package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
        //write xpath for Block 1
         String xp1 = "//h1[.='Block 1']";
         WebElement block1 = driver.findElement(By.xpath(xp1));
         //write xpath for Block 3
         String xp2 = "//h1[.='Block 3']";
         WebElement block3 = driver.findElement(By.xpath(xp2));
        // Create an object of Actions class and pass driver object as an argument
         Actions actions = new Actions(driver);
        // call the dragAndDropBy() method of Actions class
        actions.dragAndDropBy(block1, block3.getLocation().getX()+10, block3.getSize().getHeight()+10).perform();
    }
}
