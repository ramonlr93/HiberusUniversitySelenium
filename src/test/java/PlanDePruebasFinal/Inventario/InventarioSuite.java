package PlanDePruebasFinal.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventarioSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 2000);

    }

    @Test
    @Ignore
    public void testNumeroPodructos6() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> productos = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        Assert.assertEquals("PRUEBA FALLIDA - Los productos no son 6", 6, productos.size());
    }

    @Test
    @Ignore
    public void testExistePodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        boolean camiseta;
        try{
            camiseta = driver.findElement(
                    By.xpath("//*[text() = 'Sauce Labs Bolt T-Shirt']")).isDisplayed();
        }catch(NoSuchElementException findCamiseta){
            camiseta = false;
        }

        /*List<WebElement> inventoryResults = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        boolean isProductPresent = false;
        for(int i = 0; i < inventoryResults.size(); i++) {
            if(inventoryResults.get(i).getText().equals("Sauce Labs Bolt T-Shirt")) {
                isProductPresent = true;
            }
        }*/

        Assert.assertTrue("PRUEBA FALLIDA - El producto Sauce Labs Bolt T-Shirt no aparece", camiseta);
    }

    @Test
    @Ignore
    public void testAgregarPodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))));
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        boolean carrito;
        try{
            carrito = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
            WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            int cantidad = Integer.parseInt(contenido.getText());

            Assert.assertEquals("PRUEBA FALLIDA - No se ha añadido ningun producto al carrito", 1, cantidad);
        } catch (NoSuchElementException find){
            carrito = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - No se ha añadido productos ", carrito);
    }

    @Test
    @Ignore
    public void testEliminarPodructo() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
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
    @Ignore
    public void testAgregar3Podructos() throws  InterruptedException {
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
        //System.out.println("Ramdon: "+ posiciones);

        WebElement contenido = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        int cantidad = Integer.parseInt(contenido.getText());

        Assert.assertEquals("PRUEBA FALLIDA - No se han añadido 3 productos al carrito", 3, cantidad);
    }

    @Test
    @Ignore
    public void testOrdenarAlfabetico() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion
        List<WebElement> OrdenAZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> textOrdenAZ = new ArrayList();

        for (int i=0;i<OrdenAZ.size();i++) {
            textOrdenAZ.add(OrdenAZ.get(i).getText());
        }
        //System.out.println("OrdenAZ: "+ textOrdenAZ);

        /*Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByValue("za");*/
        driver.findElement(By.xpath("//option[@value = 'za']")).click();

        List<WebElement> OrdenZA = driver.findElements(
                By.xpath("//div[@class = 'inventory_item_name']"));

        List<String> textOrdenZA = new ArrayList();
        for (int i=0;i<OrdenZA.size();i++) {
            textOrdenZA.add(OrdenZA.get(i).getText());
        }
        //System.out.println("OrdenZA: "+ textOrdenZA);

        Collections.reverse(textOrdenAZ);

        Assert.assertEquals("PRUEBA FALLIDA - El filtro Name (Z to A) no funiona correctamente", textOrdenAZ, textOrdenZA);
    }

    @Test
    @Ignore
    public void testOrdenPrecioMenorMayor() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //Validacion

        /*Select selectOptionHilo = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOptionHilo.selectByValue("hilo");*/
        driver.findElement(By.xpath("//option[@value = 'hilo']")).click();

        List<WebElement> OrdenMayor = driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));
        List<Float> PrecioMayor = new ArrayList<Float>();

        for (int i=0;i<OrdenMayor.size();i++) {
            String textMayor = OrdenMayor.get(i).getText();
            PrecioMayor.add(Float.parseFloat(textMayor.substring(textMayor.indexOf("$") + 1)));
        }

        driver.findElement(By.xpath("//option[@value = 'lohi']")).click();
        List<WebElement> OrdenMenor = driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));
        List<Float> PrecioMenor = new ArrayList<Float>();

        for (int i=0;i<OrdenMenor.size();i++) {
            String textMenor = OrdenMenor.get(i).getText();
            PrecioMenor.add(Float.parseFloat(textMenor.substring(textMenor.indexOf("$") + 1)));
        }

        Collections.reverse(PrecioMayor);
        //System.out.println("Mayor: "+ PrecioMayor);
        //System.out.println("Menor: "+ PrecioMenor);

        Assert.assertEquals("PRUEBA FALLIDA - El filtro Price (low to high) no funiona correctamente", PrecioMayor, PrecioMenor);
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
