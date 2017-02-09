package org.asaunin.selenium.configuration;

import org.asaunin.selenium.configuration.properties.PropertiesLoader;
import org.asaunin.selenium.configuration.properties.Property;
import org.asaunin.selenium.configuration.properties.PropertyFile;
import org.asaunin.selenium.driver.Browser;

/**
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("config.properties")
public class Configuration {

    private static Configuration config;

    public static Configuration getConfig() {
        if (config == null) {
            config = new Configuration();
        }
        return config;
    }

    public Configuration() {
        PropertiesLoader.populate(this);
    }

    @Property("browser.name")
    private String browser = "";

    @Property("browser.version")
    private String version = "";

    public Browser getBrowser() {
        final Browser browserForTests = Browser.lookup(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

}
