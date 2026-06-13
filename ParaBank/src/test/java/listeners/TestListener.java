package listeners;
import base.BaseTest;
import utilities.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
public class TestListener implements ITestListener {
	ExtentReports extent =
	        ExtentManager.getReport();

	ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName());

        System.out.println(
                "STARTED : "
                        + result.getName());
    }

    @Override
   
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        System.out.println(
                "PASSED : "
                        + result.getName());
    }
    @Override
   
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {

            BaseTest base =
                (BaseTest) result.getInstance();

            String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        base.getDriver(),
                        result.getName());
            System.out.println(
                    "Screenshot Path = "
                            + screenshotPath);
            test.addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println(
                "FAILED : "
                        + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "Execution Finished");
    }
}