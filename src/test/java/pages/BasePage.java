package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverManger;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BasePage {
    public AppiumDriver driver = DriverManger.getDriver();

    public Dimension dim = driver.manage().window().getSize();
    public int x = dim.getWidth();
    public int y = dim.getHeight();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public WebDriverWait waitless = new WebDriverWait(driver, Duration.ofMinutes(1));


    public void verticalSwipe(){
        verticalSwipe(driver, x/2, (int)(y*.8), (int)(y*.3), 500);
    }

    public void verticalSwipe(AppiumDriver driver, int centerX, int startY, int endY, int swipeDurationInMS) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(swipeDurationInMS), PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(swipe));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void HorizontalScroll(AppiumDriver driver, int startX, int endX, int centerY, int swipeDurationInMS) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, centerY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(swipeDurationInMS), PointerInput.Origin.viewport(), endX, centerY));
        swipe.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(swipe));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ScrollRight(By scrollElement,int topToMiddleHeight){
        int y= driver.findElement(scrollElement).getLocation().getY() + topToMiddleHeight;
        HorizontalScroll(driver,(int)(x*.7),(int)(x*.2),y,1000);
    }

    public void sleep(int timeout){
        try {
            Thread.sleep(1000L*timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int customSplit(String string, String regex,int limit){
        String prepaidBalance[] = string.split(regex,limit);
        int a = Integer.parseInt(prepaidBalance[limit]);
        return a;
    }
}
