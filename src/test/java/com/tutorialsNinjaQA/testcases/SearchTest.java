package com.tutorialsNinjaQA.testcases;

import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.SearchPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.QA.base.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;
	
	public SearchTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyingSearchWithValidProduct()
	{
		homePage.enterProductNameInTheSearchBoxField(dataProp.getProperty("validProduct"));
		searchPage=homePage.clickOnSearchButton();
		
		Assert.assertTrue(searchPage.displayStatusOfSearchProduct(),"valid product is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyingSearchWithInvalidProduct()
	{
		homePage.enterProductNameInTheSearchBoxField(dataProp.getProperty("invalidProduct"));
		searchPage=homePage.clickOnSearchButton();
		
		String actualErrorSearchMessage=searchPage.retrieveNoProductMessage();
		Assert.assertEquals(actualErrorSearchMessage,dataProp.getProperty("noProductMassageInSearchResult"), "Error message not displayed ");
	}
	
	@Test(priority = 3)
	public void verifyingSearchWithoutAnyProduct()
	{
		searchPage=homePage.clickOnSearchButton();
		
		String actualErrorSearchMessage=searchPage.retrieveNoProductMessage();
		Assert.assertTrue(actualErrorSearchMessage.contains(dataProp.getProperty("noProductMassageInSearchResult")), "Error message not displayed ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
