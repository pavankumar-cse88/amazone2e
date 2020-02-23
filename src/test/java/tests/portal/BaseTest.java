package tests.portal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import ui.core.driver.DriverProviderFactory;

class BaseTest {

    WebDriver driver ;
    DriverProviderFactory driverProviderFactory = new DriverProviderFactory();
    @BeforeMethod
    void initializeBrowser() throws Exception {

       driver = driverProviderFactory.getWebDriver().instance("chrome");



    }

}
