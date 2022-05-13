package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Slf4j
public class InventoryPage extends AbstractPage{
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryContainerItem;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    private WebElement selectOptions;

    @FindBy(xpath = "//a[@class = 'shopping_cart_link']")
    private WebElement shoppingCartButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryNameList;

    InventoryPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return shoppingCartButton;
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

    public void clickShoppingCart(){
        shoppingCartButton.click();
    }

    //UNA MANERA FACIL DE HACER EL BOTON DE ORDENAR POR PRECIO O ALFABETICAMENTE
    public void selectOption(String option){
        Select selectOption = new Select(selectOptions);
        selectOption.selectByValue(option);
    }

    public int getInventoryCount(){
        return inventoryContainerItem.size();
    }

    public boolean isDisplayedItemByName(String itemName){
        WebElement itemElem;
        try{
            itemElem = getDriver().findElement(By.xpath(getButton(itemName)));
        }
        catch (NoSuchElementException e){
            return false;
        }
        return itemElem.isDisplayed();
    }

    public List<WebElement> getInventoryNameList() {
        return inventoryNameList;
    }
}
