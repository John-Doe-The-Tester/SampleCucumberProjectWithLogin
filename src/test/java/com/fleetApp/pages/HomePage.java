package com.fleetApp.pages;

import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	@FindBy(className = "li.launcher-item a[title = 'Delete']")
//	private WebElement threeDotsDeleteBtn;

	@FindBy(className = "oro-subtitle")
	private WebElement pageSubtitle;

	@FindBy(css = "li a.dropdown-toggle")
	private WebElement profileMenu;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutBtn;

	public void clickProfileMenu(){
		BrowserUtils.clickWithWait(profileMenu,2);
	}

	public String getSubtitle(){
		BrowserUtils.wait(1);
		return pageSubtitle.getText();
	}

	public void logOut(){
		clickProfileMenu();
		BrowserUtils.clickWithWait(logoutBtn,2);
	}

	public String getProfileName(){
		waitUntilLoaderScreenDisappear();
		BrowserUtils.waitForVisibility(profileMenu,2);
		return profileMenu.getText();
	}

	public void goBack(){
		Driver.getDriver().navigate().back();
	}

}
