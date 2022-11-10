package com.fleetApp.pages;

import com.fleetApp.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

	@FindBy(className = "alert")
	private WebElement message;

	@FindBy(id = "prependedInput")
	private WebElement usernameInput;

	@FindBy(css = "button[type='submit']")
	private WebElement requestBtn;

	public String getMessage(){
		BrowserUtils.waitForVisibility(message,2);
		System.out.println(message.getText());
		return message.getText();
	}

	public void resetPassword(String username){
		BrowserUtils.sendKeysWithWait(usernameInput, username,2);
		BrowserUtils.clickWithWait(requestBtn,1);
	}


}
