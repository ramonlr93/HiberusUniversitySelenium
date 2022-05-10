package com.hiberus.university.selenium;

import com.hiberus.university.selenium.carrito.TestCarrito;
import com.hiberus.university.selenium.checkout.TestCheckout;
import com.hiberus.university.selenium.inventory.TestInventory;
import com.hiberus.university.selenium.login.TestLogin;
import com.hiberus.university.selenium.logout.TestLogOut;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLogin.class,
        TestInventory.class,
        TestCarrito.class,
        TestCheckout.class,
        TestLogOut.class
})
public class RunTest {
}
