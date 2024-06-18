package sumitframework.basepackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReportDemo;

public class TestListener extends Base implements ITestListener {
	ExtentReports er;
	ExtentTest test;
	WebDriver driver;
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 er=ExtentReportDemo.reportGeneration();
		 er.createTest(result.getMethod().getMethodName());
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "Test is passes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);

	
		
		//	test.fail(result.getThrowable());
	System.out.println("test failure inside block");
			
				try {
					driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				String path = null;
		try {
			 path=takeScreenshot(result.getMethod().getMethodName(),driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	System.err.println("test failure inside block");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		er.flush();
	}
	
	

}
