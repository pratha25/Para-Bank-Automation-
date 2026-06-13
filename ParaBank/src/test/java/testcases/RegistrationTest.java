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
        String password = "Test123";

        RegistrationPage reg = new RegistrationPage(driver);

        reg.registerUser(
                "Pratha",
                "Khare",
                username,
                password);

        ExcelUtils.writeData(2, 0, username);
        ExcelUtils.writeData(2, 1, password);

        System.out.println("Saved Username : " + username);
        System.out.println("Saved Password : " + password);
    }
}