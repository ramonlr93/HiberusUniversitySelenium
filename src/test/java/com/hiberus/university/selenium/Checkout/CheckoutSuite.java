package com.hiberus.university.selenium.Checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class CheckoutSuite
{
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;
    public static String username;
    public static String password;
    public static WebDriverWait wait;


    @Before
    public void setUp(){

        username = "standard_user";
        password = "secret_sauce";

        String userProfile = "C:\\Users\\candi\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //Cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options); //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //Maximiza la ventana

        wait = new WebDriverWait(driver, 10,500);
    }

    @Test
    public void cobrarCheckout(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        //---------------------Guardamos el precio de los elementos que vamos a meter al carrito
        String[] preciosDolar = new String[3];
        preciosDolar[0] = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']/preceding:: div[1][@class = 'inventory_item_price']")).getText();
        preciosDolar[1] = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-bolt-t-shirt']/preceding:: div[1][@class = 'inventory_item_price']")).getText();
        preciosDolar[2] = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-bike-light']/preceding:: div[1][@class = 'inventory_item_price']")).getText();

        Double precio = 0.0;

        for(int i=0; i<preciosDolar.length; i++){

            precio += Double.valueOf(preciosDolar[i].substring(1));
        }
        //---------------------------------------------------------------------------------------

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        driver.findElement(By.id("first-name")).sendKeys("Ramón");
        driver.findElement(By.id("last-name")).sendKeys("García");
        driver.findElement(By.id(("postal-code"))).sendKeys("01010");

        driver.findElement(By.id("continue")).click();

        Double precioFinal = Double.valueOf(driver.findElement(By.className("summary_subtotal_label")).getText().substring(13));

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();

        Assert.assertEquals("Los precios no son iguales", precioFinal, precio);
        //assertEquals compara objetos, pero no double, por lo que declaramos los precios como Double
    }

    @Test
    public void realizarPedido(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        driver.findElement(By.id("first-name")).sendKeys("Ramón");
        driver.findElement(By.id("last-name")).sendKeys("García");
        driver.findElement(By.id(("postal-code"))).sendKeys("01010");

        driver.findElement(By.id("continue")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();

        String texto = driver.findElement(By.className("complete-text")).getText();

        Assert.assertEquals("El texto que aparece no es el esperado",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!", texto);
    }

    @After
    public void testDown(){
        driver.quit();
    }
}