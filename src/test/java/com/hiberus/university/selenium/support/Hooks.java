package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.remote.BrowserType.*;

@Slf4j
public class Hooks {

  public static WebDriver driver;

  @Before()
  public static void before(Scenario scenario){
    log.info("starting test" + scenario.getName());

    String browser = Flags.getInstance().getBrowser(); //Aquí tendríamos el navegador con el que lo queremos lanzar
    if(StringUtils.isBlank(browser)) browser = CHROME; //Si está vacío, por defecto será CHROME (La constante nos la dá selenium)

    boolean isHeadless = Flags.getInstance().isHeadless();

    switch (browser){
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions(); //Metemos la configuración de Firefox
        if(isHeadless) firefoxOptions.addArguments("--headless"); //También valdría .setHeadless(true)

        driver = new FirefoxDriver(firefoxOptions);
        break;

      case EDGE: //Con Edge es más difícil la configuración del navegador
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;

      default: //por default sería el chrome
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        if(isHeadless) chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);
        break;
    }

    //Esta parte es común a cualquier navegador
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    PagesFactory.start(driver);
  }

  @After()
  public static void after(Scenario scenario){
    log.info("ending test" + scenario.getName());

    //Poner una foto en el reporting en caso de fallo de prueba
    if(scenario.isFailed()){
      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      long time = new Date().getTime();
      String outputName = "screenshot_"+time+".png";
      scenario.attach(screenshot, "image/png", outputName);
    }

    driver.close();

  }
}