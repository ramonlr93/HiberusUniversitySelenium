package SuiteTestsRefactor;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RealizarLoginSuiteEjemplo {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso 0
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);

        PagesFactory.start(driver);
    }

    @Test
    @Ignore
    public void testLogin() throws  InterruptedException {

        //Paso 1

        driver.get(LoginPage.PAGE_URL);
        PagesFactory pf = PagesFactory.getInstance();

        LoginPage loginPage = pf.getLoginPage();

        //Paso2
        loginPage.enterUsername("standard_user");

        //Paso 3
        loginPage.enterPassword("secret_sauce");

        //Paso 4
        loginPage.clickLogin();

        //Paso 5

        Assert.assertEquals("login faile", InventoryPage.PAGE_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
