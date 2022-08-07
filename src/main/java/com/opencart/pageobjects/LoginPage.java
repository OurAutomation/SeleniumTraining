package com.opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String username, String password) {
        driver.findElement(By.xpath("")).sendKeys(username);
    }
    public void clickOnForgotPassword() {

    }
}
