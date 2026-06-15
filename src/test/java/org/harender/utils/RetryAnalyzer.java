package org.harender.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Enterprise Guardrail: Automatically re-executes a failed test case
 * to filter out temporary network lags or slow server responses.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRY_COUNT = 2; // Failed test ko 2 baar automatic aur chalayega

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < MAX_RETRY_COUNT) {
                count++;
                System.out.println("🔄 [FLAKY TEST DETECTED] Re-triggering execution framework for test: "
                        + result.getName() + " | Attempt: " + count);
                return true;
            }
        }
        return false;
    }
}