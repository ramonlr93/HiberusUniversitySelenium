package com.hiberus.university.selenium.logout;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogoutSuiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

        PagesFactory.start(driver);  //Cargar paginas de la factoria
        driver.get(LoginPage.PAGE_URL);  // Paso 1
    }

    @Test
    public void testLogOut() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.logout(); //Paso 5

        Assert.assertEquals("PRUEBA FALLIDA - El logout es fallido porque no estamos en la url del login",
                LoginPage.PAGE_URL, driver.getCurrentUrl()); //Paso 6
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
