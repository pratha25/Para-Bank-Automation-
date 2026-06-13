package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By logoutLink = By.linkText("Log Out");

    By accountOverviewLink = By.linkText("Accounts Overview");

    By transferFundsLink = By.linkText("Transfer Funds");

    By billPayLink = By.linkText("Bill Pay");

    public boolean isHomePageDisplayed() {

        return driver.findElement(logoutLink)
                     .isDisplayed();
    }

    public void clickAccountOverview() {

        driver.findElement(accountOverviewLink)
              .click();
    }

    public void clickTransferFunds() {

        driver.findElement(transferFundsLink)
              .click();
    }

    public void clickBillPay() {

        driver.findElement(billPayLink)
              .click();
    }

    public void logout() {

        driver.findElement(logoutLink)
              .click();
    }
}
