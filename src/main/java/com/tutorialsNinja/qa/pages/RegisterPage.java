package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath = "//input[contains(@name,'agree')]")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLatterOption;
	
	@FindBy(xpath = "//div[contains(text(),'Warning: E-Mail Address is already registered!')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firsNameText, String lastNameText, String emailTextField, String telephoneNumberField, String passwordField1, String passwordField2)
	{
		firstNameField.sendKeys(firsNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailTextField);
		telephoneField.sendKeys(telephoneNumberField);
		passwordField.sendKeys(passwordField1);
		passwordConfirmField.sendKeys(passwordField2);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithAllFields(String firsNameText, String lastNameText, String emailTextField, String telephoneNumberField, String passwordField1, String passwordField2)
	{
		firstNameField.sendKeys(firsNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailTextField);
		telephoneField.sendKeys(telephoneNumberField);
		passwordField.sendKeys(passwordField1);
		passwordConfirmField.sendKeys(passwordField2);
		yesNewsLatterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void enterFirstName(String firstNameText)
	{
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailTextField)
	{
		emailField.sendKeys(emailTextField);
	}
	
	public void enterTelephoneNumber(String telephoneNumberField)
	{
		telephoneField.sendKeys(telephoneNumberField);
	}

	public void enterPassword(String passwordField1)
	{
		passwordField.sendKeys(passwordField1);
	}
	
	public void enterToConfirmPassword(String passwordField2)
	{
		passwordConfirmField.sendKeys(passwordField2);
	}
	
	public void selectPrivacyPolicy()
	{
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsletterOption()
	{
		yesNewsLatterOption.click();
	}
	
	public String retrievePasswordWarning()
	{
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	
	public String retrieveTelephoneWarning()
	{
		String telephoneWarningText=telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrieveEmailWarning()
	{
		String emailWarningText=emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrievelastNameWarning()
	{
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrievefirstNameWarning()
	{
		String firstNameWarningText= firstNameWarning.getText();
		return firstNameWarningText;
	}
	public String retrievePrivacyPolicyWarning()
	{
		String privacyPolicyWarningText= privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	
	public String retrieveDuplicateEmailWarning()
	{
		String duplicateEmailWarningText=duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;
	}
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning)
	{
		String actualPrivacyPolicyWarningText= privacyPolicyWarning.getText();
		boolean privacyPolicyWarningStatus= actualPrivacyPolicyWarningText.contains(expectedPasswordWarning);
		
		String actualFirstNameWarningText=firstNameWarning.getText();
		boolean firstNameWarningStatus= actualFirstNameWarningText.equals(expectedFirstNameWarning);
		
		String actualLastNameWarning=lastNameWarning.getText();
		boolean lastNameWarningStatus=actualLastNameWarning.equals(expectedLastNameWarning);
		
		String actualEmailWarningText= emailWarning.getText();
		boolean emailWarningStatus= actualEmailWarningText.equals(expectedEmailWarning);
		
		String actualTelephoneWarningText= telephoneWarning.getText();
		boolean telephoneWarningStatus= actualTelephoneWarningText.equals(expectedTelephoneWarning);
		
		String actualPasswordWarningText= passwordWarning.getText();
		boolean passwordWarningStatus= actualPasswordWarningText.equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
	}
}
