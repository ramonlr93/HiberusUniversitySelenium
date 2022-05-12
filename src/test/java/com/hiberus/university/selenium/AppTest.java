package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static WebDriver driver;

    public static WebDriverWait wait;

    public static Actions actions;

    @Before
    public void setUp(){
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500 );

        actions = new Actions(driver);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testLogin() throws InterruptedException
    {
        //Anadir al carrito un producto y pulsar el boton aceptar de la popup que parece cuando se anade
        //driver.get("https://www.demoblaze.com/index.html");

       // driver.findElement(By.xpath("//h4[@class='card-title']/a[@href='prod.html?idp_=1']")).click();

       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"))));
       // driver.findElement(By.xpath("//a[@onclick='addToCart(1)']")).click();

       // wait.until(ExpectedConditions.alertIsPresent());
        //Alert alerta = driver.switchTo().alert();
        //alerta.accept();

        //Mostrar una alerta cuando se hace un click derecho
       // driver.get("https://the-internet.herokuapp.com/context_menu");
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hot-spot"))));
        //actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        //wait.until(ExpectedConditions.alertIsPresent());
        //Alert alerta = driver.switchTo().alert();
        //String text = alerta.getText();
        //alerta.accept();

        //Hacer un drag and drop
        driver.get("https://demoqa.com/droppable");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("draggable"))));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable, droppable).perform();


    }
    

    @After
    public void tearDown(){
        driver.quit();
    }



}
