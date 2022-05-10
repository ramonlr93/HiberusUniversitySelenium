package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidarNumeroResultado {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void testValidateNumberResults() {
        //Paso 1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso 2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso 3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4 Pulsar en el botón del Login//Paso 5. Validar numero resultados
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));
        List<WebElement> listaNumItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int numItems = listaNumItems.size();
        Assert.assertEquals("El número de items es incorrecto", 6, numItems);
    }
    @After
    public void quitDriver(){
        driver.quit();
    }
}