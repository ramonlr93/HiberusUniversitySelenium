package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ejercicio2 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Paso 1 Inicio Chrome
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Paso 2 Abrir pagina web
        String urlHiberus = "https://www.hiberus.com/";
        driver.get(urlHiberus);


        //Paso 3 Ir a enlace "Consultoria y estragegia"
        WebElement enlace = driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']"));
        enlace.click();
        Thread.sleep(1000);
        WebElement permisos = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        permisos.click();

        //Paso 4 Back
        driver.navigate().back();

        Thread.sleep(2000);

        //Paso 5 Forward
        driver.navigate().forward();
        Thread.sleep(2000);

        //Paso 6 To
        driver.navigate().to(urlHiberus);
        Thread.sleep(2000);

        //Paso 7 Refresh
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Paso 8 cierre el navegador
        driver.quit();
    }
}
