package com.fleetApp.pages;

import com.fleetApp.utilities.ConfigurationReader;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login1Page extends BasePage {

	//---locators----------------
	@FindBy(id = "prependedInput")
	private WebElement usernameField;

	@FindBy(id = "prependedInput2")
	private WebElement passwordField;

	@FindBy(id = "_submit")
	private WebElement loginBtn;


	//---methods-----------------
	public void goLoginPage(){
		driver.get(ConfigurationReader.get("url"));
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



}
