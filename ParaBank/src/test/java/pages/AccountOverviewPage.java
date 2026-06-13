package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage {

    WebDriver driver;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountOverview =
            By.linkText("Accounts Overview");

    public void openAccountOverview() {

        driver.findElement(accountOverview)
              .click();
    }

    public boolean verifyAccountOverview() {

        return driver.getPageSource()
                     .contains("Accounts Overview");
    }
}