package com.opencart.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    int i = 0;

    @Override
    public boolean retry(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE) {
            if (i < 3) {
                i++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
