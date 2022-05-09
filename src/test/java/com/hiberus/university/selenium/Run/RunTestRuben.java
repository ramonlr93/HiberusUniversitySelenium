package com.hiberus.university.selenium.Run;


import com.hiberus.university.selenium.Checkout.CheckoutSuiteTestRuben;
import com.hiberus.university.selenium.Inventario.InventarioSuiteTestRuben;
import com.hiberus.university.selenium.Carrito.CartSuiteTestRuben;
import com.hiberus.university.selenium.Login.LoginSuiteTestRuben;
import com.hiberus.university.selenium.Logout.LogoutSuiteTestRuben;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuiteTestRuben.class,
        LogoutSuiteTestRuben.class,
        InventarioSuiteTestRuben.class,
        CheckoutSuiteTestRuben.class,
        CartSuiteTestRuben.class
})
public class RunTestRuben {
}
