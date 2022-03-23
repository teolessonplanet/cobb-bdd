package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareFolderPage extends BaseActionsPage {

	public ShareFolderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='header'] h3")
	WebElement pageTitle;

	@FindBy(css = "[class='footer'] [class*='btn btn-default']")
	WebElement closeButton;

	public String getShareFolderPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		closeButton.click();
		waitForLoad();
	}

}
