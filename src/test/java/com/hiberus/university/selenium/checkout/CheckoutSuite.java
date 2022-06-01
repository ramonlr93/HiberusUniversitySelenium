package com.hiberus.university.selenium.checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Ignore
public class CheckoutSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void comprobarPrecioTotalPedido(){
        driver.get("https://www.saucedemo.com");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> buttonsAddCart =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i = 0; i < 3; i++){
            buttonsAddCart.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

        driver.findElement(By.id("first-name")).sendKeys("Carlos");
        driver.findElement(By.id("last-name")).sendKeys("Fernández");
        driver.findElement(By.id("postal-code")).sendKeys("39011");

        driver.findElement(By.id("continue")).click();

        List<WebElement> precios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        float sumatorio = 0;

        for(int i = 0; i < 3; i++){
            String textPrice = precios.get(i).getText();
            textPrice = textPrice.replace("$","");
            sumatorio += Float.parseFloat(textPrice);
        }

        String texto = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();

        texto = texto.replace("Item total: $","");
        float totalPrices = Float.parseFloat(texto);

        Assert.assertEquals("PRUEBA FALLIDA - NO SON DEL MISMO PRECIO", totalPrices, sumatorio,0.01);

    }
    @Test
    public void realizarPedido(){
        driver.get("https://www.saucedemo.com");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> buttonsAddCart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i = 0; i < 1; i++){
            buttonsAddCart.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

        driver.findElement(By.id("first-name")).sendKeys("Carlos");
        driver.findElement(By.id("last-name")).sendKeys("Fernández");
        driver.findElement(By.id("postal-code")).sendKeys("39011");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        String textoCompraCompletada = driver.findElement(By.xpath("//div[@class='complete-text']")).getText();

        String textoCorrecto = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        Assert.assertEquals("PRUEBA FALLIDA - NO SE HA REALIZADO LA COMPRA CORRECTAMENTE", textoCorrecto, textoCompraCompletada);

    }
    @After
    public void quitDriver(){
        driver.quit();
    }
}
