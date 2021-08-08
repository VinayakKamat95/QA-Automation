package com.bridgelabz;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("file:///C:/Users/Admin/IdeaProjects/Facebook/FrontEnd/DisableTextBox.html");

        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(500);
        js.executeScript("document.getElementById('t1').value='admin'");
        Thread.sleep(1000);
    }
}
