package com.fleetApp.step_definitions;

import com.fleetApp.pages.HomePage;
import com.fleetApp.pages.Login2and3Page;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Login2and3StepDef {

	private Login2and3Page login2and3Page = new Login2and3Page();
	private HomePage homePage = new HomePage();

	//--------------------------------------------------------

	@When("The user logs in as a {string}")
	public void the_user_logs_in_as_a(String userType) {
		login2and3Page.loginAsUserType(userType);
		login2and3Page.waitUntilLoaderScreenDisappear();
	}

	@Then("The user is on the {string} page")
	public void the_user_is_on_the_page(String expectedTitle) {
		String actualTitle = homePage.getSubtitle();
		Assert.assertEquals(expectedTitle,actualTitle);
	}

	//--------------------------------------------------------

	@When("The user tries to login with {string} and {string}")
	public void the_user_tries_to_login_with_and(String username, String password) {
		login2and3Page.loginWithCredentials(username,password);
		homePage.waitUntilLoaderScreenDisappear();
	}

	@Then("The user can not login and page title is {string}")
	public void the_user_can_not_login_and_page_title_is(String expectedPageTitle) {
		String actualTitle = login2and3Page.getPageTitle();
		Assert.assertEquals(expectedPageTitle,actualTitle);
	}

	//--------------------------------------------------------

	@When("The user logs in with following credentials \\(list)")
	public void the_user_logs_in_with_following_credentials(List<String> credentialsList) {
		String username = credentialsList.get(0);
		String password = credentialsList.get(1);
		login2and3Page.loginWithCredentials(username,password);

		login2and3Page.waitUntilLoaderScreenDisappear();
	}

	//--------------------------------------------------------

	@When("The user logs in with following credentials \\(map)")
	public void the_user_logs_in_with_following_credentials(Map<String,String > credentialsMap) {
		String username = credentialsMap.get("username");
		String password = credentialsMap.get("password");
		login2and3Page.loginWithCredentials(username,password);

		login2and3Page.waitUntilLoaderScreenDisappear();
	}



}
