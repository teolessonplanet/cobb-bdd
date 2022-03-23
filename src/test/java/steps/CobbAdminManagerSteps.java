package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminManagerPage;
import io.cucumber.java.en.And;
import util.Data;

public class CobbAdminManagerSteps extends BaseTest{
	AdminManagerPage adminManagerPage = new AdminManagerPage(driver);

	@Then("{string} name is displayed")
	public void check_organization_name(String name) {
		Assert.assertEquals(name, adminManagerPage.getOrganizationName(name));
	}

	@And("Manage District button is displayed")
	public void manage_district_button_is_displayed() {
		Assert.assertTrue(adminManagerPage.isManageDistrictButtonDisplayed());
	}

	@And("Search button is displayed")
	public void search_button_is_displayed() {
		Assert.assertTrue(adminManagerPage.isSearchButtonDisplayed());
	}

	@And("{string} button is displayed")
	public void add_schools_button_is_displayed(String button) {
		Assert.assertTrue(adminManagerPage.isAddButtonDisplayed());
	}

	@When("User hovers over {string} button")
	public void user_hovers_over_add_school_button(String button) {
		adminManagerPage.hoverOverAddButton();
	}

	@Then("{string} popover text is displayed")
	public void check_popover_text(String string) {
		Assert.assertEquals(string, adminManagerPage.getAddButtonPopoverText());
	}

	@And("School list is displayed")
	public void school_list_is_displayed() {
		Assert.assertTrue(adminManagerPage.isSchoolListDisplayed());
	}

	@And("Every school has: School Name, Nr of teachers, Resources Uploaded, {string} Action button and {string} Action button")
	public void check_school_options(String editButton, String seeSchoolReportingButton) {
		for (int i = 0; i < 5; i++) {
			adminManagerPage.isSchoolNameDisplayed(i);
			adminManagerPage.isNrOfTeachersDisplayed(i);
			adminManagerPage.isResourcesUploadedDisplayed(i);
			adminManagerPage.hoverOverEditActionButton(i);
			Assert.assertEquals(adminManagerPage.getEditActionButtonPopoverText(i), editButton);
			adminManagerPage.hoverOverSeeSchooReportingButton(i);
			Assert.assertEquals(adminManagerPage.getSeeSchoolReportingActionPopover(i), seeSchoolReportingButton);
		}

	}

	@Then("Every District user has: Email, First Name, Last Name, {string} Role, {string} Action button and {string} Action button")
	public void check_district_users_options(String role, String editButton, String removeButton) {
		for (int i = 0; i < 5; i++) {
			adminManagerPage.isEmailDisplayed(i);
			adminManagerPage.isFirstNameDisplayed(i);
			adminManagerPage.isLastNameDisplayed(i);
			Assert.assertTrue(adminManagerPage.getTeacherRole(i).contains(role));
			Assert.assertTrue(adminManagerPage.isJoinedDateDisplayed(i));
			adminManagerPage.hoverOverEditActionButton(i);
			Assert.assertEquals(adminManagerPage.getEditActionButtonPopoverText(i), editButton);
			adminManagerPage.hoverOverRemoveButton(i);
			Assert.assertTrue(adminManagerPage.getRemoveActionButtonPopover(i).contains(removeButton)
					|| adminManagerPage.getRemoveActionButtonPopover(i).contains(Data.REMOVE_DISTRICT_ADMIN));
		}

	}

	@And("Other users listed are district admins and have: Email, First Name, Last Name, {string} Action button and {string} Action button")
	public void check_district_admins_options(String editButton, String removeButton) {
		for (int i = 1; i < 3; i++) {
			adminManagerPage.isEmailDisplayed(i);
			adminManagerPage.isFirstNameDisplayed(i);
			adminManagerPage.isLastNameDisplayed(i);
			adminManagerPage.hoverOverRemoveAdminButton(i);
			Assert.assertTrue(adminManagerPage.getRemoveAdminButtonPopover(i).contains(removeButton)
					|| adminManagerPage.getRemoveAdminButtonPopover(i).contains(Data.REMOVE_DISTRICT_ADMIN));
			adminManagerPage.hoverOverEditAdminButton(i);
			Assert.assertEquals(adminManagerPage.getEditAdminPopoverText(i), editButton);
		}
	}

