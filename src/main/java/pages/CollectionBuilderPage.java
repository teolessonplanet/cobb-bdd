package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionBuilderPage extends BaseActionsPage {

	public CollectionBuilderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='view-manage-button']")
	WebElement myResourcesButton;

	@FindBy(css = "div[class^='dropdown cb-dropdown']")
	WebElement selectExistingButton;

	@FindBy(css = "div[class='create-folder-button ']")
	WebElement startBuildingButton;

	@FindBy(css = "[class='edit-folder-button']")
	WebElement editButton;

	@FindBy(css = "[class*='cb-dropdown'] li[class='list-option']")
	WebElement firstCollection;

	@FindBy(css = "#new-builder")
	WebElement collectionBuilder;

	public void clickOnFirstCollection() {
		waitForElement(firstCollection);
		firstCollection.click();
	}

	public void clickOnEditButton() {
		waitForElement(editButton);
		editButton.click();
		waitForLoad();
	}

	public void clickOnMyResourcesButton() {
		waitUntilElementIsClickable(myResourcesButton);
		myResourcesButton.click();
	}

	public void clickOnSelectExistingDropdown() {
		waitForElement(selectExistingButton);
		selectExistingButton.click();
	}

	public boolean isMyResourcesButtonDisplayed() {
		waitForElement(myResourcesButton);
		return myResourcesButton.isDisplayed();
	}

	public boolean isselectExistingButtonDisplayed() {
		waitForElement(selectExistingButton);
		return selectExistingButton.isDisplayed();
	}

	public boolean isstartBuildingButtonDisplayed() {
		waitForElement(startBuildingButton);
		return startBuildingButton.isDisplayed();
	}

	public boolean isEditButtonDisplayed() {
		waitForElement(editButton);
		return editButton.isDisplayed();
	}

	public boolean isCollectionBuilderDisplayed() {
		waitForElement(collectionBuilder);
		return collectionBuilder.isDisplayed();
	}
}
