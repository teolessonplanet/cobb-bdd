package steps;

import baseTest.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CollectionRrpPage;
import pages.FolderRrpPage;
import pages.ResourceRrpPage;

import org.junit.Assert;
import java.util.Arrays;

import util.Data;

public class CobbRrpSteps extends BaseTest {
	CollectionRrpPage collectionRrpPage = new CollectionRrpPage(driver);
	ResourceRrpPage resourceRrpPage = new ResourceRrpPage(driver);
	FolderRrpPage folderRrpPage = new FolderRrpPage(driver);

	@Then("Observe detailed {string} resource RRP")
	public void detailed_resource_rrp(String poolName) {
		Assert.assertTrue(resourceRrpPage.isResourceRrpTitleDisplayed());
		Assert.assertTrue(resourceRrpPage.isThumbnailDisplayed());
		Assert.assertTrue(resourceRrpPage.isDescriptionDisplayed());
		Assert.assertTrue(resourceRrpPage.isNumberOfViewsDisplayed());
		Assert.assertTrue(resourceRrpPage.isNumberOfDownloadsDisplayed());
		Assert.assertTrue(resourceRrpPage.isConceptsTagsListDisplayed());
		Assert.assertTrue(resourceRrpPage.isReviewerRatingDisplayed());
		Assert.assertTrue(resourceRrpPage.isGoToResourceButtonDisplayed());
		Assert.assertTrue(resourceRrpPage.isAddToFolderDropdownDisplayed());
		Assert.assertTrue(
				resourceRrpPage.isFavoriteButtonDisplayed() || resourceRrpPage.isFavoriteButtonDisabledDisplayed());
		Assert.assertEquals(resourceRrpPage.getPoolName(), poolName);
		Assert.assertTrue(resourceRrpPage.isGradeDisplayed());
		for (int i = 0; i < resourceRrpPage.getFullRrpSubjectsNumber(); i++) {
			Assert.assertTrue(Arrays.asList(Data.SUBJECTS).contains(resourceRrpPage.getFullRrpSubjectText().get(i)));
		}
		for (int i = 1; i < resourceRrpPage.getFullRrpResourceTypeNumber(); i++) {
			Assert.assertTrue(
					Arrays.asList(Data.RESOURCE_TYPES).contains(resourceRrpPage.getFullRrpResourceTypeText().get(i)));
		}

		Assert.assertTrue(resourceRrpPage.getEducatorRatingDetails().contains(Data.RATE_THIS_RESOURCE)
				|| resourceRrpPage.getEducatorRatingDetails().contains(Data.UPDATE_YOUR_RATING));
		resourceRrpPage.clickOnRateThisResourceLink();
		Assert.assertEquals(resourceRrpPage.getAddAReviewSectionSubtitle(), Data.ADD_A_REVIEW_SUBTITLE);
		Assert.assertTrue(resourceRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_NO_REVIEW_TITLE)
				|| resourceRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_EXISTING_REVIEW_TITLE));
		Assert.assertTrue(resourceRrpPage.isAddAReviewPanelDisplayed());
		Assert.assertTrue(resourceRrpPage.isAddAReviewRatingIconsSectionDisplayed());
	}

	@Then("Observe detailed {string} collection RRP")
	public void detailed_collection_rrp(String poolName) {
		Assert.assertTrue(collectionRrpPage.isCollectionRrpTitleDisplayed());
		Assert.assertTrue(collectionRrpPage.isDescriptionDisplayed());
		Assert.assertTrue(collectionRrpPage.isCollectionItemsCountDisplayed());
		Assert.assertTrue(collectionRrpPage.isNumberOfViewsDisplayed());
		Assert.assertTrue(collectionRrpPage.isNumberOfSavesDisplayed());
		Assert.assertTrue(collectionRrpPage.isConceptsTagsListDisplayed());
		Assert.assertTrue(collectionRrpPage.isGradeDisplayed());
		Assert.assertTrue(collectionRrpPage.isSubjectDisplayed());
		Assert.assertTrue(collectionRrpPage.isPlayCollectionButtonDisplayed());
		Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonActiveUserDisplayed());
		Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
		Assert.assertEquals(collectionRrpPage.getCollectionItemsCount(), collectionRrpPage.getPanelItemsCount());
		Assert.assertEquals(collectionRrpPage.getPoolName(), poolName);

		if ((collectionRrpPage.getCollectionItemsCount() > 4) && (collectionRrpPage.getCollectionItemsCount() <= 8)) {
			Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
			collectionRrpPage.clickNextButtonPanelItems();
			Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
		}

		if (collectionRrpPage.getCollectionItemsCount() >= 9) {
			Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
			collectionRrpPage.clickNextButtonPanelItems();
			Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed()
					&& collectionRrpPage.isNextButtonPanelItemsDisplayed());
		}

		Assert.assertTrue(collectionRrpPage.getEducatorRatingDetails().contains(Data.RATE_THIS_RESOURCE)
				|| collectionRrpPage.getEducatorRatingDetails().contains(Data.UPDATE_YOUR_RATING));
		collectionRrpPage.clickOnRateThisResourceLink();
		Assert.assertEquals(collectionRrpPage.getAddAReviewSectionSubtitle(), Data.ADD_A_REVIEW_SUBTITLE);
		Assert.assertTrue(collectionRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_NO_REVIEW_TITLE)
				|| collectionRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_EXISTING_REVIEW_TITLE));
		Assert.assertTrue(collectionRrpPage.isAddAReviewPanelDisplayed());
		Assert.assertTrue(collectionRrpPage.isAddAReviewRatingIconsSectionDisplayed());
	}

	@Then("Observe detailed {string} folder RRP")
	public void detailed_folder_rrp(String poolName) {
		Assert.assertTrue(folderRrpPage.isOpenFolderButtonDisplayed());
		Assert.assertTrue(
				folderRrpPage.isFavoriteButtonDisplayed() || folderRrpPage.isFavoriteButtonDisabledDisplayed());
		Assert.assertTrue(folderRrpPage.isBreadcrumbsContainerDisplayed());
		Assert.assertTrue(folderRrpPage.isThumbnailDisplayed());
		Assert.assertTrue(folderRrpPage.isDescriptionDisplayed());
		Assert.assertTrue(folderRrpPage.isNumberOfViewsDisplayed());
		Assert.assertTrue(folderRrpPage.isNumberOfDownloadsDisplayed());
		Assert.assertTrue(folderRrpPage.isConceptsTagsListDisplayed());
		Assert.assertTrue(folderRrpPage.isReviewerRatingDisplayed());
		Assert.assertTrue(folderRrpPage.isAddToFolderDropdownDisplayed());
		Assert.assertTrue(folderRrpPage.isGradeDisplayed());
		Assert.assertEquals(folderRrpPage.getPoolName(), poolName);
		for (int i = 0; i < folderRrpPage.getFullRrpSubjectsNumber(); i++) {
			Assert.assertTrue(Arrays.asList(Data.SUBJECTS).contains(folderRrpPage.getFullRrpSubjectText().get(i)));
		}
		for (int i = 1; i < folderRrpPage.getFullRrpResourceTypeNumber(); i++) {
			Assert.assertTrue(
					Arrays.asList(Data.RESOURCE_TYPES).contains(folderRrpPage.getFullRrpResourceTypeText().get(i)));
		}

		Assert.assertTrue(folderRrpPage.getEducatorRatingDetails().contains(Data.RATE_THIS_RESOURCE)
				|| folderRrpPage.getEducatorRatingDetails().contains(Data.UPDATE_YOUR_RATING));
		folderRrpPage.clickOnRateThisResourceLink();
		Assert.assertEquals(folderRrpPage.getAddAReviewSectionSubtitle(), Data.ADD_A_REVIEW_SUBTITLE);
		Assert.assertTrue(folderRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_NO_REVIEW_TITLE)
				|| folderRrpPage.getAddAReviewSectionTitle().contains(Data.ADD_A_REVIEW_EXISTING_REVIEW_TITLE));
		Assert.assertTrue(folderRrpPage.isAddAReviewPanelDisplayed());
		Assert.assertTrue(folderRrpPage.isAddAReviewRatingIconsSectionDisplayed());
	}

	@When("User clicks the See Full Reviews Link")
	public void user_clicks_see_full_review_from_collection_rrp() {
		collectionRrpPage.clickSeeFullReviewsLink();
	}

	@Then("Collection item RRP is displayed")
	public void item_rrp_is_displayed() {
		Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(0), collectionRrpPage.getPanelItemDataId(0));
		if (collectionRrpPage.getCollectionItemsCount() > 1) {
			Assert.assertTrue(collectionRrpPage.isNextButtonItemViewerDisplayed());
			collectionRrpPage.clickNextButtonItemViewer();
			Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(1), collectionRrpPage.getPanelItemDataId(1));
			collectionRrpPage.clickPreviousButtonItemViewer();
			Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(0), collectionRrpPage.getPanelItemDataId(0));
		}
	}

	@When("User closes the item RRP")
	public void user_closes_item_rrp() {
		collectionRrpPage.clickCloseExpandedRrp();
	}

	@Then("See Full Review link is displayed")
	public void user_clicks_see_full_review_link() {
		Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
	}

}
