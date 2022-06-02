package PlanDePruebasFinal.Run;

import PlanDePruebasFinal.Carrito.CarritoSuite;
import PlanDePruebasFinal.Checkout.CheckoutSuite;
import PlanDePruebasFinal.Inventario.InventarioSuite;
import PlanDePruebasFinal.Login.LoginSuite;
import PlanDePruebasFinal.Logout.LogoutSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginSuite.class,
    InventarioSuite.class,
    CarritoSuite.class,
    CheckoutSuite.class,
    LogoutSuite.class
})
public class RunTest {
}
