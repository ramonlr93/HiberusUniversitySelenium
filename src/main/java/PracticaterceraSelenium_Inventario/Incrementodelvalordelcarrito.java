package PracticaterceraSelenium_Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Incrementodelvalordelcarrito {
    public static WebDriver driver;

    public static void main(String[] args) {

        String userProfile = "C:\\Users\\mnavarro\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1 Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com");


        // Paso 2 Escribir el username standar user
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");


        // Paso 3 Escribier el password secret sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


        // Paso 4 Pulsar el botón del Login
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.click();

        // Paso 5 Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        WebElement element2 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        element2.click();

        //Paso 6 Validamos que en el icono del carrito se ha agregado el valor 1




    }
}
