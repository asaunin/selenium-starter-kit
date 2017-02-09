package org.asaunin.selenium.driver.browser;

import org.asaunin.selenium.driver.BrowserAbstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeBrowser extends BrowserAbstract {

    private static final String CHROMEDRIVER_PATH_FORMAT = "ChromeDriver/chromedriver_%s";
    private static final String CHROMEDRIVER_PATH_MAC = String.format(CHROMEDRIVER_PATH_FORMAT, "mac32/chromedriver");
    private static final String CHROMEDRIVER_PATH_LINUX = String.format(CHROMEDRIVER_PATH_FORMAT, "linux64/chromedriver");
    private static final String CHROMEDRIVER_PATH_WINDOWS = String.format(CHROMEDRIVER_PATH_FORMAT, "win32/chromedriver.exe");

    private ChromeOptions chromeOptions = new ChromeOptions();

    @Override
    public void setOptions() {
        String chromeBinaryPath = "";
        String osName = System.getProperty("os.name").toUpperCase();

        if (osName.contains("WINDOWS")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_WINDOWS;
        } else if (osName.contains("MAC")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_MAC;
        } else if (osName.contains("LINUX")) {
            chromeBinaryPath = CHROMEDRIVER_PATH_LINUX;
        }

        File chromedriver = new File(ClassLoader.getSystemResource(chromeBinaryPath).getPath());

        // set application user permissions to 455
        chromedriver.setExecutable(true);

        System.setProperty("webdriver.chrome.driver", chromedriver.getPath());

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("process-per-site");
        chromeOptions.addArguments("dns-prefetch-disable");
    }

    @Override
    public WebDriver create() {
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(caps);
    }

}
