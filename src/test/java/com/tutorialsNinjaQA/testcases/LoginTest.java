package com.tutorialsNinjaQA.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.QA.base.Base;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.LoginPage;
import com.tutorialsNinja.qa.utils.Utilities;

public class LoginTest extends Base
{	
	public WebDriver driver;
	LoginPage loginPage;
	
	public LoginTest()
	{
		super();
	}
		
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		loginPage=homePage.nevigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider
	public Object[][] supplyTestData()
	{
		Object [][] data=Utilities.readTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority = 1,dataProvider = "supplyTestData")
	public void verifyLoginWithValidCredentials(String email,String password)
	{	
		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOFeditYourAccountInformationOption(),"get account information is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials()
	{
		loginPage.login(Utilities.generateEmailWithTimesStamp(), dataProp.getProperty("invalidPassword"));
		
		String actualWarningMessage=loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWaringMessage),"expected warning message is not displayed");
	}
	
	@Test(priority = 3)
	public void verifyingWithInvalidEmailAndValidPassword()
	{
		loginPage.login(Utilities.generateEmailWithTimesStamp(), prop.getProperty("validPassword"));
		
		String actualWarningMessage=loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWaringMessage),"expected warning message is not displayed");
	}
	
	@Test(priority = 4)
	public void verifyingLoginWithValidEmailAndInvalidPassword()
	{
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		
		String actualWarningMessage=loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWaringMessage),"expected warning message is not displayed");
	}
	
	@Test(priority = 5)
	public void verifyingLoginWithoutProvidingCredentials()
	{
		loginPage.clickOnLoginButton();
		
		String actualWarningMessage=loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWaringMessage),"expected warning message is not displayed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
