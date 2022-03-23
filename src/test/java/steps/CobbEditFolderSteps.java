package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EditFolderPage;
import util.Data;

public class CobbEditFolderSteps extends BaseTest{
	EditFolderPage editFolderPage = new EditFolderPage(driver);

	@When("User clicks on the {string} button from edit folder modal")
	public void user_clicks_on_edit_folder_buttons(String option) {
		switch (option) {
		case Data.FOLDER_NAVIGATION:
			editFolderPage.clickOnNavigateFolderButton();
			break;
		case Data.PLAY:
			editFolderPage.clickOnPlayButton();
			break;
		case Data.MORE:
			editFolderPage.clickOnMoreButton();
			break;
		case Data.ADD:
			editFolderPage.clickOnAddButton();
			break;
		case Data.EDIT_DETAILS:
			editFolderPage.clickOnEditDetailsButton();
			break;
		}
	}

	@When("User clicks on the {string} button from Add button")
	public void user_clicks_on_add_dropdown_buttons(String option) {
		editFolderPage.clickOnAddButton();
		switch (option) {
		case Data.CREATE_PAGE:
			editFolderPage.clickOnCreatePageOption();
			break;
		case Data.NEW_FOLDER:
			editFolderPage.clickOnNewFolderOption();
			break;
		case Data.RESOURCE_LIBRARY:
			editFolderPage.clickOnResourceLibraryOption();
			break;
		case Data.PIXABAY_IMAGE:
			editFolderPage.clickOnPixabayImageOption();
			break;
		case Data.FILE_UPLOAD:
			editFolderPage.clickOnFileUploadOption();
			break;
		case Data.WEB_LINK:
			editFolderPage.clickOnWebLinkOption();
			break;
		}
	}

	@When("User clicks on the {string} button from More dropdown")
	public void user_clicks_on_more_dropdown_buttons(String option) {
		editFolderPage.clickOnMoreButton();
		switch (option) {
		case Data.PUBLISH:
			editFolderPage.clickOnPublishOption();
			break;
		case Data.ASSIGN_FOLDER:
			editFolderPage.clickOnAssignOption();
			break;
		case Data.COPY_TO:
			editFolderPage.clickOnCopyToOption();
			break;
		case Data.SHARE_FOLDER:
			editFolderPage.clickOnShareOption();
			break;
		case Data.ACTIVITY:
			editFolderPage.clickOnActivityOption();
			break;
		}
	}
	
	@And("User closes the Edit Folder Modal")
	public void user_closes_edit_folder_modal() {
		editFolderPage.clickOnCloseButton();
	}

	@Then("Folder Navigation button is displayed")
	public void folder_navigation_button_is_displayed() {
		Assert.assertTrue(editFolderPage.isNavigateFolderButtonDisplayed());
	}

	@Then("Folder Type is displayed")
	public void folder_type_is_displayed() {
		Assert.assertTrue(editFolderPage.isFolderTypeDisplayed());
	}

	@Then("Folder Title is displayed")
	public void folder_title_is_displayed() {
		Assert.assertTrue(editFolderPage.isFolderTitleDisplayed());
	}

	@Then("Add button is displayed")
	public void add_button_is_displayed() {
		Assert.assertTrue(editFolderPage.isAddButtonDisplayed());
	}

	@Then("Edit details button is displayed")
	public void edit_details_button_is_displayed() {
		Assert.assertTrue(editFolderPage.isEditDetailsButtonDisplayed());
	}

	@Then("Play button is displayed")
	public void play_button_is_displayed() {
		Assert.assertTrue(editFolderPage.isPlayButtonDisplayed());
	}

	@Then("More button is displayed")
	public void more_button_is_displayed() {
		Assert.assertTrue(editFolderPage.isMoreDropdownDisplayed());
	}

	@And("Active Folder is displayed in the list")
	public void active_folder_is_displayed() {
		Assert.assertEquals(editFolderPage.getActiveFolderTitle(), editFolderPage.getFolderTitle());
		editFolderPage.clickOnNavigateFolderCloseButton();
	}

	@Then("A list of all folders is displayed")
	public void folders_list_is_displayed() {
		editFolderPage.waitUntilSpinnerIconisNotDisplayed();
		Assert.assertTrue(editFolderPage.isFolderListDisplayed());
	}

	@Then("The collection player is displayed in a new tab")
	public void collection_player_is_displayed_in_new_tab() {
		editFolderPage.waitForNewTab();
		editFolderPage.focusDriverToLastTab();
		editFolderPage.waitForLinkToLoad();
		Assert.assertTrue(editFolderPage.getUrl().contains(Data.PLAYER_PATH));
		editFolderPage.closeTab();
	}

	@Then("The following options are displayed in the dropdown: Publish, Assign, Copy To, Share and Activity")
	public void check_more_dropdown_options() {
		Assert.assertTrue(editFolderPage.isPublishOptionDisplayed());
		Assert.assertTrue(editFolderPage.isAssignOptionDisplayed());
		Assert.assertTrue(editFolderPage.isCopyToOptionDisplayed());
		Assert.assertTrue(editFolderPage.isShareOptionDisplayed());
		Assert.assertTrue(editFolderPage.isActivityOptionDisplayed());
	}

	@Then("Publish Folder section is displayed")
	public void publish_folder_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isPublishFolderSectionDisplayed());
	}

	@Then("Copy to section is displayed")
	public void copy_to_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isCopyToSectionDisplayed());
	}

	@Then("Activity section is displayed")
	public void activity_folder_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isActivitySectionDisplayed());
	}

	@Then("Edit details section is displayed")
	public void edit_details_section_is_displayed() {
		editFolderPage.isEditDetailsSectionDisplayed();
	}

	@And("User closes Edit Folder")
	public void user_closes_edit_folder() {
		editFolderPage.clickOnCloseButton();
	}

	@Then("The following options are displayed: Web Link, File Upload, Pixabay Image, Create Page, New Folder")
	public void check_add_button_options() {
		Assert.assertTrue(editFolderPage.isWebLinkOptionDisplayed());
		Assert.assertTrue(editFolderPage.isFileUploadOptionDisplayed());
		Assert.assertTrue(editFolderPage.isPixabayImageOptionDisplayed());
		Assert.assertTrue(editFolderPage.isCreatePageOptionDisplayed());
		Assert.assertTrue(editFolderPage.isNewFolderOptionDisplayed());
		//Assert.assertTrue(editFolderPage.isResourceLibraryOptionDisplayed());
	}

	@Then("Add a Web Link section is displayed")
	public void add_web_link_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isAddWebLinkSectionDisplayed());
	}

	@Then("Upload a File section is displayed")
	public void upload_a_file_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isUploadFileSectionDisplayed());
	}

	@Then("Add Pixabay Image Section is displayed")
	public void add_pixabay_image() {
		Assert.assertTrue(editFolderPage.isAddPixabayImageSectionDisplayed());
	}

	@Then("Create a Page section is displayed")
	public void create_a_page_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isCreatePageSectionDisplayed());
	}

	@Then("Create a New Folder section is displayed")
	public void create_a_new_folder_section_is_displayed() {
		Assert.assertTrue(editFolderPage.isCreateNewFolderSectionDisplayed());
	}
	
}