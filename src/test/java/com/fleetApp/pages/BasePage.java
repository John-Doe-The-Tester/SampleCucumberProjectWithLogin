package com.fleetApp.pages;

import com.fleetApp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;

	//constructor
	BasePage() {
		this.driver = Driver.get();
		PageFactory.initElements(driver, this);
	}

	//---locators----------------
	@FindBy(css = "div[class='loader-mask shown']")
	@CacheLookup
	protected WebElement loaderMask;


	//---methods-----------------
	/**
	 * Waits until loader screen present. If loader screen will not pop up at all,
	 * NoSuchElementException will be handled  bu try/catch block
	 * Thus, we can continue in any case.
	 */
	public void waitUntilLoaderScreenDisappear() {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), 8);
			wait.until(ExpectedConditions.invisibilityOf(loaderMask));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
