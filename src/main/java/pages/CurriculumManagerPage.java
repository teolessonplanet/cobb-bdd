package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurriculumManagerPage extends BaseActionsPage {

	public CurriculumManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='cm-title cm-root-title']")
	WebElement pageTitle;

	@FindBy(css = "[href='/my/shared_with_me/by_users']")
	WebElement sharedWithMeTab;

	@FindBy(css = "[class='nav nav-tabs'] [href='/my/curriculum_manager']")
	WebElement myResourcesTab;

	@FindBy(css = "[class*='cm-create-collection-btn']")
	WebElement createFolderButton;

	@FindBy(css = "[class*='cm-upload-resource-btn']")
	WebElement uploadButton;

	@FindBy(css = "#sort-widget")
	WebElement sortByDropdown;

	@FindBy(css = "[class*='cm-show-details-btn']")
	WebElement detailsButton;

	@FindBy(css = "[class='group-table'] [id^='collection-']:not([id^='collection-item-']) [class='group-info']")
	WebElement foldersList;
	
	@FindBy(css = "[class='group-table'] [id^='collection-']:not([id^='collection-item-']) [class='group-info'] [class*='resource-title-text folder']")
	WebElement folderTitle;

	@FindBy(css = "div.collection.group-row [class*='info status']")
	WebElement folderStatus;

	@FindBy(css = "div.collection.group-row [class*='info type']")
	WebElement folderType;

	@FindBy(css = "#folder-2")
	WebElement myUploadsFolderRow;

	@FindBy(css = "#folder-2 [class='resource-title-text-wrap']")
	WebElement myUploadsFolderTitle;

	@FindBy(css = "#folder-1")
	WebElement myFavoritesFolderRow;

	@FindBy(css = "#folder-2 [class*='children-container']")
	WebElement uploadedResourceList;

	@FindBy(css = "#folder-2 [class='group-info'] [class='info persistent details']")
	WebElement uploadedResourceInfoIcon;

	@FindBy(css = "#folder-1 [class*='children-container']")
	WebElement favoritedResourceList;

	@FindBy(css = "#folder-1 [class='resource-title-text-wrap']")
	WebElement myFavoritesFolderTitle;

	@FindBy(css = "[class='group-info'] [class='info persistent details']")
	WebElement favoritedResourceInfoIcon;

	@FindBy(css = "#new-builder")
	WebElement collectionBuilder;

	@FindBy(css = "[class*='fa-refresh']")
	WebElement reFreshIcon;

	@FindBy(css = "[class='group-info'] [class*='info status']")
	WebElement resourceStatus;

	@FindBy(css = "[class='group-info'] [class*='info type']")
	WebElement resourceType;

	@FindBy(css = "[class*='group-info'] [class='action-dropdown']")
	WebElement actionsDropdown;

	@FindBy(css = "[class='options actions'] button[class*='action-item play']")
	WebElement playButton;

	@FindBy(css = "[class='options actions'] [class*='action-item edit']")
	WebElement editButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item delete']")
	WebElement deleteButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item assign']")
	WebElement assignButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item activity']")
	WebElement activityButton;

	@FindBy(css = "[class='options actions'] [class*='action-item share']")
	WebElement shareButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item publish']")
	WebElement publishButton;

	@FindBy(css = "[class='options actions'] [class*='fa-external-link']")
	WebElement goToResourceButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item unfavorite']")
	WebElement unFavoriteResourceButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item delete']")
	WebElement deleteResourceButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item edit']")
	WebElement editResourceButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item copy-to']")
	WebElement copyToButton;

	@FindBy(css = "[class='options actions'] button[class*='action-item move-to']")
	WebElement moveToButton;

	@FindBy(css = "[class*='cb-item panel'] [class*='panel-body'] [class*='spinner'] i")
	WebElement loadingIcon;

	public boolean isAssignButtonIsVisible() {
		return assignButton.isDisplayed();
	}

	public String getMyResourcesPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public boolean isMyResourcesTabDisplayed() {
		return myResourcesTab.isDisplayed();
	}

	public boolean isSharedWithMeTabDisplayed() {
		return sharedWithMeTab.isDisplayed();
	}

	public boolean isCreateFolderButtonDisplayed() {
		waitForElement(uploadButton);
		return createFolderButton.isDisplayed();
	}

	public boolean isUploadButtonDisplayed() {
		waitForElement(uploadButton);
		return uploadButton.isDisplayed();
	}

	public boolean isDetailsButtonDisplayd() {
		return detailsButton.isDisplayed();
	}

	public boolean isSortByDropdownDisplayed() {
		return sortByDropdown.isDisplayed();
	}

	public boolean isMyFavoritesFolderDisplayed() {
		return myFavoritesFolderRow.isDisplayed();
	}

	public boolean isFavoritedResourceListDisplayed() {
		return favoritedResourceList.isDisplayed();
	}

	public boolean isUploadedResourceListDisplayed() {
		return uploadedResourceList.isDisplayed();
	}

	public boolean isMyUploadsFolderDisplayed() {
		return myUploadsFolderRow.isDisplayed();
	}

	public boolean isCollectionBuilderDisplayed() {
		return collectionBuilder.isDisplayed();
	}

	public boolean isFoldersListDisplayed() {
		return foldersList.isDisplayed();
	}

	public void clickOnCreateFolderButton() {
		waitForElement(createFolderButton);
		createFolderButton.click();
	}

	public void waitForLoadingIconFromCollectionBuilderToDisappear() {
		waitUntilElementIsHidden(loadingIcon);
	}

	public void clickOnUploadButton() {
		waitForLoadingIconFromCollectionBuilderToDisappear();
		waitForElement(uploadButton);
		uploadButton.click();
	}

	public void clickOnMyFavoritesFolder() {
		myFavoritesFolderTitle.click();
	}

	public void clickOnMyUploadsFolder() {
		myUploadsFolderTitle.click();
	}

	public void waitForRefreshIconToDisappear() {
		waitUntilElementIsHidden(reFreshIcon);
	}

	public void clickOnFavoritedResourceInfoIcon() {
		favoritedResourceInfoIcon.click();
	}

	public void clickOnUploadedResourceInfoIcon() {
		uploadedResourceInfoIcon.click();
	}

	public boolean isResourceStatusDisplayd() {
		return resourceStatus.isDisplayed();
	}

	public boolean isFolderTypeDisplayed() {
		return folderType.isDisplayed();
	}

	public boolean isFolderStatusDisplayed() {
		return folderStatus.isDisplayed();
	}

	public String getFolderStatusDisplayed() {
		return folderStatus.getText();
	}

	public boolean isResourceTypeDisplayd() {
		return resourceType.isDisplayed();
	}

	public void clickOnActionsDropdown() {
		waitForElement(actionsDropdown);
		actionsDropdown.click();
	}

	public void clickOnPlayButton() {
		waitForElement(playButton);
		playButton.click();
	}

	public void clickOnAssignButton() {
		waitForElement(assignButton);
		assignButton.click();
	}

	public void clickOnGoToResourceButton() {
		waitForElement(goToResourceButton);
		goToResourceButton.click();
	}

	public void clickOnUnfavoriteResourceButton() {
		waitForElement(unFavoriteResourceButton);
		unFavoriteResourceButton.click();
	}

	public boolean isDeleteButtonDisplayed() {
		return deleteResourceButton.isDisplayed();
	}

	public boolean isEditButtonDisplayed() {
		return editButton.isDisplayed();
	}

	public boolean isMoveToButtonDisplayed() {
		return moveToButton.isDisplayed();
	}

	public boolean isCopyToButtonDisplayed() {
		return copyToButton.isDisplayed();
	}

	public void clickOnEditButton() {
		waitForElement(editButton);
		editButton.click();
	}

	public void clickOnDeleteButton() {
		waitForElement(deleteButton);
		deleteButton.click();
	}

	public boolean isGoToResourceButtonDisplayed() {
		return goToResourceButton.isDisplayed();
	}

	public boolean isUnFavoriteResourceButtonDisplayed() {
		return unFavoriteResourceButton.isDisplayed();
	}

	public boolean isActivityButtonDisplayed() {
		return activityButton.isDisplayed();
	}

	public boolean isShareButtonDisplayed() {
		return shareButton.isDisplayed();
	}

	public void clickOnCopyToButton() {
		waitForElement(copyToButton);
		copyToButton.click();
	}

	public void clickOnMoveToButton() {
		waitForElement(moveToButton);
		moveToButton.click();
	}

	public void clickOnShareButton() {
		waitForElement(shareButton);
		shareButton.click();
	}

	public void waitUntilUploadedResourceListIsDisplayed() {
		waitForElement(uploadedResourceList);
	}

	public void waitUntilFavoritedResourceListIsDisplayed() {
		waitForElement(favoritedResourceList);
	}

	public boolean isActionsButtonDisplayed() {
		return actionsDropdown.isDisplayed();
	}

	public boolean isFolderTitleDisplayed() {
		return folderTitle.isDisplayed();
	}

	public void clickOnActivityButton() {
		activityButton.click();
	}

	public void clickOnPublishButton() {
		publishButton.click();
	}

	public boolean isPublishButtonDisplayed() {
		return publishButton.isDisplayed();
	}

	public boolean isPlayButtonDisplayed() {
		return playButton.isDisplayed();
	}

	public boolean isAssignButtonDisplayed() {
		return assignButton.isDisplayed();
	}

}
