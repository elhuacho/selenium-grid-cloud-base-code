package com.practicetestautomation.base;

import com.saucelabs.saucerest.SauceREST;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SauceLabsTestListener extends TestListenerAdapter {
    private boolean sauce;
    private String sessionId;
    private SauceREST sauceREST;

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        sauce = (boolean) result.getTestContext().getAttribute("sauce");

        if (sauce) {
            this.sessionId = (String) result.getTestContext().getAttribute("sessionId");
            this.sauceREST = new SauceREST(System.getProperty("sauce.username"), System.getProperty("sauce.accesskey"));
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        if (sauce) {
            sauceREST.jobPassed(sessionId);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        if (sauce) {
            sauceREST.jobFailed(sessionId);

            Throwable throwable = result.getThrowable();
            String message = throwable.getMessage();
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            String link = "SL job link: https://app.saucelabs.com/tests/" + sessionId;
            String sauceTestName = result.getTestContext().getName() + " | " + result.getName();

            String newMessage = sauceTestName + "\n" + link + "\n" + message;
            Throwable newThrowable = new Throwable(newMessage, throwable);
            newThrowable.setStackTrace(stackTrace);
            result.setThrowable(newThrowable);
        }
    }
}
