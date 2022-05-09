package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\iezquerra\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    //Throw = cubrirte las espaldas
    public void testLogin() throws InterruptedException {
        //GIVEN
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //WHEN
        String url = driver.getCurrentUrl();
        //THEN
        Assert.assertEquals("EL LOGIN ES CORRECTO", "https://www.saucedemo.com/inventory.html", url);
    }


    @Test
    public void Validarnumeroderesultados() throws InterruptedException {
        //GIVEN
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //WHEN
        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        //THEN
       Assert.assertEquals("LA LISTA DE 6 ELEMENTOS ES CORRECTA", 6, lista.size());

    }

    @Test
    public void ExistenciadeProducto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 1200, 2000);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Boolean = guardame esto como un true o un false y con el assert true le digo que pasa la prueba y sino la pasa me saca "El elemento no se encuentra...."
        boolean text = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).isDisplayed();
        Assert.assertTrue("El elemento no se encuentra en el inventario.", text);
//Con esto le digo que me diga algo
        if (text) {
            System.out.println("Aparece");
        } else {
            System.out.println("No aparece");
        }

    }

    @Test
    public void Añadiralcarrito() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        //En el webelement le digo que a esa variable lo que le diga, sin determinar.
        String valorCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals("No se ha incrementado el carrito.", "1", valorCarrito);

    }


    @Test
    public void Eliminarproducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        boolean teniaProducto = elementExist("//span[@class = 'shopping_cart_badge']");
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        //Con el boolean pregunto si tiene o no producto.
        boolean tieneProducto = elementExist("//span[@class = 'shopping_cart_badge']");

         //Con el && que quiero que se cumplan las 2 condiciones y que sean true. Significa Y. Y con ! = NO
        Assert.assertTrue("Tenía producto", teniaProducto );
        Assert.assertTrue("ya no tiene producto", !tieneProducto);

    }
    //La función elementExist no existe. Porque quiero ejecutar lo mismo varias veces y además puedo cambiar el comportamiento.


    //Con este metodo indicamos que si no aparece el carrito es true
    public boolean elementExist(String xpath) {
        boolean existeElElemento = false;
        //con el try describo lo que voy a intentar hacer. Buscar un numero en el carro. Lo uso porque es la unica forma que tengo de saber que no esta el numero en el carro.
        try {
            driver.findElement(By.xpath(xpath));
            existeElElemento = true;
            // con el catch listo los posibles errores y reacciones ante estos errores. En este caso es que no hay producto en el carrito. No hay numero.
        } catch (NoSuchElementException e) {
            existeElElemento = false;
        }
        return existeElElemento;
    }


    @Test
    public void Añadir3alcarrito() throws InterruptedException {
        //GIVEN
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //WHEN
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        //THEN
        String carrito;
        carrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        // Estas validando que el numero del carrito es uno específico (ejemplo 3)
        //Aqui estas diciendo que si el carrito NO muestra 3, se visualiza el mensaje no especificado
        Assert.assertEquals("No es esa cantidad", "3", carrito);
    }
    @Test
    public void OrdenarZ_A () throws InterruptedException {
        //GIVEN. Dado que me he logueado, y que tengo los filtros
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement>ListaProductos = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        WebElement filtro = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
        //WHEN. Cuando ordeno en el filtro
        filtro.findElement(By.xpath("//option[@value='za']")).click();
        //THEN. Entonces quiero ver este orden en los productos
        List<WebElement>ListaProductos2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        boolean ordenadoZA = true;
        int primero = 0;
        int ultimo = ListaProductos.size() -1;
       /* while (desordenado < ListaProductos.size()) {
            String Listadesordenado = ListaProductos.get(primero).getText();
            String nombreListaZA = ListaProductos2.get(ListaZA).getText();
            if (!Listadesordenado.equals(nombreListaZA)) {
                ordenadoZA = false;
                break;
            }
            desordenado++;
            ListaZA--;
        }

        */
        //ListaProductos.get(primero) =  ListaProductos2.get(ultimo);
        //ListaProductos.get(ultimo) =  ListaProductos2.get(primero);

        Assert.assertEquals("EL PRIMERO TIENE QUE SER EL ULTIMO", ListaProductos.get(primero).getText(), ListaProductos2.get(ultimo).getText());
        Assert.assertEquals("EL ULTIMO SERÁ EL PRIMERO", ListaProductos.get(ultimo).getText(), ListaProductos2.get(primero).getText() );
    }


      //  @After
        //public void tearDom () {
          //  driver.quit();
        }







