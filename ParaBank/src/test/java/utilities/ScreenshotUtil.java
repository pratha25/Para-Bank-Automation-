package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver,
                                           String testName) {

    	String path = System.getProperty("user.dir")
    	        + "/reports/screenshots/"
    	        + testName + ".png";

        try {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(path);

            dest.getParentFile().mkdirs();

            Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}