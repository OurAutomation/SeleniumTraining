package com.opencart.login;

import com.opencart.utilities.EnvironmentDetails;
import com.opencart.utilities.ObjectRepository;
import com.opencart.utilities.TestDataUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class ValidateLoginFunctionality {
    public static void main(String[] args) {
        EnvironmentDetails.loadProperties();
        TestDataUtils.loadProperties();
        ObjectRepository.loadProperties();
        WebDriverManager.chromedriver().setup();
        //It will check your chrome version and download the respective chrome driver.exe file and it will set the property "webdriver.chrome.driver"
        WebDriver driver = new ChromeDriver();
        //Webdriver is an interface which is implemented by all the browsers like chrome, firefox, safari, IE and Edge
        //This will open chrome driver window
        driver.manage().window().maximize();
        driver.get(EnvironmentDetails.getProperty("url"));
        /*it will navigate you to the given URL
        will not store any cache*/
/*     driver.navigate().to("https://www.opencart.com/index.php?route=account/login");
        will store the cache and navigate
        it will navigate you to the given URL*/
        /*driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();*/
        WebElement loginHeader = driver.findElement(ObjectRepository.getLocator("signIn.button"));
        //It is used for locating or finding single element
        /*List<WebElement> elements= driver.findElements(By.xpath("//h3[text()='Login']"));
        //It is used for finding multiple elements*/
        boolean isDisplayed = loginHeader.isDisplayed();
        //It is used to check whether given element is displayed or not
        if (isDisplayed) {
            System.out.println("Login header is displayed");
        } else {
            System.out.println("Login header is not displayed");
        }
        List<WebElement> products = driver.findElements(ObjectRepository.getLocator("products.card"));
        System.out.println("The number of products are :: " + products.size());
        driver.findElement(ObjectRepository.getLocator("signIn.button")).click();
        driver.findElement(ObjectRepository.getLocator("username.inputBox")).sendKeys(EnvironmentDetails.getProperty("username"));
        driver.findElement(ObjectRepository.getLocator("password.inputBox")).sendKeys(EnvironmentDetails.getProperty("password"));
        driver.findElement(ObjectRepository.getLocator("login.button")).click();
        String loginName = driver.findElement(ObjectRepository.getLocator("accountName.text")).getText();
        if (loginName.equals(TestDataUtils.getProperty("accountName"))) {
            System.out.println("Login happened successfully");
        } else {
            System.out.println("login failed");
        }
        driver.findElement(ObjectRepository.getLocator("logout.button")).click();
//        driver.close(); -- It will close only that single tab
        driver.quit();//-- It will close the complete window
    }
}
