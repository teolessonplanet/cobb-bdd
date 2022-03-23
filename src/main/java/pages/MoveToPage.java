package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoveToPage extends BaseActionsPage {

	public MoveToPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='header'] h4")
	WebElement pageTitle;

	@FindBy(css = "[class='close']")
	WebElement closeButton;

	public String getMoveToPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		closeButton.click();
		waitForLoad();
	}

}
