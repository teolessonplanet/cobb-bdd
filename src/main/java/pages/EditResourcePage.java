package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditResourcePage extends BaseActionsPage {

	public EditResourcePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='modal-header'] h3")
	WebElement pageTitle;

	@FindBy(css = "[class='modal-header'] [class='close']")
	WebElement closeButton;

	public String getEditResourcePageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		waitForElement(closeButton);
		closeButton.click();
		waitForLoad();
	}

}
