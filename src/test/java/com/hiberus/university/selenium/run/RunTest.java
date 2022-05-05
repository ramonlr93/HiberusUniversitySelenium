package com.hiberus.university.selenium.run;

import com.hiberus.university.selenium.Carrito.CarritoSuite;
import com.hiberus.university.selenium.Checkout.CheckoutSuite;
import com.hiberus.university.selenium.Inventario.InventarioSuite;
import com.hiberus.university.selenium.LogOut.LogOutSuite;
import com.hiberus.university.selenium.Login.LoginSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

//Nos permitirá ejecutar las pruebas de las otras clases.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuite.class,
        InventarioSuite.class,
        CarritoSuite.class,
        CheckoutSuite.class,
        LogOutSuite.class
})

public class RunTest
{
    /**
     * Rigorous Test :-)
     */

}