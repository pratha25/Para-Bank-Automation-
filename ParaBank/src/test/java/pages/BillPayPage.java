package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayPage {

    WebDriver driver;

    public BillPayPage(WebDriver driver) {

        this.driver = driver;
    }

    By billPayLink = By.linkText("Bill Pay");

    By payeeName = By.name("payee.name");
    By address = By.name("payee.address.street");
    By city = By.name("payee.address.city");
    By state = By.name("payee.address.state");
    By zipCode = By.name("payee.address.zipCode");
    By phone = By.name("payee.phoneNumber");
    By account = By.name("payee.accountNumber");
    By verifyAccount = By.name("verifyAccount");
    By amount = By.name("amount");

    By sendPayment =
            By.xpath("//input[@value='Send Payment']");

    public void payBill(
            String payeeNameValue,
            String addressValue,
            String cityValue,
            String stateValue,
            String zipCodeValue,
            String phoneValue,
            String accountValue,
            String verifyAccountValue,
            String amountValue) {

        driver.findElement(billPayLink).click();

        driver.findElement(payeeName)
              .sendKeys(payeeNameValue);

        driver.findElement(address)
              .sendKeys(addressValue);

        driver.findElement(city)
              .sendKeys(cityValue);

        driver.findElement(state)
              .sendKeys(stateValue);

        driver.findElement(zipCode)
              .sendKeys(zipCodeValue);

        driver.findElement(phone)
              .sendKeys(phoneValue);

        driver.findElement(account)
              .sendKeys(accountValue);

        driver.findElement(verifyAccount)
              .sendKeys(verifyAccountValue);

        driver.findElement(amount)
              .sendKeys(amountValue);

        driver.findElement(sendPayment)
              .click();
    }
    public boolean verifyBillPayment() {

        return driver.getPageSource()
                     .contains("Bill Payment Complete");
    }
}