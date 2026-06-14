package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        String username =
        		ExcelUtils.getData(
        		        "LoginData",
        		       1,
        		        0);

        String password =
        		ExcelUtils.getData(
        		        "LoginData",
        		        1,
        		        1);

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(username, password);

        Thread.sleep(3000);

        HomePage homePage =
                new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Login Failed");
    }
}