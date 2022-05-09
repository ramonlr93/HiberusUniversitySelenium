package com.hiberus.university.selenium.inventario;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class InventarioSuiteTest {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void SetUp() {
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void testNumeroInventario() throws  InterruptedException {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        //Validacion
        int numeroObjetos = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals("PRUEBA FALLADA-El número de objetos en el inventario debería ser 6",
                6, numeroObjetos);
    }

    @Test
    public void ExisteProducto() {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        boolean text = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA: El elemento no se encuentra en el inventario.", text);
    }

    @Test
    public void AñadirProducto() {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        String valorCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        Assert.assertEquals("PRUEBA FALLIDA: No se ha incrementado el carrito.", "1", valorCarrito);
    }

    @Test
    public void EliminarProducto() throws InterruptedException {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        String numeroCarrito   ;

        try {
            numeroCarrito = driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).getText();
        } catch (NoSuchElementException e) {
            numeroCarrito = "";
        }

        Assert.assertEquals("PRUEBA FALLIDA: El carrito no está vacio", "", numeroCarrito);

    }

    @Test
    public void Añadir3Productos () {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-bike-light']")).click();

        driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-backpack']")).click();

        String valorCarrito = driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).getText();

        Assert.assertEquals("PRUEBA FALLIDA: No hay 3 productos en el carrito.", "3", valorCarrito);
    }

    @Test
    public void OrdenarInventarioZA () {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        List nombreAZ = new ArrayList();
        List nombreZA = new ArrayList();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Camisetas de la A-Z
        List<WebElement> camisetasAZ = driver.findElements(By.xpath("//div[@class = 'inventory_item_name']"));
        // Hace click en el filtro de z-a
        driver.findElement(By.xpath("//option[@value = 'za']")).click();
        // Camisetas de la Z-A
        List<WebElement> camisetasZA = driver.findElements(By.xpath("//div[@class = 'inventory_item_name']"));

        for (int i=0;i<camisetasZA.size();i++){
            nombreAZ.add(camisetasAZ.get(i).getText());
            nombreZA.add(camisetasZA.get(i).getText());
        }

        // Para conseguir el resultado esperado, invertimos la lista ordenada AZ
        Collections.reverse(nombreAZ);

        //Validar que el filtro seleccionado ordena de la Z a la A
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE", nombreAZ, nombreZA);

    }

    @Test
    public void OrdenarMenorAMayor () {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        List precioMenorAMayor = new ArrayList();
        List precioMayorAMenor = new ArrayList();

        // Lista camisetas de mayor a menor
        List<WebElement> camisetasMayorAMenor = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        driver.findElement(By.xpath("//option[@value = 'lohi']")).click();
        // Lista camisetas de menor a mayor
        List<WebElement> camisetasMenorAMayor = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        // Añado valores a los arraylist
        for (int i=0;i<camisetasMayorAMenor.size();i++){
            precioMayorAMenor.add(Double.parseDouble(camisetasMayorAMenor.get(i).getText().substring(1,6)));
            precioMenorAMayor.add(Double.parseDouble(camisetasMenorAMayor.get(i).getText().substring(1,6)));
        }

        // Ordeno de menor a mayor
        Collections.sort(precioMayorAMenor);

        Assert.assertEquals("PRUEBA FALLIDA, EL ORDEN NO ES DE MENOR A MAYOR", precioMayorAMenor, precioMenorAMayor);
    }

    @Test
    public void OrdenarMayorAMenor () {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        List precioMayorAMenor = new ArrayList();
        List precioMenorAMayor = new ArrayList();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_list']/child::div"))));

        // Camisetas de high to lower
        List<WebElement> camisetasMayorAMenor = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));
        // Hace click en el filtro de high a lower
        driver.findElement(By.xpath("//option[@value = 'hilo']")).click();
        // Camisetas de high a lower
        List<WebElement> camisetasMenorAMayor = driver.findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        // Añado valores a los arraylist de double
        for (int i=0;i<camisetasMayorAMenor.size();i++){
            precioMayorAMenor.add(Double.parseDouble(camisetasMayorAMenor.get(i).getText().substring(1,6)));
            precioMenorAMayor.add(Double.parseDouble(camisetasMenorAMayor.get(i).getText().substring(1,6)));
        }

        // Ordeno de mayor a menor
        Collections.sort(precioMayorAMenor, Collections.reverseOrder());

        Assert.assertEquals("PRUEBA FALLIDA, EL ORDEN NO ES DE H-L", camisetasMenorAMayor, camisetasMayorAMenor);
    }




    @After
    public void tearDown() {
        driver.close();
    }
}
