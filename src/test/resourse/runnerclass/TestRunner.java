package runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features = "C:\\Users\\dhara\\eclipse-workspace\\Adactinmvn\\src\\test\\resourse\\feature", 
glue = "stepDefinition", 
dryRun = false,
monochrome=true, plugin= {"pretty",
		"json:target/adactinreport.json",
		"html:target/adactinhtml.html",
		"junit:target/adactinjunit.xml"})
public class TestRunner {

}
