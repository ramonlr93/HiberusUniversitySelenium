package com.hiberus.university.selenium.login;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.hiberus.university.selenium.constantes.Consts.*;
import static com.hiberus.university.selenium.constantes.Metodos.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestLogin {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void setUp() {
        driver = initDriver(PAGINA_LOGIN);
        wait = initWait(driver);
    }

    @Test
    public void loginCorrecto() {
        login(driver);
        assertEquals("PRUEBA FALLIDA: El login no se ha hecho correctamente", PAGINA_INVENTARIO, driver.getCurrentUrl());
    }

    @Test
    public void validacionErrorLogin() {
        login(driver, "standard_use", PASSWORD);

        // Si se inicia sesion no se puede completar la prueba
        if (driver.getCurrentUrl().equals(PAGINA_INVENTARIO)) {
            fail("PRUEBA FALLIDA: El login es correcto por favor escoja un usuario erroneo para el buen funcionamiento de la prueba");
            return;
        }

        boolean mensajeError = false;
        try {
            mensajeError = driver.findElement(By.xpath(XPATH_DIV_ERROR)).isDisplayed();
        } catch (NoSuchElementException e) {}

        assertTrue("PRUEBA FALLIDA: no se muestra el mensaje de error", mensajeError);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
