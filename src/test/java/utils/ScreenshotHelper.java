package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    public static String capture(AppiumDriver driver, String screenShotName) {
        try {
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenShotName + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
