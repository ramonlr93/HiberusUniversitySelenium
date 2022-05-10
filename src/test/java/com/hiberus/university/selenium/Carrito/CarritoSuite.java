package com.hiberus.university.selenium.Carrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

    }

    @Test
    public void testEliminarDesdeCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        int getRandom;

        for (int i=0;i<2;i++) {
            //System.out.println("Ramdon: "+ getRandom +" "+ random);
            getRandom = (int) Math.floor(Math.random() * buttonsadd.size());

            while (posiciones.contains(getRandom)) {
                getRandom = (int) Math.floor(Math.random() * buttonsadd.size());
            }
            posiciones.add(getRandom);
            buttonsadd.get(posiciones.get(i)).click();
        }

        driver.findElement(By.className("shopping_cart_badge")).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(
                By.xpath("//div[@class= 'cart_item']"))));
        List<WebElement> productos = driver.findElements(By.xpath("//div[@class= 'cart_item']"));

        String productNameRemove = productos.get(0).findElement(
                By.xpath(".//descendant::div[@class='inventory_item_name']")).getText();
        productos.get(0).findElement(By.xpath(".//descendant::button[contains(@id,'remove')]")).click();

        List<WebElement> productosActuales = driver.findElements(By.xpath("//div[@class= 'cart_item']"));
        String productsNameCarrito;
        
        boolean productDelete = true;
        int i = 0;

        while (productDelete && i < productosActuales.size()){
            productsNameCarrito = productosActuales.get(i).findElement(
                    By.xpath(".//descendant::div[@class='inventory_item_name']")).getText();

            if (productNameRemove.equals(productsNameCarrito)){
                productDelete = false;
            }
            i++;
        }

        Assert.assertTrue("PRUEBA FALLIDA - El producto seleccionado no se ha eliminado", productDelete);
    }

    @After
    public void tearDown() {
        try{
            List<WebElement> buttonsremove = driver.findElements(By.xpath("//button[contains(@id, 'remove')]"));

            for (int i=0; i< buttonsremove.size(); i++) {
                buttonsremove.get(i).click();
            }
        }catch (NoSuchElementException removeProduct){

        }

        driver.close();
    }

}
