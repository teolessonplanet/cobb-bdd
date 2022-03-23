package steps;

import baseTest.BaseTest;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrowseResourceDirectoryPage;
import pages.SubjectPage;
import util.Data;

public class CobbBrowseResourceDirectorySteps extends BaseTest {
	BrowseResourceDirectoryPage browseResourceDirectoryPage = new BrowseResourceDirectoryPage(driver);
	SubjectPage subjectPage = new SubjectPage(driver);

	@When("User clicks on {string} link from Directory Main Page")
	public void user_clicks_on_subject_link(String subjectLink) {
		switch (subjectLink) {
		case Data.HEALTH:
			browseResourceDirectoryPage.clickOnHealthSubjectLink();
			break;
		case Data.LANGUAGE_ARTS:
			browseResourceDirectoryPage.clickOnLanguageArtsSubjectLink();
			break;
		case Data.LANGUAGES:
			browseResourceDirectoryPage.clickOnLanguagesSubjectLink();
			break;
		case Data.MATH:
			browseResourceDirectoryPage.clickOnMathSubjectLink();
			break;
		case Data.PHYSICAL_EDUCATION:
			browseResourceDirectoryPage.clickOnPhysicalEducationSubjectLink();
			break;
		case Data.SCIENCE:
			browseResourceDirectoryPage.clickOnScienceSubjectLink();
			break;
		case Data.SOCIAL_STUDIES:
			browseResourceDirectoryPage.clickOnSocialStudiesSubjectLink();
			break;
		case Data.SPECIAL_EDUCATION:
			browseResourceDirectoryPage.clickOnSpecialEducationSubjectLink();
			break;
		case Data.VISUAL_AND_PERFORMING_ARTS:
			browseResourceDirectoryPage.clickOnVisualAndPerformingArtsSubjectLink();
			break;
		}
	}

	@When("User clicks on {string} thumbnail from Directory Main Page")
	public void user_clicks_on_subject_thumbnail(String subjectThumnail) {
		switch (subjectThumnail) {
		case Data.HEALTH:
			browseResourceDirectoryPage.clickOnHealthSubjectThumbnail();
			break;
		case Data.LANGUAGE_ARTS:
			browseResourceDirectoryPage.clickOnLanguageArtsSubjectThumbnail();
			break;
		case Data.LANGUAGES:
			browseResourceDirectoryPage.clickOnLanguagesSubjectThumbnail();
			break;
		case Data.MATH:
			browseResourceDirectoryPage.clickOnMathSubjectThumbnail();
			break;
		case Data.PHYSICAL_EDUCATION:
			browseResourceDirectoryPage.clickOnPhysicalEducationSubjectThumbnail();
			break;
		case Data.SCIENCE:
			browseResourceDirectoryPage.clickOnScienceSubjectThumbnail();
			break;
		case Data.SOCIAL_STUDIES:
			browseResourceDirectoryPage.clickOnSocialStudiesSubjectThumbnail();
			break;
		case Data.SPECIAL_EDUCATION:
			browseResourceDirectoryPage.clickOnSpecialEducationSubjectThumbnail();
			break;
		case Data.VISUAL_AND_PERFORMING_ARTS:
			browseResourceDirectoryPage.clickOnVisualAndPerformingArtsSubjectThumbnail();
			break;
		}
	}

	@Then("Check subject page url {string}")
	public void check_subject_page_url(String url) {
		Assert.assertEquals(subjectPage.getPath(), url);
	}

	@Then("Check subject page title {string}")
	public void check_subject_page_title(String title) {
		Assert.assertEquals(subjectPage.getSubjectPageTitle(), title);
	}

	@Then("Observe the bottom of each subject card displayed on Directory main page")
	public void check_subject_card() {
		Assert.assertEquals(browseResourceDirectoryPage.countShowAllButtons(), 9);
	}

	@When("User clicks Show All button from Health Category")
	public void click_show_all_button() {
		browseResourceDirectoryPage.clickOnShowAllButtonFromHealthCategory();
	}

