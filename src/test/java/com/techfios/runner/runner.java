package com.techfios.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/featureFiles/Login.feature",
glue = "com.techfios.stepDefinition",
tags = {"@Login"},
monochrome = true,
dryRun = false,
plugin = {
    "pretty",
    "html:target/cucumber",
    "json:target/cucumber.json"
})

public class runner {

}