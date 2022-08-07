package com.opencart.application;

import com.opencart.utilities.Base;
import com.opencart.utilities.EnvironmentDetails;
import com.opencart.utilities.TestDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Application_Sanity extends Base {

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
       loadApplication();
    }

    @Test(priority = 0,groups = {"sanity"},description = "Validating the page title")
    public void validateThePageTitle() {
        String title = driver.getTitle();
        log.info("The tile of the page is :: " + title);
        Assert.assertEquals(title, TestDataUtils.getProperty("applicationTitle"),"The title is not matching. ");
    }

    @Test(priority = 1,groups = {"regression"},description = "Validating the URL")
    public void validatePageUrl() {
        String url = driver.getCurrentUrl();
        log.info("The current URL is :: " + url);
        Assert.assertEquals(url,EnvironmentDetails.getProperty("url"),"The page is getting re-directed.");
    }
}
