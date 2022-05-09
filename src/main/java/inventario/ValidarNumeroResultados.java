package inventario;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidarNumeroResultados {

    public static WebDriver driver;

    public static void main( String[] args ) throws InterruptedException {

        // Paso 0
        String userProfile= "C:\\Users\\migue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Paso 1
        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);

        //Paso 2
        driver.findElement(By.id("user-name"));
        //Thread.sleep(2000);

        //Paso 3
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);

        //Paso 4
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);

        //Paso 5
        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        //Paso 6
        WebElement element = driver.findElement(By.xpath("//div[@id='inventory_container']"));
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        if(list.size() == 6){
            System.out.println("El número de productos mostrados es 6.");
        } else {
            System.out.println("El número de productos mostrados NO es 6.");
        }

        //Thread.sleep(2000);

        //Paso 7
        driver.close();

    }
}
