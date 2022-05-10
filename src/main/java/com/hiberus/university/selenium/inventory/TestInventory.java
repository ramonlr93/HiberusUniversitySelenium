package com.hiberus.university.selenium.inventory;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static com.hiberus.university.selenium.Constantes.*;

public class TestInventory {

    private static WebDriver driver;
    @Before
    public void setUp() {
        driver = initDriver(PAGINA_LOGIN);
        login(driver);
    }

    @Test
    public void validarNumeroResultados() {
        List<WebElement> inventoryElements = driver.findElements(By.className(CLASS_INVENTORY_PRODUCT));
        assertEquals("PRUEBA FALLIDA: no hay 6 elementos en la página", 6, inventoryElements.size());
    }

    @Test
    public void estaTShirtBolt() {
        WebElement tituloTShitBolt = driver.findElement(By.xpath(XPATH_TITLE_BOLT_TSHIRT));
        assertTrue("No esta la camiseta Sauce Labs Bolt T-Shirt", tituloTShitBolt.isDisplayed());
    }

    @Test
    public void añadirProductoCarrito() {

        WebElement boltTShirtButton = driver.findElement(By.id(ID_BUTTON_ADD_BOLT_TSHIRT));
        boltTShirtButton.click();


        boolean hay1ElementoCarro = false;
        try {
            hay1ElementoCarro = driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER)).getText().equals("1");
        } catch (NoSuchElementException e) {}

        assertTrue("PRUEBA FALLIDA: No se ha añadido correctamente el elemento al carro", hay1ElementoCarro);
    }

    /*
    @Test
    public void muestraBotonRemove() {
        quitarElementosCarro(driver);

        WebElement addOnesieButton = driver.findElement(By.id(ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        boolean displayedRemoveOnesieButton = false;
        try {
            displayedRemoveOnesieButton = driver.findElement(By.id(ID_BUTTON_REMOVE_ONESIE)).isDisplayed();
        } catch (NoSuchElementException e) {}

        assertTrue("PRUEBA FALLIDA: No se ve el botón de quitar del carrito", displayedRemoveOnesieButton);
    }
    */

    @Test
    public void eliminarProductoCarrito() {

        WebElement addOnesieButton = driver.findElement(By.id(ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        WebElement removeOnesieButton = driver.findElement(By.id(ID_BUTTON_REMOVE_ONESIE));
        removeOnesieButton.click();

        boolean hayElementosCarrito = false;
        try {
            // OBTENEMOS EL TEXTO DEL SPAN, QUE NO ESTA SI NO HAY SPAN SI NO TIENE ELEMENTOS EN EL CARRO
            // ENTONCES SI NO HAY ELEMENTOS EN EL CARRO PASARA POR EL CATCH SINO PONDRA LA VARIABLE hayElementosCarrito A TRUE,
            // QUE PARA QUE PASE LA PRUEBA ESA VARIABLE TIENE QUE ESTAR A FALSE
            driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER));
            hayElementosCarrito = true;
        } catch (NoSuchElementException e) {}

        assertFalse("PRUEBA FALLIDA: Si que se ve el icono sin tener elementos en el carrito", hayElementosCarrito); // SI NO HAY ELEMENTOS EN EL CARRITO
    }

    @Test
    public void añadir3ProductosCarrito() throws InterruptedException {
        List<WebElement> botones =  driver.findElements(By.xpath(XPATH_BOTONES_ADD));
        List<Integer> numerosRandom = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Thread.sleep(2000);
            int rnd;
            do
                rnd = (int) Math.floor(Math.random()*(botones.size()));
            while (numerosRandom.contains(rnd));
            botones.get(rnd).click();
            numerosRandom.add(rnd);
        }

        boolean hay3ElementoCarro = false;
        try {
            hay3ElementoCarro = driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER)).getText().equals("3");
        } catch (NoSuchElementException e) {}

        assertTrue("PRUEBA FALLIDA: No se ha añadido correctamente el elemento al carro", hay3ElementoCarro);
    }

    @Test
    public void ordenAZ() {
        List<WebElement> itemList = driver.findElements(By.className(CLASS_NAME_INVENTORY_PRODUCT));
        ArrayList<String> itemNameList = new ArrayList<>();
        for (WebElement item : itemList)
            itemNameList.add(item.getText());

        String[] itemNameArray = itemNameList.toArray(new String[0]);
        Collections.sort(itemNameList);

        assertArrayEquals("Los productos no estan bien ordenados por nombre", itemNameList.toArray() , itemNameArray);
    }

    @Test
    public void ordenMenorMayorPrecio() throws InterruptedException {
        driver.findElement(By.xpath(XPATH_OPTION_MENOR_MAYOR_PRECIO)).click();

        List<WebElement> itemList = driver.findElements(By.className(CLASS_PRODUCT_PRICE));
        ArrayList<Float> itemPriceList = new ArrayList<Float>();
        for (WebElement item : itemList)
            itemPriceList.add(Float.parseFloat(item.getText().substring(1)));

        Float[] itemPriceArray = itemPriceList.toArray(new Float[0]);
        Collections.sort(itemPriceList);

        assertArrayEquals("Los productos no estan bien ordenados por precio", itemPriceList.toArray() , itemPriceArray);
    }

    @Test
    public void ordenMayorMenorPrecio() throws InterruptedException {
        driver.findElement(By.xpath(XPATH_OPTION_MAYOR_MENOR_PRECIO)).click();

        List<WebElement> itemList = driver.findElements(By.className(CLASS_PRODUCT_PRICE));
        ArrayList<Float> itemPriceList = new ArrayList<Float>();
        for (WebElement item : itemList)
            itemPriceList.add(Float.parseFloat(item.getText().substring(1)));

        Float[] itemPriceArray = itemPriceList.toArray(new Float[0]);
        Collections.sort(itemPriceList, Collections.reverseOrder());

        assertArrayEquals("Los productos no estan bien ordenados por precio", itemPriceList.toArray() , itemPriceArray);
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
