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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
        }catch (NoSuchElementException e){
            productos = false;
        }

        Assert.assertFalse("El carrito no está vacío", productos);
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

        //Guardamos la lista inicial que aparece de A a Z
        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        //Cambiamos de Z a A y guardamos la lista
        driver.findElement(By.xpath("//option[@value = 'za']")).click();
        List<WebElement> lista2 = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        //Ordenamos al revés la que está de A a Z
        Collections.reverse(lista);

        Assert.assertArrayEquals("La lista no está ordenada de la Z a la A", lista.toArray(), lista2.toArray());
    }

    @Test
    public void ordenaPrecioMenorMayor(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> lista = driver.findElements(By.className("inventory_item_price"));

        String texto;
        double[] precios = new double[6];

        for(int i=0; i<lista.size(); i++){
            texto = lista.get(i).getText().substring(1);
            precios[i] = (Double.valueOf(texto));
        }

        Arrays.sort(precios);
        double valorAnterior = 0;
        boolean correcto = false;

        for(int i=0; i<precios.length; i++){

            if(precios[i] >= valorAnterior){
                correcto = true;
            }else{
                correcto = false;
                break; // En caso de que alguna vez entremos en el else, salimos del for con el boolean en false
            }
            valorAnterior = precios[i];
        }

        Assert.assertTrue("El orden no es correcto, no está de menor a mayor", correcto);
    }

    @Test
    public void ordenarPreciosMayorMenor(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> lista = driver.findElements(By.className("inventory_item_price"));

        String texto;
        Double[] precios = new Double[6];

        for(int i=0; i<lista.size(); i++){
            texto = lista.get(i).getText().substring(1);
            precios[i] = (Double.valueOf(texto));
        }

        Arrays.sort(precios, Collections.<Double>reverseOrder());
        double valorAnterior = 10000;
        boolean correcto = false;

        for(int i=0; i<precios.length; i++){

            if(precios[i] <= valorAnterior){
                correcto = true;
            }else{
                correcto = false;
                break;
            }
            valorAnterior = precios[i];
        }

        Assert.assertTrue("El orden no es correcto, no está de mayor a menor", correcto);
    }

    @After
    public void testDown(){
        driver.quit();
    }
}