	@And("The teachers list is displayed with: Email, First, Last, {string} or {string} Role, Joined, {string} Action button and {string} Action button")
	public void check_teacher_buttons(String adminRole, String teacherRole, String editButton, String removeButton) {
		for (int i = 0; i < 1; i++) {
			adminManagerPage.isEmailDisplayed(i);
			adminManagerPage.isFirstNameDisplayed(i);
			adminManagerPage.isLastNameDisplayed(i);
			Assert.assertTrue(adminManagerPage.getTeacherRole(i).contains(adminRole)
					|| adminManagerPage.getTeacherRole(i).contains(teacherRole));
			adminManagerPage.hoverOverRemoveButton(i);
			Assert.assertTrue(adminManagerPage.getRemoveActionButtonPopover(i).contains(removeButton)
					|| adminManagerPage.getRemoveActionButtonPopover(i).contains(Data.REMOVE_TEACHER));
			adminManagerPage.hoverOverEditActionButton(i);
			Assert.assertEquals(adminManagerPage.getEditActionButtonPopoverText(i), editButton);
		}
	}

	@When("User clicks Edit District button")
	public void user_clicks_edit_district_button() {
		adminManagerPage.clickOnEditDistrictButton();
	}

	@Then("{string} field with {string} name is displayed")
	public void district_name_field_is_displayed(String option, String string) {
		Assert.assertEquals(string, adminManagerPage.getDistrictName());
	}

	@Then("{string} field is displayed")
	public void district_shortname_field_is_displayed(String string) {
		Assert.assertTrue(adminManagerPage.isDistrictShortNameFieldDisplayed());
	}

	@Then("{string} info icon is displayed")
	public void info_icon_is_displayed(String option) {
		switch (option) {
		case "District Name":
			Assert.assertTrue(adminManagerPage.isDistrictNameInfoIconDisplayed());
			break;
		case "District Shortname":
		case "School Shortname":
			Assert.assertTrue(adminManagerPage.isDistrictShortNameInfoIconDisplayed());
			break;

		case "Sharing Privileges":
			Assert.assertTrue(adminManagerPage.isSharingPrivilegesInfoIconDisplayed());
			break;
		}
	}

	@When("User hovers over {string} info icon")
	public void user_hovers_over_sharing_privileges_info_icon(String option) {
		switch (option) {
		case "District Name":
			adminManagerPage.hoverOverDistrictNameInfoIcon();
			break;
		case "District Shortname":
		case "School Shortname":
			adminManagerPage.hoverOverDistrictShortNameInfoIcon();
			break;

		case "Sharing Privileges":
			adminManagerPage.hoverOverSharingPrivilegesInfoIcon();
			break;
		}

	}

	@Then("{string} popover for {string} info icon is displayed")
	public void get_popover_button_text(String text, String option) {

		switch (option) {
		case "District Name":
		case "School Name":
			Assert.assertEquals(text, adminManagerPage.getDistrictNameInfoIconPopoverText());
			break;
		case "District Shortname":
		case "School Shortname":
			Assert.assertEquals(text, adminManagerPage.getDistrictShortNameInfoIconPopoverText());
			break;

		case "Sharing Privileges":
			Assert.assertEquals(text, adminManagerPage.getSharingPrivilegesInfoIconPopoverText());
			break;
		}
	}

	@Then("All admins in this district are also Publishers option is displayed")
	public void admins_publish_district_ability_option_is_displayed() {
		Assert.assertTrue(adminManagerPage.isAdminPublishOptionDisplayed());
	}

	@Then("All teachers in this district are also Publishers option is displayed")
	public void teachers_publish_district_ability_option_is_displayed() {
		Assert.assertTrue(adminManagerPage.isTeacherPublishOptionDisplayed());
	}

	@Then("All admins in this school are also Publishers option is displayed")
	public void admins_publish_school_ability_option_is_displayed() {
		Assert.assertTrue(adminManagerPage.isAdminPublishOptionDisplayed());
	}

	@Then("All teachers in this school are also Publishers option is displayed")
	public void teachers_publish_school_ability_option_is_displayed() {
		Assert.assertTrue(adminManagerPage.isTeacherPublishOptionDisplayed());
	}

