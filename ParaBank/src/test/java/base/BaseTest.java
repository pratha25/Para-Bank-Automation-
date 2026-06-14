package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseTest {
	public WebDriver getDriver() {
	    return driver;
	}
    protected WebDriver driver;

    @BeforeMethod
   public void setup() {

        ChromeOptions options = new ChromeOptions();

        String docker =
                System.getProperty("docker");

        if("true".equalsIgnoreCase(docker)) {

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if(driver!=null)
            driver.quit();
    }
}
