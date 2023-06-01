package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.naming.directory.SearchResult;
import java.util.List;

public class BalanceCardHomePage extends BasePage {
    By txtCurrentBalance = By.id("com.arena.banglalinkmela.app.qa:id/tvCurrentBalance");
    By tkPrefixTextBeforeMA = By.id("com.arena.banglalinkmela.app.qa:id/tkSign");
    By txtValidTill = By.id("com.arena.banglalinkmela.app.qa:id/tvValidity");
    By txtCreditLimit = By.id("com.arena.banglalinkmela.app.qa:id/tvCreditLimit");
    By buttonRechargeGreen = By.id("com.arena.banglalinkmela.app.qa:id/btnRecharge");
    By buttonRechargeRed = By.id("com.arena.banglalinkmela.app.qa:id/btnLowBalanceRecharge");
    By buttonPayBill = By.id("com.arena.banglalinkmela.app.qa:id/btnPayBill");
    By internetBalanceArea = By.id("com.arena.banglalinkmela.app.qa:id/clInternetDetailsPrepaid");
    By minutesDetailsArea = By.id("com.arena.banglalinkmela.app.qa:id/clMinuteDetailsPrepaid");
    
    By smsDetailsArea = By.id("com.arena.banglalinkmela.app.qa:id/clSmsDetailsPrepaid");

    By btnHamburger = By.id("com.arena.banglalinkmela.app.qa:id/action_hamburger");

    By txtSms = By.id("com.arena.banglalinkmela.app.qa:id/tvSMSTitle");

    By txtRecharge = By.id("com.arena.banglalinkmela.app.qa:id/btnRecharge ");
    By balancePrepaidTxt = By.id("com.arena.banglalinkmela.app.qa:id/tvBalancePrepaid");
    By totalOutstandingBalancePostpaid = By.id("com.arena.banglalinkmela.app.qa:id/tvBalancePostpaid");
    By txtLoanDue = By.id("com.arena.banglalinkmela.app.qa:id/tvLoanRunningMsg");
    By loanDueDescription = By.id("com.arena.banglalinkmela.app.qa:id/tvLoanText");
    By getAdvanceLoanButton = By.id("com.arena.banglalinkmela.app.qa:id/tvBalanceLow");

