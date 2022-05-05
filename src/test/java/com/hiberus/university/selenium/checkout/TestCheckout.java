package com.hiberus.university.selenium.checkout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


import static com.hiberus.university.selenium.Constantes.*;
import static com.hiberus.university.selenium.Constantes.quitarElementosCarro;
import static org.junit.Assert.assertEquals;

public class TestCheckout {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = initDriver(PAGINA_LOGIN);
        login(driver);
        quitarElementosCarro(driver);
    }

    @Test
    public void precioFinalCorrecto() {
        List<WebElement> productosPrecios = driver.findElements(By.className(CLASS_PRODUCT_PRICE));
        List<WebElement> productosBotones = driver.findElements(By.xpath(XPATH_BOTONES_ADD));
        int rnd1 = (int) Math.floor(Math.random()*(productosPrecios.size()));
        int rnd2;
        int rnd3;

        do
            rnd2 = (int) Math.floor(Math.random()*productosPrecios.size());
        while (rnd1 == rnd2);
        do
            rnd3 = (int) Math.floor(Math.random()*productosPrecios.size());
        while (rnd1 == rnd3 || rnd2 == rnd3);

        productosBotones.get(rnd1).click();
        productosBotones.get(rnd2).click();
        productosBotones.get(rnd3).click();

        Float precioProducto1 = Float.parseFloat(productosPrecios.get(rnd1).getText().substring(1));
        Float precioProducto2 = Float.parseFloat(productosPrecios.get(rnd2).getText().substring(1));
        Float precioProducto3 = Float.parseFloat(productosPrecios.get(rnd3).getText().substring(1));

        Float precioTotal = precioProducto1 + precioProducto2 + precioProducto3;

        driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER)).click();
        driver.findElement(By.id(ID_BOTON_CHECKOUT)).click();
        driver.findElement(By.id(ID_INPUT_FIRST_NAME)).sendKeys(" ");
        driver.findElement(By.id(ID_INPUT_LAST_NAME)).sendKeys(" ");
        driver.findElement(By.id(ID_INPUT_POSTAL_CODE)).sendKeys(" ");
        driver.findElement(By.id(ID_BOTON_CONTINUE)).click();

        String precioTotalPaginaStr = driver.findElement(By.className(CLASS_DIV_TOTAL_PRICE)).getText();
        Float precioTotalPagina = Float.parseFloat(precioTotalPaginaStr.substring(precioTotalPaginaStr.indexOf("$") + 1));

        assertEquals("PRUEBA FALLIDA: el precio no esta bien calculado", precioTotal, precioTotalPagina);

    }

    @Test
    public void realizarPedido() {
        List<WebElement> productosBotones = driver.findElements(By.xpath(XPATH_BOTONES_ADD));
        int rnd = (int) Math.floor(Math.random()*(productosBotones.size()));

        productosBotones.get(rnd).click();

        driver.findElement(By.className(CLASS_SHOPPING_CART_NUMBER)).click();
        driver.findElement(By.id(ID_BOTON_CHECKOUT)).click();
        driver.findElement(By.id(ID_INPUT_FIRST_NAME)).sendKeys(" ");
        driver.findElement(By.id(ID_INPUT_LAST_NAME)).sendKeys(" ");
        driver.findElement(By.id(ID_INPUT_POSTAL_CODE)).sendKeys(" ");
        driver.findElement(By.id(ID_BOTON_CONTINUE)).click();
        driver.findElement(By.id(ID_BOTON_FINISH)).click();

        assertEquals("PRUEBA FALLIDA: no se ha podido realizar la compra", PAGINA_COMPRA_REALIZADA, driver.getCurrentUrl());
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
