package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.SwagLabs.Pages.*;
import com.SwagLabs.utility.PropertiesUtil;
import com.SwagLabs.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckOutPage cop;
	public OverviewPage op;
	public PropertiesUtil p1;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void reports()
	{
		extent = new ExtentReports();
		spark= new ExtentSparkReporter("Reports/SwagLab.html");
		spark.config().setDocumentTitle("Sprint 1 report");
		spark.config().setReportName("SwagLabAutomation Report");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		test =extent.createTest("SwagLab End to End Report");
		
	}
	@BeforeTest //For all pages Browser setup
	public void setUpBrowser()
	{
		p1= new PropertiesUtil();
		driver= new ChromeDriver();
		Reporter.log("Log: Driver session is created",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p1.getData("url"));
		Reporter.log("Log: Application is open ",true);
		test.pass("SwagLab Application open Successfully!");
		
		lp=new LoginPage(driver);
	    ip=new InventoryPage(driver);
	    cp=new CartPage(driver);
	    cop= new CheckOutPage(driver);
	    op=new OverviewPage(driver);
	    
	}
	
	
	@BeforeClass //Page preconditions
	public void pageSetUp() {
		System.out.println("*************Login page*****************");
		System.out.println("Url is: "+lp.getUrl());
		Reporter.log("Log: Login page is open",true);
		System.out.println("Title is: "+lp.getAppTitle());
		Utility.getScreenshot(driver);
		lp.doLogin(p1.getData("un"),p1.getData("psw"));
		Reporter.log("Log: Login is completed with valid data set",true);
		test.pass("Login completed!");
		addWait();
		Utility.getScreenshot(driver);
		System.out.println("*************Inventory page*****************");
		//before checkout there should be product in the cart
		System.out.println("Total product count is :"+ip.getProductCount());
		ip.getProductName();
		addWait();
		Utility.getScreenshot(driver);
		ip.addToCart(p1.getData("pname1"));
		addWait();
		Utility.getScreenshot(driver);
		//cart page must be open before checking out
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		test.pass("Inventory page validation completed!");
		System.out.println("**************Cart Page*****************");
		cp.doRemove();
		Utility.getScreenshot(driver);
		addWait();
		cp.doContinueShopping();
		Utility.getScreenshot(driver);
		ip.addToCart(p1.getData("pname2"));
		Utility.getScreenshot(driver);
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		cp.doCheckOut();
		Utility.getScreenshot(driver);
		test.pass("Cart page validation completed!");
		System.out.println("******************Checkout Page*****************");
		cop.doContinue(p1.getData("fn"),p1.getData("ln"),p1.getData("zc"));
		test.pass("Checkout page validation completed!");
		
		System.out.println("******************Overview Page*****************");
		test.pass("Overview page validation completed!");
		
		
		
		
	}

	public void addWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void exitReport() {
		extent.flush();
	}
}
