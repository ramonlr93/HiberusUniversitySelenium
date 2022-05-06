package com.hiberus.university.selenium.runner;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.EDGE;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IEXPLORE;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.util.Flags;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin =  {"pretty"},
  glue = {"com.hiberus.university.selenium.stepdefs"},
  features = {"src/test/resources/"}
)
public class CucumberRunnerTest {

  public static WebDriver driver;

  @BeforeClass
  public static void setup() {
    String browser = Flags.getInstance().getBrowser();
    if (StringUtils.isBlank(browser)) browser = CHROME;
    boolean isHeadless = Flags.getInstance().isHeadless();
    switch(browser) {
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (isHeadless) {
          firefoxOptions.addArguments("--headless");
        }
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PagesFactory.start(driver);
        break;
      case EDGE:
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PagesFactory.start(driver);
        break;
      case IEXPLORE:
        // TODO: implement internet explorer driver
        break;
      default:
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (isHeadless) {
          chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PagesFactory.start(driver);
    }
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}
