package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import base.BaseTest;
import pages.AccountOverviewPage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class AccountOverviewTest extends BaseTest {
	private static final Logger logger =
            LogManager.getLogger(AccountOverviewTest.class);
    @Test
    public void accountOverviewTest() {

       
    	logger.info("Account Overview Test Started");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(

                ExcelUtils.getData(
                        "LoginData",
                        1,
                        0),

                ExcelUtils.getData(
                        "LoginData",
                        1,
                        1)

        );

        logger.info("Login Successful");

        AccountOverviewPage accountPage =
                new AccountOverviewPage(driver);

        accountPage.openAccountOverview();

        logger.info("Account Overview Page Opened");

        Assert.assertTrue(
                accountPage.verifyAccountOverview());

        logger.info("Account Overview Test Passed");
    }
}