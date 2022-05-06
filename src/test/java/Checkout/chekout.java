package Checkout;

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

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class chekout
{
    public static WebDriver driver;
    public static final String ruta = "https://saucedemo.com/";
    public static WebDriverWait pausa;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\mezquerro\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        pausa = new WebDriverWait(driver, 10, 1000);
        driver.manage().window().maximize();

        try {
            VaciarTodoCarrito();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void logIn() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    public static void VaciarTodoCarrito() throws InterruptedException {
        driver.get(ruta);
        logIn();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        try {
            for (WebElement btn: driver.findElements(By.xpath("//button[contains(@id, 'remove-sauce-labs')]"))) {
                btn.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ComprobarPrecioEnChekout() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        float precioFinalEsperado = 0f;
        List<WebElement> listaProductos = driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        Collections.shuffle(listaProductos);
        // Añadir 3 elementos y sumar sus precios a "precioFinal"
        for (int i = 0; i < 3; i++) {
            listaProductos.get(i).findElement(By.xpath("//button[contains(@id, 'add-to-cart-sauce-labs')]")).click();
            String campoPrecio = listaProductos.get(i).findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
            precioFinalEsperado += Float.valueOf(campoPrecio.substring(1, campoPrecio.length()));
        }

        // entrar al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        // pulsar checkout
        driver.findElement(By.id("checkout")).click();
        // coger precios dentro del carrito
        Float precio = Float.valueOf(driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText().substring(7, 12));

        //relleno del form
        driver.findElement(By.id("first-name")).sendKeys("Mario");
        driver.findElement(By.id("last-name")).sendKeys("Ezquerro Ruiz");
        driver.findElement(By.id("postal-code")).sendKeys("26000");
        Thread.sleep(1000);
        // click en botones
        driver.findElement(By.id("continue")).click();

        Assert.assertEquals("• PRUEBA FALLIDA - Error precios finales no coinciden", String.valueOf(precioFinalEsperado), String.valueOf(precio));
    }

    @Test
    public void RealizarUnPedido() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        List<WebElement> listaProductos = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));
        Collections.shuffle(listaProductos);
        for (int i = 0; i < 3; i++) {
            listaProductos.get(i).click();
        }

        // entrar al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        // pulsar checkout
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        //relleno del form
        driver.findElement(By.id("first-name")).sendKeys("Mario");
        driver.findElement(By.id("last-name")).sendKeys("Ezquerro Ruiz");
        driver.findElement(By.id("postal-code")).sendKeys("26000");
        Thread.sleep(1000);
        // click en botones
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();

        String msjEsperado = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String msj = driver.findElement(By.xpath("//div[@class='complete-text']")).getText();

        Assert.assertEquals("• PRUEBA FALLIDA - Error en al finalizar el pedido", msjEsperado, msj);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}

