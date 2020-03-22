package ui.core.driver;

public class DriverProviderFactory {


    //Factory pattern
    public WebDriverProvider getWebDriver(){
        try {
            return new WebDriverProvider();
        }
        catch(Exception error){
            throw new RuntimeException("Error in creating webDriver instance" + error.getMessage());
        }
    }

    public AndroidDriverProvider getAndroidDriver(){
        try {
            return new AndroidDriverProvider();
        }
        catch(Exception error){
            throw new RuntimeException("Error in creating Android Driver Instance" + error.getMessage());
        }

    }
}
