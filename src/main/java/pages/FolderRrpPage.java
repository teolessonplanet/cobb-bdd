package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FolderRrpPage extends ResourceRrpPage {

	public FolderRrpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='pull-left'] a[class*='trk-goto-resource'][href*='/pr/goto/']")
	WebElement openFolderButton;

	@FindBy(css = "#breadcrumbs-container")
	WebElement folderBreadcrumbs;

	public boolean isOpenFolderButtonDisplayed() {
		waitForElement(openFolderButton);
		return openFolderButton.isDisplayed();
	}

	public boolean isBreadcrumbsContainerDisplayed() {
		waitForElement(folderBreadcrumbs);
		return folderBreadcrumbs.isDisplayed();
	}

}
