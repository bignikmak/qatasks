package main.java.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("webDriver");
        new Screenshot(driver).saveScreenshot(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("webDriver");
        new Screenshot(driver).saveScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("webDriver");
        new Screenshot(driver).saveScreenshot(iTestResult);
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
