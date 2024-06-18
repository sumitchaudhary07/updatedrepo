package resource;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	
	@BeforeTest
	public static ExtentReports reportGeneration()
	{
		
	String path=System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Framewor result");
		reporter.config().setDocumentTitle("Test Result for regression");
		
		ExtentReports er =new ExtentReports();
		er.attachReporter(reporter);	
		
		return er;
		
		
	}
	
}
