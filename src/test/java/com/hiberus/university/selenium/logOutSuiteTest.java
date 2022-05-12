package com.hiberus.university.selenium;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.hiberus.university.selenium.utils.Constants.PASSWORD;
import static com.hiberus.university.selenium.utils.Constants.USERNAME;
import static com.hiberus.university.selenium.utils.Methods.initDriver;
import static org.junit.Assert.assertEquals;

public class logOutSuiteTest {
    PagesFactory pf;
    InventoryPage inventoryPage;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        inventoryPage = pf.getInventoryPage();
        pf.getLoginPage().doLogin(USERNAME, PASSWORD);
    }
    @Test
    public void logOut() {
        inventoryPage.logOut();
        
        assertEquals("PRUEBA FALLIDA: no se ha podido hacer el logout", LoginPage.PAGE_URL, pf.getCurrentUrl());
    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
