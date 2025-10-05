package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Location of the report
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            
            // Report Configurations
            reporter.config().setReportName("Automation Test Results");
            reporter.config().setDocumentTitle("Extent Report");
            reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // System/Environment Info
            extent.setSystemInfo("Project", "My Project");
            extent.setSystemInfo("Tester", "QA Engineer");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
