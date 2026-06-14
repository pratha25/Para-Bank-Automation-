package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.OpenAccountPage;
import utilities.ExcelUtils;

public class OpenAccountTest extends BaseTest {

    @Test(priority = 4)

    public void createAccount() {

        LoginPage login =
                new LoginPage(driver);

        login.login(

                ExcelUtils.getData(
                        "LoginData",
                        1,
                        0),

                ExcelUtils.getData(
                        "LoginData",
                        1,
                        1)
        );

        OpenAccountPage account =
                new OpenAccountPage(driver);

        account.openNewAccountPage();

        account.createNewAccount();

        Assert.assertTrue(
                account.verifyAccountCreated(),
                "Account Creation Failed");
    }
}