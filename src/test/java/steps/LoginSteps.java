package steps;

import baseTest.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;

import org.junit.Assert;

public class LoginSteps extends BaseTest {

	HeaderPage headerPage = new HeaderPage(driver);
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);

	@When("User clicks on the Sign In button from Header")
	public void user_clicks_Sign_In_button_from_header() {
		headerPage.clickOnSignInHeaderButton();
	}

	@Then("^User enters UserName as \"(.*)\" and Password as \"(.*)\"$")
	public void user_enters_username_and_password(String email, String password) {
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	}

	@When("User clicks on Sign In button from Login Modal")
	public void user_clicks_sign_in_button_from_login_modal() {
		loginPage.clickSignInModalButton();
	}

	@Then("^Username \"([^\"]*)\" is displayed in the header dropdown$")
	public void check_header_username(String username) {
		Assert.assertEquals(username, headerPage.getUsernameFromDropdown());
	}

	@Then("^Invalid Error Login notification \"(.*)\" is displayed$")
	public void check_invalid_login_notification(String notification) {
		Assert.assertEquals(notification, homePage.getNotificationText());
	}

}
