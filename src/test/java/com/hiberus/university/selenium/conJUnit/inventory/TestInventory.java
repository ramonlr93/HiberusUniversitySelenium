package com.hiberus.university.selenium.conJUnit.inventory;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class TestInventory {

    private static WebDriver driver;
    @Before
    public void setUp() {
        driver = Metodos.init(Consts.PAGINA_LOGIN);
        Metodos.login(driver);
    }

    @Test
    public void validarNumeroResultados() {
        List<WebElement> inventoryElements = driver.findElements(By.className(Consts.CLASS_INVENTORY_ITEM));
        assertTrue("PRUEBA FALLIDA: no hay 6 elementos en la página", inventoryElements.size() == 6);
    }

    @Test
    public void incrementoValorCarrito() {
        Metodos.quitarElementosCarro(driver);

        WebElement boltTShirtButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_BOLT_TSHIRT));
        boltTShirtButton.click();


        boolean hay1ElementoCarro = false;
        try {
            hay1ElementoCarro = driver.findElement(By.className(Consts.CLASS_SHOPPING_CART_NUMBER)).getText().equals("1");
        } catch (NoSuchElementException e) {
            fail("PRUEBA FALLIDA: No se ha añadido correctamente el elemento al carro\n");
            return;
        }
        assertTrue("PRUEBA FALLIDA: Hay un número distinto a 1 en el carrito", hay1ElementoCarro);
    }


    @Test
    public void muestraBotonRemove() {
        Metodos.quitarElementosCarro(driver);

        WebElement addOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        WebElement removeOnesieButton;
        try {
            removeOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_REMOVE_ONESIE));
        } catch (NoSuchElementException e) {
            fail("PRUEBA FALLIDA: No se ha encontrado el botón de quitar del carrito\n");
            return;
        }

        assertTrue("PRUEBA FALLIDA: No se ve el botón de quitar del carrito", removeOnesieButton.isDisplayed());
    }

    @Test
    public void eliminarProductoCarrito() {
        Metodos.quitarElementosCarro(driver);

        WebElement addOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        WebElement removeOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_REMOVE_ONESIE));
        removeOnesieButton.click();
        boolean hayElementosCarrito = false;

        try {
            // OBTENEMOS EL TEXTO DEL SPAN, QUE NO ESTA SI NO HAY SPAN SI NO TIENE ELEMENTOS EN EL CARRO
            // ENTONCES SI NO HAY ELEMENTOS EN EL CARRO PASARA POR EL CATCH SINO PONDRA LA VARIABLE hayElementosCarrito A TRUE,
            // QUE PARA QUE PASE LA PRUEBA ESA VARIABLE TIENE QUE ESTAR A FALSE
            driver.findElement(By.className(Consts.CLASS_SHOPPING_CART_NUMBER)).getText();
            hayElementosCarrito = true;
        } catch (NoSuchElementException e) {}

        assertFalse("PRUEBA FALLIDA: Si que se ve el icono sin tener elementos en el carrito", hayElementosCarrito); // SI NO HAY ELEMENTOS EN EL CARRITO
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
