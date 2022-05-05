package com.hiberus.university.selenium.logout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.hiberus.university.selenium.Constantes.*;
import static com.hiberus.university.selenium.Constantes.login;
import static org.junit.Assert.assertEquals;

public class TestLogOut {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = initDriver(PAGINA_LOGIN);
        login(driver);
    }

    @Test
    public void logOutCorrecto() {
        driver.findElement(By.id(ID_BOTON_SACAR_MENU_LATERAL)).click();
        driver.findElement(By.id(ID_BOTON_LOG_OUT)).click();
        assertEquals("PRUEBA FALLIDA: El login no se ha hecho correctamente", PAGINA_LOGIN, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
