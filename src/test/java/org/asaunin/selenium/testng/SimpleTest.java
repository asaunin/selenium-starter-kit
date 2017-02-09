package org.asaunin.selenium.testng;

import org.asaunin.selenium.driver.WebDriverFactory;
import org.asaunin.selenium.testng.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.junit.Assert.assertTrue;

/**
 * Uses TestNG test framework
 * Test demonstrates simple webdriver functions : how to start browser, open url, insert some text and check that this text was inserted
 */
@Listeners({ScreenShotOnFailListener.class})
public class SimpleTest {

    @BeforeMethod
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


    @AfterMethod
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
