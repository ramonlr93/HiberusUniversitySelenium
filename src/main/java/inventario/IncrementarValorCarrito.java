package inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class IncrementarValorCarrito {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        // Paso 0 - Iniciamos el Driver
        String userProfile= "C:\\Users\\migue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //Cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //Crear instancia para opciones de Chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Paso 1 - Entramos en la página
        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);

        //Paso 2 - Introducimos el usuario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);

        //Paso 3 - Introducimos la contraseña
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);

        //Paso 4 - Hacemos Login
        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        //Paso 5 - Hacemos click en el botón para añadir el elemento al carrito
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        //Paso 6 - Consultamos el valor del carrito y sacamos por pantalla su valor
        WebElement carrito = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        if (carrito.getText().equals("1")) {
            System.out.println("El valor del carrito es 1.");
        }
        else {
            System.out.println("El valor del carrito NO es 1.");
        }

        System.out.println("El número de productos del carrito es: " + carrito.getText());
        Thread.sleep(2000);

        //Paso 7 - Reiniciamos el carrito y cerramos sesión (para poder volver a pasar el test sin problema)
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        //Paso 8 - Cerramos el Driver
        driver.close();

    }
}
