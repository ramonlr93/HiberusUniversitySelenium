package com.hiberus.university.selenium.checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setUp() {
        // Paso 0
        String userProfile = "C:\\Users\\migue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);

    }

    @Test
    public void ComprobarPrecioCheckoutTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        driver.findElement(By.id("shopping_cart_container")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Miguel");

        driver.findElement(By.id("last-name")).sendKeys("Casado");

        driver.findElement(By.id("postal-code")).sendKeys("47001");

        driver.findElement(By.id("continue")).click();

        List<WebElement> total1 = driver.findElements(By.xpath("//div[@class='summary_subtotal_label']"));

        Double[] listaPrecios1 = new Double[1];

        Double total = 0.0;

        for(int i = 0;total1.size() > i;i++){
            listaPrecios1[i]= Double.valueOf(total1.get(i).getText().substring(13));
            total = total + listaPrecios1[i];;
        }

        List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double[] listaPrecios2 = new Double[3];

        Double sumaPrecios = 0.0;

        for(int i = 0;listaPrecios.size() > i;i++){
            listaPrecios2[i]= Double.valueOf(listaPrecios.get(i).getText().substring(1));
            sumaPrecios = sumaPrecios + listaPrecios2[i];
        }

        System.out.println(sumaPrecios);
        System.out.println(total);

        Assert.assertEquals("No coinciden los totales", total, sumaPrecios);

        //Reiniciamos el carrito y cerramos sesión (para poder volver a pasar el test sin problema)
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
