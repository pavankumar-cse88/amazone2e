package reporter.core;

import java.nio.file.Paths;

public class ReportConfiguration {
    static private String rootDirectory = System.getProperty("user.dir");
    public  static String ReportDirectoryPath = Paths.get(rootDirectory,"reports").toString();
    public static String ScreenShotDirectoryPath = Paths.get(ReportDirectoryPath,"screenshots").toString();
    public static String ReportHtmlConfig = Paths.get(rootDirectory,"src","main","resources","report-html-config.xml").toString();
    public static final String ReportName="ExecutionReport,html";
}
