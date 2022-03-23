package steps;

import org.junit.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CollectionBuilderPage;
import util.Data;

public class CobbCollectionBuilderSteps extends BaseTest {
	CollectionBuilderPage collectionBuilderPage = new CollectionBuilderPage(driver);

	@When("User clicks on the {string} button from collection builder")
	public void user_clicks_on_collection_builder_buttons(String option) {
		switch (option) {
		case Data.EDIT:
			collectionBuilderPage.clickOnEditButton();
			break;
		case Data.CREATE_OR_OPEN:
			collectionBuilderPage.clickOnSelectExistingDropdown();
			break;
		case Data.SELECT_EXISTING:
			collectionBuilderPage.clickOnSelectExistingDropdown();
		}

	}

	@Then("Collection Builder is displayed")
	public void collection_builder_is_displayed() {
		Assert.assertTrue(collectionBuilderPage.isCollectionBuilderDisplayed());
	}

	@Then("Edit button is displayed")
	public void edit_button_is_displayed() {
		Assert.assertTrue(collectionBuilderPage.isEditButtonDisplayed());
	}

	@And("My Resources button is displayed on {string} page")
	public void my_resources_button_is_displayed(String page) {
		if (!page.equals(Data.CURRICULUM_MANAGER)) {
			Assert.assertTrue(collectionBuilderPage.isMyResourcesButtonDisplayed());
		}
	}

	@And("Start Building button is displayed on {string} page")
	public void start_building_button_is_displayed(String page) {
		if (!page.equals(Data.CURRICULUM_MANAGER)) {
			Assert.assertTrue(collectionBuilderPage.isstartBuildingButtonDisplayed());
		}
	}

	@And("Select Existing button is displayed")
	public void select_existing_button_is_displayed() {
		Assert.assertTrue(collectionBuilderPage.isselectExistingButtonDisplayed());
	}

	@When("User chooses a collection")
	public void user_chooses_a_collection() {
		collectionBuilderPage.clickOnFirstCollection();
	}

	@When("On {string} page, user clicks on My Resources button")
	public void user_clicks_on_my_resources_button(String page) {
		if (!page.equals(Data.CURRICULUM_MANAGER)) {
			collectionBuilderPage.clickOnMyResourcesButton();
		}
	}

}
