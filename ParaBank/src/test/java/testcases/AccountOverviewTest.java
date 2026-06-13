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

       /* LoginPage login =
                new LoginPage(driver);

        login.login(
                ExcelUtils.getData(2,0),
                ExcelUtils.getData(2,1));

        AccountOverviewPage page =
                new AccountOverviewPage(driver);

        page.openAccountOverview();

        Assert.assertTrue(
                page.verifyAccountOverview());*/
    	logger.info("Account Overview Test Started");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ExcelUtils.getData(2,0),
                ExcelUtils.getData(2,1));

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