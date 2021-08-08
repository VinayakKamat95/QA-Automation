package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LaunchFirefoxAndChromeTogether {
    static{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
    }
    WebDriver driver;
    FileInputStream configPath;

    @Test
    @Parameters({"browser", "Username", "Password"})
    public void loginFFandCHROME(String browser, String Username, String Password) throws IOException, InterruptedException {
        //Reporter.log(browser, true);
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        {
            try {
                configPath = new FileInputStream("src/main/java/com/bridgelabz/config/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Properties prop = new Properties();
        prop.load(configPath);
        String url = prop.getProperty("URL");
        driver.get(url);

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(500);
        String title = driver.getTitle();
        System.out.println(title);
        driver.findElement(By.name("firstname")).sendKeys(Username);
        Thread.sleep(500);
        driver.findElement(By.name("lastname")).sendKeys(Password);
        Thread.sleep(500);
        driver.navigate().refresh();
        driver.get(url);

        driver.findElement(By.cssSelector("#email")).sendKeys(Username);
        driver.findElement(By.cssSelector("#pass")).sendKeys(Password);
//        WebElement un = driver.findElement(By.id("t2"));
//        for (int i = 0; i < 10; i++)
//        { un.sendKeys("admin" + i); Thread.sleep(2000);
//            un.clear();
//        }
//        driver.close();
    }
}
