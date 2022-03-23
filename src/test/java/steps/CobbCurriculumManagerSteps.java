package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CurriculumManagerPage;
import util.Data;

public class CobbCurriculumManagerSteps extends BaseTest {

	CurriculumManagerPage curriculumManagerPage = new CurriculumManagerPage(driver);

	@When("User clicks on the {string} button from Actions dropdown")
	public void user_clicks_on_folder_actions_dropdown_options(String option) {
		curriculumManagerPage.clickOnActionsDropdown();
		switch (option) {
		case Data.COPY_TO:
			curriculumManagerPage.clickOnCopyToButton();
			break;
		case Data.MOVE_TO:
			curriculumManagerPage.clickOnMoveToButton();
			break;
		case Data.SHARE_FOLDER:
			curriculumManagerPage.clickOnShareButton();
			break;
		case Data.PUBLISH:
			curriculumManagerPage.clickOnPublishButton();
			break;
		case Data.ACTIVITY:
			curriculumManagerPage.clickOnActivityButton();
			break;
		case Data.PLAY:
			curriculumManagerPage.clickOnPlayButton();
			break;
		case Data.ASSIGN_FOLDER:
		case Data.ASSIGN_RESOURCE:
			curriculumManagerPage.clickOnAssignButton();
			break;
		case Data.EDIT:
			curriculumManagerPage.clickOnEditButton();
			break;
		case Data.DELETE:
			curriculumManagerPage.clickOnDeleteButton();
			break;
		case Data.GO_TO:
			curriculumManagerPage.clickOnGoToResourceButton();
			break;
		case Data.UNFAVORITE:
			curriculumManagerPage.clickOnUnfavoriteResourceButton();
			break;
		}
	}

	@When("User clicks on the Upload Resource button")
	public void user_clicks_the_upload_button() {
		curriculumManagerPage.clickOnUploadButton();
	}

	@When("User clicks on the Create a Folder button")
	public void user_clicks_create_a_folder_button() {
		curriculumManagerPage.clickOnCreateFolderButton();
	}

	@When("User clicks on the My Favorites folder")
	public void user_clicks_my_favorites_folder() {
		curriculumManagerPage.clickOnMyFavoritesFolder();
		curriculumManagerPage.waitForRefreshIconToDisappear();
		curriculumManagerPage.waitUntilFavoritedResourceListIsDisplayed();
	}

	@When("User clicks on the favorite resource info icon")
	public void user_cliks_the_info_icon() {
		curriculumManagerPage.clickOnFavoritedResourceInfoIcon();
	}

	@When("User clicks on the uploaded resource info icon")
	public void user_cliks_the_uploaded_info_icon() {
		curriculumManagerPage.clickOnUploadedResourceInfoIcon();
	}

	@When("User clicks on the Actions button")
	public void user_clicks_the_actions_button() {
		curriculumManagerPage.clickOnActionsDropdown();
	}

	@When("User clicks on the My Uploads folder")
	public void user_clicks_the_my_uploads_folder() {
		curriculumManagerPage.clickOnMyUploadsFolder();
		curriculumManagerPage.waitForRefreshIconToDisappear();
		curriculumManagerPage.waitUntilUploadedResourceListIsDisplayed();
	}

	@Then("My Resources and Shared With Me Tabs are displayed")
	public void my_resources_and_shared_with_me_tabs_are_displayed() {
		Assert.assertTrue(curriculumManagerPage.isMyResourcesTabDisplayed());
		Assert.assertTrue(curriculumManagerPage.isSharedWithMeTabDisplayed());
	}

	@Then("The collection builder is displayed on the right")
	public void collection_builder_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isCollectionBuilderDisplayed());
	}

	@Then("Create a Folder button is displayed")
	public void create_a_folder_button_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isCreateFolderButtonDisplayed());
	}

	@Then("Upload Resource button is displayed")
	public void upload_resource_button_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isUploadButtonDisplayed());
	}

	@Then("Hide details button is displayed")
	public void hide_details_button_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isDetailsButtonDisplayd());
	}

	@Then("Sort By Dropdown is displayed")
	public void sort_by_dropdown_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isSortByDropdownDisplayed());
	}

	@Then("My Favorites folder is displayed")
	public void my_favorites_folder_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isMyFavoritesFolderDisplayed());
	}

	@Then("My Uploads folder is displayed")
	public void my_uploads_folder_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isMyUploadsFolderDisplayed());
	}

	@Then("A list of folders is displayed")
	public void list_folders_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isFoldersListDisplayed());
	}

	@Then("A list of favorited resources are displayed")
	public void favorited_resources_list_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isFavoritedResourceListDisplayed());
	}

	@Then("Play, Assign, Go To and Unfavorite options are displayed")
	public void check_favorite_resource_action_options() {
		Assert.assertTrue(curriculumManagerPage.isPlayButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isAssignButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isGoToResourceButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isUnFavoriteResourceButtonDisplayed());
		curriculumManagerPage.clickOnActionsDropdown();
	}

	@Then("A list of uploaded resources are displayed")
	public void uploaded_resources_list_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isUploadedResourceListDisplayed());
	}

	@Then("Resource type and status are displayed")
	public void resource_type_and_status_are_displayed() {
		Assert.assertTrue(curriculumManagerPage.isResourceStatusDisplayd());
		Assert.assertTrue(curriculumManagerPage.isResourceTypeDisplayd());
	}

	@Then("Edit, Play, Assign and Delete options are displayed")
	public void check_uploaded_resources_action_options() {
		Assert.assertTrue(curriculumManagerPage.isEditButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isPlayButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isAssignButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isDeleteButtonDisplayed());
		curriculumManagerPage.clickOnActionsDropdown();
	}

	@Then("A list of folders is displayed with: Title, Type, Status, Date and Actions button")
	public void folder_list_is_displayed() {
		Assert.assertTrue(curriculumManagerPage.isFolderStatusDisplayed());
		Assert.assertTrue(curriculumManagerPage.isFolderTypeDisplayed());
		Assert.assertTrue(curriculumManagerPage.isActionsButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isFolderTitleDisplayed());
	}

	@Then("Edit, Play, Assign, Publish, Copy To, Move To, Share, Delete and Activity options are displayed")
	public void check_folder_action_options() {
		Assert.assertTrue(curriculumManagerPage.isEditButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isPlayButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isAssignButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isPublishButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isCopyToButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isMoveToButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isShareButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isActivityButtonDisplayed());
		Assert.assertTrue(curriculumManagerPage.isDeleteButtonDisplayed());
		curriculumManagerPage.clickOnActionsDropdown();
	}

}
