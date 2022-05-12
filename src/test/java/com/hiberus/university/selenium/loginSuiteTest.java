package com.hiberus.university.selenium;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.hiberus.university.selenium.utils.Methods.*;
import static org.junit.Assert.*;

public class loginSuiteTest {

    PagesFactory pf;
    LoginPage loginPage;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        loginPage = pf.getLoginPage();
    }

    @Test
    public void correctLogin() {
        LoginPage loginPage = pf.getLoginPage();

        loginPage.doLogin("standard_user", "secret_sauce");

        assertEquals("PRUEBA FALLIDA: El login no se ha realizado correctamente", InventoryPage.PAGE_URL, pf.getCurrentUrl());
    }

    @Test
    public void incorrectLogin() {
        LoginPage loginPage = pf.getLoginPage();

        loginPage.doLogin("bad_standard_user", "secret_sauce");

        assertTrue("PRUEBA FALLIDA: No aparece el mensaje de error", loginPage.hasErrorMessage());
    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
