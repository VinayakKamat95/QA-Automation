package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("C:\\Users\\Admin\\IdeaProjects\\Facebook\\FrontEnd\\CheckBox.html");
        Thread.sleep(500);
        List<WebElement> webElements = driver.findElements(By.xpath("//input"));
        System.out.println(webElements.size());

        for (int index = 0; index <= webElements.size()-1; index++){
            //index
            webElements.get(index).click();
            Thread.sleep(100);
        }

        for (int index = webElements.size()-1; index >= 0; index--){
            webElements.get(index).click();
            Thread.sleep(100);
        }

        webElements.get(0).click();
        webElements.get(webElements.size()-1).click();

    }
}
