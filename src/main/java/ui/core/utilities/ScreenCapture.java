package ui.core.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenCapture {

     public static File takeScreenShot(WebDriver driver) throws Exception {
        try{
            TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
            return takesScreenshot.getScreenshotAs(OutputType.FILE);

        }
        catch(Exception error){
            throw new Exception("Error in driver instance creation"+error.getMessage());
        }
     }
}

