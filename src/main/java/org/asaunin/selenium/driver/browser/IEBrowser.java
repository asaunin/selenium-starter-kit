package org.asaunin.selenium.driver.browser;

import org.asaunin.selenium.driver.BrowserAbstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends BrowserAbstract {

    @Override
    public void setOptions() {
        // Here you should put options to set before browser instance creation
    }

    @Override
    public WebDriver create() {
        caps.setVersion("10");

        return new InternetExplorerDriver(caps);
    }

}
