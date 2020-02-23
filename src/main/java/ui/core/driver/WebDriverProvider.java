package ui.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider implements Driver {

    private static WebDriver driver;
    @Override
     public  <T> T getDriverInstance(String driverName) throws Exception {
        try {

            if (driverName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (driverName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (driverName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else {
                throw new Exception("Invalid Browser");
            }
        }
        catch(Exception error){
                throw new Exception("Error in driver instance creation"+error.getMessage());
        }
        return (T) driver;

    }


    public WebDriver instance(String driverName) throws Exception {
        if(driver == null)
                return( getDriverInstance(driverName));
        else
            return driver;
    }



}
