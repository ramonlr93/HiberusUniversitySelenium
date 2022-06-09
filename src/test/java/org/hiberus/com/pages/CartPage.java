package org.hiberus.com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/cart";

    //private String textProductLinkProductPage = ProductPage.TEXT_PRODUCT_TEXT;

    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=product/product&product_id=49']")
    private WebElement productLink;

    //private String textProductLinkCartPage = productLink.getText();



    @FindBy(xpath = "//div[@id='content']/child::p[text()='Your shopping cart is empty!']")
    private WebElement messageCartEmpty;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']")
    private WebElement continueButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public boolean hasUsernamePasswordError() {
        return messageCartEmpty.isDisplayed();
    }
}
