package pages;

import org.openqa.selenium.By;

public class GuestDashboardPage extends BasePage {
	By crossBtn = By.id("com.arena.banglalinkmela.app.qa:id/ivCross");
	By logInRegisterBtn = By.id("com.arena.banglalinkmela.app.qa:id/btnLoginRegister");
	By languageText = By.id("com.arena.banglalinkmela.app.qa:id/tvChooseLanguage");

	By englishLanguage = By.id("com.arena.banglalinkmela.app.qa:id/layoutEnglish");

	public String getLanguageText() {
		return driver.findElement(languageText).getText();
	}

	public void clickCrossBtn() {
		driver.findElement(crossBtn).click();
	}

	public void clickLogInRegisterBtn() {
		driver.findElement(logInRegisterBtn).click();
	}

	public void selectEnglishLanguage() {
		driver.findElement(englishLanguage).click();
	}

	public void goToOtpPage() {
		selectEnglishLanguage();
		clickLogInRegisterBtn();
	}
}
