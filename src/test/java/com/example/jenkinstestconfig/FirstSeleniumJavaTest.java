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
    public void testEasy() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.sv/");
        waitTime();

        String expectedURL="https://www.loc.gov/";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,expectedURL,"The URL is incorrect, redirection fails");
        waitTime();
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
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            default:
                driver = WebDriverManager.chromedriver().create();
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    public void waitTime() throws InterruptedException {
        synchronized (driver){
            driver.wait(4000);
        }
    }
}
