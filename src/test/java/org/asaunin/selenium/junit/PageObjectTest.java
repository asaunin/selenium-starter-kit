package org.asaunin.selenium.junit;

import org.asaunin.selenium.junit.rules.ScreenShotOnFailRule;
import org.asaunin.selenium.pages.YouTubePage;
import org.asaunin.selenium.pages.YouTubeSearchResultsPage;
import org.asaunin.selenium.driver.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Uses JUnit test framework
 * Test demonstrates work with Page Object Pattern(https://code.google.com/p/selenium/wiki/PageObjects)
 */
public class PageObjectTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
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

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
