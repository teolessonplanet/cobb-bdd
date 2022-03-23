package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignResourcePage extends BaseActionsPage {

	public AssignResourcePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#assign-to-student-modal [class='modal-title']")
	WebElement pageTitle;

	@FindBy(css = "#assign-to-student-modal [class='close']")
	WebElement closeButton;

	public String getAssignResourcePageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

	public void clickOnCloseButton() {
		waitForElement(closeButton);
		closeButton.click();
		waitForLoad();
	}

}
