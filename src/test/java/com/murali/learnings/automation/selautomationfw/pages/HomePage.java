package com.murali.learnings.automation.selautomationfw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(name = "search")
	private WebElement _txtSearch;

	@FindBy(xpath = "//*[@id='search']/span/button")
	private WebElement _btnSearch;

	// actions to locators
	public void clearSearchText() {
		_txtSearch.clear();
	}
	
	public void enterSearchText(String value) {
		_txtSearch.sendKeys(value);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		_btnSearch.click();
		return new SearchResultsPage(getDriver());
	}
}
