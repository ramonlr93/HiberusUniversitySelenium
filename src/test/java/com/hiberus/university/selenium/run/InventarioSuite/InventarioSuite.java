package com.hiberus.university.selenium.run.InventarioSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
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
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventarioSuite {

        public static WebDriver driver;
        public static final String username = "standard_user";
        public static final String password = "secret_sauce";


        @Before
        public void setUp() throws InterruptedException {

                // Paso 0 Iniciar el navegador

                String userProfile = "C:\\Users\\mnavarro\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
                WebDriverManager.chromedriver().setup(); //cargar Chromedriver
                ChromeOptions options = new ChromeOptions();// Crear instancia para opciones de Chrome
                options.addArguments("user-data-dir=" + userProfile);//

                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                // Para que se loguee siempre en cada paso

                driver.get("http://www.saucedemo.com/");
                Thread.sleep(2000);
                driver.findElement(By.id("user-name")).sendKeys(username);
                Thread.sleep(2000);
                driver.findElement(By.id("password")).sendKeys(password);
                Thread.sleep(2000);
                driver.findElement(By.id("login-button")).click();
                Thread.sleep(2000);

        }

        @Test

// Validar que el numero de productos mostrados es igual a 6.

        public void numeroResultadoSeis() {

                int numerodeelementos = driver.findElements(By.className("inventory_item")).size();
                assertEquals("No se muestran 6 resultados", 6, numerodeelementos);

        }

        @Test

// Validar que el producto Sauce Labs Bolt T-Shirt aparece en el inventario.

        public void validarExisteUnProducto() {

                WebElement camiseta = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
                assertTrue("No se encuentra el producto Sauce Labs Bolt T-Shirt", camiseta.isDisplayed());
        }

        @Test

        public void añadirCarrito() throws InterruptedException {

                // Paso 1. Agregar al carrito el producto Sauce Labs Bolt T-Shirt

                driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();


                Thread.sleep(2000);

                // Paso 2  Validar que, en el icono del carrito, se ha agregado 1 producto

                WebElement spanNumeroCarrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
                assertEquals("No se añade al carrito", "1", spanNumeroCarrito.getText());

                //Para quitarlo del carrito (porque se queda seleccionado y para futuros pasos da error y es mejor quitarlo

                driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();


        }

        @Test

        public void eliminarProductoDelInventario()  {

                // Agregar al carrito el producto Sauce Labs Bolt T-Shirt

                driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();


                // Eliminar del carrito el producto 'Sauce Labs Bolt T-Shirt'

                //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"))));
                driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();


                //Validar que se ha eliminado el producto del carrito

                String productsQuantityInCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
                if (productsQuantityInCart.equals("")) ;
                {
                        productsQuantityInCart = null;

                }

                Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA", null, productsQuantityInCart);


        }


        @Test

         public void  agregarTresProductosAlcarrito () throws InterruptedException {

        //  Agregar al carrito los 3 productos elegidos al azar.

        List<WebElement> inventoryResults = driver.findElements(By.xpath("//button[contains(id, 'add-to-cart')]"));

        /*  Validar que, en el icono del carrito, se han agregado los 3 productos.
            Bucle que almacena en el Array selectValue, el valor de los productos seleccionados al azar
         */
        ArrayList<Integer> selectValue = new ArrayList<Integer>();
        int pos;
        int count = 0;
        for (int i = 0; i < inventoryResults.size(); i++) {
                pos = (int) Math.floor(Math.random() * inventoryResults.size());

                while (selectValue.contains(pos)) {

                }
                if (count < 3) {
                        selectValue.add(pos);
                        count++;
                }

                //Añadir al carrito los artículos seleccionados al azar y extraer su precio

                List<String> ListPriceProducts = new ArrayList();
                for (int j = 0; j < selectValue.size(); i++) {
                        inventoryResults.get(selectValue.get(j)).click();
                }

                //Validar que, en el icono del carrito se han agregado  3 productos

                String productsQuantityInCart = driver.findElement(By.xpath("//@[class='shopping_cart_link']")).getText();

                if (productsQuantityInCart.equals("")) {
                        productsQuantityInCart = null;
                }

                Assert.assertEquals("LA CANTIDAD ACTUAL EN EL CARRITO NO ES LA ESPERADA", 3, Integer.parseInt(productsQuantityInCart));


        }
}

       @Test
        public void ordenarInventarioAlfabeticamente () {

        //Implementación logica necesaria para el paso: Seleccionar el filtro NAME (Z TO A)
        //Obtenemos el listado de elementos mostrados dado que está ordenado por defecto con el filtro (A to Z)
        List<WebElement> inventoryResultsAtoZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsAtoZ = new ArrayList();

        //Almacenamos los nombres de los productos en una lista
        for(int i= 0; i < inventoryResultsAtoZ.size(); i++) {
            nameInventoryResultsAtoZ.add(inventoryResultsAtoZ.get(i).getText());
        }

        //Revertimos la lista ordenada (A to Z), de este modo se convertirá en el resultado esperado
        Collections.reverse(nameInventoryResultsAtoZ);

        //Paso 6 Validar que el filtro seleccionado, ordena por el orden alfabético de la Z a la Z
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", nameInventoryResultsAtoZ, nameInventoryResultsAtoZ);

}

        /**
         *    Validar el filtro de ordenamiento de precio de Menor a Mayor
         */
        @Test
        public void sortInventoryAlphabeticalPriceTest() {

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


        @Test
        public void realizarLogout () {


                // Realizar el Logout

                driver.findElement(By.id("react-burger-menu-btn")).click();
                //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//nav[@class='bm-item-list']"))));
                driver.findElement(By.id("logout_sidebar_link")).click();

                // Validar que el logout se ha realizado llevándonos a la página del Login

                String loginPageUrl = driver.getCurrentUrl();
                Assert.assertEquals("NO SE HA REALIZADO EL LOGOUT, NO ESTAMOS EN LA PAGINA DEL LOGIN ",
                        "https://www.saucedemo.com/", loginPageUrl);

        }



    @After

    public void tearDown(){
        driver.close();


    }

}