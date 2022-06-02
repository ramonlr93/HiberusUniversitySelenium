package SuiteTestsRefactor.login;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSuiteTest {
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
    public void testLogin() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();

        loginPage.enterUsername("bad_standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                LoginPage.PAGE_URL, driver.getCurrentUrl());  //Paso 5
    }

    @Test
    @Ignore
    public void testLoginIncorrecto() throws  InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();

        loginPage.enterUsername("bad_standard_user");  //Paso2
        loginPage.enterPassword("secret_sauce");  //Paso 3
        loginPage.clickLogin();  //Paso 4

        Assert.assertTrue("PRUEBA FALLIDA - EL ELEMENTO ERROR NO APARECE",
                loginPage.hasUsernamePasswordError());  //Paso 5
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
