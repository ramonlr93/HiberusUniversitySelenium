package com.hiberus.university.selenium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {
    "pretty",
  },
  glue = {
    "com.hiberus.university.selenium.stepdefs",
    "com.hiberus.university.selenium.support"
  },
  features = {
    "src/test/resources/"
  }
)
public class CucumberRunnerTest {}
