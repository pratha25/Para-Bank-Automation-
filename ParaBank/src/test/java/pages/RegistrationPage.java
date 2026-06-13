package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zip = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirm = By.id("repeatedPassword");
    By register = By.xpath("//input[@value='Register']");

    public void registerUser(String fname,
                             String lname,
                             String user,
                             String pass) {

        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(address).sendKeys("India");
        driver.findElement(city).sendKeys("Mahoba");
        driver.findElement(state).sendKeys("UP");
        driver.findElement(zip).sendKeys("210421");
        driver.findElement(phone).sendKeys("7080852802");
        driver.findElement(ssn).sendKeys("123456");

        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(confirm).sendKeys(pass);

        driver.findElement(register).click();
    }
}