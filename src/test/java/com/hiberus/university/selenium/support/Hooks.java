package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Hooks {
    public static WebDriver driver;

    @Before
    public  static void before(Scenario scenario){
        log.info("starting test " + scenario.getName());
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
    }

    @After
    public  static  void After(Scenario scenario){
        log.info("ending test " + scenario.getName());
        driver.close();
    }

}
