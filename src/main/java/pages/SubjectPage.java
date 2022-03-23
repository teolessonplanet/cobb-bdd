package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPage extends BaseActionsPage {

	public SubjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='media-heading']")
	WebElement subjectPageTitle;

	public String getSubjectPageTitle() {
		return subjectPageTitle.getText();
	}
}