	@When("User clicks the {string} button")
	public void user_clicks_the_manage_district_button(String buttonText) {
		adminManagerPage.clickOnManageDistrictButton(buttonText);
	}

	@Then("Account Manager breadcrumbs is displayed")
	public void account_manager_breadcrumbs_is_displayed() {
		Assert.assertTrue(adminManagerPage.isAccountManagerBreadcrumbsDisplayed());
	}

	@Then("Edit District button is displayed")
	public void edit_district_button_is_displayed() {
		Assert.assertTrue(adminManagerPage.isEditDistrictButtonDisplayed());
	}

	@Then("Manage District Admins button is displayed")
	public void manage_district_admins_button_is_displayed() {
		Assert.assertTrue(adminManagerPage.isManageAdminsButtonDisplayed());
	}

	@When("User clicks the Search button")
	public void user_clicks_the_search_button() {
		adminManagerPage.clickOnSearchButton();
	}

	@And("User enters {string}")
	public void user_enters_text(String option) {
		adminManagerPage.typeText(option);
		adminManagerPage.clickOnSearchButton();
	}

	@Then("Results are displayed for {string} text")
	public void search_results_are_displayed(String option) {
		switch (option) {
		case "i_o_csl_cobb@lp.com":
		case "Jane":
			Assert.assertTrue(adminManagerPage.getSearchResultsText()
					.contains(adminManagerPage.getUserNumber() + " " + Data.ADMIN_MANAGER_RESULTS_SEARCH_TEXT)
					&& adminManagerPage.getSearchResultsText().contains(option));
			break;
		case "test@test.com":
		case "blabla":
			Assert.assertTrue(
					adminManagerPage.getNoSearchResultsText().contains(Data.ADMIN_MANAGER_NO_RESULTS_SEARCH_TEXT)
							&& adminManagerPage.getNoSearchResultsText().contains(option));
			break;
		}

	}

	@Then("District User list is displayed")
	public void district_user_list_is_displayed() {
		Assert.assertTrue(adminManagerPage.isDistrictUserListDisplayed());
	}

	@And("First user listed is the Owner with {string} Action button and disabled Remove button")
	public void check_owner(String editButton) {
		adminManagerPage.hoverOverRemoveAdminButton(0);
		Assert.assertEquals(adminManagerPage.getRemoveAdminButtonPopover(0), Data.REMOVE_OWNER);
		adminManagerPage.hoverOverEditAdminButton(0);
		Assert.assertEquals(adminManagerPage.getEditAdminPopoverText(0), editButton);
	}

	@And("Add a District Admin button is displayed")
	public void add_district_admin_button_is_displayed() {
		Assert.assertTrue(adminManagerPage.isAddDistrictAdminButtonDisplayed());
	}

	@When("User clicks Add a District admin button")
	public void user_clicks_add_district_admin_button() {
		adminManagerPage.clickAddDistrictAdminButton();
	}

	@When("User clicks on a school")
	public void user_clicks_on_school() {
		adminManagerPage.clickOnSchool();
	}

	@When("User clicks the Edit Teacher button")
	public void user_clicks_edit_teacher() {
		adminManagerPage.clickOnEditActionButton(0);
	}

	@And("User closes the modal")
	public void user_closes_the_modal() {
		adminManagerPage.clickOnCloseModal();
	}

	@And("User clicks on the {string} button")
	public void user_clicks_manage_admin_button(String buttonText) {
		adminManagerPage.clickOnManageDistrictButton(buttonText);
	}

	@Then("Three Add a School Admin links are displayed")
	public void get_add_school_admin() {
		Assert.assertEquals(adminManagerPage.getAddAdminLinkNumber(), 3);
	}

	@When("User hovers over Add a School Admin")
	public void user_hovers_add_school_admin() {
		adminManagerPage.hoverOverAddAdminLink();
	}

	@Then("{string} popover text for add school admin is displayed")
	public void get_popover_text_for_add_school_admin_buton(String string) {
		Assert.assertEquals(adminManagerPage.getAddSchoolAdminPopoverText(), string);
	}

}
