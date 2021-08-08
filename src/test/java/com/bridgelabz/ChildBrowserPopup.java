package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildBrowserPopup {
    public static void main(String[] args) throws InterruptedException {
        ChildBrowser();
        Naukri();
    }

    public static void ChildBrowser() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //Launching the site.
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        String MainWindow=driver.getWindowHandle();
        System.out.println(MainWindow);
        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        System.out.println(s1);
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();
            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                Thread.sleep(500);
                driver.switchTo().window(ChildWindow);
                System.out.println(ChildWindow);
                Thread.sleep(500);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
    public static void Naukri(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.naukri.com/");
        //using getWindowHandles(), get a set of window handle IDs
         Set<String> allWindowHandles = driver.getWindowHandles();
         //using size(), get the count of total number of browser windows
         int count = allWindowHandles.size();
         System.out.println("Number of browser windows opened on the system is : "+ count);
         for (String windowHandle : allWindowHandles) {
             //switch to each browser window
              driver.switchTo().window(windowHandle);
              String title = driver.getTitle();
              //print the window handle id of each browser window
         System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);
        //close all the browsers one by one
         driver.close();
        }
    }
}
