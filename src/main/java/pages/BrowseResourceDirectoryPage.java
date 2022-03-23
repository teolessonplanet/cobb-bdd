package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowseResourceDirectoryPage extends BaseActionsPage {

	public BrowseResourceDirectoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='mt0']")
	WebElement pageTitle;

	@FindBy(css = "[class*='panel-default']:not([class*='react-modal']) h4 [href*='/health']")
	WebElement healthLink;

	@FindBy(css = "[class*='panel-default']:not([class*='react-modal']) [class*='img'][href*='/health']")
	WebElement healthThumbnail;

	@FindBy(css = "h4 [href*='/language-arts']")
	WebElement languageArtsLink;

	@FindBy(css = "[class*='img'][href*='/language-arts']")
	WebElement languageArtsThumbnail;

	@FindBy(css = "h4 [href*='/languages']")
	WebElement languagesLink;

	@FindBy(css = "[class*='img'][href*='/languages']")
	WebElement languagesThumbnail;

	@FindBy(css = "h4 [href*='/math']")
	WebElement mathLink;

	@FindBy(css = "[class*='img'][href*='/math']")
	WebElement mathThumbnail;

	@FindBy(css = "h4 [href*='/physical-education']")
	WebElement physicalEducationLink;

	@FindBy(css = "[class*='img'][href*='/physical-education']")
	WebElement physicalEducationThumbnail;

	@FindBy(css = "h4 [href*='/science']")
	WebElement scienceLink;

	@FindBy(css = "[class*='img'][href*='/science']")
	WebElement scienceThumbnail;

	@FindBy(css = "h4 [href*='/social-studies']")
	WebElement socialStudiesLink;

	@FindBy(css = "[class*='img'][href*='/social-studies']")
	WebElement socialStudiesThumbnail;

	@FindBy(css = "h4 [href*='/special-education']")
	WebElement specialEducationLink;

	@FindBy(css = "[class*='img'][href*='/special-education']")
	WebElement specialEducationThumbnail;

	@FindBy(css = "h4 [href*='/visual-and-performing-arts']")
	WebElement visualAndPerformingArtsLink;

	@FindBy(css = "[class*='img'][href*='/visual-and-performing-arts']")
	WebElement visualAndPerformingArtsThumbnail;

	@FindBy(css = "[class*='open-modal']")
	WebElement showAllButton;

	@FindBy(css = "[class*='panel-container'] h4 a")
	WebElement categoryModalTitle;

	@FindBy(css = "div[class*='close-modal']")
	WebElement categoryModalCloseButton;

	@FindBy(css = "[class*='react-modal'] [class='fa-ul mb0']")
	WebElement subcategoriesText;

	@FindBy(css = "[href='/lesson-plans/wellness-and-safety']")
	WebElement wellnessAndSafetyLink;

	@FindBy(css = "[href='/lesson-plans/anaerobic-activity']")
	WebElement anaerobicActivityLink;

	@FindBy(css = "[href='/lesson-plans/water-activities']")
	WebElement waterActivitiesLink;

	@FindBy(css = "[href='/lesson-plans/sports-skills']")
	WebElement sportSkillsLink;

	@FindBy(css = "[href='/lesson-plans/natural-science']")
	WebElement naturalScienceLink;

	@FindBy(css = "[href='/lesson-plans/scientists']")
	WebElement scientistsLink;

	@FindBy(css = "[href='/lesson-plans/biology']")
	WebElement biologyLink;

	@FindBy(css = "[href='/lesson-plans/applied-science']")
	WebElement appliedScienceLink;

	@FindBy(css = "[href='/lesson-plans/21st-century-learning-skills']")
	WebElement twentyFirstCenturyLearningSkillsLink;

	@FindBy(css = "[href='/lesson-plans/geography']")
	WebElement geographyLink;

	@FindBy(css = "[href='/lesson-plans/flags']")
	WebElement flagsLink;

	@FindBy(css = "[href='/lesson-plans/history']")
	WebElement historyLink;

	@FindBy(css = "[href='/lesson-plans/graphing']")
	WebElement graphingLink;

	@FindBy(css = "[href='/lesson-plans/english-language-development']")
	WebElement englishLanguageDevelopmentLink;

	@FindBy(css = "[href='/lesson-plans/american-sign-language']")
	WebElement americanignLanguageLink;

	@FindBy(css = "[href='/lesson-plans/french']")
	WebElement frenchLink;

	@FindBy(css = "[href='/lesson-plans/spanish']")
	WebElement spanishLink;

	@FindBy(css = "[href='/lesson-plans/measurement']")
	WebElement measurementLink;

	@FindBy(css = "[href='/lesson-plans/teaching-math']")
	WebElement teachingMathLink;

	@FindBy(css = "[href='/lesson-plans/algebra']")
	WebElement algebraLink;

	@FindBy(css = "[href='/lesson-plans/genre-types']")
	WebElement genreTypesLink;

	@FindBy(css = "[href='/lesson-plans/growth-and-development']")
	WebElement growthAndDevelopmentLink;

	@FindBy(css = "[href='/lesson-plans/sex-education']")
	WebElement sexEducationLink;

	@FindBy(css = "[href='/lesson-plans/research']")
	WebElement researchLink;

	@FindBy(css = "[href='/lesson-plans/literature']")
	WebElement literatureLink;

	@FindBy(css = "[href='/lesson-plans/graphic-organizer']")
	WebElement graphicOrganizerLink;

	@FindBy(css = "[href='/lesson-plans/developmental-and-behavioral-disorders']")
	WebElement developmentAndBehavioralDisordersLink;

	@FindBy(css = "[href='/lesson-plans/physical-disabilities']")
	WebElement physicalDisabilitiesLink;

	@FindBy(css = "[href='/lesson-plans/special-needs-teacher-resources']")
	WebElement specialNeedsTeacherResourcesLink;

	@FindBy(css = "[href='/lesson-plans/accommodations']")
	WebElement accommodationLink;

	@FindBy(css = "[href='/lesson-plans/music']")
	WebElement musicLink;

	@FindBy(css = "[href='/lesson-plans/visual-arts']")
	WebElement visualArtsLink;

	@FindBy(css = "[href='/lesson-plans/film-studies']")
	WebElement filmStudiesLink;

	private static final String SHOW_ALL_BUTTONS = "[class*='open-modal']";
	private static final String CARETS = "[class*='panel-container'] a[class*='subcategory']";
	private static final String DANCE_LINK = "[href='/lesson-plans/dance']";
	private static final String SOCIAL_EMOTIONAL_LEARNING_LINK = "li:nth-child(2) a[href='/lesson-plans/social-and-emotional-learning']";

	public String getDirectoryPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnHealthSubjectLink() {
		waitForElement(healthLink);
		healthLink.click();
	}

	public void clickOnLanguageArtsSubjectLink() {
		waitForElement(languageArtsLink);
		languageArtsLink.click();
	}

	public void clickOnLanguagesSubjectLink() {
		languagesLink.click();
	}

	public void clickOnMathSubjectLink() {
		mathLink.click();
	}

	public void clickOnPhysicalEducationSubjectLink() {
		physicalEducationLink.click();
	}

	public void clickOnScienceSubjectLink() {
		waitForElement(scienceLink);
		scienceLink.click();
	}

	public void clickOnSocialStudiesSubjectLink() {
		waitForElement(socialStudiesLink);
		socialStudiesLink.click();
	}

	public void clickOnSpecialEducationSubjectLink() {
		specialEducationLink.click();
	}

	public void clickOnVisualAndPerformingArtsSubjectLink() {
		visualAndPerformingArtsLink.click();
	}

	public void clickOnHealthSubjectThumbnail() {
		waitForElement(healthThumbnail);
		healthThumbnail.click();
	}

	public void clickOnLanguageArtsSubjectThumbnail() {
		waitForElement(languageArtsThumbnail);
		languageArtsThumbnail.click();
	}

	public void clickOnLanguagesSubjectThumbnail() {
		languagesThumbnail.click();
	}

	public void clickOnMathSubjectThumbnail() {
		mathThumbnail.click();
	}

	public void clickOnPhysicalEducationSubjectThumbnail() {
		physicalEducationThumbnail.click();
	}

	public void clickOnScienceSubjectThumbnail() {
		waitForElement(scienceThumbnail);
		scienceThumbnail.click();
	}

	public void clickOnSocialStudiesSubjectThumbnail() {
		waitForElement(scienceThumbnail);
		socialStudiesThumbnail.click();
	}

	public void clickOnSpecialEducationSubjectThumbnail() {
		specialEducationThumbnail.click();
	}

	public void clickOnVisualAndPerformingArtsSubjectThumbnail() {
		visualAndPerformingArtsThumbnail.click();
	}

	public int countShowAllButtons() {
		return findElements(SHOW_ALL_BUTTONS).size();
	}

	public void clickOnShowAllButtonFromHealthCategory() {
		showAllButton.click();
	}

	public String getCategoryModalTitle() {
		return categoryModalTitle.getText();
	}

	public void clickOnCloseCategoryModalButton() {
		categoryModalCloseButton.click();
	}

	public String getSubcategoriesAsText() {
		return subcategoriesText.getText();
	}

	public void clickOnFirstCaret() {
		findElements(CARETS).get(0).click();
	}

	public void clickOnSecondCaret() {
		findElements(CARETS).get(1).click();
	}

	public void clickOnWellnessAndSafetyLink() {
		wellnessAndSafetyLink.click();
	}

	public void clickOnGrowthAndDevelopmentLink() {
		growthAndDevelopmentLink.click();
	}

	public void clickOnSexEducationLink() {
		sexEducationLink.click();
	}

	public void clickOnResearchLink() {
		researchLink.click();
	}

	public void clickOnLiteratureLink() {
		literatureLink.click();
	}

	public void clickOnGraphicOrganizerLink() {
		graphicOrganizerLink.click();
	}

	public void clickOnGenreTypesLink() {
		genreTypesLink.click();
	}

	public void clickOnEnglishLanguageDevelopmentLink() {
		englishLanguageDevelopmentLink.click();
	}

	public void clickOnAmericanSignLanguageLink() {
		americanignLanguageLink.click();
	}

	public void clickOnFrenchLink() {
		frenchLink.click();
	}

	public void clickOnSpanishLink() {
		spanishLink.click();
	}

	public void clickOnMeasurementLink() {
		measurementLink.click();
	}

	public void clickOnTeachingMathLink() {
		teachingMathLink.click();
	}

	public void clickOnAlgebraLink() {
		algebraLink.click();
	}

	public void clickOnGraphingLink() {
		graphingLink.click();
	}

	public void clickOnAnaerobicActivityLink() {
		anaerobicActivityLink.click();
	}

	public void clickOnWaterActivitiesLink() {
		waterActivitiesLink.click();
	}

	public void clickOnSportSkillsLink() {
		sportSkillsLink.click();
	}

	public void clickOnNaturalScienceLink() {
		naturalScienceLink.click();
	}

	public void clickOnScientistsLink() {
		scientistsLink.click();
	}

	public void clickOnBiologyLink() {
		biologyLink.click();
	}

	public void clickOnAppliedScienceLink() {
		appliedScienceLink.click();
	}

	public void clickOnTwentyOneCenturyLearningSkillsLink() {
		twentyFirstCenturyLearningSkillsLink.click();
	}

	public void clickOnGeographyLink() {
		geographyLink.click();
	}

	public void clickOnFlagsLink() {
		flagsLink.click();
	}

	public void clickOnHistoryLink() {
		historyLink.click();
	}

	public void clickOnDevelopmentAndBehavioralDisordersLink() {
		developmentAndBehavioralDisordersLink.click();
	}

	public void clickOnPhysicalDisabilitiesLink() {
		physicalDisabilitiesLink.click();
	}

	public void clickOnSpecialNeedsTeacherResourcesLink() {
		specialNeedsTeacherResourcesLink.click();
	}

	public void clickOnAccommodationsLink() {
		accommodationLink.click();
	}

	public void clickOnMusicLink() {
		musicLink.click();
	}

	public void clickOnDanceFromViPerArtsLink() {
		findElements(DANCE_LINK).get(1).click();
	}

	public void clickOnDanceFromPyEdLink() {
		findElements(DANCE_LINK).get(0).click();
	}

	public void clickOnSocialEmotionalLearningLink() {
		findElements(SOCIAL_EMOTIONAL_LEARNING_LINK).get(0).click();
	}

	public void clickOnVisualArtsLink() {
		visualArtsLink.click();
	}

	public void clickOnFilmStudiesLink() {
		filmStudiesLink.click();
	}

}
