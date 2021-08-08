package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class DownloadPopUP {
    public static void main(String[] args) throws InterruptedException {
        DownloadPopUPChrome();
        DownloadPopUPFirefox();
    }

        public static void DownloadPopUPFirefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\geckodriver.exe");
        //File Download
        //Create an object of FirefoxProfile class
        FirefoxProfile profile = new FirefoxProfile();
        // Set the Key so that it will not show the file download pop up on the screen
        String key = "browser.helperApps.neverAsk.saveToDisk";
        // Set the type of file which you want to download
        String value = "application/zip";
        //using setPreference() method, change the setting
        profile.setPreference(key, value);
        // 0 - save to desktop, 1 - save to download folder( default), 2 - save to any other location
        profile.setPreference("browser.download.folderList", 2);
        // save the file to the given folder location
        profile.setPreference("browser.download.dir", "D:\\vinayak");
        // Use DesiredCapabilities class to modify the firefox settings as shown below
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        // Launch the firefox browser with the above modified settings
        WebDriver driver = new FirefoxDriver(cap);
        // Enter selenium official website url
        driver.get("http://www.seleniumhq.org/download/");
        Thread.sleep(3000);
        //Use following-sibling axes in Xpath to find the download link for selenium java
        driver.findElement(By.xpath("//tbody/tr[2]/td[6]/a[1]")).click();
    }

    public static void DownloadPopUPChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\driver\\chromedriver.exe");
        //Create Hashmap object and assign the profile settings HashMap<
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "D:\\vinayak");
        //Assign this chromePrefs object with ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        //Create Capability object and assign the option object
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(cap);
        driver.get("http://www.seleniumhq.org/download/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tbody/tr[2]/td[6]/a[1]")).click();
    }
}
