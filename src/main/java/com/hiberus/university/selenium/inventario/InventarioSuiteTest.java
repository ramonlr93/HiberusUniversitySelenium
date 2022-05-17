package com.hiberus.university.selenium.inventario;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InventarioSuiteTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

    }

    @Test
    public void validateInventoryResultsTest() {
        // Validar que el numero de productos mostrados en el inventario es igual a 6
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        int size = inventoryPage.getInventoryItems();
        Assert.assertEquals("No hay seis artículos", 6, size);
    }

    @Test
    public void validateExistenceGivenProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        Assert.assertTrue("El producto no existe.", inventoryPage.nameInventoryItem("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void addCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        // Agregar al carrito el producto 'Sauce Labs Bolt T-Shirt'
        inventoryPage.addItemToCartByName("Sauce Labs Bolt T-Shirt");

        Assert.assertEquals("No se ha añadido el artículo al carrito", 1, inventoryPage.getCartNumberOfItems());


    }

    @Test
    public void removeInventoryCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

        inventoryPage.addItemToCartByName("Sauce Labs Bolt T-Shirt");

        inventoryPage.removeItemToCartByName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals("No se ha añadido el artículo al carrito", 0, inventoryPage.getCartNumberOfItems());

    }

    @Test
    public void addCartThreeProductTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Agregar al carrito los 3 productos elegidos al azar
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));

        /*
        * Bucle que almacena en el Array selectValue, el valor de los productos seleccionados al azar
        */
        ArrayList<Integer> selectValue = new ArrayList<>();
        int pos;
        int count = 0;
        for(int  i = 0; i < inventoryResults.size(); i++) {
            pos = (int) Math.floor(Math.random() * inventoryResults.size());

            while (selectValue.contains(pos)) {
                pos = (int) Math.floor(Math.random() * inventoryResults.size());
            }

            if(count < 3) {
                selectValue.add(pos);
                count++;
            }
        }

        // Añadir al carrito los articulos seleccionados al azar
        for(int i = 0; i < selectValue.size(); i++) {
            inventoryResults.get(selectValue.get(i)).click();
        }

        //  Validar que, en el icono del carrito, se han agregado 3 productos
        String productsQuantityInCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();

        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 3, Integer.parseInt(productsQuantityInCart));

    }

    /**
    *    Validar el filtro de ordenamiento alfabetico (Z to A)
     */
    @Test
    public void sortInventoryAlphabeticalOrderTest() {
        // Paso 1
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Paso 2
        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Paso 3
        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Paso 4
        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado dado que esta ordenado por defecto con el filtro (A to Z)
        List<WebElement> inventoryResultsAtoZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsAtoZ = new ArrayList<>();

        // Almacenamos los nombres de los productos en una Lista
        for(int i = 0; i < inventoryResultsAtoZ.size(); i++) {
            nameInventoryResultsAtoZ.add(inventoryResultsAtoZ.get(i).getText());
        }

        // Paso 5
        //  Seleccionar el filtro NAME (Z TO A)
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByValue("za");

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado -- Filtro ya aplicado NAME (Z to A)
        List<WebElement> inventoryResultsZtoA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsZtoA = new ArrayList<>();

        // Almacenamos los nombres de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsZtoA.size(); i++) {
            nameInventoryResultsZtoA.add(inventoryResultsZtoA.get(i).getText());
        }

        //Revertimos la lista ordenada (A to Z), de este modo se convertira en el resultado esperado
        Collections.reverse(nameInventoryResultsAtoZ);

        // Paso 6
        // Validar que el filtro seleccionado, ordena por el orden alfabético de la Z a la A
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", nameInventoryResultsAtoZ, nameInventoryResultsZtoA);
    }

    /**
     *    Validar el filtro de ordenamiento de precio de Menor a Mayor
     */
    @Test
    public void sortInventoryAlphabeticalPriceTest() {
        // Paso 1
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Paso 2
        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Paso 3
        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Paso 4
        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Paso 5
        //  Seleccionar el filtro 'Price (high to low)'
        Select selectOptionHilo = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOptionHilo.selectByValue("hilo");

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado -- Filtro aplicado 'Price (high to low)'
        List<WebElement> inventoryResultsHighToLow = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> priceInventoryResultsHighToLow = new ArrayList<>();

        // Almacenamos los precios de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsHighToLow.size(); i++) {
            priceInventoryResultsHighToLow.add(Double.parseDouble(inventoryResultsHighToLow.get(i).getText().replace("$", "").trim()));
        }

        // Comparamos los valores de la lista
        Comparator<Double> comparator = (x, y) -> Double.compare(x, y);

        // Ordenamos de menor a mayor los valores comparados de la lista
        priceInventoryResultsHighToLow.sort(comparator);

        // Seleccionar el filtro 'Price (low to high)'
        Select selectOptionLohi = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOptionLohi.selectByValue("lohi");

        // Obtenemos el listado de elementos mostrado -- Filtro aplicado 'Price (low to high)'
        List<WebElement> inventoryResultsLowToHigh = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> priceInventoryResultsLowToHigh = new ArrayList<>();

        // Almacenamos los precios de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsLowToHigh.size(); i++) {
            priceInventoryResultsLowToHigh.add(Double.parseDouble(inventoryResultsLowToHigh.get(i).getText().replace("$", "").trim()));
        }

        // Paso 6
        // Validar que el filtro seleccionado, ordena por el orden de precio de menor a mayor
        Assert.assertEquals("EL FILTRO 'Price (low to high)', NO FUNCIONA CORRECTAMENTE. ", priceInventoryResultsHighToLow, priceInventoryResultsLowToHigh);
    }


    @After
    public void tearDown() {
        driver.close();
    }

}