package com.automation.base;

import com.automation.factory.DriverFactory;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentManager;
import com.automation.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected LoginPage loginPage;

    @BeforeSuite
    public void setupSuite() {

        String browser = ConfigReader.getProperty("browser");

        driver = DriverFactory.initDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setupTest(Method method) {
        ExtentManager.createTest(method.getName());
        System.out.println("=== BeforeMethod: Open URL + Login ===");

        String url = ConfigReader.getProperty("url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Open URL
        driver.get(url);


        loginPage = new LoginPage(driver);


        loginPage.login(username, password);


        // loginPage.login(password);
        // loginPage.clickLogin();
    }

    @AfterMethod
    public void logout() {

        System.out.println("=== AfterMethod: Logout ===");

        //driver.manage().deleteAllCookies();
        LogoutPage logoutpage = new LogoutPage(driver);
        logoutpage.logout();



        ExtentManager.getTest().info("Logout successful");


        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "logout");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    //@AfterSuite
    //public void tearDown() {

      //  if (driver != null) {
        //    driver.quit();
        //}
    //}
      @AfterSuite
      public void tearDown() {
          ExtentManager.flush();
          try {
              File reportFile = new File("reports/extent-report.html");
                 if(reportFile.exists()){
                     Desktop.getDesktop().browse(reportFile.toURI());
                 }
                 else {
                     System.out.println("Extent report not found at: " + reportFile.getAbsolutePath());
                 }


              //Desktop.getDesktop().browse(new File("reports/extent-report.html").toURI());
          }
          catch(IOException e) {
              e.printStackTrace();
          }
      }

}