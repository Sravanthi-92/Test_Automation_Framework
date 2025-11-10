package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtilities;

public final class loginPage extends BrowserUtilities {
	
	private static final By EMAIL_ID_LOCATOR=By.id("email");
	private static final By PASSWORD_ID_LOCATOR=By.id("passwd");
	private static final By SUBMIT_BTN_LOCATOR=By.id("SubmitLogin");

	public loginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage loginWith(String emailaddress, String password) {
		enterText(EMAIL_ID_LOCATOR, emailaddress);
		enterText(PASSWORD_ID_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);
		MyAccountPage accountPage;
		accountPage = new MyAccountPage(getDriver());
		return accountPage;
		
	}

}
