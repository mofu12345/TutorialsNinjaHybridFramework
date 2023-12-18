package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfSearchProduct()
	{
		boolean displayStatus=validProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductMessage()
	{
		String errorMessage=noProductMessage.getText();
		return errorMessage;
	}
}
