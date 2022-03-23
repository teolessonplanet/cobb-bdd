package steps;

import java.text.ParseException;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContentManagerPage;
import util.Data;

public class CobbContentManagerSteps extends BaseTest {

	ContentManagerPage contentManagerPage = new ContentManagerPage(driver);

	@Then("{string} sub-title is displayed")
	public void content_manager_subtitle_is_displayed(String subtitle) {
		Assert.assertEquals(contentManagerPage.getPageSubtitleText(), subtitle);
	}

	@Then("Search text field is displayed")
	public void search_text_field_is_displayed() {
		Assert.assertTrue(contentManagerPage.isSearchTextFieldTextDisplayed());
	}

	@Then("Sort by dropdown is displayed")
	public void sort_by_dropdown_is_displayed() {
		Assert.assertTrue(contentManagerPage.isSortByOptionDropdownDisplayedt());
	}

	@Then("Facet sidebar is displayed")
	public void facet_sidebar_is_displayed() {
		Assert.assertTrue(contentManagerPage.isFacetSidebarDisplayed());
	}

	@Then("Resource cards list is displayed")
	public void resource_cards_list_is_displayed() {
		Assert.assertTrue(contentManagerPage.isResourceCardsListDisplayed());
	}

	@When("User types {string} inside search bar")
	public void user_types_a_keyword_inside_search_bar(String keyword) {
		contentManagerPage.typeSearchText(keyword);
	}

	@When("User clicks the search icon")
	public void user_clicks_the_search_icon() {
		contentManagerPage.clickOnSearchButton();
	}

	@Then("Search results are displayed on Content Manager Page for {string}")
	public void search_results_are_displayed_on_cntent_manager_page(String keyword) throws ParseException {
		Assert.assertTrue(contentManagerPage.getSearchTextFieldText(keyword)
				.contains(Data.CONTENT_MANAGER_SEARCH_TEXT + " " + keyword));
		Assert.assertEquals(contentManagerPage.getSearchInputText(), keyword);
	}

	@When("User clicks the close button from search input")
	public void user_clicks_close_button_from_search() {
		contentManagerPage.clickOnSearchCloseButton();
	}

	@Then("The keyword is not displayed anymore in the search input")
	public void keyword_is_not_displayed_inside_search_input() {
		Assert.assertTrue(contentManagerPage.getSearchInputText().isEmpty());
	}

	@Then("Resource result list has Thumbnail image, Pool Name, Resource title, Resource type, Grade, Rating, Views, Description, Keyterms, Concepts, Additional tags, Standards, Quick View button, Hide from Search checkbox,")
	public void check_resource_cards_details() {
		Assert.assertTrue(contentManagerPage.isResourceProviderDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceHideFromViewDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceTitleDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceThumbnailDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceTypeDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceGradesDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceRatingDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceViewsDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceDescriptionDisplayed(0));
		Assert.assertTrue(contentManagerPage.isResourceQuickViewButtonDisplayed(0));
	}

}