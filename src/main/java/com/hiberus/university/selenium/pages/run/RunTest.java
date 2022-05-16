package com.hiberus.university.selenium.pages.run;



import com.hiberus.university.selenium.pages.carrito.CartSuiteTest;
import com.hiberus.university.selenium.pages.checkout.CheckoutSuiteTest;
import com.hiberus.university.selenium.pages.inventario.InventarioSuiteTest;
import com.hiberus.university.selenium.pages.login.LoginSuiteTest;
import com.hiberus.university.selenium.pages.logout.LogoutTest;
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