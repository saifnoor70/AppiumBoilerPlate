package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Resource;

public class OtpAndPasswordLoginPage extends BasePage {
	By inputNumber = By.id("com.arena.banglalinkmela.app.qa:id/etNumber");
	By otpBtn = By.id("com.arena.banglalinkmela.app.qa:id/btnGetOtp");
	By passwordBtn = By.id("com.arena.banglalinkmela.app.qa:id/tvPassword");
	By inputPassword = By.id("com.arena.banglalinkmela.app.qa:id/etPassword");
	By btnLogin = By.id("com.arena.banglalinkmela.app.qa:id/btnLogin");
	By passwordForgotBtn = By.id("com.arena.banglalinkmela.app.qa:id/btnForgotPassword");

	public void toggleToPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBtn));
		driver.findElement(passwordBtn).click();
	}

	public void setPhoneNumber(String phoneNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputNumber));
		driver.findElement(inputNumber).sendKeys(phoneNumber);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
		driver.findElement(inputPassword).sendKeys(password);
	}

	public void clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		driver.findElement(btnLogin).click();
	}

	public void clickPasswordForgotBtn() {
		driver.findElement(passwordForgotBtn).click();
	}

	public void logInWithPassword(String msisdn, String password) {
		GuestDashboardPage guestDashboardPage = new GuestDashboardPage();
		guestDashboardPage.goToOtpPage();
		toggleToPassword();
		setPhoneNumber(msisdn);
		setPassword(password);
		clickLoginBtn();
	}

	public void logInWithPassword(String Type){
		if(Type == "PREPAID"){
		logInWithPassword(Resource.prepaidMsisdnHavingNoLoan[0],Resource.prepaidMsisdnHavingNoLoan[1]);
		} else if (Type == "POSTPAID") {
			logInWithPassword(Resource.number290,Resource.pass290);
		}
		else if (Type == "PREPAID_LOAN_DUE"){
			logInWithPassword(Resource.prepaidMsisdnHavingLoan[0],Resource.prepaidMsisdnHavingLoan[1]);
		} else if (Type == "PREPAID_LOAN_OFFER") {
			logInWithPassword(Resource.number372,Resource.pass372);
		} else if (Type == "POSTPAID_346") {
			logInWithPassword(Resource.num346,Resource.pass346);
		}
		else if (Type == "PREPAID_LOW_BALANCE") {
			logInWithPassword(Resource.prepaidMsisdnHavingLowBalance[0],Resource.prepaidMsisdnHavingLowBalance[1]);
		}
		else if (Type == "PREPAID_HIGH_BALANCE") {
			logInWithPassword(Resource.prepaidMsisdnHavingHighBalance[0],Resource.prepaidMsisdnHavingHighBalance[1]);
		}

	}
}
