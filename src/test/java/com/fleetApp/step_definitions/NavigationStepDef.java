package com.fleetApp.step_definitions;

import com.fleetApp.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationStepDef {

	private HomePage homePage = new HomePage();

	@When("The user navigates to {string} - {string} module")
	public void the_user_navigates_to_module(String module, String subModule) {
		homePage.navigateToModule(module,subModule);
		homePage.waitUntilLoaderScreenDisappear();
	}

	@Then("The title of the page contains {string}")
	public void the_title_of_the_page_contains(String title) {
		String expectedTitle = title;
		String actualTitle = homePage.getPageTitle();

		System.out.println("expectedTitle: " + expectedTitle);
		System.out.println("actualTitle: " + actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}


}
