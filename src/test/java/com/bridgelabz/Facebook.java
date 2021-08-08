package com.bridgelabz;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Facebook {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Browser Name : ");
        String inputBrowser = scanner.next();
        if (inputBrowser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        Thread.sleep(100);
        driver.manage().window().maximize();
        Thread.sleep(100);
        driver.get("https://en-gb.facebook.com/");
        System.out.println(driver.getTitle());

//        // Open new child window within the main window
////        driver.get("https://demoqa.com/browser-windows");
////        driver.findElement(By.id("windowButton")).click();
////        driver.findElement(By.id("messageWindowButton")).click();
//
//        //Get handles of the windows
////        String mainWindowHandle = driver.getWindowHandle();
////        System.out.println(mainWindowHandle);
////        Set<String> allWindowHandles = driver.getWindowHandles();
////        System.out.println(allWindowHandles);
//        // Here we will check if child window has other child windows and will fetch the heading of the child window
////        for (String ChildWindow : allWindowHandles) {
////            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
////                driver.switchTo().window(ChildWindow);
////                WebElement text = driver.findElement(By.id("sampleHeading"));
////                System.out.println("Heading of child window is " + text.getText());
////            }
////        }
////
//
////        //use to move cursor on particular element and passing control
////
////        WebElement un = driver.findElement(By.linkText("Create New Account"));
////        int xaxis = un.getLocation().x;
////        System.out.println(xaxis);
////        int yaxis=un.getLocation().y;
////        System.out.println(yaxis);
////
////        int width = un.getSize().width;
////        System.out.println(width);
////        int height= un.getSize().height;
////        System.out.println(height);
////
////        Robot r =new Robot();
////        r.mouseMove(xaxis+width/2, yaxis+height/2+120);
////        System.out.println(xaxis+width/2);
////        System.out.println(yaxis+height/2+120);
        
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(500);
        String title = driver.getTitle();
        System.out.println(title);
        driver.findElement(By.name("firstname")).sendKeys("Vinayak");
        Thread.sleep(500);
        driver.findElement(By.name("lastname")).sendKeys("Kamat");
        Thread.sleep(500);
        driver.findElement(By.name("reg_email__")).sendKeys("vinayakkamat@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vinayakkamat@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.id("password_step_input")).sendKeys("Face123!");
        Thread.sleep(500);
//        driver.findElement(By.id("day")).sendKeys("21");
//        driver.findElement(By.id("month")).sendKeys("Sep");
//        driver.findElement(By.id("year")).sendKeys("1995");
        Select selDate = new Select(driver.findElement(By.id("day")));
        Select selMonth = new Select(driver.findElement(By.id("month")));
        Select selYear = new Select(driver.findElement(By.id("year")));

        selDate.selectByVisibleText("21");
        selMonth.selectByVisibleText("Sep");
        selYear.selectByVisibleText("1995");
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        String text = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/p[1]")).getText();
        System.out.println(text);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File DestinationFile = new File("./screenshots/" + "facebook-register-" + System.currentTimeMillis() + ".png");
        FileHandler.copy(SourceFile, DestinationFile);

//        String windowHandle = driver.getWindowHandle();
//        System.out.println(windowHandle);
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        System.out.println(allWindowHandles);
//        Iterator<String> iterator = allWindowHandles.iterator();
//
//        while (iterator.hasNext()) {
//            String childWindow = iterator.next();
//            if (!windowHandle.equalsIgnoreCase(childWindow)) {
//                driver.switchTo().window(childWindow);
//                driver.get("https://www.instagram.com/");
//            }
//        }
//        driver.close();
        driver.quit();
    }
}