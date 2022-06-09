package com.hiberusuniversity.openCart.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {
                "pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-html-report.html",
        },
        glue = {
                "com.hiberusuniversity.openCart.stepdefs",
                "com.hiberusuniversity.openCart.support"
        },
        features = {
                "src/test/resources/"
        }
)
public class CucumberRunnerTest {
}