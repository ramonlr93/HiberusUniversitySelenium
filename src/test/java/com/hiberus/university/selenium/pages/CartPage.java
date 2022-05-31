package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractPage{

    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(xpath = "//div[@class='cart_list']")
    private List<WebElement> itemsList;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> inventoryContainerItem;

    public CartPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return checkoutButton;
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public String getItemCount(){
        return shoppingCart.getText();
    }

    public List<WebElement> getItemsList(){
        return itemsList;
    }

    public void deleteCartItemByName(String itemName) {
        String xpathName = itemName.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='remove-" + xpathName + "']");
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }


}
