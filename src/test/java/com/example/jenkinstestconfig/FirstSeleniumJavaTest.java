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
        if (browser != "" && browser != null) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = WebDriverManager.chromedriver().create();
            }
            else if (browser.equalsIgnoreCase("firefox")) {
                driver = WebDriverManager.firefoxdriver().create();
            }
            else if (browser.equalsIgnoreCase("edge")) {
                driver = WebDriverManager.edgedriver().create();
            }
            else {
                System.out.println("Invalid option Selected hence defaulting to chrome");
                driver = WebDriverManager.chromedriver().create();
            }
        }
        else {
            browser = "Chrome";
            driver = WebDriverManager.chromedriver().create();
        }
    }



//        switch(browser) {
//            case "edge":
//                driver = WebDriverManager.edgedriver().create();
//                break;
//            case "firefox":
//                driver = WebDriverManager.firefoxdriver().create();
//                break;
//            default:
//                driver = WebDriverManager.chromedriver().create();
//        }



    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
