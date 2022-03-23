package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLinkPage extends BaseActionsPage {

	public AddLinkPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#add-url-modal [class='lp-modal-title']")
	WebElement pageTitle;

	@FindBy(css = "#add-url-modal [class='close']")
	WebElement closeButton;

	public String getAddLinkPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		closeButton.click();
		waitForLoad();
	}

}
