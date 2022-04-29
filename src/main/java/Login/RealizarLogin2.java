package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class RealizarLogin2 {
    public static WebDriver driver;

    public static void main(String[] args) {

        //Paso0

        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");

        login("standard_user", "secret_sauce" );

        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce" );


        driver.close();
    }

    public static void login(String user, String passwd) {
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys(user);
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys(passwd);
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso 5. Validar que hemos accedido correctamente a la página, comprobando que se muestra
        //la URL https://www.saucedemo.com/inventory.html
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login correcto");
        } else {
            System.out.println("Url incorrecta");
        }

    }
}
