package LogOut;

import Common.constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class logOut
{
    public static WebDriver driver;
    public static WebDriverWait pausa;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + constants.userProfile);

        driver = new ChromeDriver(options);
        pausa = new WebDriverWait(driver, 10, 1000);
        driver.manage().window().maximize();
    }

    public static void logIn() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }


    @Test
    public void RealizarLogOut() throws InterruptedException {
        driver.get(constants.ulrPruebas);
        logIn();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        pausa.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logout_sidebar_link")))).click();

        String paginaInicio = "https://www.saucedemo.com/";
        String url = driver.getCurrentUrl();

        Assert.assertEquals("• PRUEBA FALLIDA - No se regreso a la pagina principal", paginaInicio, url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}

