package com.automation.listeners;

import com.automation.base.TestBase;
import com.automation.utils.ExtentManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((TestBase) result.getInstance()).getDriver();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName() + "_FAILED");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = ((TestBase) result.getInstance()).getDriver();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName() + "_PASSED");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver driver = ((TestBase) result.getInstance()).getDriver();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName() + "_SKIPPED");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }


}
