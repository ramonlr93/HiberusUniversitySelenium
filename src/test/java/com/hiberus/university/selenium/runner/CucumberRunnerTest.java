package com.hiberus.university.selenium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  publish = true,
  plugin = {
    "pretty",
    "html:target/cucumber-reports",
    "json:target/surefire-reports/cucumber.json",
    "html:target/cucumber-html-report.html",
  },
  glue = {
    "com.opencart.stepdefs",
    "com.opencart.support"
  },
  tags = "@smoke",
  features = {
          "src/test/resources/"
  }
)
public class CucumberRunnerTest {
}
