package pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Data;

public class ContentManagerPage extends BaseActionsPage {

	public ContentManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[href$='/content-tool']")
	WebElement contentManagerTab;

	@FindBy(css = "[class*='content-manager-header'] h2")
	WebElement pageTitle;

	@FindBy(css = "[class*='content-manager-header'] [class*='text-lg']")
	WebElement pageSubTitle;

	@FindBy(css = "#resources-heading")
	WebElement searchTextFieldText;

	@FindBy(css = "[class*='sort'] [class='text text-blue-700']")
	WebElement sortByDropdown;

	@FindBy(css = "#resources-heading strong")
	WebElement resourcesFoundText;

	@FindBy(css = "#cm-facet-sidebar")
	WebElement facetSidebar;

	@FindBy(css = "[class*='keywords-search-bar'] #keywords")
	WebElement searchInput;

	@FindBy(css = "[class*='keywords-search-bar'] #clear-search")
	WebElement searchCloseButton;

	@FindBy(css = "[class*='keywords-search-bar'] #content-search-btn")
	WebElement searchButton;

	@FindBy(css = "[class='resources']")
	WebElement resourceCardsList;

	@FindBy(css = "[class='lp-loading-bg ma-bo-sm']")
	WebElement loadingPage;

	private static final String resourceCards = "[class='resources'] [class*='resource']";
	private static final String resourceProvider = "[class='pool-area'] [class*='pool']";
	private static final String resourceTitle = "[class='main-panel'] [class*='resource-heading'] [href*='/']";
	private static final String resourceThumbnail = "[class*='resource'] img[class*='thumbnail-img']";
	private static final String resourceType = "[class='resource-content'] [class*='type-resource']";
	private static final String resourceGrades = "[class='resource-content'] [class*='detail-grades']";
	private static final String resourceRating = "[class='resource-content'] [class*='star-rating']";
	private static final String resourceViews = "[class='resource-content'] [class='views']";
	private static final String resourceDescription = "[class='resource-content'] [class*='description']";
	private static final String resourceQuickView = "[class*='action-panel-actions'] [class*='lp-button']";
	private static final String resourceHideFromSearch = "[class*='action-panel-actions'] [class*='checkbox-item']";

	public void clickOnContentManagerTab() {
		waitForElement(contentManagerTab);
		contentManagerTab.click();
		waitUntilElementIsHidden(loadingPage);
	}

	public String getTitleText() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public String getPageSubtitleText() {
		waitForElement(pageSubTitle);
		return pageSubTitle.getText();
	}

	public boolean isSearchTextFieldTextDisplayed() {
		return searchTextFieldText.isDisplayed();
	}

	public boolean isFacetSidebarDisplayed() {
		return facetSidebar.isDisplayed();
	}

	public String getSearchTextFieldText(String text) {
		waitUntilTextIsDisplayed(searchTextFieldText, text);
		return searchTextFieldText.getText();
	}

	public int getTotalResourcesFound() throws ParseException {
		waitForElement(resourcesFoundText);
		String rawNumber = resourcesFoundText.getText();
		int number;
		number = NumberFormat.getNumberInstance(Data.LOCALE).parse(rawNumber).intValue();
		return number;
	}

	public boolean isSortByOptionDropdownDisplayedt() {
		return sortByDropdown.isDisplayed();
	}

	public boolean isResourceCardDisplayed(int position) {
		return findElements(resourceCards).get(position).isDisplayed();
	}

	public boolean isResourceCardsListDisplayed() {
		return resourceCardsList.isDisplayed();
	}

	public List<WebElement> getResourceCards() {
		return findElements(resourceCards);
	}

	public boolean isResourceProviderDisplayed(int position) {
		return findElements(resourceProvider).get(position).isDisplayed();
	}

	public boolean isResourceHideFromViewDisplayed(int position) {
		return findElements(resourceHideFromSearch).get(position).isDisplayed();
	}

	public boolean isResourceTitleDisplayed(int position) {
		return findElements(resourceTitle).get(position).isDisplayed();
	}

	public boolean isResourceThumbnailDisplayed(int position) {
		return findElements(resourceThumbnail).get(position).isDisplayed();
	}

	public boolean isResourceTypeDisplayed(int position) {
		return findElements(resourceType).get(position).isDisplayed();
	}

	public boolean isResourceGradesDisplayed(int position) {
		return findElements(resourceGrades).get(position).isDisplayed();
	}

	public boolean isResourceRatingDisplayed(int position) {
		return findElements(resourceRating).get(position).isDisplayed();
	}

	public boolean isResourceViewsDisplayed(int position) {
		return findElements(resourceViews).get(position).isDisplayed();
	}

	public boolean isResourceDescriptionDisplayed(int position) {
		return findElements(resourceDescription).get(position).isDisplayed();
	}

	public boolean isResourceQuickViewButtonDisplayed(int position) {
		return findElements(resourceQuickView).get(position).isDisplayed();
	}

	public String getResourceTitle(int i) {
		return findElements(resourceTitle).get(i).getText();
	}

	public void typeSearchText(String searchText) {
		searchInput.sendKeys(searchText);
	}

	public String getSearchInputText() {
		return searchInput.getAttribute("value");
	}

	public void clickOnSearchCloseButton() {
		searchCloseButton.click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}
}
