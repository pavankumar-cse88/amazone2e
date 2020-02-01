package ui.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    WebDriver driver = null;

    public WebDriver initializeDriver(){

         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         return driver;

     }





}
