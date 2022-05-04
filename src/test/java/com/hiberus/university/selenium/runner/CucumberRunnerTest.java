package com.hiberus.university.selenium.runner;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin =  {"pretty"},
  glue = {"com/hiberus/university/selenium/stepdefs"},
  features = {"src/test/resources/"}
)
public class CucumberRunnerTest {

  public static WebDriver driver;

  @BeforeClass
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    PagesFactory.start(driver);
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}
