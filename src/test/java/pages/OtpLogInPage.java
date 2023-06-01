package pages;

import org.openqa.selenium.By;

public class OtpLogInPage extends BasePage {
    By inputNumberField = By.id("com.arena.banglalinkmela.app.qa:id/etNumber");
    By getOtpBtn = By.id("com.arena.banglalinkmela.app.qa:id/btnGetOtp");
    By togglePassword = By.id("com.arena.banglalinkmela.app.qa:id/tvPassword");
    By inputPassword = By.id("com.arena.banglalinkmela.app.qa:id/etPassword");
    By logInButton = By.id("com.arena.banglalinkmela.app.qa:id/btnLogin");

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputNumberField).sendKeys(phoneNumber);
    }

    public void clickOtpBtn() {
        driver.findElement(getOtpBtn).click();
    }

    public void clickLogInBtn(){
        driver.findElement(logInButton).click();
    }

    public void setPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void toggleToPassword(){
        driver.findElement(togglePassword).click();
    }

    public void logInWithPassword(String msisdn, String password){
        setPhoneNumber(msisdn);
        setPassword(password);
        clickLogInBtn();
    }

    public void loginWithOTP(String msisdn) {
        setPhoneNumber(msisdn);
        clickOtpBtn();
    }
}
