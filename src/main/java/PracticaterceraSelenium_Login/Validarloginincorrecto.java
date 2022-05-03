package PracticaterceraSelenium_Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Validarloginincorrecto {
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
        WebElement passBox = driver.findElement(By.id("user-name"));
        passBox.sendKeys("standarduser");

        // Paso 3 Escribir el password secret sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Paso 4 Pulsar el botón del Login
        WebElement element1 = driver.findElement(By.id("login-button"));
        element1.click();

        // Paso 5 Validar que aparece el mensaje de error
        WebElement errorMessage = driver.findElement(By.xpath("//button[@class='error-button']"));
        if (errorMessage.isDisplayed()) {
            System.out.println("El mensaje de error se muestra");
        } else {
            System.out.println("El mensaje no se muestra");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}

