package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Hooks {
    public static WebDriver driver;

    @Before()
    public  static  void setUp(Scenario scenario){
        log.info("starting test" + scenario.getName());
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        PagesFactory.start(driver);
    }

    @After()
    public static void after(Scenario scenario) {
        /*
        log.info("ending test" + scenario.getName());
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", formatter.format(date).toString());
        }
        */
        log.info("ending " + scenario.getName());
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            long time = new Date().getTime();
            String outputName = "screenshot_ " + time + ".png";
            scenario.attach(screenshot,"image/png", outputName);
        }

        driver.close();
    }

}
