package com.example.jenkinstestconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSeleniumJavaTest {
    private WebDriver driver;
    String browser = System.getProperty("browser");

    @Test
    public void testEasy(){
        driver.get("https://testautomationu.applitools.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Test Automation University | Applitools"));
    }

    @BeforeTest
    public void beforeTest() {
        switch(browser) {
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                driver = WebDriverManager.chromedriver().create();
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
