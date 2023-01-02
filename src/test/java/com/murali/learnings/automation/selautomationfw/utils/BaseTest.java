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
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		// Maximize Screen
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void teardown() {
		// driver.close();
		driver.quit();
	}
}
