package com.hiberus.university.selenium.Inventario;

import com.sun.org.apache.xpath.internal.operations.Or;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventarioSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void SetUp() {
        //String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + userProfile)

        driver =  new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 2000);

    }

    @Test
    public void testNumeroPodructos6() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> productos = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        Assert.assertEquals("PRUEBA FALLIDA - Los productos no son 6", 6, productos.size());
    }

    @Test
    public void testExistePodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        boolean camiseta = driver.findElement(
                By.xpath("//*[text() = 'Sauce Labs Bolt T-Shirt']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - El producto Sauce Labs Bolt T-Shirt no aparece", camiseta);
    }

    @Test
    public void testAgregarPodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);

        boolean carrito;
        try{
            carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
            WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            int cantidad = Integer.parseInt(contenido.getText());

            //Se ha añadido remover aqui para que al volver a ejecutar la prueba se abra sin productos añadidos
            driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

            Assert.assertEquals("PRUEBA FALLIDA - No se ha añadido ningun producto al carrito", 1, cantidad);
        } catch (NoSuchElementException find){
            carrito = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - No se ha añadido productos ", carrito);


        /**WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        int cantidad = Integer.parseInt(contenido.getText());

        //Se ha añadido remover aqui para que al volver a ejecutar la prueba se abra sin productos añadidos
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        Assert.assertEquals("PRUEBA FALLIDA - No se ha añadido ningun producto al carrito", 1, cantidad);

        //Otra forma de hacerlo
        boolean carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();

        if (carrito) {
            WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

            //Se ha añadido remover aqui para que al volver a ejecutar la prueba se abra sin productos añadidos
            driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

            Assert.assertEquals("PRUEBA FALLIDA - No se ha añadido ningun producto al carrito",
                    contenido.getText(), 1);
        } else {
            Assert.assertTrue("PRUEBA FALLIDA - No se ha añadido productos ", carrito);
        }**/
    }

    @Test
    public void testEliminarPodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        boolean carrito;
        try{
            carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        } catch (NoSuchElementException find){
            carrito = false;
        }

        Assert.assertFalse("PRUEBA FALLIDA - El producto no se ha eliminado", carrito);
    }

    @Test
    public void testAgregar3Podructos() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));

        /**int getRamdown;
        int ramdown = 0;

        for (int i=0;i<3;i++) {
            getRamdown = (int) Math.floor(Math.random() * (buttonsadd.size()));
            //System.out.println("Ramdon: "+ getRamdown +" "+ ramdown);

            if ((getRamdown != 0) & (getRamdown != ramdown)){
                //System.out.println("Ramdon: "+ getRamdown);
                ramdown = getRamdown;
                buttonsadd.get(getRamdown).click();
            } else {
                i--;
            }
        }**/

        int getRamdown1 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        int getRamdown2;
        int getRamdown3;

        do{
            getRamdown2 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        } while (getRamdown1 == getRamdown2);
        do{
            getRamdown3 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        } while (getRamdown1 == getRamdown3 || getRamdown2 == getRamdown3);

        buttonsadd.get(getRamdown1).click();
        buttonsadd.get(getRamdown2).click();
        buttonsadd.get(getRamdown3).click();

        Thread.sleep(2000);

        WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        int cantidad = Integer.parseInt(contenido.getText());

        List<WebElement> buttonsremove = driver.findElements(By.xpath("//button[contains(@id, 'remove')]"));
        for (int i=0;i<3;i++) {
            buttonsremove.get(i).click();
        }
        Thread.sleep(2000);

        Assert.assertEquals("PRUEBA FALLIDA - No se han añadido 3 productos al carrito", 3, cantidad);
    }

    @Test
    public void testOrdenarAlfabetico() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> OrdenAZ = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        List<String> textOrdenAZ = new ArrayList();
        for (int i=0;i<OrdenAZ.size();i++) {
            textOrdenAZ.add(OrdenAZ.get(i).getText());
        }

        driver.findElement(By.xpath("//option[@value = 'za']")).click();
        List<WebElement> OrdenZA = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        List<String> textOrdenZA = new ArrayList();
        for (int i=0;i<OrdenZA.size();i++) {
            textOrdenZA.add(OrdenZA.get(i).getText());
        }

        Collections.reverse(OrdenAZ);

        Assert.assertEquals("PRUEBA FALLIDA - El producto no se ha eliminado", OrdenAZ, OrdenZA);
    }

    @Test
    public void testOrdenPrecioMenorMayor() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.xpath("//option[@value = 'hilo']")).click();
        List<WebElement> OrdenMayor = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        List<String> textMayor = new ArrayList<String>();
        for (int i=0;i<OrdenMayor.size();i++) {
            textMayor.add(String.valueOf(OrdenMayor.get(i).getText()));
        }

        driver.findElement(By.xpath("//option[@value = 'lohi']")).click();
        List<WebElement> OrdenMenor = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        List<String> textMenor = new ArrayList();
        for (int i=0;i<OrdenMenor.size();i++) {
            textMenor.add(String.valueOf(OrdenMenor.get(i).getText()));
        }

        Collections.reverse(textMayor);

        Assert.assertEquals("PRUEBA FALLIDA - El producto no se ha eliminado", textMayor, textMenor);
    }

    @Test
    public void testOrdenPrecioMayorMenor() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.xpath("//option[@value = 'lohi']")).click();
        List<WebElement> OrdenMenor = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        List<String> textMenor = new ArrayList();
        for (int i=0;i<OrdenMenor.size();i++) {
            textMenor.add(String.valueOf(OrdenMenor.get(i).getText()));
        }

        driver.findElement(By.xpath("//option[@value = 'hilo']")).click();
        List<WebElement> OrdenMayor = driver.findElements(
                By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        List<String> textMayor = new ArrayList();
        for (int i=0;i<OrdenMayor.size();i++) {
            textMayor.add(String.valueOf(OrdenMayor.get(i).getText()));
        }

        Collections.reverse(textMenor);

        Assert.assertEquals("PRUEBA FALLIDA - El producto no se ha eliminado", textMenor, textMayor);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
