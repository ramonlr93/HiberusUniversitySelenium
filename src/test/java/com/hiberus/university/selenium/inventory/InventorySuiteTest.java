package com.hiberus.university.selenium.inventory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InventorySuiteTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setupClass() {
        String userProfile = "C:\\Users\\Dayana Dumas Leon\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void resultValidate() {
        driver.get("https://www.saucedemo.com/");

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        int list = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();

        Assert.assertEquals("Error: Items numbers is 6", 6, list);
    }

    @Test
    public void validateProductExits() {
        driver.get("https://www.saucedemo.com/");

        //driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).isDisplayed();

        boolean itemShow = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).isDisplayed();

        Assert.assertTrue("Product doesn't exist", itemShow);
    }

    @Test
    public void addProductToCar() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        String productNumber = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("Error: Is not Validate", "1", productNumber);
    }

    @Test
    public void deleteProductFromCar() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();

        String productNumber = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("Error: Is not Validate", "", productNumber);
    }

    @Test
    public void add3ProductToCart() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        List<WebElement> inventoryItemsContainer = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));

        List<WebElement> randomElementsList = getRandomElements(3, inventoryItemsContainer);

        for (WebElement element : randomElementsList) {
            element.click();
        }

        String productNumber = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("Error: Is not Validate", "3", productNumber);
    }

    private List<WebElement> getRandomElements(int countRandomElement, List<WebElement> inventoryItemsContainer) {
        List<WebElement> resultsList = new ArrayList<>();

        return resultsList;
    }

    //private List<WebElement> getRandomElements(int countRandomElements, List<WebElement> collection){

    @Test
    public void orderZToA() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        //ListAZ
        List<WebElement> inventoryResultsAZ = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        List<String> nameInventoryResultsAZ = new ArrayList<>();

        // Save List Products Names
        for (WebElement webElement : inventoryResultsAZ) {
            nameInventoryResultsAZ.add(webElement.getText());
        }

        // Create object of the Select class
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByIndex(1);

        //ListZA
        List<WebElement> inventoryResultsZA = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        List<String> nameInventoryResultsZA = new ArrayList<>();

        // Save List Products Names
        for (WebElement webElement : inventoryResultsZA) {
            nameInventoryResultsZA.add(webElement.getText());
        }

        //Reverse list
        Collections.reverse(nameInventoryResultsAZ);

        //Validate select filter
        Assert.assertEquals("Name Filter 'Name (Z to A)', Failed", nameInventoryResultsAZ, nameInventoryResultsZA);
    }

    @Test
    public void orderLowToHigh() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        //List Low to High
        List<WebElement> inventoryResultsLowToHigh = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        List<String> nameInventoryResultsLowToHigh = new ArrayList<>();

        // Save List Products Names
        for (WebElement webElement : inventoryResultsLowToHigh) {
            nameInventoryResultsLowToHigh.add(webElement.getText());
        }

        // Create object of the Select class
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByIndex(2);

        //List High To Low
        List<WebElement> inventoryResultsHighToLow = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        List<String> nameInventoryResultsHighToLow = new ArrayList<>();

        // Save List Products Names
        for (WebElement webElement : inventoryResultsHighToLow) {
            nameInventoryResultsHighToLow.add(webElement.getText());
        }

        //Reverse list
        Collections.reverse(nameInventoryResultsLowToHigh);

        //Validate select filter
        Assert.assertEquals("Name Filter 'Name ( Low To High)', Failed", nameInventoryResultsLowToHigh, nameInventoryResultsHighToLow);
    }

    @After
    public void tearDom() {
        driver.quit();
    }
}


