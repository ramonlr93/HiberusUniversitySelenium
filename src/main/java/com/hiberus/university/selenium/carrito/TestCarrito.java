
package com.hiberus.university.selenium.carrito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hiberus.university.selenium.Constantes.*;
import static com.hiberus.university.selenium.Constantes.login;
import static org.junit.Assert.assertFalse;

public class TestCarrito {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = initDriver(PAGINA_LOGIN);
        login(driver);
    }

    @Test
    public void eliminarProductoDesdeCarro() {
        List<WebElement> botonesProductos = driver.findElements(By.xpath(XPATH_BOTONES_ADD));
        List<Integer> numerosRandom = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int rnd;
            do
                rnd = (int) Math.floor(Math.random() * (botonesProductos.size()));
            while (numerosRandom.contains(rnd));
            botonesProductos.get(rnd).click();
            numerosRandom.add(rnd);
        }

        driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER)).click();

        quitarElementosCarro(driver);

        boolean hayElementosCarrito = false;
        try {
            // OBTENEMOS EL TEXTO DEL SPAN, QUE NO ESTA SI NO HAY SPAN SI NO TIENE ELEMENTOS EN EL CARRO
            // ENTONCES SI NO HAY ELEMENTOS EN EL CARRO PASARA POR EL CATCH SINO PONDRA LA VARIABLE hayElementosCarrito A TRUE,
            // QUE PARA QUE PASE LA PRUEBA ESA VARIABLE TIENE QUE ESTAR A FALSE
            driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER));
            hayElementosCarrito = true;
        } catch (NoSuchElementException e) {
        }

        assertFalse("PRUEBA FALLIDA: Si que se ve el icono sin tener elementos en el carrito", hayElementosCarrito); // SI NO HAY ELEMENTOS EN EL CARRITO
    }

    @After
    public void tearDown() {
        driver.close();
    }
}