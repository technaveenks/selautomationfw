package com.murali.learnings.automation.selautomationfw.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenParameters {

	@Test
	public void MavenParamTest() throws InterruptedException {
		WebDriver driver = null;

		String browser = System.getProperty("browser", "chrome");
		if (driver == null) {
			if (browser.contains("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("http://www.tutorialsninja.com/demo/");
				// Maximize Screen
				driver.manage().window().maximize();
			} else if (browser.contains("firefox")) {
				System.out.println(" Firefox browser initiated");
			}

		}
	}

}
