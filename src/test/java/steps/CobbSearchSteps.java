package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CollectionRrpPage;
import pages.FolderRrpPage;
import pages.ResourceRrpPage;
import pages.SearchPage;
import util.Data;

public class CobbSearchSteps extends BaseTest {

	SearchPage searchPage = new SearchPage(driver);
	CollectionRrpPage collectionRrpPage = new CollectionRrpPage(driver);
	ResourceRrpPage resourceRrpPage = new FolderRrpPage(driver);
	FolderRrpPage folderRrpPage = new FolderRrpPage(driver);

	@Then("User clicks List View")
	public void user_clicks_list_view() {
		searchPage.clickOnListViewButton();
	}

	@When("User clicks Thumbnail View")
	public void user_clicks_thumbnail_view() {
		searchPage.clickOnThumbnailViewButton();
	}

	@When("User clicks Tiled View")
	public void user_clicks_tiled_view() {
		searchPage.clickOnTiledViewButton();
	}

	@When("User chooses a Lesson Planet {string}")
	public void user_choose_a_lesson_planet_resource(String resourceType) {
		searchPage.expandProviderFacet();
		searchPage.selectLessonPlanetProvider();
		switch (resourceType) {
		case "resource":
			searchPage.selectActivitiesAndProjectsResourceType();
			break;
		case "collection":
			searchPage.selectCollectionResourceType();
			break;
		}
	}

	@When("User chooses a Proprietary resource")
	public void user_choose_a_proprietary_resource() {
		searchPage.expandProviderFacet();
		searchPage.selectDiscoveryEducationProvider();
		searchPage.selectActivitiesAndProjectsResourceType();
	}

	@When("User chooses a CTLS {string}")
	public void user_choose_a_ctls_resource(String resourceType) {
		searchPage.expandProviderFacet();
		searchPage.selectCTLSProvider();
		switch (resourceType) {
		case "resource":
			searchPage.selectActivitiesAndProjectsResourceType();
			break;
		case "collection":
			searchPage.selectCollectionResourceType();
			break;
		}
	}

	@When("User chooses an HMH folder")
	public void user_choose_a_hmh_folder() {
		searchPage.expandProviderFacet();
		searchPage.selectHMHProvider();
		searchPage.selectLessonResourceType();
	}

	@When("User clicks on the See Folder button")
	public void user_clicks_see_collection_button() {
		searchPage.clickOnSeeFolderButton();
	}

	@When("User clicks on the See Full Review button")
	public void user_clicks_see_review_button() {
		searchPage.clickOnSeeFullReviewButton();
	}

	@When("User clicks on the Go to Resource button")
	public void user_clicks_go_to_resource_button() {
		searchPage.clickOnGoToResourceButton();
	}

	@When("User clicks on the Folder Details button")
	public void user_clicks_folder_details_button() {
		searchPage.clickOnFolderDetailsButton();
	}

	@When("User clicks on the Open Folder button")
	public void user_clicks_open_folder_button() {
		searchPage.clickOnOpenFolderButton();
	}

	@Then("{string} collection RRP is displayed")
	public void collection_rrp_is_displayed(String poolName) {
		Assert.assertTrue(collectionRrpPage.isCollectionRrpTitleDisplayed());
		Assert.assertTrue(collectionRrpPage.isSaveFolderButtonDisplayed());
		Assert.assertEquals(collectionRrpPage.getPoolName(), poolName);
		collectionRrpPage.clickOnCloseButton();
	}

	@Then("Resource RRP is displayed")
	public void resource_rrp_is_displayed() {
		Assert.assertTrue(resourceRrpPage.isResourceRrpTitleDisplayed());
		resourceRrpPage.clickOnCloseButton();
	}

	@Then("{string} resource RRP is displayed")
	public void resource_rrp_is_displayed(String poolName) {
		Assert.assertTrue(resourceRrpPage.isResourceRrpTitleDisplayed());
		Assert.assertEquals(resourceRrpPage.getPoolName(), poolName);
		resourceRrpPage.clickOnCloseButton();
	}

