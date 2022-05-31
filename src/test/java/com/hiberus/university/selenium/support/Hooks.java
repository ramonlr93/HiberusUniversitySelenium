package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

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

    private static WebDriver createWebDriver(){
        String webdriver = System.getProperty("browser", "chrome");
        switch(webdriver) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }

    @After()
    public static void after(Scenario scenario){
        log.info("Ending test: " + scenario.getName());
        driver.close();
    }
}
