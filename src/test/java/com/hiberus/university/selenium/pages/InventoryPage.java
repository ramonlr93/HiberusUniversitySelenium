package com.hiberus.university.selenium.pages;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";
    public double finalPrice;
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryContainer;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private WebElement selectOptions;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(xpath = "//div[@class = 'inventory_item_price']")
    private List<WebElement> inventoryPriceList;

    @FindBy(xpath = "//button[text() = 'Remove']/parent::div/child::div")
    private List<WebElement> addedItemsPrice;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryNameList;

    @Override
    public WebElement getPageLoadedTestElement() {
        return selectOptions;
    }

    public void addItemToCartByName(String itemName) {
        String xpath = getButton(itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void removeItemToCartByName(String itemName) {
        String xpath = getButton(itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    private String getButton(String itemName) {
        return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
    }

    public void clickOnShoppingCart() {
        finalPrice = getPrcieofAddedItems();
        shoppingCart.click();

    }

    public void selectOption(String option) {
        Select selectOption = new Select(selectOptions); //El objeto Select lo usaremos para seleccionar un Select-option de la web
        selectOption.selectByValue(option);
    }

    public Boolean isItemDisplayed(String item) {

        boolean isProductPresent = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(item)) {
                isProductPresent = true;
                break;
            }
        }
        return isProductPresent;
    }

    public int getNumberProducts() {
        return products.size();
    }

    public List<WebElement> getItemList() {
        return inventoryContainer;
    }

    public List<WebElement> getInventoryNameList() {
        return inventoryNameList;
    }

    public List<WebElement> getInventoryPriceList() {
        return inventoryPriceList;
    }

    public List<WebElement> getRandomItemsByNumber() {
        List<WebElement> listaRandom = getItemList();
        Collections.shuffle(listaRandom);
        return listaRandom;
    }

    public double getPrcieofAddedItems() {
        double price = 0;
        for (int i = 0; i < addedItemsPrice.size(); i++) {
            price += Double.parseDouble(addedItemsPrice.get(i).getText().replace("$", "").trim());
        }
        return price;
    }
}


