package com.opencart.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Locale;

public class Base {
    public static WebDriver driver;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @BeforeSuite(alwaysRun = true)
//    @Parameters(value = {"browser"})
    public void beforeSuite() {
       /* switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }*/
        log.info("Driver is started");

        log.info("Window is maximized");
    }

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"browser"})
    public void beforeTest(String browser) {
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        EnvironmentDetails.loadProperties();
        log.info("The environment details are loaded");
        TestDataUtils.loadProperties();
        log.info("The testdata details are loaded");
        ObjectRepository.loadProperties();
        log.info("The object repsoitory  details are loaded");
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
        log.info("Driver is closed");
    }

    public void loadApplication() {
        try {
            driver.manage().deleteAllCookies();
            driver.get(EnvironmentDetails.getProperty("url"));
            log.info("Application is loaded");
        } catch (Exception e) {
            log.error("Application is not loading due to :: " + e.getMessage());
            Assert.fail("Application is not loading due to :: " + e.getMessage());
        }
    }
}
