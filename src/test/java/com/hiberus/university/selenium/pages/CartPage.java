package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(@id, 'remove')]")
    private List<WebElement> removeButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(className = "cart_item")
    private List<WebElement> itemsList;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNameList;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return itemsList.get(0);
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public int getItemListSize(){
        return itemsList.size();
    }

    public void clickContinueShopping(){
        continueShoppingButton.click();
    }

    public void removeItemToCartByName(String itemName) {
        String xpathName = itemName.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='remove-" + xpathName + "']");
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public List<String> getItemsName(){
        List<String> itemNames = new ArrayList<String>();
        for (WebElement webElement : itemNameList) {
            itemNames.add(webElement.getText());
        }
        return itemNames;
    }

    public boolean itemPresentToCartByName(String itemName){
        boolean isProductPresent = false;
        for (WebElement webElement : itemNameList) {
            if (webElement.getText().equals(itemName)) {
                isProductPresent = true;
                break;
            }
        }
        return isProductPresent;
    }}
