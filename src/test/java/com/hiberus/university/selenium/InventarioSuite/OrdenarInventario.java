package com.hiberus.university.selenium.InventarioSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.print.JobSettings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class OrdenarInventario {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();
    }

    @Test
    public void TestOrdenInventarioZA() throws InterruptedException {

        //Paso 5. Seleccionar el filtro name (Z to A)
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();

        //Paso 6. Validar que el filtro selecionado es por orden alfabetico Z a A
        List<WebElement> listaZA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        //Imprimo los elementos de la lista ZA
        /*       System.out.println("----------Elementos listaZA----------");
        for (WebElement item : listaZA ) { // ElementoLista nombre : Lista
            System.out.println(item.getText());
        }
        System.out.println("----------Fin Elementos listaZA----------");*/

        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();
        List<WebElement> listaAZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Collections.reverse(listaAZ);
        //Imprimo las elementos de la lista AZ reverse
       /* System.out.println("----------Elementos ListaAZ----------");
        for (WebElement item : listaAZ) { // ElementoLista nombre : Lista
            System.out.println(item.getText());
        }
        System.out.println("----------Fin Elementos ListaAZ----------");*/

        Assert.assertArrayEquals("No se han ordenado los productos de Z a A", listaAZ.toArray(), listaZA.toArray());

    }

    @Test
    public void TestOrdenInventarioMenorMayor() throws InterruptedException {

        //Paso 5. Seleccionar el filtro name (Z to A)
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='lohi']")).click();

        //Paso 6. Validar que el filtro selecionado es por orden alfabetico Z a A
        List<WebElement> listaMenorMayor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        //Imprimo los elementos de la lista Menor a Mayor
        System.out.println("----------Elementos listaMenorMayor----------");
        for (WebElement item : listaMenorMayor) { // ElementoLista nombre : Lista
            System.out.println(item.getText());
        }
        System.out.println("----------Fin Elementos listaMenorMayor----------");

        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        List<WebElement> listaMayorMenor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Collections.reverse(listaMayorMenor);
        //Imprimo las elementos de la lista Mayor Menor reverse
        System.out.println("----------Elementos listaMayorMenor----------");
        for (WebElement item : listaMayorMenor) { // ElementoLista nombre : Lista
            System.out.println(item.getText());
        }
        System.out.println("----------Fin Elementos listaMayorMenor----------");

        Assert.assertArrayEquals("La lista no esta orddenada de menor a mayor",listaMayorMenor.toArray(), listaMenorMayor.toArray());


    }

    @After
    public void TearDown() {
        driver.close();
    }

    private void setUpDriver() {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void authenticateSauceDemo() {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();
    }
}
