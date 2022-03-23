package steps;

import java.util.Map;

import org.junit.Assert;
import baseTest.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddLinkPage;
import pages.AdminManagerPage;
import pages.AssignResourcePage;
import pages.BrowseResourceDirectoryPage;
import pages.CalendarPage;
import pages.CollectionBuilderPage;
import pages.ConfirmationPage;
import pages.ContentManagerPage;
import pages.CopyToPage;
import pages.CreateNewFolderPage;
import pages.CurriculumManagerPage;
import pages.EditFolderPage;
import pages.EditResourcePage;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MoveToPage;
import pages.MyAccountPage;
import pages.SearchPage;
import pages.ShareFolderPage;
import pages.UploadFilePage;
import util.Data;

public class GeneralSteps extends BaseTest {
	AddLinkPage addLinkPage = new AddLinkPage(driver);
	AdminManagerPage adminManagerPage = new AdminManagerPage(driver);
	AssignResourcePage assignResourcePage = new AssignResourcePage(driver);
	CalendarPage calendarPage = new CalendarPage(driver);
	CreateNewFolderPage createNewFolderPage = new CreateNewFolderPage(driver);
	CollectionBuilderPage collectionBuilderPage = new CollectionBuilderPage(driver);
	CopyToPage copyToPage = new CopyToPage(driver);
	ContentManagerPage contentManagerPage = new ContentManagerPage(driver);
	CurriculumManagerPage curriculumManagerPage = new CurriculumManagerPage(driver);
	BrowseResourceDirectoryPage browseResourceDirectoryPage = new BrowseResourceDirectoryPage(driver);
	EditFolderPage editFolderPage = new EditFolderPage(driver);
	EditResourcePage editResourcePage = new EditResourcePage(driver);
	HomePage homePage = new HomePage(driver);
	HeaderPage headerPage = new HeaderPage(driver);
	LoginPage loginPage = new LoginPage(driver);
	MoveToPage moveToPage = new MoveToPage(driver);
	MyAccountPage myAccountPage = new MyAccountPage(driver);
	ConfirmationPage confirmationPage = new ConfirmationPage(driver);
	SearchPage searchPage = new SearchPage(driver);
	ShareFolderPage shareFolderPage = new ShareFolderPage(driver);
	UploadFilePage uploadFilePage = new UploadFilePage(driver);

	@Given("User goes to {string} page")
	public void user_goes_to_page(String page) {
		switch (page) {
		case Data.SEARCH:
			homePage.loadUrl(Data.SEARCH_PAGE_PATH);
			headerPage.waitForLinkToLoad();
			break;
		case Data.BROWSE_RESOURCE_DIRECTORY_MAIN_PAGE:
			homePage.loadUrl("");
			headerPage.hoverOverDiscoverDropdown();
			headerPage.clickOnBrowseResourceDirectoryButton();
			headerPage.waitForLinkToLoad();
			headerPage.waitForPageLoad();
			break;
		case Data.BROWSE_RESOURCE_DIRECTORY_SUBJECT_PAGE:
			homePage.loadUrl("");
			headerPage.hoverOverDiscoverDropdown();
			headerPage.clickOnBrowseResourceDirectoryButton();
			browseResourceDirectoryPage.clickOnHealthSubjectLink();
			headerPage.waitForPageLoad();
			break;
		case Data.CURRICULUM_MANAGER:
			homePage.loadUrl(Data.CURRICULUM_MANAGER_PAGE_PATH);
			headerPage.waitForLinkToLoad();
			headerPage.waitForPageLoad();
			break;
		case Data.HOME:
			homePage.loadUrl(Data.BLANK);
			break;
		case Data.ADMIN_MANAGER:
			headerPage.hoverOverUsernameDropdown();
			headerPage.clickOnAdminManagerButton();
			headerPage.waitForLinkToLoad();
			headerPage.waitForPageLoad();
			break;
		case Data.CURRICULUM_CALENDAR:
			homePage.loadUrl("");
			headerPage.hoverOverDiscoverDropdown();
			headerPage.clickOnCurriculumCalendarButton();
			headerPage.waitForLinkToLoad();
		case Data.CONTENT_MANAGER:
			headerPage.hoverOverUsernameDropdown();
			headerPage.clickOnAdminManagerButton();
			contentManagerPage.clickOnContentManagerTab();
			break;
		}
	}

	@Then("URL is {string}")
	public void check_url(String url) {
		Assert.assertEquals(url, homePage.getUrl());
	}

	@When("^User logs in with \"(.*)\" and \"(.*)\"$")
	public void login(String username, String password) {
		loginPage.performLogin(username, password);
	}

