package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features", glue = "steps", strict = true,

		plugin = { "pretty", "json:target/MyReports/report.json", "junit:target/MyReports/report.xml",
				"html:target/MyReports/report-html", "rerun:target/MyReports/rerun.txt" },  //tags = "@run",
		// dryRun = true,
		monochrome = true)
public class Runner {

}
