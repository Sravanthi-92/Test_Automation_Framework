package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utilities.LoggerUtility;
@Listeners({com.ui.listeners.TestListener.class})
public class signin3 extends TestBase{
    Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Test(description = "Verify user is able to login with valid credentials..", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {
		assertEquals(homePage.goToLoginPage().loginWith(user.getEmailaddress(), user.getPassword()).getUserName(), "Test Test");
	}
	
	@Test(description = "Verify user is able to login with valid credentials..", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		assertEquals(homePage.goToLoginPage().loginWith(user.getEmailaddress(), user.getPassword()).getUserName(), "Test Test");
	}
	@Test(description = "Verify user is able to login with valid credentials..", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryListeners.class)
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLoginPage().loginWith(user.getEmailaddress(), user.getPassword()).getUserName(), "Test Test2");
	}

}
