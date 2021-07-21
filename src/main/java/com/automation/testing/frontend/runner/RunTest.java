package com.automation.testing.frontend.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src//main//resources//features"},
        glue = {"com.automation.testing.frontend.steps", "com.automation.testing.frontend.helpers"},
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@Regression",
        strict = true
)

@Test
public class RunTest extends AbstractTestNGCucumberTests { }
