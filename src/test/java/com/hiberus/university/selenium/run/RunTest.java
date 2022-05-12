package com.hiberus.university.selenium.run;


import com.hiberus.university.selenium.carrito.CarritoSuite;
import com.hiberus.university.selenium.checkout.CheckoutSuite;
import com.hiberus.university.selenium.inventario.InventarioSuite;
import com.hiberus.university.selenium.login.LoginSuite;
import com.hiberus.university.selenium.logout.LogOutSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuite.class,
        InventarioSuite.class,
        CarritoSuite.class,
        CheckoutSuite.class,
        LogOutSuite.class
})

public class RunTest {
}
