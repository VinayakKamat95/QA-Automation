package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AutoIt {
    public static void UploadFileAutoIT() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("https://www.monsterindia.com/seeker/registration");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(text(),'Choose CV')]")).click();
        Thread.sleep(1000);
        // below line execute the AutoIT script .
        Runtime.getRuntime().exec("C:\\Users\\Admin\\IdeaProjects\\Facebook\\AutoIt\\FileUpload.exe");
        Thread.sleep(500);
        driver.close();
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        UploadFileAutoIT();

    }
}
