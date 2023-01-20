package com.murali.learnings.automation.selautomationfw.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHelper {
	 protected static Properties _userProperties = new Properties();
	 static WebDriver driver;
	
	 public WebDriverHelper() throws IOException{
		 loadProperties();
	 }
	
	public static Properties loadProperties() throws IOException {
		try {
			FileInputStream configStreams = new FileInputStream("config.user.properties");
			_userProperties.load(configStreams);
			return _userProperties;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userProperties;
		
	}
	
	public static String getStringProperty(String propertyName) {
		try {
			_userProperties = loadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = _userProperties.getProperty(propertyName);
		return value;
	}
	
	public static WebDriver createDriver() {
		
			if(driver==null) {
				String browser = getStringProperty("browser");
				if(browser.contains("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get("http://www.tutorialsninja.com/demo/");
					// Maximize Screen
					driver.manage().window().maximize();		
			}else if(browser.contains("firefox")) {
				System.out.println(" Firefox browser initiated");
			}
			
		}
		return driver;
		
	}
	
	/*
	 * public static void main(String[] args) { String value = getString("env");
	 * System.out.println(value); value = getString("url");
	 * System.out.println(value); }
	 */
	

}
