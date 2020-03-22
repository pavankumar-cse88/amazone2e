package ui.core.driver;

import com.google.gson.Gson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ui.core.constants.Configuration;
import ui.core.listeners.EventCapture;

import java.io.*;

public class WebDriverProvider implements Driver {

    private static WebDriver driver;
    Gson gson = new Gson();
    PortalConfiguration portalConfiguration = new PortalConfiguration();
    @Override
     public  <T> T getDriverInstance(String driverName) throws Exception {
        try {
            switch(driverName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getChromeDesiredCapabilities());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new Exception("Invalid Browser");

            }

        }
        catch(Exception error){
                throw new Exception("Error in driver instance creation"+error.getMessage());
        }
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        EventCapture eventCapture = new EventCapture();

        return (T) eventFiringWebDriver.register(eventCapture);

    }
    public WebDriver instance(String driverName) throws Exception {
        //Singleton design patterns
        if(driver == null)
                return( getDriverInstance(driverName));
        else
            return driver;
    }

   private  ChromeOptions getChromeDesiredCapabilities() throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Configuration.PortalConfigurationJsonPath));
            String configuration = IOUtils.toString(bufferedReader);
            portalConfiguration = gson.fromJson(configuration, PortalConfiguration.class);

            ChromeOptions options = new ChromeOptions();
            for (String flag : portalConfiguration.getFlags())
                options.addArguments(flag);

            Boolean remoteExecution = Boolean.parseBoolean(System.getProperty("remoteExecution")) ? true : false;
            if (remoteExecution) {
                options.addArguments("--headless");
                options.addArguments("--window-size=1200x600");
            }

            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return options;
        }
        catch(Exception error){
                throw new Exception("Error getting chrome configurations."+ error.getMessage());
        }


    }




}
