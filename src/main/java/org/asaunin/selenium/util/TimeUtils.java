package org.asaunin.selenium.util;

/**
 * Operations with time
 */
public class TimeUtils {

    /**
     * waiting for seconds
     * @param timeoutInSeconds timeout in seconds for wait
     */
    public static void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
