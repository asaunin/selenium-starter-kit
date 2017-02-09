package org.asaunin.selenium.testng;

import org.asaunin.selenium.driver.WebDriverFactory;
import org.asaunin.selenium.pages.YouTubePage;
import org.asaunin.selenium.pages.YouTubeSearchResultsPage;
import org.asaunin.selenium.testng.listeners.ScreenShotOnFailListener;
import org.testng.annotations.*;

import static org.junit.Assert.assertTrue;

/**
 * Uses TestNG test framework
 * Test demonstrates work with Page Object Pattern(https://code.google.com/p/selenium/wiki/PageObjects)
 */
@Listeners({ScreenShotOnFailListener.class})
public class PageObjectTest {

    @BeforeMethod
    public void beforeTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void testSearch() {
        String toSearch = "Selenium";
        YouTubePage youTubePage = new YouTubePage();
        youTubePage.insertSearchString(toSearch);
        YouTubeSearchResultsPage resultsPage = youTubePage.doSearch();
        assertTrue("No results were found on results page", resultsPage.hasResults());
    }

    @AfterMethod
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
