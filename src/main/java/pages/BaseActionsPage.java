package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import logs.Log;

import java.util.ArrayList;
import java.util.List;

public class BaseActionsPage {
	protected WebDriver driver;
	private WebDriverWait webDriverWait;
	private JavascriptExecutor javascriptExecutor;

	protected BaseActionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webDriverWait = new WebDriverWait(driver, 5);
	}

	public void waitForElement(WebElement element) {
		try {
			Log.logStart("Wait until the webElement is visible: " + element);
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
			Log.info("WebElement is visible: " + element);

		} catch (Exception ex) {
			Log.logEnd("The element " + element + " is not visible");
		}
	}

	protected void waitForElement(String cssSelector) {
		waitForLoad();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
	}

	public void waitUntilTextIsDisplayed(WebElement element, String text) {
		webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitUntilElementIsClickable(WebElement element) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitUntilElementIsHidden(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));

		} catch (Exception ex) {

		}
	}

	public void waitForLinkToLoad() {
		try {
			Log.logStart("Wait for link to load");
			webDriverWait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return (!driver.getCurrentUrl().contains(""));
				}
			});
		} catch (Exception ex) {
			Log.info("Waited for link to load");
		}
	}

	public void hoverOverElement(WebElement element) {
		try {
			(new Actions(driver)).moveToElement(element).build().perform();
		} catch (StaleElementReferenceException exception) {
			Log.info("Element is stale " + element);
		}
		waitForLoad();
	}

	public void loadUrl(String pagePath) {
		final String url = "https://staging.lessonplanet.com/" + pagePath;
		Log.info("Accessing: " + url);
		driver.get(url);
		waitForLinkToLoad();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void scrollToElement(WebElement element) {
		Log.info("Scrolling to element");
		try {
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
		} catch (StaleElementReferenceException staleElementReferenceException) {
			Log.info("Element is stale " + element);
		}

	}

	public void focusDriverToLastTab() {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void closeTab() {
		Log.info("Closing the tab");
		driver.close();
		focusDriverToLastTab();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPath() {
		try {
			String path[] = getUrl().split(".com/");
			Log.info("Path: " + path[1]);
			return path[1];
		} catch (Exception e) {
			Log.info("The homepage is loaded.");
			return "";
		}
	}

	public void waitForLoad() {
		Log.info("Waiting for load");
		waitForLinkToLoad();
		waitForPageLoad();
		Log.info("Waited for load");
	}

	public void waitForPageLoad() {
		Log.logStart("Waiting for jQuery to complete");
		try {
			webDriverWait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return (Boolean) javascriptExecutor
							.executeScript("return !!window.jQuery && window.jQuery.active == 0");
				}
			});
			Log.logEnd("jQuery completed");
		} catch (Exception ex) {
			Log.info("jQuery is not completed: " + ex.toString());
		}

	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	protected List<WebElement> findElements(String cssLocator) {
		return driver.findElements(By.cssSelector(cssLocator));
	}

	public void waitForNewTab() {
		webDriverWait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (driver.getWindowHandles().size() > 1);
			}
		});
	}

}
