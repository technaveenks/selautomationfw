package com.murali.learnings.automation.selautomationfw.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.murali.learnings.automation.selautomationfw.pages.HomePage;
import com.murali.learnings.automation.selautomationfw.pages.SearchResultsPage;
import com.murali.learnings.automation.selautomationfw.utils.BaseTest;
import com.murali.learnings.automation.selautomationfw.utils.DataUtility;

public class PageObjectTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(PageObjectTest.class);
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	@DataProvider(name = "items")
	public static Object[][] items() {
		//return new Object[][] { { "iphone"}, { "apple"}, { "samsung"}};
		return DataUtility.getExcelData();
	}

	
	@Test(groups = { "smoke", "sanity", "search" }, priority=2, dataProvider = "items")
	public void verifySearchOfItems(String data, String price) {
		logger.info("Test started - Page Object Test");
		homePage.clearSearchText();
		homePage.enterSearchText(data);
		searchResultsPage = homePage.clickOnSearchButton();
		//searchResultsPage.clickOnAddToCart();
		logger.info("Test completed - Page Object Test");

	}

	@Test(groups = { "electronics" }, priority=3)
	public void validateElectronicsPage() {
		System.out.println("Electronics");
	}

	@BeforeClass
	public void tsetup() {
		homePage = new HomePage(getDriver());

	}

}
