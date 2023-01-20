package com.murali.learnings.automation.selautomationfw.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	public void setup() {
		driver = WebDriverHelper.createDriver();
	}

	@AfterSuite
	public void teardown() {
		// driver.close();
		driver.quit();
	}
}
