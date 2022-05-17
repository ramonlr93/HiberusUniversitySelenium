package com.hiberus.university.selenium.runner;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
public class CucumberRunnerTest {

        public static WebDriver driver;

        @BeforeClass
        public static void setUp() {
                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                PagesFactory.start(driver);

        }

        @AfterClass
        public static void tearDown() {
                driver.close();
        }
}
