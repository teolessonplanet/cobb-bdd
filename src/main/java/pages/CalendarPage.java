package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BaseActionsPage {

	public CalendarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content-main h1")
	@CacheLookup
	WebElement pageTitle;

	public String getCalendarPageTitle() {
		waitForElement(pageTitle);
		return pageTitle.getText();
	}

}