	@When("^User enters username and password$")
	public void logIn(DataTable testData) throws Throwable {
		Map<String, String> data = testData.asMap(String.class, String.class);
		loginPage.setEmail(data.get("username"));
		loginPage.setPassword(data.get("password"));
	}

	@Then("{string} modal is displayed")
	public void modal_is_displayed(String modalTitle) {
		switch (modalTitle) {
		case Data.SHARE_FOLDER:
			Assert.assertEquals(modalTitle, shareFolderPage.getShareFolderPageTitle());
			shareFolderPage.clickOnCloseButton();
			break;
		case Data.MOVE_TO:
			if (curriculumManagerPage.getFolderStatusDisplayed().contains(Data.PRIVATE)) {
				Assert.assertEquals(modalTitle, moveToPage.getMoveToPageTitle());
				moveToPage.clickOnCloseButton();
			}
			if (curriculumManagerPage.getFolderStatusDisplayed().equals(Data.SHARED)) {
				Assert.assertEquals(Data.PLEASE_CONFIRM, confirmationPage.getConfirmationPageTitle());
				confirmationPage.clickOnCloseButton();
			}
			break;
		case Data.COPY_TO:
			Assert.assertEquals(modalTitle, copyToPage.getCopyToPageTitle());
			copyToPage.clickOnCloseButton();
			break;
		case Data.CREATE_NEW_FOLDER:
			Assert.assertEquals(modalTitle, createNewFolderPage.getCreateNewFolderPageTitle());
			createNewFolderPage.clickOnCloseButton();
			break;
		case Data.ASSIGN_RESOURCE:
		case Data.ASSIGN_FOLDER:
			Assert.assertEquals(modalTitle, assignResourcePage.getAssignResourcePageTitle());
			assignResourcePage.clickOnCloseButton();
			break;
		case Data.PLEASE_CONFIRM:
			Assert.assertEquals(modalTitle, confirmationPage.getConfirmationPageTitle());
			confirmationPage.clickOnCloseButton();
			break;
		case Data.EDIT_FILE:
			Assert.assertEquals(modalTitle, editResourcePage.getEditResourcePageTitle());
			editResourcePage.clickOnCloseButton();
			break;
		case Data.UPLOAD_YOUR_FILE:
			Assert.assertEquals(modalTitle, uploadFilePage.getUploadPageTitle());
			uploadFilePage.clickOnCloseButton();
			break;
		case Data.ADD_A_LINK:
			Assert.assertEquals(modalTitle, addLinkPage.getAddLinkPageTitle());
			addLinkPage.clickOnCloseButton();
			break;
		case Data.EDIT_FOLDER:
			Assert.assertTrue(editFolderPage.isEditFolderModalDisplayed());
			break;
		case Data.EDIT_DISTRICT:
		case Data.ADD_DISTRICT_ADMIN:
		case Data.EDIT_SCHOOL:
		case Data.EDIT_TEACHER:
			Assert.assertEquals(modalTitle, adminManagerPage.getModalTitle());
			break;
		case Data.LOGIN:
			Assert.assertEquals(modalTitle, loginPage.getPageTitle());
			break;
		}

	}

	@And("{string} page title is {string}")
	public void check_page_title(String option, String title) {
		switch (option) {
		case Data.DISCOVER_RESOURCES:
			Assert.assertEquals(title, searchPage.getSearchPageText(title));
			break;
		case Data.BROWSE_RESOURCE_DIRECTORY_MAIN_PAGE:
			Assert.assertEquals(title, browseResourceDirectoryPage.getDirectoryPageTitle());
			break;
		case Data.CURRICULUM_MANAGER:
			Assert.assertEquals(title, curriculumManagerPage.getMyResourcesPageTitle());
			break;
		case Data.CURRICULUM_CALENDAR:
			Assert.assertTrue(calendarPage.getCalendarPageTitle().contains(title));
			break;
		case Data.MY_ACCOUNT:
			Assert.assertEquals(title, myAccountPage.getMyAccountPageTitle());
			break;
		case Data.MY_RESOURCES:
			Assert.assertEquals(title, curriculumManagerPage.getMyResourcesPageTitle());
			break;
		case Data.ADMIN_MANAGER:
			Assert.assertEquals(title, adminManagerPage.getOrganizationName(title));
			break;
		case Data.SIGN_OUT:
			Assert.assertTrue(headerPage.isLessonPlanetLogoDisplayed());
			Assert.assertTrue(homePage.getPageTitle().contains(title));
			break;
		case Data.CONTENT_MANAGER:
			Assert.assertEquals(title, contentManagerPage.getTitleText());
			break;
		}
	}
}
