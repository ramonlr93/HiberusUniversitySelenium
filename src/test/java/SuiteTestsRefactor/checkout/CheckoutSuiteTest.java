package SuiteTestsRefactor.checkout;

import com.hiberus.university.selenium.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

        PagesFactory.start(driver);  //Cargar paginas de la factoria
        driver.get(LoginPage.PAGE_URL);  // Paso 1
    }

    @Test
    @Ignore
    public void testPrecioFinalVariosProductos() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getRandomAndClick(3, "add");  //Paso 5
        inventoryPage.clickOnShoppingCart(); //Paso 6

        //Cart
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();  //Paso 7

        //Checkout
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        //Paso 8
        checkOutStepOnePage.enterFirstName("Flor");
        checkOutStepOnePage.enterLastName("Ch");
        checkOutStepOnePage.enterPostalCode("29999");
        checkOutStepOnePage.clickContinue();

        Assert.assertEquals("PRUEBA FALLIDA - La suma total de los productos no son iguales",
                checkOutStepTwoPage.getItemsSum(), checkOutStepTwoPage.getItemTotal());  //Paso 9
    }

    @Test
    @Ignore
    public void testRealizarPedido() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getRandomAndClick(3, "add");  //Paso 5
        inventoryPage.clickOnShoppingCart(); //Paso 6

        //Cart
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();  //Paso 7

        //Checkout
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        CheckOutCompletePage checkOutCompletePage = pf.getCheckOutCompletePage();
        //Paso 8
        checkOutStepOnePage.enterFirstName("Flor");
        checkOutStepOnePage.enterLastName("Ch");
        checkOutStepOnePage.enterPostalCode("29999");
        checkOutStepOnePage.clickContinue();

        checkOutStepTwoPage.clickFinish(); //Paso 9

        Assert.assertTrue("PRUEBA FALLIDA - El pedido no ha finalizado correctamente",
                checkOutCompletePage.textCompleteIsPresent());  //Paso 10
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
