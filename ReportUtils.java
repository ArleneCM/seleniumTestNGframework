package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {

	ExtentHtmlReporter htmlReport; // variable for html report
	
	ExtentReports extentReports; // generate a report
	
	ExtentTest extentTest; // create test cases
	
	public ReportUtils(String htmlReportFilename) {
		htmlReportFilename = htmlReportFilename.trim();
		
		// initialize all the 3 variables above
		htmlReport = new ExtentHtmlReporter(htmlReportFilename);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(htmlReport);
		
	}

	public void createATestCase(String testcaseName) {
		
		// create a new test case here
		extentTest = extentReports.createTest(testcaseName);
		
	}
	
	public void addTestLog(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void attachScreenshotToReport(String filename) throws Exception {
		extentTest.addScreenCaptureFromPath(filename);
	}
	
	public void flushReport() {
		// to close the report
		extentReports.flush();
	}
}
