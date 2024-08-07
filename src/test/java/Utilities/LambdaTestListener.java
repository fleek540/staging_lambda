package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

public class LambdaTestListener extends BaseClass implements ITestListener {
    private static final Logger logger = LogManager.getLogger(LambdaTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName());
        ((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "passed");
        ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a passed test \"}} ");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test failed: " + result.getMethod().getMethodName());
        ((JavascriptExecutor) alcDriver).executeScript("lambda-status=" + "failed");
        ((JavascriptExecutor) pbDriver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a failed test \"}} ");
        
       

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implement if needed
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Tests started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Tests finished: " + context.getName());
    }

  }