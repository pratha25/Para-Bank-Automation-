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

    public void payBill() {

        driver.findElement(billPayLink).click();

        driver.findElement(payeeName)
              .sendKeys("Electricity Board");

        driver.findElement(address)
              .sendKeys("Jyendra nagar");

        driver.findElement(city)
              .sendKeys("Mahoba");

        driver.findElement(state)
              .sendKeys("UP");

        driver.findElement(zipCode)
              .sendKeys("210421");

        driver.findElement(phone)
              .sendKeys("7080852802");

        driver.findElement(account)
              .sendKeys("12345");

        driver.findElement(verifyAccount)
              .sendKeys("12345");

        driver.findElement(amount)
              .sendKeys("500");

        driver.findElement(sendPayment)
              .click();
    }
    public boolean verifyBillPayment() {

        return driver.getPageSource()
                     .contains("Bill Payment Complete");
    }
}