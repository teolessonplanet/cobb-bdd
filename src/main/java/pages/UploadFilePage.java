package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePage extends BaseActionsPage {

	public UploadFilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#upload-file-modal [class='modal-title']")
	WebElement pageTitle;

	@FindBy(css = "#upload-file-modal [class='close']")
	WebElement closeButton;

	public String getUploadPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		waitForElement(closeButton);
		closeButton.click();
		waitForLoad();
	}

}
