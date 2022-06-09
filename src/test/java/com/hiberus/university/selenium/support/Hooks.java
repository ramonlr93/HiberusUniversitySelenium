package com.hiberus.university.selenium.support;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.EDGE;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

import com.hiberus.university.selenium.model.CartProduct;
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
import org.openqa.selenium.support.PageFactory;

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
        ChromeOptions options = new ChromeOptions();
        if (!isHeadless) {
          options.addArguments("--headless");
        }
        options.addArguments(
                "--window-size=1920,1200",
                "start-maximized", // open maximized browser
                "disable-infobars", // disabling info-bars
                "--disable-extensions", // disabling extensions
                "--disable-dev-shm-usage", // fix limited rsc issues
                "--no-sandbox", // pass OS security model
                "--whitelisted-ips"
        );
        driver = new ChromeDriver(options);
    }
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
      scenario.attach(screenshot, "image/png", "SCREENSHOT");
    }

    try {
      PagesFactory.getInstance().getHomePage().cleanCartProducts();
    } catch (Exception ignored) { }
    driver.close();
  }
}
