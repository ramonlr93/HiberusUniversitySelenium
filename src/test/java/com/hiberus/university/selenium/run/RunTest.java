package com.hiberus.university.selenium.run;


import com.hiberus.university.selenium.carrito.CartSuiteTest;
import com.hiberus.university.selenium.checkout.CheckoutSuiteTest;
import com.hiberus.university.selenium.inventario.InventarioSuiteTest;
import com.hiberus.university.selenium.login.LoginSuiteTest;
import com.hiberus.university.selenium.logout.LogoutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuiteTest.class,
        LogoutTest.class,
        InventarioSuiteTest.class,
        CheckoutSuiteTest.class,
        CartSuiteTest.class
})
public class RunTest {
}
