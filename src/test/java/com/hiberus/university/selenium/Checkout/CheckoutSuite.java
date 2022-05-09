package com.hiberus.university.selenium.Checkout;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutSuite {
    public static WebDriver driver;

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
    }

    @Test
    public void testPrecioFinalVariosProductos() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
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

        driver.findElement(By.className("shopping_cart_badge")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Flor");
        driver.findElement(By.id("last-name")).sendKeys("QA");
        driver.findElement(By.id("postal-code")).sendKeys("25849");
        driver.findElement(By.id("continue")).click();

        List<WebElement> Precios = driver.findElements(
                By.xpath("//div[@class = 'inventory_item_price']"));

        String precio1 = Precios.get(0).getText();
        String precio2 = Precios.get(1).getText();
        String precio3 = Precios.get(2).getText();
        System.out.println("Precios: "+ precio1 +""+ precio2 +""+ precio3);

        Float numPre1 = Float.parseFloat(precio1.substring(precio1.indexOf("$")+1));
        Float numPre2 = Float.parseFloat(precio2.substring(precio2.indexOf("$")+1));
        Float numPre3 = Float.parseFloat(precio3.substring(precio3.indexOf("$")+1));
        Float suma = numPre1 + numPre2 + numPre3;
        System.out.println("Suma: "+ suma);

        WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));
        String textTotal = itemTotal.getText();
        System.out.println("Total: "+ textTotal);
        Float total = Float.parseFloat(textTotal.substring(textTotal.indexOf("$")+1));
        System.out.println("Total: "+ total);

        Assert.assertEquals("PRUEBA FALLIDA - La suma total de los productos no son iguales", suma, total);
    }

    @Test
    public void testRealizarPedido() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        int getRamdown1 = (int) Math.floor(Math.random() * (buttonsadd.size()));
        int getRamdown2;
        int getRamdown3;

        do{
            getRamdown2 = (int) Math.floor(Math.random() * (buttonsadd.size()));

        } while (getRamdown1 == getRamdown2);
        do{
            getRamdown3 = (int) Math.floor(Math.random() * (buttonsadd.size()));

        } while (getRamdown1 == getRamdown3 || getRamdown2 == getRamdown3);

        WebElement elemento1 = buttonsadd.get(getRamdown1);
        elemento1.click();
        WebElement elemento2 = buttonsadd.get(getRamdown2);
        elemento2.click();
        WebElement elemento3 = buttonsadd.get(getRamdown3);
        elemento3.click();

        driver.findElement(By.className("shopping_cart_badge")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Flor");
        driver.findElement(By.id("last-name")).sendKeys("QA");
        driver.findElement(By.id("postal-code")).sendKeys("25849");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        boolean menssageExist;
        try {
            menssageExist = driver.findElement(By.className("complete-text")).isDisplayed();
        } catch (NoSuchElementException find) {
            menssageExist = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - El pedido no ha finalizado correctamente", menssageExist);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
