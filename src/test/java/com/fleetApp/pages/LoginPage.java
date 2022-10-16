package com.fleetApp.pages;

import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//---locators----------------
	@FindBy(id = "prependedInput")
	private WebElement usernameField;

	@FindBy(id = "prependedInput2")
	private WebElement passwordField;

	@FindBy(id = "_submit")
	private WebElement loginBtn;


	//---methods-----------------
	public void goLoginPage(){
		Driver.get().get(ConfigurationReader.get("url"));
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
		return Driver.get().getTitle();
	}



}
