package PracticaterceraSelenium_Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Realizarlogin {

    //Paso 0

    public static WebDriver driver;
     public static void main(String[] args) throws InterruptedException {

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
        Thread.sleep(2000);


        // Paso 3 Escribier el password secret sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        // Paso 4 Pulsar el botón del Login
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.click();
        Thread.sleep(2000);

        // Paso 5 Validar que hemos accecido correctamente a la página, comprobando que se muestra la URL https://www.saucedemo.com
        String url = driver.getCurrentUrl();
        System.out.println("la url es " + url);
        if (url.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("La url " + url + "es correcta");
        } else {
            System.out.println("La url " + url + "no es correcta");

        }

        driver.quit();
    }
}