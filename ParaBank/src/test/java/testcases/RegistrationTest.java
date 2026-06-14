package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import utilities.ExcelUtils;
import utilities.RandomDataGenerator;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerUser() {

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        String username = RandomDataGenerator.getUsername();
        String password =
                ExcelUtils.getData(
                        "RegistrationData",
                        1,
                        8);

        RegistrationPage reg = new RegistrationPage(driver);
        reg.registerUser(

                ExcelUtils.getData(
                        "RegistrationData",
                        1,
                        0),

                ExcelUtils.getData(
                        "RegistrationData",
                        1,
                        1),

                username,

                password
        );

        ExcelUtils.writeData(
                "LoginData",
                1,
                0,
                username);

        ExcelUtils.writeData(
                "LoginData",
                1,
                1,
                password);

        System.out.println("Saved Username : " + username);
        System.out.println("Saved Password : " + password);
    }
}