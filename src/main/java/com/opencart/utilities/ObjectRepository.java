package com.opencart.utilities;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ObjectRepository {

    static Properties prop = new Properties();

    public static void loadProperties() {
        try {
            File propertiesFile = new File(Constants.objectRepositoryDetailsPropFile);
            prop.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static By getLocator(String propertyName) {
        String[] locators = prop.getProperty(propertyName).split(":");
        String locatorType = locators[0];
        String locatorValue = locators[1];
        switch (locatorType.toLowerCase(Locale.ROOT)) {
            case "id":
                return By.id(locatorValue);
            case "class":
            case "classname":
                return By.className(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "tagname":
                return By.tagName(locatorValue);
            case "linktext":
                return By.linkText(locatorValue);
            case "partiallinktext":
                return By.partialLinkText(locatorValue);
            case "css":
            case "cssselector":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
        }
        return null;
    }
}
