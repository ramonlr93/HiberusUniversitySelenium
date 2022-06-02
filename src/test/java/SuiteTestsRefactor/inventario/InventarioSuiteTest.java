package SuiteTestsRefactor.inventario;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventarioSuiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 2000);

        PagesFactory.start(driver);  //Cargar paginas de la factoria
        driver.get(LoginPage.PAGE_URL);  // Paso 1
    }

    @Test
    @Ignore
    public void testNumeroPodructos6() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();

        Assert.assertEquals("PRUEBA FALLIDA - Los productos no son 6",
                6, inventoryPage.getInventoryContainerSize());  //Paso5
    }

    @Test
    @Ignore
    public void testExistePodructo() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        String itemName = "Sauce Labs Bolt T-Shirt";

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();

        Assert.assertTrue("PRUEBA FALLIDA - El producto Sauce Labs Bolt T-Shirt no aparece",
                inventoryPage.itemPresentByName(itemName)); //Paso 5
    }

    @Test
    @Ignore
    public void testAgregarPodructo() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        String itemName = "Sauce Labs Bolt T-Shirt";

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getButtonByName(itemName, "add"); //Paso 5

        Assert.assertEquals("PRUEBA FALLIDA - La cantidad en el carrito no es la esperada",
                1, inventoryPage.getNumberInCart()); //Paso 6
}

    @Test
    @Ignore
    public void testEliminarPodructo() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        String itemName = "Sauce Labs Bolt T-Shirt";

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getButtonByName(itemName, "add"); //Paso 5
        inventoryPage.getButtonByName(itemName, "remove"); //Paso 6

        Assert.assertTrue("PRUEBA FALLIDA - El producto no se ha eliminado", inventoryPage.cartIsPresent());  //Paso 7
    }

    @Test
    @Ignore
    public void testAgregar3Podructos() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        int itemNumber = 3;

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getRandomAndClick(itemNumber, "add");  //Paso 5

        Assert.assertEquals("PRUEBA FALLIDA - No se han añadido 3 productos al carrito",
                itemNumber, inventoryPage.getNumberInCart()); //Paso 6
    }

    @Test
    @Ignore
    public void testOrdenarAlfabetico() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.sortSelectOption("az");

        List<String> OrderAZ= inventoryPage.getItemNameList();
        inventoryPage.sortSelectOption("za"); //Paso 5

        List<String> OrderZA= inventoryPage.getItemNameList();
        Collections.reverse(OrderAZ);

        Assert.assertEquals("PRUEBA FALLIDA - El filtro Name (Z to A) no funiona correctamente",
                OrderAZ, OrderZA); //Paso 6
    }

    @Test
    @Ignore
    public void testOrdenPrecioLoHi() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();

        //Login
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        //Inventory
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.sortSelectOption("hilo");

        List<Float> OrderHiLo = inventoryPage.getItemPriceList();
        inventoryPage.sortSelectOption("lohi");  //Paso 5

        List<Float> OrderLoHi= inventoryPage.getItemPriceList();
        Collections.reverse(OrderHiLo);

        Assert.assertEquals("PRUEBA FALLIDA - El filtro Price (low to high) no funiona correctamente",
                OrderHiLo, OrderLoHi);  //Paso 6
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
