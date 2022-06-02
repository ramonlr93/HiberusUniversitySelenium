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
                "es.demoblaze.prueba.demoblaze.prueba.stepdefs",
                "es.demoblaze.prueba.demoblaze.prueba.support"
                // Así es como estaba antes, hay que cambiar a la carpeta que se tenga en este momento
                //"com.hiberus.university.selenium.es.demoblaze.prueba.support"
        },
        features = {
                "src/test/resources/"
        }
)
public class CucumberRunnerTest {
}
