package com.hiberus.university.selenium.checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.DoubleBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Random dado = new Random();

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void checkPriceTest() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Add to cart']"))));
            items.get(dado.nextInt(items.size())).click();
        }
        // 6
        List<WebElement> itemsCarro = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Remove']/parent::div"))));

        double priceItemsdouble = 0;
        for (int i = 0; i < itemsCarro.size(); i++) {
            priceItemsdouble += Double.parseDouble(itemsCarro.get(i).getText().substring(1).replace("REMOVE", ""));
        }
        String priceItems = "" + priceItemsdouble;
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")))).click();
        // 7
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkout")))).click();
        // 8
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name")))).sendKeys("hola");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("last-name")))).sendKeys("adios");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("postal-code")))).sendKeys("no");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("continue")))).click();

        String totalPricewait = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")))).getText().substring(13);
        // 9
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish")))).click();
        // 10

        Assert.assertEquals("ERROR LA SUMA DEL PRECIO TOTAL NO ES CORRECTA.", priceItems, totalPricewait);
    }

    @Test
    public void makeAnOrderTest() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[text()='Add to cart']"))));
        items.get(dado.nextInt(items.size())).click();
        // 6
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")))).click();        // 7
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkout")))).click();
        // 8
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name")))).sendKeys("hola");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("last-name")))).sendKeys("adios");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("postal-code")))).sendKeys("no");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("continue")))).click();
        // 9
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish")))).click();
        // 10
        String textExpected = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String text = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='complete-text']")))).getText();
        Assert.assertEquals("ERROR EL TEXTO NO ES IGUAL.", textExpected, text);
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
