package pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Data;

public class CollectionRrpPage extends RrpPage {

	public CollectionRrpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='panel-default panel-review'] div h1")
	WebElement pageTitle;

	@FindBy(css = "[class*='panel-default panel-review'] span[class='save-collection-btn']")
	WebElement saveFolderButton;

	@FindBy(css = "[class='rrp-items-count']")
	WebElement itemsCount;

	@FindBy(css = "[class*='panel-default panel-review'] [class='save-collection-btn'] [action*='/remix_collection']")
	WebElement saveCollectionButton;

	@FindBy(css = "[class*='panel-default panel-review'] [class='play-collection-btn']")
	WebElement playCollectionButton;

	@FindBy(css = "[class='top-buttons'] button[class*='rrp-share-resource']")
	WebElement shareButton;

	@FindBy(css = "div.shared_collection div[class*='rrp-details panel-body'] div.row:nth-child(2) p:nth-child(1)")
	WebElement description;

	@FindBy(css = "div.shared_collection span[title='Subject']")
	WebElement subject;

	@FindBy(css = "[class*='detail-saves']")
	WebElement nrOfSaves;

	@FindBy(css = "[class='panel-items'] a[class='bx-next']")
	WebElement nextButtonPanelItem;

	@FindBy(css = "[class='panel-items'] a[class='bx-prev']")
	WebElement previousButtonPanelItem;

	@FindBy(css = "[class='see-full-reviews-link'] h4")
	WebElement seeFullReviewLink;

	@FindBy(css = "[class='expanded-item-rrps'] a[class='bx-next']")
	WebElement nextButtonItemViewer;

	@FindBy(css = "[class='expanded-item-rrps'] a[class='bx-prev']")
	WebElement previousButtonItemViewer;

	@FindBy(css = "[class='expanded-item-rrps'] [class*='close-item-rrp-view']")
	WebElement xButtonExpandedRrp;

	public static final String EXPANDED_RRP = "[class='rrp-list'] li[class='rrp-content']";
	public static final String PANEL_ITEMS = "[class='panel-items'] [class='item-list'] li";
	public static final String PANEL_ITEM = "[class='panel-items'] ul[class='item-list'] li [class='item-panel'] [class='item-rrp-link']";

	public boolean isCollectionRrpTitleDisplayed() {
		waitForElement(pageTitle);
		return pageTitle.isDisplayed();
	}

	public boolean isSaveFolderButtonDisplayed() {
		waitForElement(saveFolderButton);
		return saveFolderButton.isDisplayed();
	}

	public int getCollectionItemsCount() {
		String rawNumber = itemsCount.getText();
		int number;
		try {
			number = NumberFormat.getNumberInstance(Data.LOCALE).parse(rawNumber).intValue();
		} catch (ParseException e) {
			throw new Error("The number " + rawNumber + " cannot be parsed");
		}
		return number;
	}

	public boolean isPreviousButtonPanelItemsDisplayed() {
		waitForElement(previousButtonPanelItem);
		return previousButtonPanelItem.isDisplayed();
	}

	public boolean isNextButtonPanelItemsDisplayed() {
		waitForElement(nextButtonPanelItem);
		return nextButtonPanelItem.isDisplayed();
	}

	public boolean isDescriptionDisplayed() {
		return description.isDisplayed();
	}

	public void clickNextButtonPanelItems() {
		waitForElement(nextButtonPanelItem);
		nextButtonPanelItem.click();
	}

	public void clickSeeFullReviewsLink() {
		waitForElement(seeFullReviewLink);
		seeFullReviewLink.click();
	}

	public boolean isSeeFullReviewsLinkVisible() {
		waitForElement(seeFullReviewLink);
		return seeFullReviewLink.isDisplayed();
	}

	public void clickNextButtonItemViewer() {
		waitForElement(nextButtonItemViewer);
		nextButtonItemViewer.click();
	}

	public boolean isNextButtonItemViewerDisplayed() {
		waitForElement(nextButtonItemViewer);
		return nextButtonItemViewer.isDisplayed();
	}

	public void clickCloseExpandedRrp() {
		waitForElement(xButtonExpandedRrp);
		xButtonExpandedRrp.click();
	}

	public boolean isPreviousButtonItemViewerDisplayed() {
		waitForElement(previousButtonItemViewer);
		return previousButtonItemViewer.isDisplayed();
	}

	public boolean isGradeDisplayed() {
		return grade.isDisplayed();
	}

	public boolean isNumberOfSavesDisplayed() {
		return nrOfSaves.isDisplayed();
	}

	public boolean isSubjectDisplayed() {
		return subject.isDisplayed();
	}

	public boolean isPlayCollectionButtonDisplayed() {
		return playCollectionButton.isDisplayed();
	}

	public boolean isSaveCollectionButtonActiveUserDisplayed() {
		return saveCollectionButton.isDisplayed();
	}

	public boolean isCollectionItemsCountDisplayed() {
		return itemsCount.isDisplayed();
	}

	public void clickPreviousButtonItemViewer() {
		waitForElement(previousButtonItemViewer);
		previousButtonItemViewer.click();
	}

	public int getPanelItemsCount() {
		final List<WebElement> panelItems = findElements(PANEL_ITEMS);
		return panelItems.size();
	}

	public String getExpandedRrpDataId(int i) {
		waitForElement(EXPANDED_RRP);
		final List<WebElement> expandedRrp = findElements(EXPANDED_RRP);
		return expandedRrp.get(i).getAttribute("data-id");
	}

	public String getPanelItemDataId(int i) {
		waitForElement(PANEL_ITEM);
		final List<WebElement> panelItem = findElements(PANEL_ITEM);
		return panelItem.get(i).getAttribute("data-id");
	}

}
