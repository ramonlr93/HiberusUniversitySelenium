package com.hiberus.university.selenium.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/";

    //Contenido general de la home
//Xpath del primer carrusel
    @FindBy(xpath = "//div[@id='content']")
    private WebElement containerYourStore;

//Xpath de los carruseles y productos
    @FindBy(xpath = "//div[@class='container']")
    private WebElement inventoryContainer;

//Xpath de productos de la home
    @FindBy(xpath = "//div[@className='product-layout']")
    private List<WebElement> products;

//El xpath es el del nombre de todos los productos.
    @FindBy(xpath = "//div[contains(@class, 'caption')]//descendant::a")
    private List<WebElement> productNames;
    private List<String> productNamesAdded = new ArrayList<>();

    @FindBy(className = "swiper-viewport")
    private List<WebElement> carrousels;

    //My Account
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = "//a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=account/login')]")
    private WebElement login;

    @FindBy(xpath = "//a[contains(@href, 'https://opencart.abstracta.us:443/index.php?route=account/register')]")
    private WebElement register;

    //Añadir al carrito
    @FindBy(xpath = "//button[contains(@onclick, 'cart.add') and contains(@onclick, '40')]")
    private WebElement itemAdd;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/child::a[1]")
    private WebElement successAddToCart;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement shoppingCartElement;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {

        return myAccount;
    }

    public void clickMyAccount() {

        myAccount.click();
    }

    public void clickLogin() {

        login.click();
    }

    public void clickRegister() {
        register.click();}
    public List<WebElement> getInventoryNameList() {
        return productNames;
    }
// Sacado del inventory de Jonatan
    public boolean existProductInInventoryList(String itemName) {
        boolean isProductPresent = false;
        for (WebElement webElement : productNames) {
            if (webElement.getText().equals(itemName)) {
                isProductPresent = true;
                break;
            }
        }
        return isProductPresent;
    }
    public void addItemToCart() {

        itemAdd.click();
    }
    public boolean theItemIsInTheCart() {

        return successAddToCart.isDisplayed();
    }
    public String cartInfo() {

        return shoppingCartElement.getText();
    }
}




