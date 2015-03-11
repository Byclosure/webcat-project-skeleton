package com.byclosure;

import com.byclosure.webcat.WebcatRunner;
import com.byclosure.webcat.stepdefinitions.BrowsingSteps;
import com.byclosure.webcat.stepdefinitions.FormSteps;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(WebcatRunner.class)
@CucumberOptions(format = {"pretty", "junit:target/junit-report.xml"},
        monochrome = true, glue={"com.byclosure.webcat.stepdefinitions", "com.byclosure.steps"})
public class FeatureRunnerTest {
}
