package com.hiberus.university.selenium.InventarioSuite;

import com.sun.corba.se.spi.activation.BadServerDefinition;
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

import java.lang.reflect.Array;
import java.util.*;


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
        ArrayList<String> namelistaZA = new ArrayList<String>();
        //System.out.println("----------Elementos listaZA----------");
        for (WebElement articulo : listaZA) {
            namelistaZA.add(articulo.getText());
            //System.out.println(articulo.getText());
        }

        //Extraer texto de cada elemento de la lista ZA
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();
        List<WebElement> listaAZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        ArrayList<String> namelistaAZ = new ArrayList<String>();
        //System.out.println("----------Elementos listaAZ----------");
        for (int i = 0; i < listaAZ.size(); i++) {
            namelistaAZ.add(listaAZ.get(i).getText());
            //System.out.println(listaAZ.get(i).getText());
        }
        Collections.sort(namelistaAZ); //Asegurar que la lista AZ este ordenada
        Collections.reverse(namelistaAZ);
        Assert.assertEquals("No se han ordenado los productos de Z a A", namelistaAZ, namelistaZA);
    }

    @Test
    public void TestOrdenInventarioMenorMayor() throws InterruptedException {

        //Paso 5. Seleccionar el filtro price low to high
        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='lohi']")).click();

        //Paso 6. Validar que el filtro selecionado es por orden alfabetico Z a A
        List<WebElement> listaMenorMayor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<String> menorMayor = new ArrayList<String>();
        // System.out.println("----------Elementos listaMenorMayor----------");
        for (WebElement producto : listaMenorMayor) { // ElementoLista nombre : Lista que quiero recorrer
            menorMayor.add(producto.getText().replace("$", ""));
            //System.out.println(producto.getText().replace("$", ""));
        }
        List<Float> listaOrdenadaNumerosMenorMayor = new ArrayList<Float>();
        try {
            for (String valor : menorMayor)
                listaOrdenadaNumerosMenorMayor.add(Float.valueOf(valor));
        } catch (NoSuchElementException e) {
            System.out.println("No se puede convertir el texto a números");
        }

        driver.findElement(By.xpath("//select[@data-test='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        List<WebElement> listaMayorMenor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<String> mayorMenor = new ArrayList<String>();
        //System.out.println("----------Elementos listaMayorMenor----------");
        for (WebElement producto : listaMayorMenor) {
            mayorMenor.add(producto.getText().replace("$", ""));
            //System.out.println(producto.getText().replace("$", ""));
        }
        List<Float> listaNumerosMayorMenor = new ArrayList<Float>();
        try {
            for (String valor : mayorMenor)
                listaNumerosMayorMenor.add(Float.valueOf(valor));
            Collections.sort(listaNumerosMayorMenor); //Ordenar numeros de menor a mayor
        } catch (Exception e) {
            System.out.println("No se puede convertir el texto a números");
        }

        Assert.assertEquals("La lista no esta orddenada de menor a mayor", listaNumerosMayorMenor, listaOrdenadaNumerosMenorMayor);
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
