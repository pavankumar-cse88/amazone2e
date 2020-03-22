package reporter.core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import static reporter.core.ReportConfiguration.ReportDirectoryPath;


public class Reporter {

    private HashMap<Long, ExtentTest> testMap = new HashMap<Long,ExtentTest>();
    Logger logger = LoggerFactory.getLogger(this.getClass());
    ExtentManager extentManager;

   public ExtentTest startTest(String testName){
        extentManager = new ExtentManager();
        ExtentTest test = extentManager.instance().createTest(testName);

        testMap.put(Thread.currentThread().getId(), test);
        return test;

    }

    public void endTest(){
        extentManager.instance().flush();
    }

    void logWarning(String message){
        logger.warn(message);
        getTest().log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.ORANGE));

    }

    void logInfo(String info){
        logger.info(info);
        getTest().log(Status.INFO, info);

    }

    void logError(String error){
        logger.error(error);
        getTest().log(Status.ERROR, error);
    }

    void logFile(String filePath,String fileText){
        getTest().info("<a href"+filePath+">"+fileText+"</>");

    }

    void logScreenShot(File image){
        try{
            String testName = getTest().getModel().getName().replace(" ", "");
            String currentDirectoryPath = Paths.get(ReportConfiguration.ScreenShotDirectoryPath,testName).toString();
            FileUtils.copyFile(image, new File(Paths.get(currentDirectoryPath,image.getName()).toString()));
            String screenshotPath = currentDirectoryPath.replace(ReportDirectoryPath, "");
            getTest().addScreenCaptureFromPath(screenshotPath+"+/"+image.getName());
        }
        catch(Exception error){

        }
    }


    ExtentTest getTest(){
        return testMap.get(Thread.currentThread().getId());
    }
}


