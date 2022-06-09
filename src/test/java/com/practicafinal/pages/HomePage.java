package com.practicafinal.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement dropDownAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/*[1]")
    private WebElement registerOption;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/*[2]")
    private WebElement loginOption;

    @FindBy(id = "logo")
    private WebElement titleHome;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    private List<WebElement> items;

    @FindBy(id = "cart-total")
    private WebElement cartItems;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private WebElement shoppingCartBtn;

    @FindBy(xpath = "//a[@title='Checkout']")
    private WebElement checkoutBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return titleHome;
    }


    public void goToRegister(){
        dropDownAccount.click();
        wait.until(ExpectedConditions.visibilityOf(registerOption)).isDisplayed();
        registerOption.click();
    }

    public void goToLogin(){
        dropDownAccount.click();
        wait.until(ExpectedConditions.visibilityOf(loginOption)).isDisplayed();
        loginOption.click();

    }


    public void addItemsFromHomePageAndGoToCartPage(){
        for (int i =0;i<2;i++) {
            items.get(i).click();
        }
    }

    public void goToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn));
        shoppingCartBtn.click();
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.sendKeys(Keys.ENTER);
    }

}
