package com.opencart.login;

import com.opencart.pageobjects.LoginPage;
import com.opencart.utilities.*;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Login_Sanity extends Base {
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        loginPage = new LoginPage(driver);
        loadApplication();
        loginPage.login("", "");
    }

    @Test(priority = 0, invocationCount = 3, description = "it will validate sign in button is present or not", enabled = true, groups = {"sanity", "regression"})
    public void validateLoginButtonIsPresent() {
        WebElement loginButton = driver.findElement(ObjectRepository.getLocator("signIn.button"));
        Assert.assertTrue(loginButton.isDisplayed(), "The login button is not displayed");
        log.info("Login button is present");
    }

    @Test(priority = 1, description = "I will validate the number of products displayed are matching with the expected n umber of products", groups = {"sanity"})
    public void validateTheProducts() {
        List<WebElement> products = driver.findElements(ObjectRepository.getLocator("products.card"));
        log.info("The number of products are :: " + products.size());
        Assert.assertEquals(products.size(), 7, "The products are not matching");
        log.info("The number of products displayed are matching");
    }

    @Test(priority = 2, invocationCount = 1, groups = {"regression"}, dependsOnMethods = "validateLoginButtonIsPresent", dataProvider = "users", description = "Validating the login functionality with different test data", dataProviderClass = DataProviders.class)
    public void validateLoginFunctionality(String username, String password, String status) throws InterruptedException {
        loadApplication();
        driver.findElement(ObjectRepository.getLocator("signIn.button")).click();
        driver.findElement(ObjectRepository.getLocator("username.inputBox")).sendKeys(username);
        driver.findElement(ObjectRepository.getLocator("password.inputBox")).sendKeys(password);
        driver.findElement(ObjectRepository.getLocator("login.button")).click();

        if (Boolean.valueOf(status)) {
            String loginName = driver.findElement(ObjectRepository.getLocator("accountName.text")).getText();
            log.info("The user logged in is :: " + loginName);
            Assert.assertEquals(loginName, TestDataUtils.getProperty("accountName"), "The login functionality is not working. ");
            driver.findElement(ObjectRepository.getLocator("logout.button")).click();
        } else {
            Assert.assertTrue(driver.findElement(ObjectRepository.getLocator("invalidUsername.error")).isDisplayed());
        }
        log.info("The login functionality is working as expected");

    }

    @AfterClass
    public void logout() {
        log.info("Logging out of the application");

    }
}
