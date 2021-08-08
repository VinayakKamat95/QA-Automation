package com.bridgelabz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM {
    ///        Declaration
    @FindBy(xpath="//input[@id='email']")
    private  WebElement unTB;
    @FindBy(xpath="//input[@id='pass']")
    private  WebElement pwTB;
    @FindBy(tagName="button")
    private  WebElement loginBtn;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("https://en-gb.facebook.com/");
        POM pom = new POM();
        pom.LoginPage(driver);
        pom.setUsername("vinayak");
        pom.setPassword("kamat");
        pom.clickLogin();
    }
    //Initialisation
    public void LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Utilisation
    public void setUsername(String un) {
        unTB.sendKeys(un);
    }

    public void setPassword(String pw) {
        pwTB.sendKeys(pw);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
