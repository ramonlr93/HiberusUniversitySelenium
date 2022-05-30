package com.hiberus.university.selenium.logout;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogoutTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
    }

    @Then("the page redirects to the login page")
    public void logoutValidationTest() {

        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);

        /*
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        */

        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.openMenu();
        inventoryPage.clickLogout();

        // Validar que el logout se ha realizado llevándonos a la página del Login
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals("Logout is failed",
          LoginPage.PAGE_URL, loginPageUrl);
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
