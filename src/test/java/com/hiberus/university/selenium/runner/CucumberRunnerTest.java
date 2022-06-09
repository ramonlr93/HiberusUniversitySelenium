package com.hiberus.university.selenium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                //"usage",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-html-report.html",
                //"junit:target/cucumber-reports/cucumber.xml",
                //"html:target/cucumber-reports/cucumber-reports.html",
        },
        glue = {
                "com.hiberus.university.selenium.stepdefs",
                "com.hiberus.university.selenium.support"
        },
        tags = "@smoke",
        features = {
                "src/test/resources/"
        }
)
public class CucumberRunnerTest {

}

