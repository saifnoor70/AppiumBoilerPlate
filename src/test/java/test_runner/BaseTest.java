package test_runner;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import setup.DriverManger;
import setup.DriverSetup;
import utils.Listener;
import utils.ScreenshotHelper;

import java.lang.reflect.Method;

@Listeners(Listener.class)
public class BaseTest {

    @BeforeMethod()
    public void setUp(Method method) {
        System.out.println("Start Test: ============> " + method.getName());
        DriverSetup.startDriver("android");

    }

    @AfterMethod()
    public void tearDown(ITestResult result, Method method) {
        if (result.getStatus() == ITestResult.FAILURE)
            ScreenshotHelper.capture(DriverManger.getDriver(), result.getName());
        DriverSetup.stopDriver();
        System.out.println("End Test: ============> " + method.getName());
    }

    public void sleep(int timeout) {
        try {
            Thread.sleep(1000L * timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
