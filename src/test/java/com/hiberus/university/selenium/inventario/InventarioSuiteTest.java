package com.hiberus.university.selenium.inventario;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
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


@Slf4j
@Ignore
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
    }



    @Then("the user see the inventory list with items size list")
    public void validateInventoryResultsTest() {
        /*
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        */
        // Validar que el numero de productos mostrados en el inventario es igual a 6
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        Assert.assertEquals("EL NUMERO DE ITEMS RESULTANTES EN EL INVENTARIO, NO ES EL CORRECTO. ",
                6, inventoryResults.size());
    }

    @Test
    public void validateExistenceGivenProductTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Validar que el producto 'Sauce Labs Bolt T-Shirt' aparece en el inventario.
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        boolean isProductPresent = false;
        for(int i = 0; i < inventoryResults.size(); i++) {
            if(inventoryResults.get(i).getText().equals("Sauce Labs Bolt T-Shirt")) {
                isProductPresent = true;
            }
        }

        Assert.assertTrue("EL PRODUCTO 'Sauce Labs Bolt T-Shirt', NO APARECE EN EL LISTADO DE ITEMS DEL INVENTARIO ",
                isProductPresent);
    }

    @Test
    public void addCartProductTest() {
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String itemName = "Sauce Labs Backpack";
        log.info("the user adds " + itemName + " by 'Add To Cart'");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.addItemToCartByName(itemName);

        log.info("the user clicks on the shopping cart");
        inventoryPage.clickOnShoppingCart();

        log.info("there should be 1 item in the shopping cart");
        CartPage cartPage = pf.getCartPage();
        int currentCount = cartPage.getItemCount();
        Assert.assertEquals(1, currentCount);
    }

    @Test
    public void removeInventoryCartProductTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Agregar al carrito el producto 'Sauce Labs Bolt T-Shirt'
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))));
        //driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        // Eliminar del carrito el producto 'Sauce Labs Bolt T-Shirt'
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"))));
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        //  Validar que, en el icono del carrito, se ha eliminado el producto añadido previamente
        String productsQuantityInCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();

        if(productsQuantityInCart.equals("")) {
            productsQuantityInCart = null;
        }


        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", null, productsQuantityInCart);
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
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.selectOption("az");

        List<WebElement> inventoryList = inventoryPage.getInventoryNameList();
        List<String> nameInventoryResult = new ArrayList<>();
        List<String> nameInventoryResultSorted = new ArrayList<>();

        for (WebElement webElement : inventoryList) {
            nameInventoryResult.add(webElement.getText());
            nameInventoryResultSorted.add(webElement.getText());
        }

        Collections.sort(nameInventoryResultSorted);
        Assert.assertEquals("list is not sorted",
          nameInventoryResultSorted, nameInventoryResult);
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