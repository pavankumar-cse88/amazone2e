package tests;

import org.testng.annotations.Test;
import ui.core.driver.BrowserDriver;
import webportal.pages.HomePage;

public class AddToCartTest extends BaseTest {

    @Test
    void userShouldBeAbleToAddProductToCart() throws Exception {

        new BrowserDriver(driver).navigateToUrl("https://amazon.in/", HomePage.class);

        new HomePage(driver)
                .clickOnLogin()
                .setUserNameAndClickContinue("pvn.cs37@gmail.com")
                .enterPasswordAndClickOnLoginButton("password");





    }
}
