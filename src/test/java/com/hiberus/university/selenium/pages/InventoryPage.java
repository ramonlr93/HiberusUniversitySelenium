package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryContainer;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private WebElement selectOptions;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryNameList;

    @FindBy(xpath = "//button[contains(@id, 'add-to-cart')]")
    private List<WebElement> btnAddToCart;

    @FindBy(xpath = "//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']")
    private List<WebElement> itemPrices;

    @FindBy(xpath = "//div[@class='cart_item']")
    List<WebElement> cartElements;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return selectOptions;
    }

    public void addItemToCartByName(String itemName) {
        String xpath = getButton(itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void removeItemFromCartByName(String itemName) {
        String xpath = "//div[contains(., '" + itemName + "')]/parent::a/parent::div//button";
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    private String getButton(String itemName) {
        return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
    }

    public void clickOnShoppingCart() {
        shoppingCart.click();
    }

    public void selectOption(String option) {
        Select selectOption = new Select(selectOptions);
        selectOption.selectByValue(option);
    }

    public List<WebElement> getItemList() {
        return inventoryContainer;
    }

    public List<WebElement> getInventoryItems() {
        return inventoryNameList;
    }

    public List<String> getInventoryItemsName() {
        List<String> names = new ArrayList<>();
        for (WebElement e : inventoryNameList) {
            names.add(e.getText());
        }
        return names;
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<Double>();
        for (WebElement itemPrice : itemPrices) {
            prices.add(Double.parseDouble(itemPrice.getText().substring(1)));
        }
        return prices;
    }

    public int getInventoryListSize() {
        return inventoryContainer.size();
    }

    public boolean isItemVisible(String name) {
        try {
            for (WebElement elem : inventoryNameList) {
                if (elem.getText().equalsIgnoreCase(name) && elem.isDisplayed()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getCartListSize() {
        return cartElements.size();
    }


}
