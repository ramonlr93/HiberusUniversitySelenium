package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

@Slf4j
public class Hooks {

    public static WebDriver driver;

    @Before()
    public static void before(Scenario scenario) {
        log.info("starting test" + scenario.getName());
        String browser = Flags.getInstance().getBrowser();
        if (StringUtils.isBlank(browser)) browser = CHROME;
        boolean isHeadless = Flags.getInstance().isHeadless();

        switch (browser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(isHeadless);
                driver = new FirefoxDriver();
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
//                EdgeOptions edgeOptions = new EdgeOptions();
//                if (isHeadless) edgeOptions.set("--headless");
                driver = new EdgeDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        PagesFactory.start(driver);
    }

    @After()
    public static void after(Scenario scenario) {
        log.info("ending test" + scenario.getName());
        driver.close();
    }
}
