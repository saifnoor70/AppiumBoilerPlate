package test_cases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import test_runner.BaseTest;
import utils.Resource;

public class LoginTest extends BaseTest {




    @Test
    public void validateLogInWithPasswordTest() {
        GuestDashboardPage guestDashboardPage = new GuestDashboardPage();
        OtpLogInPage otpLogInPage = new OtpLogInPage();
        BalanceCardHomePage balanceCardHome = new BalanceCardHomePage();
        FlashHourPage flashHourPage = new FlashHourPage();
        guestDashboardPage.goToOtpPage();
        otpLogInPage.toggleToPassword();
        otpLogInPage.logInWithPassword(Resource.number110, Resource.password110);
        flashHourPage.clickCloseBtn();
        Assert.assertEquals("Current Balance",balanceCardHome.getCurrentBalanceTxt());
    }
}
