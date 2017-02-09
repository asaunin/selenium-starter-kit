package org.asaunin.selenium.junit;

import org.asaunin.selenium.junit.rules.ScreenShotOnFailRule;
import org.asaunin.selenium.driver.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Uses JUnit test framework
 * Test demonstrates simple webdriver functions : how to start browser, open url, insert some text and check that this text was inserted
 */
public class SimpleTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void testFillGoogleForm() {
        String toSearch = "Selenium";
        WebDriverFactory.getDriver().get("http://www.youtube.com");
        WebElement searchString = WebDriverFactory.getDriver().findElement(By.cssSelector("#masthead-search-term"));
        searchString.sendKeys(toSearch);
        String searchStringText = searchString.getAttribute("value");
        assertTrue("Text from page(" + searchStringText + ") not equals to text from test(" + toSearch + ")",
                searchStringText.equals(toSearch));
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
