package com.fleetApp.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {


	public static void wait(int second) {
		second *= 1000;
		try {
			Thread.sleep(second);
		} catch (InterruptedException ignored) {
		}
	}


	//wait for clickability of an element then click
	public static void clickWithWait(WebElement element, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
