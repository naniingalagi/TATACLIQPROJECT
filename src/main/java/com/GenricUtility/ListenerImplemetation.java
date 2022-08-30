package com.GenricUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplemetation implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("hai ----> i am onStart ");
		 spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "TestNG environment");
		report.setSystemInfo("ReporterName", "Narayan Ingalagi ");
		report.setSystemInfo("Platform", "Windows 11");
		report.setSystemInfo("UnitTesting Tool", " TESTNG");
		report.setSystemInfo("Build management Tool", "Maven");
		report.setSystemInfo("AutomationTool", "Selenium ");
		
		
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("hai ----> i am onTestStart ");
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("hai ----> i am onTestSuccess ");
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("hai ----> i am onTestFailure ");
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL,result.getThrowable());
		//JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		test.addScreenCaptureFromPath(webDriverUtility.takeScreenShot(result.getMethod().getMethodName(),BaseClass.staticdriver));
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("hai ----> i am onTestSuccess ");
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP,result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("hai ----> i am onTestFailedButWithinSuccessPercentage ");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("hai ----> i am onFinish ");
		report.flush();
		
		
	}

}
