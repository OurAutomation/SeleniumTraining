package com.opencart.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public Object[][] users() {
        String[][] users = new String[2][3];
        users[0][0] = EnvironmentDetails.getProperty("username");
        users[0][1] = EnvironmentDetails.getProperty("password");
        users[0][2] = "true";
        users[1][0] = "invalid";
        users[1][1] = "invalid";
        users[1][2] = "false";
        return users;
    }
}
