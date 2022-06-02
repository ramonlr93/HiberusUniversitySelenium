package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.text.SimpleDateFormat;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.remote.BrowserType.*;


@Slf4j
public class Hooks {
    public static WebDriver driver;
    @Before()
    public static void before(Scenario scenario) {
        log.info("starting test" + scenario.getName());
        String browser = Flags.getInstance().getBrowser();
        Boolean isHeadLess = Flags.getInstance().isHeadless();
        if (StringUtils.isBlank(browser)) {
            browser = CHROME;
        }
        switch (browser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsF = new FirefoxOptions();
                if (isHeadLess) {
                    optionsF.setHeadless(isHeadLess);
                }
                driver = new FirefoxDriver(optionsF);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsC = new ChromeOptions();
                if (isHeadLess) {
                    optionsC.setHeadless(isHeadLess);
                }
                driver = new ChromeDriver(optionsC);
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PagesFactory.start(driver);
    }


    @After()
    public static void after(Scenario scenario) {
        log.info("ending test" + scenario.getName());
        SimpleDateFormat formatter = new SimpleDateFormat("HH mm ss");
        Date date = new Date();
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",formatter.format(date).toString());
        }
        driver.close();
    }
}
