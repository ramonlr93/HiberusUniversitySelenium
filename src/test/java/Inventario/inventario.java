package Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class inventario
{
    public static WebDriver driver;
    public static final String ruta = "https://saucedemo.com/";
    public static WebDriverWait pausa;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\mezquerro\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        pausa = new WebDriverWait(driver, 10, 1000);
        driver.manage().window().maximize();
    }

    public static void logIn() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void numeroDeProductosEsSeis() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //pausa.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login-button"))));
        List<WebElement> hijos = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div"));

        //Validacion
        Assert.assertEquals("• PRUEBA FALLIDA - Nuemero de elementos no es 6", 6, hijos.size());
    }

    @Test
    public void existeSauceLabsBoltTShirt() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        boolean SauceLabsBoltTShirtVisible;

        try {
            SauceLabsBoltTShirtVisible= driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bolt T-Shirt')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            SauceLabsBoltTShirtVisible = false;
        }

        Assert.assertTrue("• PRUEBA FALLIDA - El elemento error no aparece", SauceLabsBoltTShirtVisible);
    }

    @Test
    public void SeAñadeACarroSauceLabsBoltTShirt() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        boolean seAñadioAlCarrito;
        try {
            seAñadioAlCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).isDisplayed();
        } catch (NoSuchElementException e) {
            seAñadioAlCarrito = false;
        }

        Assert.assertTrue("• PRUEBA FALLIDA - Sauce Labs Bolt T-Shirt NO se ha agregado", seAñadioAlCarrito);

    }

    @Test
    public void EliminarDelCarroSauceLabsBoltTShirt() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        boolean seEliminoDelCarrito;
        try {
            seEliminoDelCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).isDisplayed();
        } catch (NoSuchElementException e) {
            seEliminoDelCarrito = true;
        }

        Assert.assertFalse("• PRUEBA FALLIDA - Sauce Labs Bolt T-Shirt NO se ha eliminado", seEliminoDelCarrito);
    }

    @Test
    public void Añadir3ProductosAlCArro() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        List<WebElement> listaProductos = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));
        Collections.shuffle(listaProductos);
        for (int i = 0; i < 3; i++) {
            listaProductos.get(i).click();
        }

        int cantidadEnCarro = Integer.parseInt(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText());

        Assert.assertEquals("• PRUEBA FALLIDA - No hay 3 prodctos en el carro", 3, cantidadEnCarro);
    }

    @Test
    public void OrdenarInventarioZ_A() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        List<WebElement> listaProductos = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        WebElement btnFiltrar = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));

        btnFiltrar.findElement(By.xpath("//option[@value='za']")).click();

        List<WebElement> listaProductosZA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        boolean estaOrdenadoZA = true;
        int idxListaDesorden = 0;
        int idxListaZA = listaProductosZA.size() - 1;

        while (idxListaDesorden < listaProductos.size()) {
            String nombreListaDesorden = listaProductos.get(idxListaDesorden).getText();
            String nombreListaZA = listaProductosZA.get(idxListaZA).getText();

            if (!nombreListaDesorden.equals(nombreListaZA)) {
                estaOrdenadoZA = false;
                break;
            }
            idxListaDesorden++;
            idxListaZA--;
        }

        Assert.assertTrue("• PRUEBA FALLIDA - Los elementos no estan ordenados de Z-A", estaOrdenadoZA);
    }

    @Test
    public void OrdenarInventarioPrecioAscendente() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']/option[@value='lohi']")).click();

        List<WebElement> listaTrasFiltro = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));


        // almacenar como queda la lista tras dar a filtrar
        List<Float> preciosLista = new ArrayList<>();
        for (WebElement p: listaTrasFiltro) {
            preciosLista.add(Float.valueOf(p.getText().substring(1, p.getText().length())));
        }

        // calcular como debe ser la lista correcta
        List<Float> listaEsperada = new ArrayList<>();
        for (WebElement p: driver.findElements(By.xpath("//div[@class='inventory_item_price']"))) {
            listaEsperada.add(Float.valueOf(p.getText().substring(1, p.getText().length())));
        }
        Collections.sort(listaEsperada);

        Assert.assertEquals("• PRUEBA FALLIDA - Lista no ordenada de manera ascendente", listaEsperada, preciosLista);
    }

    @Test
    public void OrdenarInventarioPrecioDescendente() throws InterruptedException {
        driver.get(ruta);
        logIn();

        //Validacion
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']/option[@value='hilo']")).click();

        List<WebElement> listaTrasFiltro = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));


        // almacenar como queda la lista tras dar a filtrar
        List<Float> preciosLista = new ArrayList<>();
        for (WebElement p: listaTrasFiltro) {
            preciosLista.add(Float.valueOf(p.getText().substring(1, p.getText().length())));
        }

        // calcular como debe ser la lista correcta
        List<Float> listaEsperada = new ArrayList<>();
        for (WebElement p: driver.findElements(By.xpath("//div[@class='inventory_item_price']"))) {
            listaEsperada.add(Float.valueOf(p.getText().substring(1, p.getText().length())));
        }
        Collections.sort(listaEsperada, Collections.reverseOrder());

        Assert.assertEquals("• PRUEBA FALLIDA - Lista no ordenada de manera descendente", listaEsperada, preciosLista);
    }

        @After
    public void tearDown() {
        driver.close();
    }

}

