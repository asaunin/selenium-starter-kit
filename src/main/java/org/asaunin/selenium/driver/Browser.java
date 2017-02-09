package org.asaunin.selenium.driver;

import org.asaunin.selenium.driver.browser.ChromeBrowser;
import org.asaunin.selenium.driver.browser.FirefoxBrowser;
import org.asaunin.selenium.driver.browser.HtmlUnitBrowser;
import org.asaunin.selenium.driver.browser.IEBrowser;

public enum Browser {

    CHROME(ChromeBrowser.class, "chrome"),
    FIREFOX(FirefoxBrowser.class, "firefox"),
    HTML(HtmlUnitBrowser.class, "html"),
    IE(IEBrowser.class, "ie");

    private Class<? extends BrowserAbstract> browserClass;
    private String name;

    Browser(Class<? extends BrowserAbstract> browserClass, String name) {
        this.name = name;
        this.browserClass = browserClass;
    }

    public static Browser lookup(String browserName) {
        for (Browser name : Browser.values()) {
            if (name.getName().equalsIgnoreCase(browserName)) {
                return name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Class<? extends BrowserAbstract> getBrowserClass() {
        return browserClass;
    }
}
