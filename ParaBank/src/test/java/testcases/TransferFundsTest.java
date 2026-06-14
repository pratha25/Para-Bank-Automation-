package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.TransferFundsPage;
import utilities.ExcelUtils;

public class TransferFundsTest extends BaseTest {
	@Test
	public void transferFundsTest() throws InterruptedException {

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
	    	            1));

	    TransferFundsPage transferPage =
	            new TransferFundsPage(driver);

	    transferPage.transferFunds(

	    	    ExcelUtils.getData(
	    	            "TransferData",
	    	            1,
	    	            0)

	    	);

	    Thread.sleep(3000);

	    Assert.assertTrue(true);
	}
}