package tests.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporter.core.ReportConfiguration;
import reporter.core.Reporter;

import java.io.File;

public class TestListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Reporter reporter = new Reporter();

    @Override
    public void onTestStart(ITestResult result) {

        String  testName = result.getMethod().getDescription();

        String currentTestDirectoryPath =  ReportConfiguration.ScreenShotDirectoryPath+"/"+testName.replace(" ", "").trim();

        File currentTestDirectory = new File(currentTestDirectoryPath);
        if (!currentTestDirectory.exists()) {
            currentTestDirectory.mkdir();
        }

        logger.info("Test Started: $testName");
        if (result.getParameters().length==0)
            reporter.startTest(testName);

        else

            reporter.startTest(testName + "-"+result.getParameters()[0]);


    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Suite ${context?.name} Started");
        File reportDirectory = new File(ReportConfiguration.ReportDirectoryPath);
        if (reportDirectory.exists()) {
            reportDirectory.deleteOnExit();
        }
        reportDirectory.mkdir();

    }

    @Override
    public void onFinish(ITestContext context) {

        reporter.endTest();
    }
}
