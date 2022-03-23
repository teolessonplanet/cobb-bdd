package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseActionsPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='alert alert-dismissable alert-danger']")
	@CacheLookup
	WebElement notificationText;

	public String getNotificationText() {
		waitForElement(notificationText);
		return notificationText.getText();
	}

}
