package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManagerPage extends BaseActionsPage {

	public AdminManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='se-org-name']")
	WebElement organizationName;

	@FindBy(css = "[class*='se-member-search']")
	WebElement searchButton;

	@FindBy(css = "#input-field")
	WebElement searchInput;

	@FindBy(css = "[class='search-result-container']")
	WebElement searchResultsText;

	@FindBy(css = "[class='no-results-search']")
	WebElement noSearchResultsText;

	@FindBy(css = "[class*='se-edit-org-admins']")
	WebElement manageDistrictButton;

	@FindBy(css = "[class*='se-add-school']")
	WebElement addButton;

	@FindBy(css = "[class*='se-add-school'] [class*='popuptext']")
	WebElement addPopover;

	@FindBy(css = "[class='group-table children'] [class='group-row org school']")
	WebElement schoolList;

	@FindBy(css = "[class='group-table children'] [class='group-body'] [class='group-row member member']")
	WebElement usersList;

	@FindBy(css = "[class='group-row org school'] [class*='name'] a")
	WebElement schoolRow;

	@FindBy(css = "[class='group-table children'] [class='group-row org school']")
	WebElement school;

	@FindBy(css = "[class='form-group']:nth-child(1) [class='form-control']")
	WebElement districtNameInput;

	@FindBy(css = "div.form-group:nth-child(1) [class*='popup']")
	WebElement districtNameInfoIcon;

	@FindBy(css = "div.form-group:nth-child(1) [class*='popuptext']")
	WebElement districtNameInfoIconPopoverText;

	@FindBy(css = "div.form-group:nth-child(2) [class='form-control']")
	WebElement districtShortNameInput;

	@FindBy(css = "div.form-group:nth-child(2) [class*='popup']")
	WebElement districtShortNameInfoIcon;

	@FindBy(css = "div.form-group:nth-child(2) [class*='popuptext']")
	WebElement districtShortNameInfoIconPopoverText;

	@FindBy(css = "div.form-group:nth-child(3) [class='form-group-label'] [class*='popup']")
	WebElement sharingPrivilegesInfoIcon;

	@FindBy(css = "[class='form-group']:nth-child(3) [class='form-group-label'] [class*='popuptext']")
	WebElement sharingPrivilegesInfoIconPopoverText;

	@FindBy(css = "[name='allow_all_admins_to_publish']")
	WebElement adminPublishCheckbox;

	@FindBy(css = "[name='allow_all_teachers_to_publish']")
	WebElement teacherPublishCheckbox;

	@FindBy(css = "[class*='se-edit-org-info']")
	WebElement editDistrictButton;

	@FindBy(css = "[class='header'] h3")
	WebElement modalTitle;

	@FindBy(css = "[class*='go-to-parent']")
	WebElement accountManagerBreadCrumbs;

	@FindBy(css = "[class='footer'] [class='lp-button lp-small-button lp-white-button']")
	WebElement cancelButton;

	@FindBy(css = "[class='group-table admins'] [class*='placeholder'] a")
	WebElement addAdminLink;

	@FindBy(css = "[class='group-table admins'] [class*='placeholder'] a [class*='popuptext']")
	WebElement addAdminLinkPopover;

	@FindBy(css = "[class='group-table admins'] [class*='placeholder'] a")
	WebElement addDistrictAdminButton;

	private static final String schoolName = "[class='group-row org school'] [class*='name'] a";
	private static final String nrOfTeachers = "[class='group-row org school'] [class*='members-count']";
	private static final String nrOfUploadedResources = "[class='group-row org school'] [class*='uploads-count']";
	private static final String seeSchoolReportingButton = "[class='group-row org school'] [class*='btn-primary']";
	private static final String seeSchoolReportingPopover = "[class='group-row org school'] [class*='btn-primary'] [class*='popuptext']";
	private static final String editActionButton = "[class='group-table children'] [class*='btn-success']";
	private static final String removeActionButton = "[class='group-table children'] [class*='btn-danger']";
	private static final String removeActionPopover = "[class='group-table children'] [class*='btn-danger'] [class*='popuptext']";
	private static final String editActionPopover = "[class='group-table children'] [class*='btn-success'] [class*='popuptext']";
	private static final String editAdminActionButton = "[class='group-table admins'] [class='group-row member member'] [class*='btn-success']";
	private static final String removeAdminActionButton = "[class='group-table admins'] [class='group-row member member'] [class*='btn-danger']";
	private static final String removeAdminActionPopover = "[class='group-table admins'] [class='group-row member member'] [class*='btn-danger'] [class*='popuptext']";
	private static final String editAdminActionPopover = "[class='group-table admins'] [class='group-row member member'] [class*='btn-success'] [class*='popuptext']";
	private static final String addLink = "[class='group-table admins'] [class*='placeholder'] a";
	private static final String adminEmail = "[class='group-table admins'] [class='group-row member member'] [class*='email']";
	private static final String firstName = "[class='group-table children'] [class='group-row member member'] [class='info first-name']";
	private static final String lastName = "[class='group-table children'] [class='group-row member member'] [class='info last-name']";
	private static final String teacherRole = "[class='group-table children'] [class='group-row member member'] [class='info role']";
	private static final String userNumberAfterSearch = "[class='group-table children'] [class='group-body'] [class='group-row org member']";
	private static final String joinedDate = "[class='group-table children'] div[class*='joined-on ']";

	public String getOrganizationName(String title) {
		waitUntilTextIsDisplayed(organizationName, title);
		return organizationName.getText();
	}

	public boolean isSearchButtonDisplayed() {
		return searchButton.isDisplayed();
	}

	public boolean isManageDistrictButtonDisplayed() {
		return manageDistrictButton.isDisplayed();
	}

	public boolean isAddButtonDisplayed() {
		return addButton.isDisplayed();
	}

	public void hoverOverAddButton() {
		waitForElement(addButton);
		hoverOverElement(addButton);
	}

	public String getAddButtonPopoverText() {
		waitForElement(addPopover);
		return addPopover.getText();
	}

	public boolean isSchoolListDisplayed() {
		return schoolList.isDisplayed();
	}

	public void clickOnEditDistrictButton() {
		waitForElement(editDistrictButton);
		editDistrictButton.click();
	}

	public String getModalTitle() {
		waitForElement(modalTitle);
		return modalTitle.getText();
	}

	public boolean isDistrictNameFieldDisplayed() {
		waitForElement(districtNameInput);
		return districtNameInput.isDisplayed();
	}

	public boolean isDistrictNameInfoIconDisplayed() {
		waitForElement(districtNameInfoIcon);
		return districtNameInfoIcon.isDisplayed();
	}

	public void hoverOverDistrictNameInfoIcon() {
		waitForElement(districtNameInfoIcon);
		hoverOverElement(districtNameInfoIcon);
	}

	public String getDistrictNameInfoIconPopoverText() {
		waitForElement(districtNameInfoIconPopoverText);
		return districtNameInfoIconPopoverText.getText();
	}

	public boolean isDistrictShortNameInfoIconDisplayed() {
		waitForElement(districtShortNameInfoIcon);
		return districtShortNameInfoIcon.isDisplayed();
	}

	public boolean isDistrictShortNameFieldDisplayed() {
		waitForElement(districtShortNameInput);
		return districtShortNameInput.isDisplayed();
	}

	public void hoverOverDistrictShortNameInfoIcon() {
		waitForElement(districtShortNameInfoIcon);
		hoverOverElement(districtShortNameInfoIcon);
	}

	public String getDistrictShortNameInfoIconPopoverText() {
		waitForElement(districtShortNameInfoIconPopoverText);
		return districtShortNameInfoIconPopoverText.getText();

	}

	public boolean isSharingPrivilegesInfoIconDisplayed() {
		waitForElement(sharingPrivilegesInfoIcon);
		return sharingPrivilegesInfoIcon.isDisplayed();
	}

	public void hoverOverSharingPrivilegesInfoIcon() {
		waitForElement(sharingPrivilegesInfoIcon);
		hoverOverElement(sharingPrivilegesInfoIcon);

	}

	public String getSharingPrivilegesInfoIconPopoverText() {
		waitForElement(sharingPrivilegesInfoIconPopoverText);
		return sharingPrivilegesInfoIconPopoverText.getText();
	}

	public boolean isAdminPublishOptionDisplayed() {
		waitForElement(adminPublishCheckbox);
		return adminPublishCheckbox.isDisplayed();
	}

	public boolean isTeacherPublishOptionDisplayed() {
		waitForElement(teacherPublishCheckbox);
		return teacherPublishCheckbox.isDisplayed();
	}

	public String getDistrictName() {
		return districtNameInput.getAttribute("value");
	}

	public boolean isAccountManagerBreadcrumbsDisplayed() {
		return accountManagerBreadCrumbs.isDisplayed();
	}

	public boolean isManageAdminsButtonDisplayed() {
		return manageDistrictButton.isDisplayed();
	}

	public boolean isEditDistrictButtonDisplayed() {
		return editDistrictButton.isDisplayed();
	}

	public void clickOnSearchButton() {
		waitForElement(searchButton);
		searchButton.click();
	}

	public void typeText(String text) {
		waitForElement(searchInput);
		searchInput.sendKeys(text);
	}

	public String getSearchResultsText() {
		waitForElement(searchResultsText);
		return searchResultsText.getText();
	}

	public String getNoSearchResultsText() {
		waitForElement(noSearchResultsText);
		return noSearchResultsText.getText();
	}
	
	public void clickOnManageDistrictButton(String buttonText) {
		waitUntilTextIsDisplayed(manageDistrictButton, buttonText);
		manageDistrictButton.click();
		waitForLoad();
	}

	public boolean isAddDistrictAdminButtonDisplayed() {
		waitForElement(addDistrictAdminButton);
		return addDistrictAdminButton.isDisplayed();
	}

	public void clickAddDistrictAdminButton() {
		waitForElement(addDistrictAdminButton);
		addDistrictAdminButton.click();
	}

	public int getUserNumber() {
		return findElements(userNumberAfterSearch).size();
	}

	public boolean isEmailDisplayed(int positionButton) {
		return findElements(adminEmail).get(positionButton).isDisplayed();
	}

	public boolean isFirstNameDisplayed(int positionButton) {
		return findElements(firstName).get(positionButton).isDisplayed();
	}

	public boolean isLastNameDisplayed(int positionButton) {
		return findElements(lastName).get(positionButton).isDisplayed();
	}

	public void hoverOverRemoveAdminButton(int positionButton) {
		hoverOverElement(findElements(removeAdminActionButton).get(positionButton));
	}

	public String getRemoveAdminButtonPopover(int positionButton) {
		return findElements(removeAdminActionPopover).get(positionButton).getText();
	}

	public void hoverOverEditAdminButton(int positionButton) {
		hoverOverElement(findElements(editAdminActionButton).get(positionButton));
	}

	public String getEditAdminPopoverText(int positionButton) {
		return findElements(editAdminActionPopover).get(positionButton).getText();
	}

	public void clickOnEditActionButton(int positionButton) {
		findElements(editActionButton).get(positionButton).click();
	}

	public boolean isJoinedDateDisplayed(int positionButton) {
		return findElements(joinedDate).get(positionButton).isDisplayed();
	}
	
	public String getTeacherRole(int positionButton) {
		return findElements(teacherRole).get(positionButton).getText();
	}

	public int getAddAdminLinkNumber() {
		return findElements(addLink).size();
	}
	
	public boolean isSchoolNameDisplayed(int positionButton) {
		return findElements(schoolName).get(positionButton).isDisplayed();
	}

	public boolean isNrOfTeachersDisplayed(int positionButton) {
		return findElements(nrOfTeachers).get(positionButton).isDisplayed();
	}

	public boolean isResourcesUploadedDisplayed(int positionButton) {
		return findElements(nrOfUploadedResources).get(positionButton).isDisplayed();
	}

	public void hoverOverSeeSchooReportingButton(int positionButton) {
		hoverOverElement(findElements(seeSchoolReportingButton).get(positionButton));
	}

	public String getSeeSchoolReportingActionPopover(int positionButton) {
		return findElements(seeSchoolReportingPopover).get(positionButton).getText();
	}

	public void hoverOverEditActionButton(int positionButton) {
		hoverOverElement(findElements(editActionButton).get(positionButton));
	}

	public String getEditActionButtonPopoverText(int positionButton) {
		return findElements(editActionPopover).get(positionButton).getText();
	}

	public void hoverOverRemoveButton(int positionButton) {
		hoverOverElement(findElements(removeActionButton).get(positionButton));
	}

	public String getRemoveActionButtonPopover(int positionButton) {
		return findElements(removeActionPopover).get(positionButton).getText();
	}

	public void clickOnSchool() {
		waitForElement(schoolRow);
		schoolRow.click();
	}

	public void clickOnCloseModal() {
		waitForElement(cancelButton);
		cancelButton.click();
	}

	public void hoverOverAddAdminLink() {
		hoverOverElement(addAdminLink);
	}

	public String getAddSchoolAdminPopoverText() {
		waitForElement(addAdminLinkPopover);
		return addAdminLinkPopover.getText();
	}

	public boolean isDistrictUserListDisplayed() {
		waitForElement(usersList);
		return usersList.isDisplayed();
	}

}
