package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//" + reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createExtentTest(String TestName) {
		ExtentTest test = extentReports.createTest(TestName);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
}
