package com.tutorialsNinjaQA.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.QA.base.Base;
import com.tutorialsNinja.qa.pages.AccountSuccessPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.RegisterPage;
import com.tutorialsNinja.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		registerPage= homePage.nevigateToRegisterPage();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryField()
	{	
		AccountSuccessPage accountSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimesStamp(), dataProp.getProperty("phoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		String actualSuccessHeading=accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account successful page is not displayed");
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields()
	{
		AccountSuccessPage accountSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimesStamp(), dataProp.getProperty("phoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		String actualSuccessHeading=accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account successful page is not displayed");
	}
	
	@Test(priority=3)
	public void verifyingRegisteringAccountWithExistingEmailAddress()
	{
		registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("phoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		String actualDuplicateEmailMessage=registerPage.retrieveDuplicateEmailWarning();
		Assert.assertTrue(actualDuplicateEmailMessage.contains(dataProp.getProperty("duplicateEmailWarning")),"warning message is not displayed");
	}
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails()
	{
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning", dataProp.getProperty("passwordWarning")), "Warning messages are not displayed"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
