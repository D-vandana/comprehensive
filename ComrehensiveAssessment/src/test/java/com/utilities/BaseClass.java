package com.utilities;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pageobject.AboutUs;
import com.pageobject.FeesAndPayment;
import com.pageobject.GiftCards;
import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SearchPage;
import com.pageobject.Shipping;
import com.pageobject.SofaPage;
import com.pageobject.StudyClass;
import com.reuseability.HelperClass;


public class BaseClass
{
	public WebDriver driver;
	public ConfigClass co;
	public ExtentReports report;
	public ExtentTest log;
	public ExcelClass ex;
	public HomePage HP;
	public LoginPage LP;
	public SearchPage SP;
	public StudyClass SC;
	public FeesAndPayment FP;
	public SofaPage SB;
	public GiftCards GC;
	public AboutUs AU;
	public Shipping SH;

	@BeforeSuite
	public void start() throws Exception
	{
		ex =new ExcelClass();
		co = new ConfigClass();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Urban_"+HelperClass.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);	
		
	}
/*
	@BeforeClass
	public WebDriver setup()
	{
		return driver = DriverClass.Application(driver, co.getBrowser(), co.getURL());
	}

	@AfterClass
	public void close()
	{
		DriverClass.quitBrowser(driver);
	}
*/
	@AfterMethod
	public void ssMethod(ITestResult result) throws Exception
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			log.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
			log.fail("Oops! The TestCase failed");
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			log.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
			log.pass("Hey! The Testcase is Passed");
		}
		report.flush();
	}
}
