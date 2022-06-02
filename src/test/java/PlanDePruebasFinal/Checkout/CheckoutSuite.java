package PlanDePruebasFinal.Checkout;

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

public class CheckoutSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    @Ignore
    public void testPrecioFinalVariosProductos() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        int getRandom;

        for (int i=0;i<3;i++) {
            //System.out.println("Ramdon: "+ getRandom +" "+ random);
            getRandom = (int) Math.floor(Math.random() * buttonsadd.size());

            while (posiciones.contains(getRandom)) {
                getRandom = (int) Math.floor(Math.random() * buttonsadd.size());
            }
            posiciones.add(getRandom);
            buttonsadd.get(posiciones.get(i)).click();
        }

        driver.findElement(By.className("shopping_cart_badge")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Flor");
        driver.findElement(By.id("last-name")).sendKeys("Ch");
        driver.findElement(By.id("postal-code")).sendKeys("25849");
        driver.findElement(By.id("continue")).click();

        List<WebElement> Precios = driver.findElements(
                By.xpath("//div[@class = 'inventory_item_price']"));
        Float suma = Float.valueOf(0);

        for (int i=0; i<3; i++) {
            String precio = Precios.get(i).getText();
            Float precioProduct = Float.parseFloat(precio.substring(precio.indexOf("$")+1));

            suma = suma + precioProduct;
        }
        //System.out.println("Suma: "+ suma);

        String textTotal = driver.findElement(By.className("summary_subtotal_label")).getText();
        Float total = Float.parseFloat(textTotal.substring(textTotal.indexOf("$")+1));
        //System.out.println("Total: "+ total);

        Assert.assertEquals("PRUEBA FALLIDA - La suma total de los productos no son iguales", suma, total);
    }

    @Test
    @Ignore
    public void testRealizarPedido() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> buttonsadd = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        int getRandom;

        for (int i=0;i<3;i++) {
            //System.out.println("Ramdon: "+ getRandom +" "+ random);
            getRandom = (int) Math.floor(Math.random() * buttonsadd.size());

            while (posiciones.contains(getRandom)) {
                getRandom = (int) Math.floor(Math.random() * buttonsadd.size());
            }
            posiciones.add(getRandom);
            buttonsadd.get(posiciones.get(i)).click();
        }

        driver.findElement(By.className("shopping_cart_badge")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Flor");
        driver.findElement(By.id("last-name")).sendKeys("Ch");
        driver.findElement(By.id("postal-code")).sendKeys("25849");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        boolean menssageExist;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("complete-text"))));
            menssageExist = driver.findElement(By.className("complete-text")).isDisplayed();
        } catch (NoSuchElementException find) {
            menssageExist = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - El pedido no ha finalizado correctamente", menssageExist);

        /*String getMessage = driver.findElement(By.xpath("//div[@class='complete-text']")).getText();
        String message = "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        Assert.assertEquals("EL MENSAJE FINAL DEL PEDIDO REALIZADO NO ES EL CORRECTO ", message, getMessage);*/
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
