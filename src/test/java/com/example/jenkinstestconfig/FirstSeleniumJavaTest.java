package com.example.jenkinstestconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSeleniumJavaTest {
    private WebDriver driver;

    @Test
    public void testEasy(){
        driver.get("https://testautomationu.applitools.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Test Automation University | Applitools"));
    }

    @BeforeTest
    public void beforeTest(){
        driver = WebDriverManager.firefoxdriver().create();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
