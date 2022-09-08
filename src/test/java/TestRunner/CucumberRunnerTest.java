package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"src/test/resources"}, glue= {"StepDefination"},
plugin = {"pretty","html:target/cucumber-report","json:target/cucumber.json","junit:target/cucumber.xml"},
monochrome = true,
tags = "@category_details_for_catalogue")

public class CucumberRunnerTest {

}



