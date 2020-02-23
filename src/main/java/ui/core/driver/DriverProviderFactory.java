package ui.core.driver;

public class DriverProviderFactory {


    public WebDriverProvider getWebDriver(){

        return new WebDriverProvider();

    }

    public AndroidDriverProvider getAndroidDriver(){
        return new AndroidDriverProvider();

    }
}
