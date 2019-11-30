package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import java.io.IOException;

public class TestNGListeners extends BrowserHelper implements ISuiteListener, ITestListener {


    @Override
    public void onStart(ISuite suite) {
        reporter = new ExtentHtmlReporter(GenericHelper.getFilePath("reports", suite.getName()+".html"));
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    @Override
    public void onFinish(ISuite suite) {
        reports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = testTag.createNode(result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass(result.getName()+ " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String imgPath = ScreenshotHelper.captureScreenshot(driver, "screenshots", result.getName());
        try {
            test.fail("failed").addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        testTag = reports.createTest(context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
