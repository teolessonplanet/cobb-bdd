package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BaseActionsPage {

	public HeaderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "lp-sign-in")
	WebElement signInHeaderButton;

	@FindBy(css = "[class*='lp-nav-menu'] #lp-username")
	WebElement userDropdown;

	@FindBy(css = "[class*='lp-nav-menu'] [class='lp-resources']")
	WebElement discoverDropdown;

	@FindBy(css = "[class='lp-resources'] [href='/search']")
	WebElement discoverResourcesButton;

	@FindBy(css = "[class='lp-resources'] [href='/lesson-plans']")
	WebElement browseResourceDirectoryButton;

	@FindBy(css = "[class='lp-username'] [href='/my/curriculum_manager']")
	WebElement myResourcesButton;

	@FindBy(css = "[class='lp-username'] [href*='/my/admin-manager/account/']")
	WebElement adminManagerButton;

	@FindBy(id = "curriculum-manager-menu-item")
	WebElement curriculumManagerButton;

	@FindBy(css = "[class='lp-resources'] [href='/calendar']")
	WebElement curriculumCalendarButton;

	@FindBy(css = "[class='lp-username'] [href='/profile/account']")
	WebElement myAccountButton;

	@FindBy(css = "[class='lp-username'] [href='/logout']")
	WebElement signOutButton;

	@FindBy(css = "[class='lp-header'] [class='lp-logo-wrap lp-logo'] /*[name()='svg']")
	WebElement lessonPlanetLogo;

	@FindBy(css = "[class='lp-header-title']")
	WebElement resourcesText;

	@FindBy(css = "#keywords")
	WebElement searchInput;

	@FindBy(css = "[class='lp-header-search-button']")
	WebElement searchButton;

	@FindBy(css = "[class*='lp-header-clear-search']")
	WebElement clearButton;

	public void clickOnSignInHeaderButton() {
		waitForElement(signInHeaderButton);
		signInHeaderButton.click();
	}

	public boolean isDiscoverDropdownDisplayed() {
		return discoverDropdown.isDisplayed();
	}

	public boolean isUserDropdownDisplayed() {
		return userDropdown.isDisplayed();
	}

	public void hoverOverUsernameDropdown() {
		hoverOverElement(userDropdown);
	}

	public void hoverOverResourceText() {
		hoverOverElement(resourcesText);
	}

	public String getUsernameFromDropdown() {
		waitForElement(userDropdown);
		return userDropdown.getText();
	}

	public void hoverOverDiscoverDropdown() {
		hoverOverElement(discoverDropdown);
	}

	public void clickOnDiscoverResourcesButton() {
		discoverResourcesButton.click();
	}

	public void clickOnBrowseResourceDirectoryButton() {
		browseResourceDirectoryButton.click();
	}

	public void clickOnCurriculumManagerButton() {
		curriculumManagerButton.click();
	}

	public void clickOnCurriculumCalendarButton() {
		curriculumCalendarButton.click();
	}

	public void clickOnMyAccountButton() {
		myAccountButton.click();
	}

	public void clickOnAdminManagerButton() {
		waitForElement(adminManagerButton);
		adminManagerButton.click();
	}

	public void clickOnMyResourcesButton() {
		myResourcesButton.click();
	}

	public void clickOnSignOutButton() {
		signOutButton.click();
	}

	public boolean isLessonPlanetLogoDisplayed() {
		return lessonPlanetLogo.isDisplayed();
	}

	public boolean isResourceTextDisplayed() {
		return resourcesText.isDisplayed();
	}

	public boolean isSearchInputDisplayed() {
		return searchInput.isDisplayed();
	}

	public void clickOnSearchInput() {
		searchInput.click();
	}

	public String getSearchInputPlaceholderText() {
		return searchInput.getAttribute("placeholder");
	}

	public String getSearchButtonText() {
		waitForElement(searchButton);
		return searchButton.getText();
	}

	public void typeSearchText(String searchText) {
		searchInput.clear();
		searchInput.sendKeys(searchText);
	}

	public void clickOnSearchButton() {
		waitForElement(searchButton);
		searchButton.click();
	}

	public String getSearchInputText() {
		return searchInput.getAttribute("value");
	}

	public boolean isClearButtonDisplayed() {
		waitForElement(clearButton);
		return clearButton.isDisplayed();
	}

	public void clickOnClearButton() {
		waitForElement(clearButton);
		clearButton.click();
	}

	public void clickOnResourcesHeaderText() {
		resourcesText.click();
	}
}
