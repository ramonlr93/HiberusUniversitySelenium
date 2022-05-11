package com.hiberus.university.selenium.run;


import com.hiberus.university.selenium.checkout.CheckoutSuiteTestRuben;
import com.hiberus.university.selenium.inventario.InventarioSuiteTestRuben;
import com.hiberus.university.selenium.carrito.CartSuiteTestRuben;
import com.hiberus.university.selenium.login.LoginSuiteTestRuben;
import com.hiberus.university.selenium.logout.LogoutSuiteTestRuben;
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
