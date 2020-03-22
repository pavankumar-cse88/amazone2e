package tests.portal;

import constants.BaseUrls;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.core.driver.BrowserDriver;
import webportal.pages.HomePage;

import java.lang.reflect.InvocationTargetException;

public class SearchBarTests extends BaseTest {

    @Test
    void validKeywordsTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new BrowserDriver(driver).navigateToUrl(BaseUrls.amazonUrl, HomePage.class);
        new HomePage(driver)
                .enterKeywordInSearchBar("shoe")
                .getSuggestionsMatching("shoe")
                .stream().forEach(suggestion ->Assert.assertTrue(suggestion.contains("shoe")));
    }
}
