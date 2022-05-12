package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class InventoryPage extends AbstractPage {
    public static final String PAGE_UTL = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(xpath = "//div[@class='shopping_cart_link']")
    private WebElement shoppingCartElement;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private WebElement inventoryContainerElement;

    @FindBy(xpath = "//slerct[data-test='product_sort_container']")
    private Select productSortContainerSelect;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return inventoryContainerElement;
    }

    public void addItemToCartByName(String itemName) {
        String xpath = String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button", itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void removeItemByName(String itemName) {
        String xpath = String.format("//div[contains(., '%s')]/parent::a/parent::div/following-sibling::div/button", itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void clickOnShoppingCart() {
        shoppingCartElement.click();
    }

    public void sortInventoryBy(String sort) {
       log.info("Sorting ...");
        try {
            productSortContainerSelect.selectByValue(sort);
            WebElement itemSelected = productSortContainerSelect.getFirstSelectedOption();
            itemSelected.click();
        }catch (TimeoutException e){
            log.info("Timeout clicking option: " + e.getClass().getSimpleName());
        }catch (Exception e){
            log.info("Clicking option, caught exception, type: " + e.getClass().getSimpleName());
        }
    }
}
