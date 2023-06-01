package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlashHourPage extends BasePage {
    By closeBtn = By.id("com.arena.banglalinkmela.app.qa:id/ivCloseFlashHour");
    By buyBtn = By.id("com.arena.banglalinkmela.app.qa:id/btnBuy");
    By btnBuyNowOrRecharge = By.id("com.arena.banglalinkmela.app.qa:id/btnBuyNow");
    By btnGoToOffers = By.id("com.arena.banglalinkmela.app.qa:id/btnSeeAll");

    By cardFlashHour = By.id("com.arena.banglalinkmela.app.qa:id/root_linear");

    public void clickCloseBtn() {
        if(isCloseButtonVisible() == true){
            wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
            driver.findElement(closeBtn).click();
        }
    }

    public boolean isCloseButtonVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtn));
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public void clickBuyBtn() {
        driver.findElement(buyBtn).click();
    }

    public void tapFlashHourRechargeOrBuyNow(int itemNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardFlashHour));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnBuyNowOrRecharge));
        if(itemNumber > 2){
            for(int i=0;i< itemNumber-2;i++){
                ScrollRight(cardFlashHour,50);
            }
            List<WebElement> elm = driver.findElements(btnBuyNowOrRecharge);
            elm.get(2).click();
        }
        else{
             List<WebElement> elm = driver.findElements(btnBuyNowOrRecharge);
             elm.get(itemNumber-1).click();
        }
    }

    public void goToProductDetailsScreen() {
        clickCloseBtn();
        clickBuyBtn();
    }

    public void tapGoToOffers(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnGoToOffers));
        driver.findElement(btnGoToOffers).click();
    }

    public String getGoToOffersBtnText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnGoToOffers));
        return driver.findElement(btnGoToOffers).getText();
    }
}
