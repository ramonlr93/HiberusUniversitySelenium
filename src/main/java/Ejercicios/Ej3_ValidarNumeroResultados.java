package Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.omg.CORBA.WStringSeqHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ej3_ValidarNumeroResultados {
    public static WebDriver driver;

    public static void main( String[] args ) throws  InterruptedException {

        //Paso 0
        String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1
        driver.get("https://www.saucedemo.com/");

        //Paso 2
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");

        //Paso 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4
        driver.findElement(By.id("login-button")).click();

        //Paso 5
        List<WebElement> productos = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int contar = productos.size();

        if (contar == 6) {
            System.out.println("Los productos son 6");
        } else {
            System.out.println("Los productos no son 6");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
