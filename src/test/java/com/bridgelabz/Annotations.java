package com.bridgelabz;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Annotations {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("--------beforeMethod-------");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("--------afterMethod-------");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("--------beforeClass-------");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("--------afterClass-------");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("--------beforeTest-------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("--------afterTest-------");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("--------beforeSuite-------");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("--------afterSuite-------");
    }

    @Test(priority = 1)
    public void test() {
        System.out.println("--------Test---------");
    }

    @Test(groups = "Login")
    public void userName(){
        System.out.println("vinayak");
    }

    @Test(groups = "Login", invocationCount = 2)
    public void userPass(){
        System.out.println("kamat");
    }

    @Test(groups = "Upload")
    public void FileName(){
        System.out.println("upload1");
    }

    @Test(groups = "Upload")
    public void FileOperation(){
        System.out.println("upload2");
    }
}
