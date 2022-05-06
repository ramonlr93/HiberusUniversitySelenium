package Carrito;

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

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class carrito
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
    public void Añadir2ElementosAlCarritoEntrarYBorrar1() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        List<WebElement> listaProductos = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));
        Collections.shuffle(listaProductos);
        for (int i = 0; i < 2; i++) {
            listaProductos.get(i).click();
        }

        // entrar al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        WebElement elm = driver.findElement(By.xpath( "//div[@class='cart_item']//button[contains(@id,'remove-sauce-labs')]"));


        boolean presente;
        try {
            elm.click();
            presente = true;
        } catch (NoSuchElementException e) {
            presente = false;
        }

        Assert.assertTrue("• PRUEBA FALLIDA - No se elimino el elemento del carro", presente);
    }

        @After
    public void tearDown() {
        driver.close();
    }

}

