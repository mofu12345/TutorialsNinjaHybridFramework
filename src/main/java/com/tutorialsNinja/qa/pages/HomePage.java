package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@type,'button')][@class='btn btn-default btn-lg']")
	private WebElement searchButton;
		
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount()
	{
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage nevigateToLoginPage()
	{
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductNameInTheSearchBoxField(String productText)
	{
		searchBoxField.sendKeys(productText);
	}
	
	public SearchPage clickOnSearchButton()
	{
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public RegisterPage nevigateToRegisterPage()
	{
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

}
