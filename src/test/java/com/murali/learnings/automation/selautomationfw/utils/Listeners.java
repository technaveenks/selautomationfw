package com.murali.learnings.automation.selautomationfw.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener{
	protected static ExtentReports extent;
	protected static ExtentSparkReporter spark;
	protected static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, " Test Started -  "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	//	test = extent.createTest(result.getMethod().getMethodName());
		test.pass(result.getMethod().getMethodName());	
		test.log(Status.PASS, " Test Passed "+result.getMethod().getMethodName());
		test.log(Status.INFO, "On Test Success ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "On Test Failure ");
		test.fail(result.getMethod().getMethodName());	
		test.log(Status.FAIL, " Test Failed "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "On Test Skipped ");
		test.fail(result.getMethod().getMethodName());	
		test.log(Status.SKIP, " Test Skipped "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("reports/testreport.html");
		extent.attachReporter(spark);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
