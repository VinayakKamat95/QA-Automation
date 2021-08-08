package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        Thread.sleep(100);
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("https://www.bigbasket.com/");
        Thread.sleep(1000);

        //driver.findElement(By.cssSelector("#input")).sendKeys("Vinayak");
        String id = driver.findElement(By.xpath("//body/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/a[1]")).getAttribute("title");
        //driver.findElement(By.partialLinkText("Shop by Catego")).click();
        System.out.println(id);
        //Thread.sleep(500);
        //driver.findElement(By.cssSelector("ul#navBarMegaNav>li:nth-of-type(6)")).click();


    }
}
