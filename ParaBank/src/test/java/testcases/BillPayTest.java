package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BillPayPage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class BillPayTest extends BaseTest {

    @Test
    public void billPayTest() throws InterruptedException {

        LoginPage login =
                new LoginPage(driver);

        login.login(
                ExcelUtils.getData(2,0),
                ExcelUtils.getData(2,1));

        BillPayPage billPay =
                new BillPayPage(driver);

        billPay.payBill();
        Thread.sleep(5000);
        Assert.assertTrue(
                billPay.verifyBillPayment(),
                "Bill Payment Failed");
    }
}