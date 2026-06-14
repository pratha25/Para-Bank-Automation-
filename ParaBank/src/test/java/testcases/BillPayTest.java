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
        	    ExcelUtils.getData(
        	            "LoginData",
        	            1,
        	            0),

        	    ExcelUtils.getData(
        	            "LoginData",
        	            1,
        	            1));
        

        BillPayPage billPay =
                new BillPayPage(driver);

        billPay.payBill(

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        0),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        1),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        2),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        3),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        4),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        5),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        6),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        7),

                ExcelUtils.getData(
                        "BillPayData",
                        1,
                        8)

        );
        Thread.sleep(5000);
        Assert.assertTrue(
                billPay.verifyBillPayment(),
                "Bill Payment Failed");
    }
}