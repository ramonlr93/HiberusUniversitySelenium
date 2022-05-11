package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Slf4j
public class InventoryPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[@class='inventory-item']")
    private List<WebElement> itemList;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartElement;

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainerElement;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[contains(@id, 'add-to-cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(contains(@id, 'remove')]")
    private WebElement removeToCartButton;

    @FindBy(xpath = "//select[@class='product_sort_container']/option::*")
    private Select productSortContainerOption;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectFilter;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickOnShoppingCart() {
        shoppingCartElement.click();
    }

    /*
    public void addItemToCartByName01(String itemName) {
        String xpath =
                String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button",
                        itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void removeItemByName01(String itemName) {
        String xpath =
                String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button",
                        itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }
    */

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

    public void sortInventoryByNameDesc() {
        productSortContainerOption.selectByValue("az");
    }

    public void sortInventoryByNameAsc() {
        productSortContainerOption.selectByValue("za");
    }

    public void sortInventoryByPriceAsc() {
        productSortContainerOption.selectByValue("hilo");
    }

    public void sortInventoryByPriceDesc() {
        productSortContainerOption.selectByValue("lohi");

    }

    public void sortInventoryByValue(String value) {
        Select selectOptionOrder = new Select(selectFilter);
        selectOptionOrder.selectByValue(value);
    }

}
