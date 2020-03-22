package ui.core.driver;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class BrowserDriver {

     WebDriver driver;

    public BrowserDriver(WebDriver driver){
        this.driver = driver;
    }

    public  <T> T navigateToUrl(String url, Class<T> page) {
    try {
        driver.navigate().to(url);
        T navigatedpage = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        return navigatedpage;
    }
    catch (Exception error){
        throw new RuntimeException("Error getting chrome configurations." + error.getMessage());
    }

    }
}
