package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditFolderPage extends BaseActionsPage {

	public EditFolderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#edit-collection-modal")
	WebElement editFolderModal;

	@FindBy(css = "#edit-collection-modal [class*='edit-collection-modal-close']")
	WebElement closeButton;

	@FindBy(css = "[class='edit-folder-title'] h1")
	WebElement folderTitle;

	@FindBy(css = "#edit-folder-type")
	WebElement folderType;

	@FindBy(css = "#collection-add-items-wrap")
	WebElement addButton;

	@FindBy(css = "[class='edit-folder-actions'] [class='edit-folder-details edit-folder-action-item']")
	WebElement editDetailsButton;

	@FindBy(css = "[class='edit-folder-panel edit-details']")
	WebElement editDetailsSection;

	@FindBy(css = "[class='edit-folder-panel publish-folder']")
	WebElement publishSection;

	@FindBy(css = "[class='edit-folder-panel transfer']")
	WebElement copyToSection;

	@FindBy(css = "[class='edit-folder-panel player-activity']")
	WebElement activitySection;

	@FindBy(css = "[class='edit-folder-action-item button play-folder']")
	WebElement playButton;

	@FindBy(css = "#collection-actions-wrap")
	WebElement moreDropdown;

	@FindBy(css = "[class*='collection-actions-dropdown'] [class*='fa-book']")
	WebElement publishOption;

	@FindBy(css = "[class*='collection-actions-dropdown'] [class*='fa-paper-plane']")
	WebElement assignOption;

	@FindBy(css = "[class*='collection-actions-dropdown'] [class*='fa-clone']")
	WebElement copyToOption;

	@FindBy(css = "[class*='collection-actions-dropdown'] [class*='fa-bar-chart']")
	WebElement activityOption;

	@FindBy(css = "[class*='collection-actions-dropdown'] [class*='fa-users']")
	WebElement shareOption;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(1)")
	WebElement webLinkOption;

	@FindBy(css = "[class='edit-folder-panel add-link']")
	WebElement addWebLinkSection;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(4)")
	WebElement createPageOption;

	@FindBy(css = "[class='edit-folder-panel add-page-resource']")
	WebElement createPageSection;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(2)")
	WebElement fileUploadOption;

	@FindBy(css = "[class='edit-folder-panel upload-file']")
	WebElement uploadFileSection;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(3)")
	WebElement pixabayImageOption;

	@FindBy(css = "[class='edit-folder-panel add-pixabay-image']")
	WebElement addPixabayImageSection;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(5)")
	WebElement newFolderOption;

	@FindBy(css = "[class='edit-folder-panel add-new-folder']")
	WebElement createNewFolderSection;

	@FindBy(css = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(6)")
	WebElement resourceLibraryOption;

	@FindBy(css = "#folder-navigator [class='list-option active'] [class='folder-title']")
	WebElement activeFolderTitle;

	@FindBy(css = "#folder-navigator ul")
	WebElement foldersList;

	@FindBy(css = "[class*='navigator-toggle']")
	WebElement navigateFolderButton;

	@FindBy(css = "[class='navigator-toggle active']")
	WebElement navigateFolderCloseButton;

	@FindBy(css = "[class='fa fa-spin fa-circle-o-notch']")
	WebElement spinnerIcon;

	public boolean isEditFolderModalDisplayed() {
		waitForElement(editFolderModal);
		return editFolderModal.isDisplayed();
	}

	public void clickOnCloseButton() {
		waitForElement(closeButton);
		closeButton.click();
		waitForLoad();
	}

	public String getFolderTitle() {
		return folderTitle.getText();
	}

	public boolean isNavigateFolderButtonDisplayed() {
		waitForElement(navigateFolderButton);
		return navigateFolderButton.isDisplayed();
	}

	public boolean isFolderTypeDisplayed() {
		waitForElement(folderType);
		return folderType.isDisplayed();
	}

	public boolean isFolderTitleDisplayed() {
		waitForElement(folderTitle);
		return folderTitle.isDisplayed();
	}

	public boolean isAddButtonDisplayed() {
		waitForElement(addButton);
		return addButton.isDisplayed();
	}

	public boolean isEditDetailsButtonDisplayed() {
		waitForElement(editDetailsButton);
		return editDetailsButton.isDisplayed();
	}

	public boolean isPlayButtonDisplayed() {
		waitForElement(playButton);
		return playButton.isDisplayed();
	}

	public boolean isMoreDropdownDisplayed() {
		waitForElement(moreDropdown);
		return moreDropdown.isDisplayed();
	}

	public void clickOnNavigateFolderButton() {
		waitForElement(navigateFolderButton);
		navigateFolderButton.click();
	}

	public void waitUntilSpinnerIconisNotDisplayed() {
		waitUntilElementIsHidden(spinnerIcon);
	}

	public boolean isFolderListDisplayed() {
		waitForElement(foldersList);
		return foldersList.isDisplayed();
	}

	public void clickOnNavigateFolderCloseButton() {
		waitForElement(navigateFolderCloseButton);
		navigateFolderCloseButton.click();
	}

	public void clickOnPlayButton() {
		waitForElement(playButton);
		playButton.click();
	}

	public void clickOnMoreButton() {
		waitForElement(moreDropdown);
		moreDropdown.click();
	}

	public boolean isPublishOptionDisplayed() {
		waitForElement(publishOption);
		return publishOption.isDisplayed();
	}

	public boolean isAssignOptionDisplayed() {
		return assignOption.isDisplayed();
	}

	public boolean isCopyToOptionDisplayed() {
		return copyToOption.isDisplayed();
	}

	public boolean isActivityOptionDisplayed() {
		return activityOption.isDisplayed();
	}

	public void clickOnEditDetailsButton() {
		waitForElement(editDetailsButton);
		editDetailsButton.click();
	}

	public boolean isEditDetailsSectionDisplayed() {
		return editDetailsSection.isDisplayed();
	}

	public void clickOnAddButton() {
		waitForElement(addButton);
		addButton.click();
	}

	public boolean isWebLinkOptionDisplayed() {
		return webLinkOption.isDisplayed();
	}

	public boolean isFileUploadOptionDisplayed() {
		return fileUploadOption.isDisplayed();
	}

	public boolean isPixabayImageOptionDisplayed() {
		return pixabayImageOption.isDisplayed();
	}

	public boolean isCreatePageOptionDisplayed() {
		return createPageOption.isDisplayed();
	}

	public boolean isNewFolderOptionDisplayed() {
		return newFolderOption.isDisplayed();
	}

	public boolean isResourceLibraryOptionDisplayed() {
		return resourceLibraryOption.isDisplayed();
	}

	public void clickOnWebLinkOption() {
		waitForElement(webLinkOption);
		webLinkOption.click();
	}

	public boolean isAddWebLinkSectionDisplayed() {
		return addWebLinkSection.isDisplayed();
	}

	public void clickOnFileUploadOption() {
		waitForElement(fileUploadOption);
		fileUploadOption.click();
	}

	public boolean isUploadFileSectionDisplayed() {
		return uploadFileSection.isDisplayed();
	}

	public void clickOnPixabayImageOption() {
		waitForElement(pixabayImageOption);
		pixabayImageOption.click();
	}

	public boolean isAddPixabayImageSectionDisplayed() {
		return addPixabayImageSection.isDisplayed();
	}

	public void clickOnCreatePageOption() {
		waitForElement(createPageOption);
		createPageOption.click();
	}

	public boolean isCreatePageSectionDisplayed() {
		waitForElement(createPageOption);
		return createPageSection.isDisplayed();
	}

	public void clickOnNewFolderOption() {
		waitForElement(newFolderOption);
		newFolderOption.click();
	}

	public boolean isCreateNewFolderSectionDisplayed() {
		waitForElement(createNewFolderSection);
		return createNewFolderSection.isDisplayed();
	}

	public void clickOnResourceLibraryOption() {
		waitForElement(resourceLibraryOption);
		resourceLibraryOption.click();
	}

	public String getActiveFolderTitle() {
		waitForElement(activeFolderTitle);
		return activeFolderTitle.getText();
	}

	public boolean isShareOptionDisplayed() {
		waitForElement(shareOption);
		return shareOption.isDisplayed();
	}

	public void clickOnPublishOption() {
		waitForElement(publishOption);
		publishOption.click();
	}

	public void clickOnShareOption() {
		waitForElement(shareOption);
		shareOption.click();
	}

	public void clickOnAssignOption() {
		waitForElement(assignOption);
		assignOption.click();
	}

	public void clickOnCopyToOption() {
		waitForElement(copyToOption);
		copyToOption.click();
	}

	public void clickOnActivityOption() {
		waitForElement(activityOption);
		activityOption.click();
	}

	public boolean isPublishFolderSectionDisplayed() {
		waitForElement(publishSection);
		return publishSection.isDisplayed();
	}

	public boolean isCopyToSectionDisplayed() {
		waitForElement(copyToSection);
		return copyToSection.isDisplayed();
	}

	public boolean isActivitySectionDisplayed() {
		waitForElement(activitySection);
		return activitySection.isDisplayed();
	}

}
