package es.david.practica.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-html-report.html"
        },
        glue = {
                "es.david.practica.stepdefs",
                "es.david.practica.support"
        },
        features = {
                "src/test/resources/"
        }
)
public class CucumberRunnerTest {
}
