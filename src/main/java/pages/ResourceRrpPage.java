package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourceRrpPage extends RrpPage {
	public ResourceRrpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='resource-title'] h1")
	WebElement pageTitle;

	@FindBy(css = "[class*='panel-default panel-review'] [class*='resource-img img-thumbnail img-responsive']")
	WebElement thumbnail;

	@FindBy(css = "[class='panel-body'] [class*='js-help-rpp-description'] + p")
	WebElement description;

	@FindBy(css = "[class*='detail-downloads']")
	WebElement nrOfDownloads;

	@FindBy(css = "[class*='panel-default panel-review'] [class*='trk-goto-resource']")
	WebElement goToResourceButton;

	@FindBy(css = "div[class$='add-to-folder-btn']")
	WebElement addToFolderDropdown;

	@FindBy(css = "[class*='panel-default panel-review'] [class*='trk-save-resource']")
	WebElement favoriteButton;

	@FindBy(css = "[class*='panel-default panel-review'] div[class*='btn-default disabled']")
	WebElement disabledFavoriteButton;

	private static final String RESOURCE_TYPES = "[class*='panel-review new-rrp'] [class*='left-resource-details'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(2) dd";
	private static final String RRP_SUBJECTS = "[class*='panel-review new-rrp'] [class*='left-resource-details'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(1) dd";

	public boolean isResourceRrpTitleDisplayed() {
		waitForElement(pageTitle);
		return pageTitle.isDisplayed();
	}

	public boolean isThumbnailDisplayed() {
		return thumbnail.isDisplayed();
	}

	public boolean isDescriptionDisplayed() {
		return description.isDisplayed();
	}

	public boolean isNumberOfDownloadsDisplayed() {
		return nrOfDownloads.isDisplayed();
	}

	public boolean isGoToResourceButtonDisplayed() {
		return goToResourceButton.isDisplayed();
	}

	public boolean isAddToFolderDropdownDisplayed() {
		return addToFolderDropdown.isDisplayed();
	}

	public boolean isFavoriteButtonDisplayed() {
		return favoriteButton.isDisplayed();
	}

	public boolean isFavoriteButtonDisabledDisplayed() {
		return disabledFavoriteButton.isDisplayed();
	}

	public int getFullRrpSubjectsNumber() {
		final List<WebElement> subjects = findElements(RRP_SUBJECTS);
		return subjects.size();
	}

	public List<String> getFullRrpSubjectText() {
		List<WebElement> subjects = findElements(RRP_SUBJECTS);
		List<String> displaySubjects = new ArrayList<>();
		for (WebElement subject : subjects) {
			displaySubjects.add(subject.getText());
		}
		return displaySubjects;
	}

	public List<String> getFullRrpResourceTypeText() {
		List<WebElement> resourceTypes = findElements(RESOURCE_TYPES);
		List<String> displayResourceType = new ArrayList<>();
		for (WebElement resourceType : resourceTypes) {
			displayResourceType.add(resourceType.getText());
		}
		return displayResourceType;
	}

	public int getFullRrpResourceTypeNumber() {
		final List<WebElement> resourceType = findElements(RESOURCE_TYPES);
		return resourceType.size();
	}

}
