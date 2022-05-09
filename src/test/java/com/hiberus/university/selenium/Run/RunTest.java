package com.hiberus.university.selenium.Run;

import com.hiberus.university.selenium.Carrito.CarritoSuite;
import com.hiberus.university.selenium.Checkout.CheckoutSuite;
import com.hiberus.university.selenium.Inventario.InventarioSuite;
import com.hiberus.university.selenium.LogOut.LogOutSuite;
import com.hiberus.university.selenium.Login.LoginSuite;
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
