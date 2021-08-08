package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);

//        //Launching Sample site
//        driver.get("https://artoftesting.com/samplesiteforselenium");
//
//        //Right click in the TextBox
//        Actions action = new Actions(driver);
//        WebElement searchBox = driver.findElement(By.id("fname"));
//        action.contextClick(searchBox).perform();
//
//        //Thread.sleep just for user to notice the event
//        Thread.sleep(3000);

//        driver.get("http://demo.guru99.com/test/newtours/");
//        WebElement link_Home = driver.findElement(By.linkText("Home"));
//        WebElement td_Home = driver
//                .findElement(By
//                        .xpath("//html/body/div"
//                                + "/table/tbody/tr/td"
//                                + "/table/tbody/tr/td"
//                                + "/table/tbody/tr/td"
//                                + "/table/tbody/tr"));
//
//        Actions builder = new Actions(driver);
//        Action mouseOverHome = builder
//                .moveToElement(link_Home)
//                .build();
//
//        String bgColor = td_Home.getCssValue("background-color");
//        System.out.println("Before hover: " + bgColor);
//        mouseOverHome.perform();
//        bgColor = td_Home.getCssValue("background-color");
//        System.out.println("After hover: " + bgColor);

        driver.get("http://www.facebook.com/");
        WebElement txtUsername = driver.findElement(By.id("email"));

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();

        seriesOfActions.perform() ;

//        driver.get("http://demo.guru99.com/test/drag_drop.html");
//
//        Thread.sleep(500);
//        //Element which needs to drag.
//        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
//        Thread.sleep(500);
//        //Element on which need to drop.
//        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));
//        Thread.sleep(500);
//        //Using Action class for drag and drop.
//        Actions act=new Actions(driver);
//
//        //Dragged and dropped.
//        act.dragAndDrop(From, To).build().perform();
    }
}