	@Then("{string} category modal is displayed")
	public void category_modal_is_displayed(String category) {
		Assert.assertEquals(browseResourceDirectoryPage.getCategoryModalTitle(), category);
		Assert.assertEquals(browseResourceDirectoryPage.getSubcategoriesAsText(),
				Data.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
		browseResourceDirectoryPage.clickOnFirstCaret();
		Assert.assertEquals(browseResourceDirectoryPage.getSubcategoriesAsText(),
				Data.HEALTH_CATEGORY_MODAL_FIRST_CARET_EXPANDED_TEXT);
		browseResourceDirectoryPage.clickOnFirstCaret();
		Assert.assertEquals(browseResourceDirectoryPage.getSubcategoriesAsText(),
				Data.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
		browseResourceDirectoryPage.clickOnSecondCaret();
		Assert.assertEquals(browseResourceDirectoryPage.getSubcategoriesAsText(),
				Data.HEALTH_CATEGORY_MODAL_SECOND_CARET_EXPANDED_TEXT);
		browseResourceDirectoryPage.clickOnSecondCaret();
		Assert.assertEquals(browseResourceDirectoryPage.getSubcategoriesAsText(),
				Data.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);

	}

	@When("User clicks on {string} sub-Subject link")
	public void user_clicks_on_sub_subject_link(String subSubjectLink) {
		switch (subSubjectLink) {
		case "Wellness & Safety":
			browseResourceDirectoryPage.clickOnWellnessAndSafetyLink();
			break;
		case "Social and Emotional Learning":
			browseResourceDirectoryPage.clickOnSocialEmotionalLearningLink();
			break;
		case "Growth and Development":
			browseResourceDirectoryPage.clickOnGrowthAndDevelopmentLink();
			break;
		case "Sex Education":
			browseResourceDirectoryPage.clickOnSexEducationLink();
			break;
		case "Research":
			browseResourceDirectoryPage.clickOnResearchLink();
			break;
		case "Literature":
			browseResourceDirectoryPage.clickOnLiteratureLink();
			break;
		case "Graphic Organizer":
			browseResourceDirectoryPage.clickOnGraphicOrganizerLink();
			break;
		case "Genre Types":
			browseResourceDirectoryPage.clickOnGenreTypesLink();
			break;
		case "English Language Development":
			browseResourceDirectoryPage.clickOnEnglishLanguageDevelopmentLink();
			break;
		case "American Sign Language":
			browseResourceDirectoryPage.clickOnAmericanSignLanguageLink();
			break;
		case "French":
			browseResourceDirectoryPage.clickOnFrenchLink();
			break;
		case "Spanish":
			browseResourceDirectoryPage.clickOnSpanishLink();
			break;
		case "Measurements":
			browseResourceDirectoryPage.clickOnMeasurementLink();
			break;
		case "Teaching Math":
			browseResourceDirectoryPage.clickOnTeachingMathLink();
			break;
		case "Algebra":
			browseResourceDirectoryPage.clickOnAlgebraLink();
			break;
		case "Graphing":
			browseResourceDirectoryPage.clickOnGraphingLink();
			break;
		case "Anaerobic Activity":
			browseResourceDirectoryPage.clickOnAnaerobicActivityLink();
			break;
		case "Dance Physical Education":
			browseResourceDirectoryPage.clickOnDanceFromPyEdLink();
			break;
		case "Water Activities":
			browseResourceDirectoryPage.clickOnWaterActivitiesLink();
			break;
		case "Sports Skills":
			browseResourceDirectoryPage.clickOnSportSkillsLink();
			break;
		case "Natural Science":
			browseResourceDirectoryPage.clickOnNaturalScienceLink();
			break;
		case "Scientists":
			browseResourceDirectoryPage.clickOnScientistsLink();
			break;
		case "Biology":
			browseResourceDirectoryPage.clickOnBiologyLink();
			break;
		case "Applied Science":
			browseResourceDirectoryPage.clickOnAppliedScienceLink();
			break;
		case "21st Century Learning Skills":
			browseResourceDirectoryPage.clickOnTwentyOneCenturyLearningSkillsLink();
			break;
		case "Geography":
			browseResourceDirectoryPage.clickOnGeographyLink();
			break;
		case "Flags":
			browseResourceDirectoryPage.clickOnFlagsLink();
			break;
		case "History":
			browseResourceDirectoryPage.clickOnHistoryLink();
			break;
		case "Developmental & Behavioral Disorder":
			browseResourceDirectoryPage.clickOnDevelopmentAndBehavioralDisordersLink();
			break;
		case "Physical Disabilities":
			browseResourceDirectoryPage.clickOnPhysicalDisabilitiesLink();
			break;
		case "Special Needs Teacher Resources":
			browseResourceDirectoryPage.clickOnSpecialNeedsTeacherResourcesLink();
			break;
		case "Accommodations":
			browseResourceDirectoryPage.clickOnAccommodationsLink();
			break;
		case "Music":
			browseResourceDirectoryPage.clickOnMusicLink();
			break;
		case "Dance Visual and Performing Arts":
			browseResourceDirectoryPage.clickOnDanceFromViPerArtsLink();
			break;
		case "Visual Arts":
			browseResourceDirectoryPage.clickOnVisualArtsLink();
			break;
		case "Film Studies":
			browseResourceDirectoryPage.clickOnFilmStudiesLink();
			break;
		}
	}

}