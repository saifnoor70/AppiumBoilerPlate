package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.DriverManger;

import java.io.File;

public class Listener implements ITestListener {
    AppiumDriver driver;
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    @Override
    public void onStart(ITestContext iTestContext) {
        htmlReporter = new ExtentSparkReporter(new File(Resource.resultFolderPath + "/MyBlResult" + "_" + Resource.autVersion + ".html"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Machine", System.getProperty("os.name"));
        extent.setSystemInfo("Platform Name", "Android");
        extent.setSystemInfo("Application Name", "MyBL App");
        extent.setSystemInfo("Application Version", Resource.autVersion);
        extent.setSystemInfo("Script developed by", "Saif Noor (saifalnoor70@gmail.com)");

        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Automation Test Results of MyBL App" + Resource.autVersion + " Android App");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        driver = DriverManger.getDriver();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName(), "Passed");
        test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(driver.getScreenshotAs(OutputType.BASE64)).build());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName(), "Failed");
        test.log(Status.FAIL, result.getThrowable().getLocalizedMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(driver.getScreenshotAs(OutputType.BASE64)).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName(), "Failed");
        test.log(Status.SKIP, result.getThrowable().getLocalizedMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(driver.getScreenshotAs(OutputType.BASE64)).build());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
}