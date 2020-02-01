package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import ui.core.driver.WebDriverProvider;

class BaseTest {

    WebDriver driver ;
    WebDriverProvider webDriverProvider = new WebDriverProvider();
    @BeforeMethod
    void initializeBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = webDriverProvider.initializeDriver();

    }

}
