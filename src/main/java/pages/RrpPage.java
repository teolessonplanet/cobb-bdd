package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RrpPage extends BaseActionsPage {

	public RrpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='resource-modal-close']")
	WebElement closeButton;

	@FindBy(css = "[class*='pool-name'")
	WebElement poolName;

	@FindBy(css = "[class='not-yet-rated']")
	WebElement notYetRatedText;

	@FindBy(css = "[class='educator-rating-wrap']")
	WebElement educatorRatingIconSection;

	@FindBy(css = "[class='user-rating-link']")
	WebElement rateThisResourceLink;

	@FindBy(css = "#comment-text-area")
	WebElement addReviewPanel;

	@FindBy(css = "#educator-rating-form-root [class='subtitle']")
	WebElement addReviewSectionSubtitle;

	@FindBy(css = "#educator-rating-form-root h4")
	WebElement addReviewSectionTitle;

	@FindBy(css = "[class='rating-selector']")
	WebElement addReviewRatingIconSection;

	@FindBy(css = "[class='educator-rating-details']")
	WebElement educatorRatingSectionDetails;

	@FindBy(css = "[class*='concepts']")
	WebElement concepts;

	@FindBy(css = "[itemprop='reviewRating']")
	WebElement reviewerRating;

	@FindBy(css = "[class*='detail-views']")
	WebElement nrOfViews;

	@FindBy(css = "[title='Grades']")
	WebElement grade;

	public void clickOnCloseButton() {
		closeButton.click();
		waitForLoad();
	}

	public boolean isGradeDisplayed() {
		return grade.isDisplayed();
	}

	public boolean isNumberOfViewsDisplayed() {
		return nrOfViews.isDisplayed();
	}

	public String getPoolName() {
		return poolName.getText();
	}

	public boolean isConceptsTagsListDisplayed() {
		return concepts.isDisplayed();
	}

	public boolean isReviewerRatingDisplayed() {
		return reviewerRating.isDisplayed();
	}

	public boolean isNotYetRatedTextDisplayed() {
		return notYetRatedText.isDisplayed();
	}

	public boolean isEducatorRatingIconsSectionDisplayed() {
		return educatorRatingIconSection.isDisplayed();
	}

	public String getAddAReviewSectionSubtitle() {
		waitForElement(addReviewSectionSubtitle);
		return addReviewSectionSubtitle.getText();
	}

	public String getAddAReviewSectionTitle() {
		return addReviewSectionTitle.getText();
	}

	public boolean isAddAReviewRatingIconsSectionDisplayed() {
		return addReviewRatingIconSection.isDisplayed();
	}

	public boolean isAddAReviewPanelDisplayed() {
		return addReviewPanel.isDisplayed();
	}

	public void clickOnRateThisResourceLink() {
		rateThisResourceLink.click();
	}

	public String getEducatorRatingDetails() {
		return educatorRatingSectionDetails.getText();
	}

}
