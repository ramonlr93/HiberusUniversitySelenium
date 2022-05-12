package com.hiberus.university.selenium.example;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.hiberus.university.selenium.utils.Constants.PASSWORD;
import static com.hiberus.university.selenium.utils.Constants.USERNAME;
import static com.hiberus.university.selenium.utils.Methods.initDriver;

public class SuiteExample {
    PagesFactory pf;

    @Before
    public void setUp() {
        pf = PagesFactory.start(initDriver(LoginPage.PAGE_URL));
        pf.getLoginPage().doLogin(USERNAME, PASSWORD);
    }
    @Test
    public void test() {

    }

    @After
    public void tearDown() {
        pf.getDriver().close();
    }
}
