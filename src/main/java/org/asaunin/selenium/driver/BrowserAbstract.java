package org.asaunin.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BrowserAbstract {

    protected DesiredCapabilities caps = new DesiredCapabilities();

    /**
     * Get a ready to work instance for chosen browser
     *
     * @return
     */
    public WebDriver getInstance() {
        setOptions();
        setBrowserLogging(Level.SEVERE);
        WebDriver webdriver = create();
        setTimeputs(webdriver);

        return webdriver;
    }

    /**
     * Set Browser specific options, before creating a working instance
     */
    public abstract void setOptions();
    /**
     * Create a working instance of a Browser
     *
     * @return
     */
    public abstract WebDriver create();

    protected void setBrowserLogging(Level logLevel) {
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, logLevel);
        caps.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
    }

    protected void setTimeputs(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

}
