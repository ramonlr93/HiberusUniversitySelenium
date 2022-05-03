package com.hiberus.university.selenium.conJUnit.login;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestLogin
{
    private static WebDriver driver;
    @Before
    public void setUp() {
        driver = Metodos.init(Consts.PAGINA_LOGIN);
    }

    @Test
    public void loginCorrecto() {
        Metodos.login(driver);
        assertEquals("PRUEBA FALLIDA: El login no se ha hecho correctamente", Consts.PAGINA_INVENTARIO, driver.getCurrentUrl());
    }

    @Test
    public void validacionErrorLogin() {
        Metodos.login(driver, "standard_use", Consts.PASSWORD);

        // Si se inicia sesion no se puede completar la prueba
        if (driver.getCurrentUrl().equals(Consts.PAGINA_INVENTARIO)) {
            fail("PRUEBA FALLIDA: El login es correcto por favor escoja un usuario erroneo para el buen funcionamiento de la prueba");
            return;
        }

        WebElement mensajeError;
        try {
            mensajeError  = driver.findElement(By.xpath(Consts.XPATH_DIV_ERROR));
        } catch (Exception e) {
            fail("PRUEBA FALLIDA: NO se muestra el mensaje de error");
            return;
        }
        assertTrue(mensajeError.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
