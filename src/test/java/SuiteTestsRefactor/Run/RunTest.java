package SuiteTestsRefactor.Run;

import SuiteTestsRefactor.login.LoginSuiteTest;
import SuiteTestsRefactor.logout.LogoutSuiteTest;
import SuiteTestsRefactor.carrito.CartSuiteTest;
import SuiteTestsRefactor.checkout.CheckoutSuiteTest;
import SuiteTestsRefactor.inventario.InventarioSuiteTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginSuiteTest.class,
    LogoutSuiteTest.class,
    InventarioSuiteTest.class,
    CheckoutSuiteTest.class,
    CartSuiteTest.class
})
public class RunTest {
}
