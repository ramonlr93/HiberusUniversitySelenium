package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.an.E;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.EDGE;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@Slf4j
public class Hooks {
    public static WebDriver driver;

    @Before()
    public static void before(Scenario scenario){
        log.info("Starting test: " + scenario.getName());
        driver = createWebDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PagesFactory.start(driver);
    }

    // mvn test -Dcucumber.filter.tags="@testcase-01" -Dbrowser=firefox -Dheadless=true
    private static WebDriver createWebDriver(){
        String browser = Flags.getInstance().getBrowser();
        boolean isHeadless = Flags.getInstance().isHeadless();

        switch(browser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(isHeadless){
                    firefoxOptions.setHeadless(true);
                }
                return new FirefoxDriver(firefoxOptions);
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(isHeadless){
                    chromeOptions.setHeadless(true);
                }
                return new ChromeDriver(chromeOptions);
        }
    }

    @After()
    public static void after(Scenario scenario){
        log.info("Ending test: " + scenario.getName());
        driver.close();
    }
}
