package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.hiberus.university.selenium.utils.Methods.initDriver;

@Slf4j
public class Hooks {
    private static WebDriver driver;
    @Before
    public static void before(Scenario scenario) {
        log.info("Starting scenario: " + scenario.getName());
        driver = initDriver();
        PagesFactory.start(driver);
    }

    @After
    public static void after(Scenario scenario) {
        log.info("Ending scenario: " + scenario.getName());
        driver.close();
    }
}
