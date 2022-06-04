package com.hiberus.university.selenium.support;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.EDGE;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
public class Hooks {

  public static WebDriver driver;

  /**
   * @param scenario to execute
   */
  @Before()
  public void before(Scenario scenario) {
    log.info("starting " + scenario.getName());
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
        break;
      case EDGE:
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions);
        break;
      default:
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (isHeadless) {
          chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);
    }
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    PagesFactory.start(driver);
  }

  /**
   * @param scenario to execute
   */
  @After()
  public void after(Scenario scenario) {
    log.info("ending " + scenario.getName());
    if (scenario.isFailed()) {
      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      long time = new Date().getTime();
      String outputName = "screenshot_" + time + ".png";
      scenario.attach(screenshot, "image/png", outputName);
    }
    driver.close();
  }
}
