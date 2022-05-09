package Login;

import static org.junit.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class login
{
    public static WebDriver driver;
    public static WebDriverWait pausa;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + constants.userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void correctLoginUser() throws  InterruptedException {
        driver.get(constants.ulrPruebas);
        pausa = new WebDriverWait(driver, 10, 1000);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //pausa.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login-button"))));
        driver.findElement(By.id("login-button")).click();

        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login fallo dado que no se accedio a la url correcta","https://www.saucedemo.com/inventory.html",url);
    }

    @Test
    public void incorrectLoginUser() throws  InterruptedException {
        driver.get(constants.ulrPruebas);
        pausa = new WebDriverWait(driver, 10, 1000);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean isMenssageErrorVisible = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece",isMenssageErrorVisible);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
