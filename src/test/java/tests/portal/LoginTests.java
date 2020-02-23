package tests.portal;

import constants.BaseUrls;
import org.testng.annotations.Test;
import ui.core.driver.BrowserDriver;
import webportal.pages.HomePage;

public class LoginTests extends BaseTest {

    @Test
    void loginTests() throws Exception {

        new BrowserDriver(driver).navigateToUrl(BaseUrls.amazonUrl, HomePage.class);

        new HomePage(driver)
                .clickOnLogin()
                .setUserNameAndClickContinue("pvn.cs37@gmail.com")
                .enterPasswordAndClickOnLoginButton("password");

    }
}
