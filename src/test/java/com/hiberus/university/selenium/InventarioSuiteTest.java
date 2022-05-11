package com.hiberus.university.selenium.inventario;

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
    }

/* MI CÓDIGO
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

*/

    // SOLUCIÓN RUBÉN

    @Test
    public void validateInventoryResultsTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

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
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        //  Validar que, en el icono del carrito, se ha agregado 1 producto
        String productsQuantityInCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();

        if(productsQuantityInCart.equals("")) {
            productsQuantityInCart = null;
        }

        Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA. ", 1, Integer.parseInt(productsQuantityInCart));
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
        ArrayList<Integer> selectValue = new ArrayList();
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
        List<String> nameInventoryResultsAtoZ = new ArrayList();

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
        List<String> nameInventoryResultsZtoA = new ArrayList();

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
        List<Double> priceInventoryResultsHighToLow = new ArrayList();

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
        List<Double> priceInventoryResultsLowToHigh = new ArrayList();

        // Almacenamos los precios de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsLowToHigh.size(); i++) {
            priceInventoryResultsLowToHigh.add(Double.parseDouble(inventoryResultsLowToHigh.get(i).getText().replace("$", "").trim()));
        }

        // Paso 6
        // Validar que el filtro seleccionado, ordena por el orden de precio de menor a mayor
        Assert.assertEquals("EL FILTRO 'Price (low to high)', NO FUNCIONA CORRECTAMENTE. ", priceInventoryResultsHighToLow, priceInventoryResultsLowToHigh);
    }

    @After
    public void tearDown () {
        driver.quit();
    }

}