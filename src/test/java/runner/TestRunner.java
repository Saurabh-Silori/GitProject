package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features =  "src/test/java/features/", //the path of the feature files
glue = {"StepDefinitions"}, //the path of the step definition files
tags= {"@volunteer"},
plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"} //to generate different types of reporting
)
public class TestRunner {

}
