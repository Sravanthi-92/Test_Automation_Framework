package com.ui.tests;

import static com.constants.Browser.EDGE;

import java.sql.Driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtilities;
import com.utilities.LambdaTestUtility;
import com.utilities.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "Load the homepage of the website")
    public void setUp(
    		@Optional("chrome") String browser, 
    		@Optional("true") boolean isLambdaTest, 
    	    @Optional("false") boolean isHeadless,  ITestResult result) {
		
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			lambdaDriver=LambdaTestUtility.initializeLambdaTest(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}
		else {
    	logger.info("Load the Homepage of the website");
    	homePage = new HomePage(Browser.EDGE, isHeadless);
		}
    	
    }
	
	public BrowserUtilities getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}else {
			homePage.getDriver().quit();
		}
		
	}

}
