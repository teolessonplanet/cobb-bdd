/**
 * 
 */
package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import baseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import logs.Log;

public class Hooks {
	BaseTest baseTest;

	@Before
	public void initializeTest() {
		baseTest = new BaseTest();
		baseTest.setUp();
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				Log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "failed");
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				Log.info(scenario.getName() + " is pass");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@After
	public void end() {
		baseTest = new BaseTest();
		baseTest.tearDown();
	}
}
