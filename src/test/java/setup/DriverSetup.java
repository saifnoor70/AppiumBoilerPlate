package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    public static void startAndroidDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "vivo Y01");
        caps.setCapability("udid", "98756435790008Q");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("app", System.getProperty("user.dir") + "/MyBL-qaRelease-23-03-21T15-35-10.7.0-beta34.apk");
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("fullReset", true);
        caps.setCapability("noReset", false);
        try {
            AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            DriverManger.setDriver(driver);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void startAndroidDriver(String Simulator) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("app", System.getProperty("user.dir") + "/MyBL-qaRelease-23-05-31T11-52-10.10.0-beta03.apk");
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("fullReset", true);
        caps.setCapability("noReset", false);
        try {
            AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            DriverManger.setDriver(driver);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }



    public static void startIOSDriver(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("platformVersion", "15.5");
        cap.setCapability("deviceName", "iPhone 11");
        //cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
        cap.setCapability("app","/Users/saifnoor/Downloads/proverbial_ios.ipa");

        try {
            IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            DriverManger.setDriver(driver);
        } catch (Exception exp) {
            exp.printStackTrace();
        }


    }

    public static void startDriver(String platform){
        if(platform == "android"){
            startAndroidDriver("Simulator");
        }
        else if (platform == "ios"){
            startIOSDriver();
        }
    }

    public static void stopDriver() {
        if (DriverManger.getDriver() != null)
            DriverManger.getDriver().quit();
    }
}
