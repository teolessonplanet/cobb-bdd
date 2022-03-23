package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;
import pages.SearchPage;
import util.Data;

public class CobbHeaderSteps extends BaseTest {

	HeaderPage headerPage = new HeaderPage(driver);
	SearchPage searchPage = new SearchPage(driver);

	@When("User hovers over Discover dropdown")
	public void user_hovers_over_discover_dropdown() {
		headerPage.hoverOverDiscoverDropdown();
	}

	@When("User hovers over User dropdown")
	public void user_hovers_over_user_dropdown() {
		headerPage.hoverOverUsernameDropdown();
	}

	@And("User clicks on {string} button from header")
	public void user_clicks_on_header_buttons(String option) {
		switch (option) {
		case Data.DISCOVER_RESOURCES:
			headerPage.clickOnDiscoverResourcesButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.BROWSE_RESOURCE_DIRECTORY_MAIN_PAGE:
			headerPage.clickOnBrowseResourceDirectoryButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.CURRICULUM_MANAGER:
			headerPage.clickOnCurriculumManagerButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.CURRICULUM_CALENDAR:
			headerPage.clickOnCurriculumCalendarButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.MY_ACCOUNT:
			headerPage.clickOnMyAccountButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.MY_RESOURCES:
			headerPage.clickOnMyResourcesButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.ADMIN_MANAGER:
			headerPage.clickOnAdminManagerButton();
			headerPage.waitForLinkToLoad();
			break;
		case Data.SIGN_OUT:
			headerPage.clickOnSignOutButton();
			headerPage.waitForLinkToLoad();
			break;
		}
	}

	@Then("Resources text is displayed")
	public void resources_text_is_displayed_in_the_header() {
		Assert.assertTrue(headerPage.isResourceTextDisplayed());
	}

	@And("Discover and User Dropdown are displayed")
	public void header_dropdowns_are_diplayed() {
		Assert.assertTrue(headerPage.isDiscoverDropdownDisplayed());
		Assert.assertTrue(headerPage.isUserDropdownDisplayed());
	}

	@And("Search input is empty")
	public void search_input_is_empty() {
		Assert.assertEquals(headerPage.getSearchInputText(), Data.BLANK);
	}

	@And("{string} placeholder is displayed inside the search input")
	public void get_placeholder_text(String placeholderText) {
		Assert.assertEquals(headerPage.getSearchInputPlaceholderText(), placeholderText);
	}

	@And("The search button with the magnifying glass icon is displayed")
	public void search_button_with_the_magnifying_glass_is_displayed() {
		Assert.assertEquals(headerPage.getSearchButtonText(), Data.BLANK);
	}

	@When("User clicks the search input")
	public void user_clicks_on_search_input() {
		headerPage.clickOnSearchInput();
	}

	@Then("The search button with the {string} text is displayed")
	public void search_button_with_search_text_is_displayed(String searchText) {
		Assert.assertEquals(headerPage.getSearchButtonText(), searchText);
	}

	@When("User types {string} inside the search input")
	public void user_types_keyword(String keyword) {
		headerPage.typeSearchText(keyword);
	}

	@And("User does not click the search button")
	public void user_does_not_click_the_search_button() {

	}

	@When("User clicks outside the search input")
	public void user_clicks_outside_search_input() {
		headerPage.clickOnResourcesHeaderText();
	}

	@And("Search is not performed")
	public void search_is_not_performed() {
		Assert.assertEquals(headerPage.getPath(), Data.SEARCH.toLowerCase());
	}

	@And("User clicks the search button")
	public void user_clicks_search_icon() {
		headerPage.clickOnSearchButton();
	}

	@Then("{string} is displayed inside the search input")
	public void get_search_input_keyword(String keyword) {
		Assert.assertEquals(headerPage.getSearchInputText(), keyword);
	}

	@And("X is displayed in the search input")
	public void clear_button_is_displayed() {
		Assert.assertTrue(headerPage.isClearButtonDisplayed());
	}

	@When("User clicks on the X button")
	public void user_clicks_the_clear_button() {
		headerPage.clickOnClearButton();
		if (searchPage.isClearAllButtonDisplayed()) {
			searchPage.clickOnClearAllButton();
		}
	}

}
