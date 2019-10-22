package main.java.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 1;
    int retryCount = 2;
    @java.lang.Override
    public boolean retry(ITestResult iTestResult) {
                if (counter < retryCount) {
                    counter++;
                    return true;
                }
        return false;
    }
}
