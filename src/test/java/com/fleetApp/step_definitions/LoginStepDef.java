package com.fleetApp.step_definitions;

import com.fleetApp.pages.HomePage;
import com.fleetApp.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDef {

	private LoginPage loginPage = new LoginPage();
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

	@When("The user logs in as a {string}")
	public void the_user_logs_in_as_a(String userType) {
		loginPage.loginAsUserType(userType);
		loginPage.waitUntilLoaderScreenDisappear();
	}

	@Then("The user is on the {string} page")
	public void the_user_is_on_the_page(String expectedTitle) {
		String actualTitle = homePage.getSubtitle();
		Assert.assertEquals(expectedTitle,actualTitle);
	}


	@When("The user tries to login with {string} and {string}")
	public void the_user_tries_to_login_with_and(String username, String password) {
		loginPage.loginWithCredentials(username,password);
		homePage.waitUntilLoaderScreenDisappear();
	}

	@Then("The user can not login and page title is {string}")
	public void the_user_can_not_login_and_page_title_is(String expectedPageTitle) {
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedPageTitle,actualTitle);
	}


	@When("The user logs in with following credentials \\(list)")
	public void the_user_logs_in_with_following_credentials(List<String> credentialsList) {
		String username = credentialsList.get(0);
		String password = credentialsList.get(1);
		loginPage.loginWithCredentials(username,password);

		loginPage.waitUntilLoaderScreenDisappear();
	}


	@When("The user logs in with following credentials \\(map)")
	public void the_user_logs_in_with_following_credentials(Map<String,String > credentialsMap) {
		String username = credentialsMap.get("username");
		String password = credentialsMap.get("password");
		loginPage.loginWithCredentials(username,password);

		loginPage.waitUntilLoaderScreenDisappear();
	}


}
