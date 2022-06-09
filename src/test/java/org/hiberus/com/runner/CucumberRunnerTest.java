package org.hiberus.com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-html-report.html",
        },
        glue = {
                "org.hiberus.com.stepdefs",
                "org.hiberus.com.support"
        },
        features = {
                "src/test/resources/"
        }
)
public class CucumberRunnerTest {
}
