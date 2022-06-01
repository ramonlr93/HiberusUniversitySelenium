package com.hiberus.university.selenium.pages;

import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.*;

public class InventoryPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    private WebElement hamburgerElem;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryContainer;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private WebElement selectOptions;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryNameList;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return selectOptions;
    }

    private String getButton(String itemName) {
        return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
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

    public void clickOnShoppingCart() {
        shoppingCart.click();
    }

    public int productsQuantityInCart() {
        if (StringUtils.isEmpty(shoppingCart.getText())) {
            return 0;
        } else {
            return Integer.parseInt(shoppingCart.getText());
        }
    }

    public void selectOption(String option) {
        Select selectOption = new Select(selectOptions);
        selectOption.selectByValue(option);
    }

    public List<String> sortedZtoAInventoryByname() {
        List<String> inventoryName = getInventoryName();
        Collections.sort(inventoryName);
        Collections.reverse(inventoryName);
        return inventoryName;
    }

    public List<WebElement> getItemList() {
        return inventoryContainer;
    }

    public List<String> getInventoryName() {
        List<String> productName = new ArrayList<>();
        for (WebElement name : inventoryNameList) {
            productName.add(name.getText());
        }
        return productName;
    }

    public void clickOnRandomProduct(int number) {
        if (number > 0 && number <= inventoryContainer.size()) {
            List<WebElement> randList = new ArrayList<>();
            for (WebElement elementInventoryContainer : inventoryContainer) {
                randList.add(elementInventoryContainer.findElement(By.xpath("./descendant::button[text()='Add to cart']")));
            }
            Collections.shuffle(randList);
            List<WebElement> subRandList = randList.subList(0, number);
            for (WebElement item : subRandList) {
                item.click();
            }
        } else {
            System.out.println("El numero de items debe ser mayor que cero y menor o igual que el tamaño del inventario");
        }
    }

    public boolean isItemContains(String itemName) {
        return getInventoryName().contains(itemName);
    }

    public List<Double> sortedProductHighToLowPrice() {
        List<WebElement> priceList = new ArrayList<>();
        for (WebElement price : inventoryContainer) {
            priceList.add(price.findElement(By.xpath("./descendant::div[@class='inventory_item_price']")));
        }
        List<Double> priceInventoryResultsLowToHigh = new ArrayList<>();
        for (WebElement number : priceList) {
            priceInventoryResultsLowToHigh.add(Double.parseDouble(number.getText().replace("$", "").trim()));
        }
        Collections.reverse(priceInventoryResultsLowToHigh);
        return priceInventoryResultsLowToHigh;
    }

    public List<Double> getProductPrice() {
        List<WebElement> priceList = new ArrayList<>();
        for (WebElement price : inventoryContainer) {
            priceList.add(price.findElement(By.xpath("./descendant::div[@class='inventory_item_price']")));
        }
        List<Double> priceInventoryResults = new ArrayList<>();
        for (WebElement number : priceList) {
            priceInventoryResults.add(Double.parseDouble(number.getText().replace("$", "").trim()));
        }
        Collections.sort(priceInventoryResults);
        return priceInventoryResults;
    }

    public void logout() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerElem)).click();
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }
    public int getNumberOfItems() {
        return inventoryNameList.size();
    }
}