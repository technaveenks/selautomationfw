package com.murali.learnings.automation.selautomationfw.rajiv.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.murali.learnings.automation.selautomationfw.utils.BaseTest;

public class SmokeTest extends BaseTest {
	//Page Object
	@FindBy(name = "search")
	private WebElement _txtSearch;

	@Test(groups = { "smoke", "sanity" }, enabled=false)
	public void verifySearchOfItems() {
		getDriver().findElement(By.name("search")).clear();
		getDriver().findElement(By.name("search")).sendKeys("iPhone");
		getDriver().findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();


	}

}
