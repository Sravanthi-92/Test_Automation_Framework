package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utilities.BrowserUtilities;
import com.utilities.JSONUtility;
import com.utilities.LoggerUtility;

import static com.utilities.PropertiesUtility.*;

public class HomePage extends BrowserUtilities {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGNINLOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	
	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
		maximizeWindow();
		goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		maximizeWindow();
		goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public loginPage goToLoginPage() {
		logger.info("Trying to perform click to go to login page");
		clickOn(SIGNINLOCATOR);
		loginPage loginPage = new loginPage(getDriver());
		return loginPage;
		
	}

}
