package com.hiberus.university.selenium.practicaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Practice2 {

    public static WebDriver driver;

        public static void main(String[] args) throws InterruptedException {
            String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + userProfile);

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //Paso 2. Open web “https://www.hiberus.com/”.
            driver.get("https://www.hiberus.com/");
            Thread.sleep(2000);

            //Paso 3. Click link "Consultoría y Estrategia"
            driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();
            Thread.sleep(2000);

            //Paso 4. Vuelva a la página de inicio (utilice el comando 'Back')
            driver.navigate().back();
            Thread.sleep(2000);

            //Paso 5. Vuelva nuevamente a la página de Consultoría y Estrategia (esta vez use el comando Foward)
            driver.navigate().forward();
            Thread.sleep(2000);

            //Paso 6. Vuelva nuevamente a la página de inicio (esta vez use el comando 'To')
            driver.navigate().to("https://www.hiberus.com/");
            Thread.sleep(2000);

            //Paso 7. Actualizar el navegador (Use el comando 'Refresh')
            driver.navigate().refresh();
            Thread.sleep(2000);

            driver.close();
        }
    }