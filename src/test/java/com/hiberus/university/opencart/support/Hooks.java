package com.hiberus.university.opencart.support;

import com.hiberus.university.opencart.pages.PagesFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class Hooks {

    public static WebDriver driver;

    @Before()
    public static void before(Scenario scenario){
        log.info("starting " + scenario.getName());
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        PagesFactory.start(driver);
    }

    @After
    public void after(Scenario scenario) {
        log.info("Ending scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            long time = new Date().getTime();
            String outputName = "screenshot_" + time + ".png";
            scenario.attach(screenshot, "image/png", outputName);
        }

        driver.close();
    }
}