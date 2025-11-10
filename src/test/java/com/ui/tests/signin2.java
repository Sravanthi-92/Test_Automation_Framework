package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.loginPage;

public class signin2 {

	public static void main(String[] args) {
		WebDriver wb = new ChromeDriver(); //launching the browser, session started
		HomePage homePage = new HomePage(wb);
		loginPage loginPage = homePage.goToLoginPage();
		loginPage.loginWith("fohehi8851@gamegta.com", "password");
		
	}

}
