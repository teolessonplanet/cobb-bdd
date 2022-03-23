package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewFolderPage extends BaseActionsPage {

	public CreateNewFolderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#create-folder-modal h4")
	WebElement pageTitle;

	@FindBy(css = "#inline-close")
	WebElement closeButton;

	public String getCreateNewFolderPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		waitForElement(closeButton);
		closeButton.click();
		waitForLoad();
	}

}
