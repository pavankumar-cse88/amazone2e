package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import ui.core.driver.DriverProviderFactory;
import ui.core.driver.WebDriverProvider;

class BaseTest {

    WebDriver driver ;
    DriverProviderFactory driverProviderFactory = new DriverProviderFactory();
    @BeforeMethod
    void initializeBrowser() throws Exception {

       driver = driverProviderFactory.getWebDriver().instance("chrome");



    }

}