    By navRail = By.id("com.arena.banglalinkmela.app.qa:id/rvNavigationRail");
    By searchIcon = By.id("com.arena.banglalinkmela.app.qa:id/ivSearch");
    By searchInput = By.id("com.arena.banglalinkmela.app.qa:id/etSearch");
    By searchResult = By.id("com.arena.banglalinkmela.app.qa:id/tv_str");
    By cardLoanDue = By.id("com.arena.banglalinkmela.app.qa:id/ll_loan_info");
    By txtLoanDueAmount = By.id("com.arena.banglalinkmela.app.qa:id/tvLoanAmountWithTk");
    By txtGetXTkAdvanceLoanInLoanOffercard = By.id("com.arena.banglalinkmela.app.qa:id/tvBalanceLow");
    public String getCurrentBalanceTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCurrentBalance));
       return driver.findElement(txtCurrentBalance).getText();
    }

    public String getTkPrefixTextOfMA(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tkPrefixTextBeforeMA));
        return driver.findElement(tkPrefixTextBeforeMA).getText();
    }

    public String getBtnRechargeText(){
        if(getPrepaidBalance() >= 10){
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRechargeGreen));
            return driver.findElement(buttonRechargeGreen).getText();
        }
        else{
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRechargeRed));
            return driver.findElement(buttonRechargeRed).getText();
        }
    }

    public String getBtnPayBillText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPayBill));
        return driver.findElement(buttonPayBill).getText();
    }

    public String getCreditLimitText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCreditLimit));
        return driver.findElement(txtCreditLimit).getText();
    }

    public String getValidTillText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtValidTill));
        return driver.findElement(txtValidTill).getText();
    }

    public void clickCurrentBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCurrentBalance));
        driver.findElement(txtCurrentBalance).click();
    }

    public void tapOnInternetBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(internetBalanceArea));
        driver.findElement(internetBalanceArea).click();
    }

    public void tapOnMinuteBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(minutesDetailsArea));
        driver.findElement(minutesDetailsArea).click();
    }

    public void tapOnSMSBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(smsDetailsArea));
        driver.findElement(smsDetailsArea).click();
    }

    public void clickButtonRecharge(){
        if(getPrepaidBalance() >= 10){
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRechargeGreen));
            driver.findElement(buttonRechargeGreen).click();
        }
        else{
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRechargeRed));
            driver.findElement(buttonRechargeRed).click();
        }
    }

    public void tapBtnPayBill(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPayBill));
        driver.findElement(buttonPayBill).click();
    }

    public int getPrepaidBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(balancePrepaidTxt));
        String prepaidBalance[] = driver.findElement(balancePrepaidTxt).getText().split("[.]",0);
        int a = Integer.parseInt(prepaidBalance[0]);
        return a;
    }

    public double getPrepaidBalanceExact(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(balancePrepaidTxt));
        String prepaidBalance = driver.findElement(balancePrepaidTxt).getText();
        return Double.parseDouble(prepaidBalance);
    }

    public int getPrepaidBalanceRound(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(balancePrepaidTxt));
        String prepaidBalance = driver.findElement(balancePrepaidTxt).getText();
        return customSplit(prepaidBalance,"[.]",0);
    }

    public double getPostpaidTotalOutstandingBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalOutstandingBalancePostpaid));
        return Double.parseDouble(driver.findElement(totalOutstandingBalancePostpaid).getText());
    }

    public String getMainBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(balancePrepaidTxt));
        return driver.findElement(balancePrepaidTxt).getText().split("\\.")[0];
    }

    public boolean isLoanDueTextDisplayed(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(txtLoanDue));
        return driver.findElement(txtLoanDue).getText().contains("Loan Due");
    }

    public boolean isLoanDueDescriptionTextDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loanDueDescription));
        return driver.findElement(loanDueDescription).getText().contains("Next recharge loan amount will be deducted");
    }

    public boolean isLoanDueCardDisplayed(){
        if(isLoanDueTextDisplayed() && isLoanDueDescriptionTextDisplayed() == true){
            return true;
        }
        return false;
    }

    public boolean isGetAdvanceLoanCardDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAdvanceLoanButton));
        if(driver.findElement(getAdvanceLoanButton).isDisplayed() && getGetAdvanceLoanText().contains("TK. Advance Loan")) {
            return true;
        }
        return false;
    }

    public String getGetAdvanceLoanText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAdvanceLoanButton));
        return driver.findElement(getAdvanceLoanButton).getText();
    }

    public void searchByText (String searchText){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon));
        driver.findElement(searchIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys(searchText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        for (WebElement elm: driver.findElements(searchResult)) {
            if(elm.getText().contains(searchText)){
                elm.click();
                break;
            }
        }

    }

    public boolean isLoanDueCardVisible(){
       try{
           wait.until(ExpectedConditions.visibilityOfElementLocated(cardLoanDue));
           return true;
       }
       catch (Exception e){return false;}
    }

    public boolean isLoanOfferCardVisible(){
        try {
            waitless.until(ExpectedConditions.visibilityOfElementLocated(txtGetXTkAdvanceLoanInLoanOffercard));
            return true;
        }
        catch (Exception e){return false;}
    }

    public String getLoanDueAmountInHome(){
        if(isLoanDueCardVisible()==true) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txtLoanDueAmount));
            return driver.findElement(txtLoanDueAmount).getText();
        }
        else{
            return "No Loan Due card vailable";
        }
    }

    public String getLoanOfferCardtext(){
        if(isLoanOfferCardVisible()==true){
           return driver.findElement(txtGetXTkAdvanceLoanInLoanOffercard).getText();
        }
        return null;
    }

}

