package com.fleetApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(className = "oro-subtitle")
	private WebElement pageSubtitle;

	public String getSubtitle(){
		return pageSubtitle.getText();
	}

}
