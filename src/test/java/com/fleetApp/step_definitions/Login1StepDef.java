package com.fleetApp.step_definitions;

import com.fleetApp.pages.HomePage;
import com.fleetApp.pages.Login1Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Driver;

public class Login1StepDef {

	private Login1Page loginPage = new Login1Page();
	private HomePage homePage = new HomePage();

	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		loginPage.goLoginPage();
	}

	@When("The user logs in as a driver")
	public void the_user_logs_in_as_a_driver() {
		loginPage.loginAsDriver();
		homePage.waitUntilLoaderScreenDisappear();
	}

	@When("The user logs in as a sales manager")
	public void the_user_logs_in_as_a_sales_manager() {
		loginPage.loginAsSalesManager();
		homePage.waitUntilLoaderScreenDisappear();
	}

	@When("The user logs in as a store manager")
	public void the_user_logs_in_as_a_store_manager() {
		loginPage.loginAsStoreManager();
		homePage.waitUntilLoaderScreenDisappear();
	}

	@Then("The user is on the Quick Launchpad page")
	public void the_user_is_on_the_Quick_Launchpad_page() {
		String expectedTitle = "Quick Launchpad";
		String actualTitle = homePage.getSubtitle();
		Assert.assertEquals(expectedTitle,actualTitle);
	}

	@Then("The user is on the Dashboard page")
	public void the_user_is_on_the_Dashboard_page() {
		String expectedTitle = "Dashboard";
		String actualTitle = homePage.getSubtitle();
		Assert.assertEquals(expectedTitle,actualTitle);
	}


}
