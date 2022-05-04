package com.hiberus.university.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class Ejercicio2 {
        public static WebDriver driver;

        public static void main( String[] args ) throws InterruptedException {

            // Paso 1:
            // Inicie un nuevo navegador Chrome ->
            String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + userProfile);


            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            // Paso 2:
            // Abra el sitio web “https://www.hiberus.com/” ->
            driver.get("https://www.hiberus.com/");
            Thread.sleep(4000);


            // Paso 3:
            // Haga click en el enlace de Consultoría y Estrategia usando “driver.findElement(By.xpath(“//a[@href=’/consultoría y estrategia de
            // negocio’]”)).click(); click();”
            driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();
            Thread.sleep(4000);


            // Paso 4:
            // Vuelva a la página de inicio (utilice el comando 'Back') ->
            driver.navigate().back();
            Thread.sleep(4000);

            // Paso 5:
            // Vuelva nuevamente a la página de Consultoría y Estrategia (esta vez use el comando 'Forward') ->
            driver.navigate().forward();
            Thread.sleep(4000);

            // Paso 6:
            // Vuelva nuevamente a la página de inicio (esta vez use el comando 'To') ->
            driver.navigate().to("https://www.hiberus.com/");
            Thread.sleep(4000);

            // Paso 7:
            // Actualizar el navegador (Use el comando 'Refresh') ->
            driver.navigate().refresh();
            Thread.sleep(4000);

            // Paso 8:
            // Cierra el navegador ->
            driver.quit();
        }
}