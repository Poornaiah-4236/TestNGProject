package com.common.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/AutomationReport.html");
		reporter.config().setReportName("Selenium Automation Report");
		reporter.config().setDocumentTitle("Test Execution Report");
		if (extent == null) {
			extent = new ExtentReports();
		}
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Poornaiah");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}
}
