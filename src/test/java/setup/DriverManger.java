package setup;

import io.appium.java_client.AppiumDriver;

public class DriverManger {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void setDriver(AppiumDriver driver) {
        DriverManger.driver = driver;
    }
}
