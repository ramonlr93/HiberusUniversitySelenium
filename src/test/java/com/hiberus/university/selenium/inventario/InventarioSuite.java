package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InventarioSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final String URL = "https://www.saucedemo.com/";

    @Before
    public void tearUp(){
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);
    }


    @Test
    public void testValidarNumeroResultados(){
        // Ir a la URL
        driver.get(URL);
        // Escribir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));


        // Validar que el número de productos mostrados es 6
        int len = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div")).size();
        Assert.assertEquals( "PRUEBA FALLIDA, NUMERO DE ITEMS NO ES 6", 6, len);
    }

    @Test
    public void testExisteProducto(){
        // Ir a la URL
        driver.get(URL);
        // Introducir username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Introducir password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Comprobar que el botón ha cambiado y ahora es remove
        boolean existeProducto = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bolt T-Shirt']")).isDisplayed();
        Assert.assertTrue("PRUEBA FALLIDA, EL ITEM NO EXISTE. ", existeProducto);
    }

    @Test
    public void testIncrementoValorCarrito(){
        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        // Validamos que en el icono se a agregado el valor 1
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals( "PRUEBA FALLIDA, NUMERO DE ITEMS EN EL CARRITO NO ES 1", "1", numeroDeElementos);
    }


    @Test
    public void testEliminarProductoCarrito(){
        // Ir a la URL
        driver.get(URL);
        // Escribir el username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar botón Login
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Eliminar producto
        driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-bolt-t-shirt']")).click();
        // Comprobación carrito
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals( "PRUEBA FALLIDA, HAY NUMERO DE ELEMENTOS EN EL CARRITO", "", numeroDeElementos);
    }

    @Test
    public void testAgregar3AlCarrito(){
        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        // Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-backpack']")).click();
        // Agregar al carrito el producto Test.allTheThings() T-Shirt (Red)
        driver.findElement(By.xpath("//button[@name ='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        // Validamos que en el icono se a agregado el valor 3
        String numeroDeElementos = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals( "PRUEBA FALLIDA, NUMERO DE ITEMS EN EL CARRITO NO ES 1", "3", numeroDeElementos);
    }

    @Test
    public void ordenarInventarioDeZAA(){
        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Camisetas de la A-Z
        List<WebElement> camisetasAZ = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));
        // Hace click en el filtro de z-a
        driver.findElement(By.xpath("//option[@value = 'za']")).click();
        // Camisetas de la Z-A
        List<WebElement> camisetasZA = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));
        // Hago un reverse al array inicial
        Collections.reverse(camisetasAZ);
        Assert.assertArrayEquals("PRUEBA FALLIDA, EL ORDEN NO ES DE Z-A", camisetasAZ.toArray(), camisetasZA.toArray());
    }

    @Test
    public void ordenarInventarioMenorAMayor(){

        List precioHL = new ArrayList();
        List precioLH = new ArrayList();

        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Camisetas de high to lower
        List<WebElement> camisetasHL = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));
        // Hace click en el filtro de lower a high
        driver.findElement(By.xpath("//option[@value = 'lohi']")).click();
        // Camisetas de lower a high
        List<WebElement> camisetasLH = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        // Añado valores a los arraylist de double
        for (int i=0;i<camisetasHL.size();i++){
            precioHL.add(Double.parseDouble(camisetasHL.get(i).getText().substring(1,5)));
            precioLH.add(Double.parseDouble(camisetasLH.get(i).getText().substring(1,5)));
        }

        // Ordeno de menor a mayor
        Collections.sort(precioHL);

        Assert.assertArrayEquals("PRUEBA FALLIDA, EL ORDEN NO ES DE L-H", precioHL.toArray(), precioLH.toArray());
    }

    @Test
    public void ordenarInventarioMayorAMenor(){

        List precioHL = new ArrayList<Double>();
        List precioLH = new ArrayList<Double>();

        // Ir a la página
        driver.get(URL);
        // Escribir el usuario
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Camisetas de high to lower
        List<WebElement> camisetasHL = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));
        // Hace click en el filtro de high a lower
        driver.findElement(By.xpath("//option[@value = 'hilo']")).click();
        // Camisetas de high a lower
        List<WebElement> camisetasLH = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        // Añado valores a los arraylist de double
        for (int i=0;i<camisetasHL.size();i++){
            precioHL.add(Double.parseDouble(camisetasHL.get(i).getText().substring(1,5)));
            precioLH.add(Double.parseDouble(camisetasLH.get(i).getText().substring(1,5)));
        }

        // Ordeno de mayor a menor
        Collections.sort(precioLH, Collections.reverseOrder());

        Assert.assertArrayEquals("PRUEBA FALLIDA, EL ORDEN NO ES DE H-L", camisetasHL.toArray(), camisetasHL.toArray());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}


