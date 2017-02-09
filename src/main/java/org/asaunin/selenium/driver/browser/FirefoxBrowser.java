package org.asaunin.selenium.driver.browser;

import org.asaunin.selenium.driver.BrowserAbstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

public class FirefoxBrowser extends BrowserAbstract {

    private FirefoxProfile firefoxProfile;

    @Override
    public void setOptions() {
        // Windows 8 requires to set webdriver.firefox.bin system variable
        // to path where executive file of FF is placed
        if ("WINDOWS 8".equalsIgnoreCase(System.getProperty("os.name"))) {
            System.setProperty("webdriver.firefox.bin", "c:" + File.separator + "Program Files (x86)"
                    + File.separator + "Mozilla Firefox" + File.separator + "Firefox.exe");
        }

        // Check if user who is running tests have write access in ~/.mozilla dir and home dir
        if ("LINUX".equalsIgnoreCase(System.getProperty("os.name"))) {
            File homePath = new File(System.getenv("HOME") + File.separator);
            File mozillaPath = new File(homePath + File.separator + ".mozilla");
            File tmpFile;
            if (mozillaPath.exists()) {
                try {
                    tmpFile = File.createTempFile("webdriver", null, mozillaPath);
                } catch (IOException ex) {
                    throw new WebDriverException(
                            "Can't create file in path: %s".replace("%s", mozillaPath.getAbsolutePath()));
                }
            } else {
                try {
                    tmpFile = File.createTempFile("webdriver", null, homePath);
                } catch (IOException ex) {
                    throw new WebDriverException(
                            "Can't create file in path: %s".replace("%s", homePath.getAbsolutePath()));
                }
            }
            tmpFile.delete();
        }

        firefoxProfile = new FirefoxProfile(
                new File(ClassLoader.getSystemResource("FirefoxProfiles/Default").getPath()));
    }

    @Override
    public WebDriver create() {
        caps.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        caps.setCapability("marionette", true);

        return new FirefoxDriver(caps);
    }

}
