package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends AbstractPage{

    public static final String PAGE_URL = "https://www.saucedemo.com/inventory";

    @FindBy(xpath = "//div[@class='inventory_item_description']") //
    private List<WebElement> inventoryItems;

    @FindBy (xpath = "//select[@class='product_sort_container']")
    private WebElement sortProductButton; // Podría ser un List ***


    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return sortProductButton;
    }

    public void clickAddToCartButton (String itemName){
        for (WebElement elm:inventoryItems){
            elm.findElement(By.xpath("//button[contains(@id='add-"+itemName+"')]")).click();
        }
    }

    public void clickRemoveButton (String itemName){
        for (WebElement elm:inventoryItems){
            elm.findElement(By.xpath("//button[contains(@id='remove-"+itemName+"')]")).click();
        }
    }


    public void sortItemsBy(String order){
        sortProductButton.click();
        sortProductButton.findElement(By.xpath("//option[@value='"+order+"'])"));
    }

}
