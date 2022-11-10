package com.fleetApp.step_definitions;

import com.fleetApp.pages.HomePage;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogoutStepDef {

	private HomePage homePage = new HomePage();

	@When("The user clicks on logout btn in the profile menu")
	public void the_user_clicks_on_logout_btn_in_the_profile_menu() {
		homePage.logOut();
	}

	@Then("The user ends up in {string} page")
	public void the_user_ends_up_in_page(String excepctedPage) {
		BrowserUtils.waitForTitleContains(excepctedPage,3);
		String actualPage = homePage.getPageTitle();
		Assert.assertEquals(actualPage,excepctedPage);
	}

	@When("The user clicks on step-back btn in the browser")
	public void the_user_clicks_on_step_back_btn_in_the_browser() {
		homePage.goBack();
	}

	@When("The user closes all the open tabs")
	public void the_user_closes_all_the_open_tabs() {
		// here we open an empty tab in advance,
		// otherwise after closing open tabs,
		// we'll get NoSessionException
		BrowserUtils.openNewTab();

		Set<String> windowHandles = Driver.getDriver().getWindowHandles();
		List<String> allOpenTabs = new ArrayList<>(windowHandles);

		//allOpenTabs.size()-1 --> don't close the empty tab
		for (int i = 0; i < allOpenTabs.size()-1; i++) {
			Driver.getDriver().switchTo().window(allOpenTabs.get(i));
			Driver.getDriver().close();
		}
		BrowserUtils.switchToWindow(0);
	}

	@When("The user navigates to {string}")
	public void the_user_navigates_to(String url) {
		Driver.getDriver().get(url);
	}

	@When("The user is inactive for {int} minutes consecutively")
	public void the_user_is_inactive_for_minutes_consecutively(Integer minute) {
		BrowserUtils.wait(minute * 60);
	}

}
