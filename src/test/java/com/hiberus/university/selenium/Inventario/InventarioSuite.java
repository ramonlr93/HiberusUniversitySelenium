package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class InventarioSuite
{
    /**
     * Rigorous Test :-)
     */

    //Las variables que se usarán en varias pruebas deberán ser static
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
    public void validarNumeroResultados(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        Assert.assertEquals("Los elementos que se muestran no son 6", 6, lista.size());
    }

    @Test
    public void validarExistenciaProducto(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        //El xpath del findElement nos sitúa exactamente en el div que nos interesa.

        boolean aparece;

        try{
            driver.findElement(By.xpath("//a[@id = 'item_5_title_link']/ancestor:: div[@class = 'inventory_item']"));
            aparece = true;
        }catch (NoSuchElementException e){
            aparece = false;
        }
        Assert.assertTrue("No se encuentra el elemento",  aparece);
    }

    @Test
    public void productoCarrito(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String productos = driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']")).getText();
        Assert.assertEquals("No existe 1 artículo en el carrito", "1", productos);
    }

    @Test
    public void eliminarProductoCarrito(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        boolean productos;
        try{
            driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']"));
            productos = true;
            Assert.assertFalse("El carrito no está vacío", productos);
        }catch (NoSuchElementException e){
            productos = false;
            Assert.assertFalse("El carrito no está vacío",  productos);
        }
    }

    @Test
    public void agregarTresProductos(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String productos;

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        productos = driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']")).getText();
        Assert.assertEquals("No hay 3 productos en el carrito", "3", productos);
    }

    //El siguiente no está terminado.
    @Test
    public void ordenarZA(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//option[@value = 'za']")).click();
        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        String[] productos = new String[6];

        for(int i=0; i<lista.size(); i++){

            productos[i] = driver.findElement(By.xpath("//div[@class = 'inventory_list']/child::div["+(i+1)+"]" +
                    "/descendant::div[@class = 'inventory_item_name']")).getText();
        }

        boolean correct;
        if(productos[0].equals("T-Shirt (Red)") && productos[1].equals("Sauce Labs Onesie") && productos[2].equals("Sauce Labs Fleece Jacket") &&
        productos[3].equals("Sauce Labs Bolt T-Shirt") && productos[4].equals("Sauce Labs Bike Light") && productos[5].equals("Sauce Labs Backpack")){
            correct = true;
        }else{
            correct = false;
        }

        Assert.assertTrue("No está correctamente ordenado", correct);
    }

    @After
    public void testDown(){
        driver.quit();
    }
}