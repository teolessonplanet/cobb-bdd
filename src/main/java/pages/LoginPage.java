package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import logs.Log;
import util.Data;

public class LoginPage extends BaseActionsPage {
	private static final String STAGING_LOGIN_URL = "https://staging.lessonplanet.com/users/auto/login?user_email=";
	private HeaderPage headerPage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#login-modal #user_login")
	WebElement emailTextField;

	@FindBy(css = "#login-modal #user_password")
	WebElement passwordTextField;

	@FindBy(className = "modal-title")
	WebElement pageTitle;

	@FindBy(css = "#login-modal [name='commit']")
	WebElement signInModalButton;

	public void setEmail(String email) {
		waitForElement(emailTextField);
		emailTextField.sendKeys(email);
	}

	public void setPassword(String password) {
		waitForElement(passwordTextField);
		passwordTextField.sendKeys(password);
	}

	public String getPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickSignInModalButton() {
		waitForElement(signInModalButton);
		signInModalButton.click();
	}

	public void performLogin(String email, String password) {
		if (getUrl().equals(Data.EMPTY_URL)) {
			loadUrl(Data.BLANK);
		}
		boolean loggedIn = false;

		if (STAGING_LOGIN_URL.startsWith(Data.STAGING_URL)) {
			driver.get(STAGING_LOGIN_URL + email);
			headerPage = new HeaderPage(driver);
			if (headerPage.isUserDropdownDisplayed()) {
				Log.info("Successful login via endpoint");
				loggedIn = true;
			}
		}

		if (!loggedIn || !STAGING_LOGIN_URL.startsWith(Data.STAGING_URL)) {
			final String path = getPath();
			loadUrl(Data.LOGIN_PAGE_PATH);
			emailTextField.sendKeys(email);
			passwordTextField.sendKeys(password);
			signInModalButton.click();
			if (headerPage.isUserDropdownDisplayed()) {
				Log.info("Successful login via UI");
				loadUrl(path);
			} else {
				throw new Error("Invalid login error with: " + email + ":" + password);
			}
		}
	}

}
