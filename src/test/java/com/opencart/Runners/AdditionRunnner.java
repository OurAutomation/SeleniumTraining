package com.opencart.Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com.opencart/Features",glue = {"com.opencart.StepDefinition"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = "")
public class AdditionRunnner extends AbstractTestNGCucumberTests {

}
