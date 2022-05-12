package com.hiberus.university.selenium.run;

import com.hiberus.university.selenium.carrito.CartSuiteTest;
import com.hiberus.university.selenium.checkout.CheckoutSuiteTest;
import com.hiberus.university.selenium.InventarioSuiteTest;

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
        CartSuiteTest.class
})

public class RunTest {

}

