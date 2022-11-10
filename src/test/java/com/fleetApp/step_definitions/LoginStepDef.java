package com.fleetApp.step_definitions;

import com.fleetApp.pages.ForgotPasswordPage;
import com.fleetApp.pages.HomePage;
import com.fleetApp.pages.LoginPage;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginStepDef {

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	private String currentURL;

	@When("The user copy the URL and then logs out")
	public void the_user_copy_the_url_and_then_logs_out() {
		currentURL = BrowserUtils.getURL();
		System.out.println("current URL is: " + currentURL);
		homePage.logOut();
	}

	@Then("{string} message should be displayed in {string} field")
	public void message_should_be_displayed_in_field(String expectedMessage, String field) {
		BrowserUtils.wait(0.5);
		String actualMessage = loginPage.getWarningMessage(field);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@When("The user clicks on login btn while username field is empty")
	public void the_user_clicks_on_login_btn_while_username_field_is_empty() {
		loginPage.loginWithCredentials("", "");
	}

	@When("The user enters any username and click on login btn while password field is empty")
	public void the_user_enters_any_username_and_click_on_login_btn_while_password_field_is_empty() {
		BrowserUtils.wait(1);
		loginPage.loginWithCredentials("blablabla :))", "");
	}

	@When("The user enters wrong username and password")
	public void the_user_enters_wrong_username_and_password() {
		BrowserUtils.wait(1);
		loginPage.loginWithCredentials("blablabla :)", "blablabla :)");
	}

	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String expectedMessage) {
		String actualMessage = loginPage.getWarningMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@When("The user enters anything into password field")
	public void the_user_enters_anything_into_password_field() {
		loginPage.loginWithCredentials("", "blablabla :)");
	}

	@Then("The password field must be seen in bullet sign")
	public void the_password_field_must_be_seen_in_bullet_sign() {
		BrowserUtils.wait(1);
		Assert.assertEquals(loginPage.isBulletSign(), "password");
	}

	@When("The user clicks on Forgot your password? link")
	public void the_user_clicks_on_forgot_your_password_link() {
		loginPage.clickForgotYourPassword();
	}

	@Then("The user lands on the {string} page")
	public void the_user_lands_on_the_page(String pageTitle) {
		Assert.assertEquals(pageTitle, Driver.getDriver().getTitle());
	}

	@When("The user logs out and go to login page again")
	public void the_user_logs_out_and_go_to_login_page_again() {
		BrowserUtils.openNewTab();
		homePage.logOut();
		Driver.getDriver().close();
		BrowserUtils.switchToWindow(0);
		loginPage.goLoginPage();
	}

	@When("The user enters {string} into {string} field")
	public void theUserEntersIntoField(String value, String field) {
		loginPage.enterUsernameOrPassword(value, field);
	}

	@When("Hit the enter key on keyboard")
	public void hit_the_enter_key_on_keyboard() {
		loginPage.hitEnterKey();
	}

	@Given("The user logs in with following credentials map")
	public void the_user_logs_in_with_following_credentials_map(Map<String, String> credentialsMap) {
		String username = credentialsMap.get("username");
		String password = credentialsMap.get("password");
		loginPage.loginWithCredentials(username, password);

		loginPage.waitUntilLoaderScreenDisappear();
	}

	@When("The user clicks on profile menu")
	public void the_user_clicks_on_profile_menu() {
		homePage.clickProfileMenu();
	}

	@Then("The user can see his own username {string} in the profile menu")
	public void the_user_can_see_his_own_username_in_the_profile_menu(String username) {
		System.out.println("Actual Profile Name: " + homePage.getProfileName());
		System.out.println("Expectedd Profile Name: " + username);
		System.out.println(homePage.getProfileName());
		Assert.assertEquals(username, homePage.getProfileName());
	}

	@Given("Username and password input boxes have proper placeholders")
	public void username_and_password_input_boxes_have_proper_placeholders() {
		String userNameAttribute = loginPage.usernameField.getAttribute("placeholder");
		String passwordAttribute = loginPage.passwordField.getAttribute("placeholder");

		Assert.assertEquals(userNameAttribute, "Username or Email");
		Assert.assertEquals(passwordAttribute, "Password");
	}

	@Given("the user should see the background color of {string} button as {string}")
	public void theUserShouldSeeTheBackgroundColorOfButtonAs(String WebElement, String colorCode) {
		BrowserUtils.wait(2);
		String cssValue = loginPage.loginBtn.getCssValue("background-color");
		System.out.println(cssValue);

		String asHex = Color.fromString(cssValue).asHex();
		System.out.println(asHex);
		Assert.assertEquals(colorCode, asHex);

	}

	@Given("the user enters valid credentials to password input box")
	public void theUserEntersValidCredentialsToPasswordInputBox() {
		loginPage.passwordField.sendKeys("UserUser123");
	}


	@And("the system should not allow user to copy password")
	public void theSystemShouldNotAllowUserToCopyPassword() {
		BrowserUtils.wait(3);
		loginPage.passwordField.sendKeys(Keys.chord(Keys.CONTROL, "A"));
		loginPage.passwordField.sendKeys(Keys.chord(Keys.CONTROL, "C"));
		String localClipboardData = null;
		try {
			localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Assert.assertNotEquals("UserUser123", localClipboardData);
		System.out.println(localClipboardData);
	}

	@When("Paste the copied URL to the browser")
	public void paste_the_copied_url_to_the_browser() {
		Driver.getDriver().navigate().to(currentURL);
	}

	@Then("The user is still on the login page")
	public void the_user_is_still_on_the_login_page() {
		BrowserUtils.waitForURLContains("login", 5);
		currentURL = Driver.getDriver().getCurrentUrl();
		System.out.println("current URL is: " + currentURL);

		Assert.assertTrue(currentURL.contains("login"));
	}

	@Then("the password is not visible in the Page Source")
	public void thePasswordIsNotVisibleInThePageSource() {
		String pageSource = Driver.getDriver().getPageSource();
		Assert.assertFalse(pageSource.contains("UserUser123"));
	}

	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		loginPage.goLoginPage();
	}

	//feature: login1
	@When("The user logs in as a driver")
	public void the_user_logs_in_as_a_driver() {
		loginPage.loginAsDriver();
		homePage.waitUntilLoaderScreenDisappear();
	}

	//feature: login1
	@When("The user logs in as a sales manager")
	public void the_user_logs_in_as_a_sales_manager() {
		loginPage.loginAsSalesManager();
		homePage.waitUntilLoaderScreenDisappear();
	}

	//feature: login1
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

	//feature: login2 and login3
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

	@When("The user enters any username {string} and clicks on request btn")
	public void the_user_enters_any_username_and_clicks_on_request_btn(String username) {
		forgotPasswordPage.resetPassword(username);
	}

	@Then("The user successfully reset the password")
	public void the_user_successfully_reset_the_password() {
		Assert.assertFalse(forgotPasswordPage.getMessage().contains("Unable to send the email"));
	}

	@Then("The user gets a warning message containing {string}")
	public void the_user_gets_a_warning_message_containing(String expectedMessage) {
		Assert.assertTrue(forgotPasswordPage.getMessage().contains(expectedMessage));
	}

	@Given("The user clicks on RememberMe btn and logs in with following credentials")
	public void the_user_clicks_on_remember_me_btn_and_logs_in_with_following_credentials(Map<String, String> credentials) {
		loginPage.clickRememberMeBtn();
		loginPage.loginWithCredentials(credentials.get("username"), credentials.get("password"));
	}


	//feature: login2
	@When("The user logs in with following credentials \\(list)")
	public void the_user_logs_in_with_following_credentials(List<String> credentialsList) {
		String username = credentialsList.get(0);
		String password = credentialsList.get(1);
		loginPage.loginWithCredentials(username,password);

		loginPage.waitUntilLoaderScreenDisappear();
	}


	//feature: login2
	@When("The user logs in with following credentials \\(map)")
	public void the_user_logs_in_with_following_credentials(Map<String,String > credentialsMap) {
		String username = credentialsMap.get("username");
		String password = credentialsMap.get("password");
		loginPage.loginWithCredentials(username,password);

		loginPage.waitUntilLoaderScreenDisappear();
	}


}
