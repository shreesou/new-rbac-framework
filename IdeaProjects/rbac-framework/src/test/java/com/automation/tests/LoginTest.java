package com.automation.tests;

import com.automation.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyLogin() {

        // Example validation (change as per your app)
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);


        Assert.assertTrue(currentUrl.contains("your-organizations"),
                "Login failed or your-organizations not loaded");
    }
}