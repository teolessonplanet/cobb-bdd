package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Data;

import java.text.NumberFormat;
import java.text.ParseException;

public class SearchPage extends BaseActionsPage {

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "js-search-heading")
	WebElement searchText;

	@FindBy(css = "[class='count text-action']")
	WebElement resourcesCounterText;

	@FindBy(css = "[class='clear-all']")
	WebElement clearAllButton;

	@FindBy(css = "#list")
	WebElement listViewButton;

	@FindBy(css = "#thumbnail")
	WebElement thumbnailViewButton;

	@FindBy(css = "#tiled")
	WebElement tiledViewButton;

	@FindBy(css = "[class*='panel-footer'] [title*='Collection'][href*='/collections/']")
	WebElement seeFolderButton;

	@FindBy(css = "[class='panel-footer'] [class*='trk-show-resource'][href*='lessonplanet.com/pr/teachers/']")
	WebElement folderDetailsButton;

	@FindBy(css = "[class='panel-footer'] a[class*='open-folder-btn']")
	WebElement openFolderButton;

	@FindBy(css = "[class*='panel-footer'] [class*='trk-show-resource']")
	WebElement seeFullReviewButton;

	@FindBy(css = "[class*='trk-goto-resource'][href*='/goto/']")
	WebElement goToResourceButton;

	@FindBy(css = "#facet-sidebar [class*='lp-filter-group parent-provider_ids'] h4")
	WebElement providerFacet;

	@FindBy(css = "[class='lp-filter-group parent-provider_ids'] [class='lp-filter-body resource-pools'] [class='providers-list-divider']:nth-child(2) li:nth-child(2)")
	WebElement lessonPlanetProvider;

	@FindBy(css = "[class='lp-filter-group parent-provider_ids'] [class='lp-filter-body resource-pools'] [class='providers-list-divider']:nth-child(3) li:nth-child(12)")
	WebElement HMHProvider;

	@FindBy(css = "[class='lp-filter-group parent-provider_ids'] [class='lp-filter-body resource-pools'] [class='providers-list-divider']:nth-child(3) li:nth-child(8)")
	WebElement discoveryEducationProvider;

	@FindBy(css = "[class='lp-filter-group parent-provider_ids'] [class='lp-filter-body resource-pools'] [class='providers-list-divider']:nth-child(1) li")
	WebElement CTLSProvider;

	@FindBy(css = "[class*='lp-filter-group parent-type_ids'] [class='lp-filter-body resource-types'] [class='lp-filter-list'] li:nth-child(2)")
	WebElement activitiesAndProjectsResourceType;

	@FindBy(css = "[class*='lp-filter-group parent-type_ids'] [class='lp-filter-body resource-types'] [class='lp-filter-list'] li:nth-child(1) [class='show-more-facets']")
	WebElement folderResourceTypeFacet;

	@FindBy(css = "[class*='lp-filter-group parent-type_ids'] [class='lp-filter-body resource-types'] [class='lp-filter-list'] [class='lp-filter-item open'] [class='lp-filter-list children'] li:nth-child(2)")
	WebElement collectionResourceType;

	@FindBy(css = "[class*='lp-filter-group parent-type_ids'] [class='lp-filter-body resource-types'] [class='lp-filter-list'] [class='lp-filter-item open'] [class='lp-filter-list children'] li:nth-child(4)")
	WebElement lessonsResourceType;

	@FindBy(css = "div[class*='resource-icon']")
	WebElement cardResourceType;

	@FindBy(css = "h4[class*='resource-title']")
	WebElement cardTitle;

	@FindBy(css = "div[class='resource-description']")
	WebElement cardDescription;

	@FindBy(css = "span[class='resource-pool-tag']")
	WebElement cardPoolName;

	@FindBy(css = "[class='pull-right'] span[class='resource-pool-tag']")
	WebElement cardPoolNameList;

	@FindBy(css = "span[class='star-rating']")
	WebElement cardRating;

	@FindBy(css = "span[class*='detail-subject']")
	WebElement cardSubject;

	@FindBy(css = "span[class*='detail-grades']")
	WebElement cardGrade;

	@FindBy(css = "div[class='thumb-img-wrap']")
	WebElement cardIconThumbnail;

	@FindBy(css = "div[class*='resource-type-banner']")
	WebElement cardResourceTypeThunbnail;

	@FindBy(css = "span[class*='resource-grade']")
	WebElement cardGradeThumbnail;

	@FindBy(css = "[class='thumb-img-wrap']")
	WebElement cardThumbnail;

	public String getSearchPageText(String text) {
		waitUntilTextIsDisplayed(searchText, text);
		return searchText.getText();
	}

	public int getResourceResultsAfterSearch() {
		String rawNumber = resourcesCounterText.getText();
		int number;
		try {
			number = NumberFormat.getNumberInstance(Data.LOCALE).parse(rawNumber).intValue();
		} catch (ParseException e) {
			throw new Error("The number " + rawNumber + " cannot be parsed");
		}
		return number;
	}

	public void clickOnClearAllButton() {
		waitForElement(clearAllButton);
		clearAllButton.click();
	}

	public boolean isClearAllButtonDisplayed() {
		return clearAllButton.isDisplayed();
	}

	public void clickOnListViewButton() {
		waitForElement(listViewButton);
		listViewButton.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void clickOnThumbnailViewButton() {
		waitForElement(thumbnailViewButton);
		thumbnailViewButton.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void clickOnTiledViewButton() {
		waitForElement(tiledViewButton);
		tiledViewButton.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void clickOnSeeFolderButton() {
		waitForElement(seeFolderButton);
		seeFolderButton.click();
	}

	public void clickOnSeeFullReviewButton() {
		waitForElement(seeFullReviewButton);
		seeFullReviewButton.click();
	}

	public void clickOnGoToResourceButton() {
		waitForElement(goToResourceButton);
		goToResourceButton.click();
	}

	public void expandProviderFacet() {
		waitForElement(providerFacet);
		providerFacet.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectLessonPlanetProvider() {
		waitForElement(lessonPlanetProvider);
		lessonPlanetProvider.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectCTLSProvider() {
		waitForElement(CTLSProvider);
		CTLSProvider.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectActivitiesAndProjectsResourceType() {
		waitForElement(activitiesAndProjectsResourceType);
		activitiesAndProjectsResourceType.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectCollectionResourceType() {
		waitForElement(folderResourceTypeFacet);
		folderResourceTypeFacet.click();
		waitForElement(collectionResourceType);
		collectionResourceType.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectLessonResourceType() {
		waitForElement(folderResourceTypeFacet);
		folderResourceTypeFacet.click();
		waitForElement(lessonsResourceType);
		lessonsResourceType.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void clickOnOpenFolderButton() {
		waitForElement(openFolderButton);
		openFolderButton.click();
	}

	public void clickOnFolderDetailsButton() {
		waitForElement(folderDetailsButton);
		folderDetailsButton.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectHMHProvider() {
		waitForElement(HMHProvider);
		HMHProvider.click();
		waitForLoad();
		waitForPageLoad();
	}

	public void selectDiscoveryEducationProvider() {
		waitForElement(discoveryEducationProvider);
		discoveryEducationProvider.click();
		waitForLoad();
		waitForPageLoad();
	}

	public boolean isCardTitleDisplayed() {
		return cardTitle.isDisplayed();
	}

	public boolean isCardDescriptionDisplayed() {
		return cardDescription.isDisplayed();
	}

	public boolean isCardRatingDisplayed() {
		return cardRating.isDisplayed();
	}

	public boolean isCardGradeDisplayed() {
		return cardGrade.isDisplayed();
	}

	public boolean isCardResourceTypeDisplayed() {
		return cardResourceType.isDisplayed();
	}

	public boolean isCardPoolNameDisplayed() {
		return cardPoolName.isDisplayed();
	}

	public boolean isCardDescriptionisplayed() {
		return cardDescription.isDisplayed();
	}

	public boolean isCardPoolNameListDisplayed() {
		return cardPoolNameList.isDisplayed();
	}

	public boolean isCardSubjectDisplayed() {
		return cardSubject.isDisplayed();
	}

	public boolean isCardIconInThumbnailViewDisplayed() {
		return cardIconThumbnail.isDisplayed();
	}

	public boolean isCardResourceTypeInThumbnailViewDisplayed() {
		return cardResourceTypeThunbnail.isDisplayed();
	}

	public boolean isCardGradeInThumbnailViewDisplayed() {
		return cardGradeThumbnail.isDisplayed();
	}

	public void hoverOverThumbnailResource() {
		hoverOverElement(cardThumbnail);
	}

	public String getCardPoolNameList() {
		return cardPoolNameList.getText();
	}

	public String getCardPoolName() {
		return cardPoolName.getText();
	}
	
}
