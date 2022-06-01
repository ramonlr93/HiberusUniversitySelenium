package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class Hooks {

    public static WebDriver driver;

    @Before()
    public static void before(Scenario scenario){
        log.info("starting test" + scenario.getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        PagesFactory.start(driver);
    }

    @After()
    public static void after(Scenario scenario){
        log.info("ending test" + scenario.getName());
        if (scenario.isFailed()) {
            try {
                log.info(scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot , "image/png", "Taking Screen Shot");
                log.info("This is an Info");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}