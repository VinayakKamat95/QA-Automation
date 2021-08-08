package com.bridgelabz;

import com.bridgelabz.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ExcelTestNg {
    private static WebDriver driver;

//    @DataProvider(name = "Authentication")
//    public static Object[][] credentials() {
//        // The number of times data is repeated, test will be executed the same no. of times
//        // Here it will execute two times
//        return new Object[][]{{"testuser_1", "Test@123"}, {"testuser_1", "Test@123"}};
//    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://en-gb.facebook.com/");
    }

    // Here we are calling the Data Provider object with its Name
    @Test(dataProvider = "Authentication")
    public void test(String sUsername, String sPassword) {

        driver.findElement(By.linkText("Create New Account")).click();
        // Argument passed will be used here as String Variable
        driver.findElement(By.name("firstname")).sendKeys(sUsername);
        driver.findElement(By.name("lastname")).sendKeys(sPassword);
//        driver.quit();
    }

    @DataProvider
    public Object[][] Authentication() {
        Object[][] testObjArray = ExcelUtils.getTableArray("Data/Book1.xlsx","Sheet1");
        System.out.println(Arrays.deepToString(testObjArray));
        return (testObjArray);
    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.close();
//    }
}
