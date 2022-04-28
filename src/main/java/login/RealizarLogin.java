package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {
    public static WebDriver driver;
    public static final String ruta = "https://saucedemo.com/";

    public static void main( String[] args ) {
        // Paso 1
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();  //Cargar ChroneDriver
        ChromeOptions options = new ChromeOptions();  //Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(ruta);
        WebElement inptUsername = driver.findElement(By.id("user-name"));
        WebElement inptPassw = driver.findElement(By.id("password"));

        inptUsername.sendKeys("standard_user");
        inptPassw.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();


    }
}
