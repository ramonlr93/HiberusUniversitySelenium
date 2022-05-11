package com.hiberus.university.selenium.run;

import com.hiberus.university.selenium.carrito.CarTSuiteTest;
import com.hiberus.university.selenium.checkout.CheckoutSuiteTest;
import com.hiberus.university.selenium.inventario.InventarioSuiteTest;
import com.hiberus.university.selenium.login.LoginSuiteTest;

import com.hiberus.university.selenium.logout.LogOutSuiteTest;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuiteTest.class,
        LogOutSuiteTest.class,
        InventarioSuiteTest.class,
        CheckoutSuiteTest.class,
        CarTSuiteTest.class
})

public class RunTest {

}

