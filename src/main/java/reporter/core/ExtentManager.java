package reporter.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentManager {

    private ExtentReports extent;
    ExtentReports instance(){
        if(extent == null){
            File reportDirectory = new File(ReportConfiguration.ReportDirectoryPath);
            if(!reportDirectory.exists())
                reportDirectory.mkdir();

            File screenShotDirectory = new File(ReportConfiguration.ScreenShotDirectoryPath);
            if(!screenShotDirectory.exists())
                screenShotDirectory.mkdir();

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportConfiguration.ReportDirectoryPath.concat(
                    ReportConfiguration.ReportName));
            htmlReporter.loadXMLConfig(ReportConfiguration.ReportHtmlConfig);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
