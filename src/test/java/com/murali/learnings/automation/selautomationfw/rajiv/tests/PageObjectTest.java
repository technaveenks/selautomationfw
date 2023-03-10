package com.murali.learnings.automation.selautomationfw.rajiv.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.murali.learnings.automation.selautomationfw.pages.HomePage;
import com.murali.learnings.automation.selautomationfw.pages.SearchResultsPage;
import com.murali.learnings.automation.selautomationfw.utils.BaseTest;

public class PageObjectTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(PageObjectTest.class);
	HomePage homePage;
	SearchResultsPage searchResultsPage;

	@Test(groups = { "smoke", "sanity", "search" }, enabled=false)
	public void verifySearchOfItems() {
		logger.info("Test started - Page Object Test");
		homePage.clearSearchText();
		homePage.enterSearchText("iPhone");
		searchResultsPage = homePage.clickOnSearchButton();
		searchResultsPage.clickOnAddToCart();
		logger.info("Test completed - Page Object Test");

	}

	@Test(groups = { "electronics" }, enabled=false)
	public void validateElectronicsPage() {
		System.out.println("Electronics");
	}

	@BeforeClass
	public void tsetup() {
		homePage = new HomePage(getDriver());

	}

}
