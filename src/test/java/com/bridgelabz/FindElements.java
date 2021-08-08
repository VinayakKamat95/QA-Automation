package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\page1.html");
        Thread.sleep(500);
        List<WebElement> webElements = driver.findElements(By.tagName("input"));
        for (WebElement element : webElements){
            System.out.println(element.getTagName());
            System.out.println(element.getAttribute("type"));
        }
    }

}