	@Then("{string} resource is opened in a new tab")
	public void resource_is_opened_in_new_tab(String url) {
		searchPage.waitForNewTab();
		searchPage.focusDriverToLastTab();
		searchPage.waitForLinkToLoad();
		switch (url) {
		case Data.LESSON_PLANET:
			System.out.print(searchPage.getUrl());
			searchPage.waitForLinkToLoad();
			Assert.assertTrue(
					searchPage.getUrl().contains(Data.GO_TO_PATH) && searchPage.getUrl().contains(Data.STAGING_URL));
			break;
		case Data.CTLS:
		case Data.DISCOVERY_EDUCATION:
			Assert.assertFalse(searchPage.getUrl().contains(Data.STAGING_URL));
			break;
		}
	}

	@Then("{string} folder RRP is displayed")
	public void folder_rrp_is_displayed(String poolName) {
		Assert.assertTrue(folderRrpPage.isOpenFolderButtonDisplayed());
		Assert.assertTrue(folderRrpPage.isBreadcrumbsContainerDisplayed());
		Assert.assertEquals(folderRrpPage.getPoolName(), poolName);
		folderRrpPage.clickOnCloseButton();
	}

	@Then("Folder navigation page is displayed")
	public void folder_navigation_page_is_displayed() {
		Assert.assertTrue(searchPage.getPath().contains(Data.FOLDER_NAVIGATION_PATH));
	}

	@Then("Observe {string} card in List view")
	public void check_card_list_view(String resourceType) {
		Assert.assertTrue(searchPage.isCardTitleDisplayed());
		Assert.assertTrue(searchPage.isCardResourceTypeDisplayed());
		Assert.assertTrue(searchPage.isCardPoolNameListDisplayed());
		Assert.assertEquals(searchPage.getCardPoolNameList(), resourceType);
		Assert.assertTrue(searchPage.isCardDescriptionDisplayed());
		switch (resourceType) {
		case Data.LESSON_PLANET:
		case Data.DISCOVERY_EDUCATION:
		case Data.CTLS:
			Assert.assertTrue(searchPage.isCardGradeDisplayed());
			Assert.assertTrue(searchPage.isCardSubjectDisplayed());
			break;
		}
	}

	@Then("Observe {string} card in Tiled view")
	public void check_card_tiled_view(String resourceType) {
		Assert.assertTrue(searchPage.isCardTitleDisplayed());
		Assert.assertTrue(searchPage.isCardResourceTypeDisplayed());
		Assert.assertTrue(searchPage.isCardPoolNameDisplayed());
		Assert.assertEquals(searchPage.getCardPoolName(), resourceType);
		Assert.assertTrue(searchPage.isCardDescriptionDisplayed());
		switch (resourceType) {
		case Data.LESSON_PLANET:
		case Data.DISCOVERY_EDUCATION:
		case Data.CTLS:
			Assert.assertTrue(searchPage.isCardGradeDisplayed());
			break;
		}
	}

	@Then("Observe {string} card in Thumbnail view")
	public void check_card_thumbnail_view(String resourceType) {
		Assert.assertTrue(searchPage.isCardTitleDisplayed());
		Assert.assertTrue(searchPage.isCardResourceTypeInThumbnailViewDisplayed());
		Assert.assertTrue(searchPage.isCardGradeInThumbnailViewDisplayed());
		Assert.assertTrue(searchPage.isCardPoolNameDisplayed());
		Assert.assertEquals(searchPage.getCardPoolName(), resourceType);
		searchPage.hoverOverThumbnailResource();
		Assert.assertTrue(searchPage.isCardDescriptionDisplayed());
	}

	@And("Search results are displayed for {string}")
	public void search_results_are_displayed_on_search_page(String keyword) {
		switch (keyword) {
		case Data.KEYWORD_RESULTS:
			Assert.assertTrue(searchPage.getSearchPageText(keyword).contains(Data.WE_FOUND)
					&& searchPage.getSearchPageText(keyword).contains(Data.RESOURCES_FOR + " " + keyword));
			break;

		case Data.KEYWORD_NO_RESULTS:
			Assert.assertEquals(0, searchPage.getResourceResultsAfterSearch());
			Assert.assertEquals(searchPage.getSearchPageText(keyword),
					Data.WE_FOUND + " " + "0" + " " + Data.RESOURCES_FOR + " " + keyword);
			break;
		}
	}

}
