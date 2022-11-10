package com.fleetApp.pages;

import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//---locators----------------
	@FindBy(id = "prependedInput")
	public WebElement usernameField;

	@FindBy(id = "prependedInput2")
	public WebElement passwordField;

	@FindBy(id = "_submit")
	public WebElement loginBtn;

	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotYourPasswordLink;

	@FindBy(className = "custom-checkbox__icon")
	private WebElement rememberMeBtn;

	@FindBy(css = ".alert.alert-error")
	private WebElement invalidCredenrialMessage;





	//---methods-----------------
	public void goLoginPage(){
		Driver.getDriver().get(ConfigurationReader.get("url"));
	}

	public void loginAsDriver(){
		String username = ConfigurationReader.get("driver_username");
		String password = ConfigurationReader.get("driver_password");

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	public void loginAsSalesManager(){
		String username = ConfigurationReader.get("sales_manager_username");
		String password = ConfigurationReader.get("sales_manager_password");

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	public void loginAsStoreManager(){
		String username = ConfigurationReader.get("store_manager_username");
		String password = ConfigurationReader.get("store_manager_password");

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}


	public void loginAsUserType(String userType){

		String password = "";
		String username = "";

		if (userType.equalsIgnoreCase("driver")) {
			username = ConfigurationReader.get("driver_username");
			password = ConfigurationReader.get("driver_password");
		}
		else if (userType.equalsIgnoreCase("sales manager")) {
			username = ConfigurationReader.get("sales_manager_username");
			password = ConfigurationReader.get("sales_manager_password");
		}
		else if (userType.equalsIgnoreCase("store manager")) {
			username = ConfigurationReader.get("store_manager_username");
			password = ConfigurationReader.get("store_manager_password");
		}

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}


	public void loginWithCredentials(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	public String getPageTitle(){
		return Driver.getDriver().getTitle();
	}

	public void enterUsernameOrPassword(String value, String field){
		switch (field) {
			case "username":
				BrowserUtils.sendKeysWithWait(usernameField,value,3);
				break;
			case "password":
				BrowserUtils.sendKeysWithWait(passwordField,value,3);
				break;
		}
	}

	//method overloading
	public String getWarningMessage(String field){
		String message = "";

		switch (field) {

			case "username":
				message = usernameField.getAttribute("validationMessage");
				System.out.println("Message is: " + message);
				break;

			case "password":
				message = passwordField.getAttribute("validationMessage");
				System.out.println("Message is: " + message);
				break;
		}

		return message;

	}

	//method overloading
	public String getWarningMessage(){
		BrowserUtils.waitForText(invalidCredenrialMessage,"Invalid");
		return invalidCredenrialMessage.getText();
	}

	public String isBulletSign(){
		return passwordField.getAttribute("type");
	}

	public void clickForgotYourPassword(){
		BrowserUtils.clickWithWait(forgotYourPasswordLink,3);
	}

	public void clickRememberMeBtn(){
		BrowserUtils.clickWithWait(rememberMeBtn,3);
	}

	public void hitEnterKey(){
		Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
	}




}
