package com.murali.learnings.automation.selautomationfw.rajiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	// Locator
	@FindBy(xpath="//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
	private WebElement _btnAddToCart;
	
	//Actions
	public void clickOnAddToCart() {
		_btnAddToCart.click();
	}
	
}
