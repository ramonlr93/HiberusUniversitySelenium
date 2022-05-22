package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement itemName;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement itemDescription;

    @FindBy(className = "inventory_details_price")
    private WebElement itemPrice;

    @FindBy(className = "inventory_details_img")
    private WebElement imgItem;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    InventoryItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return imgItem;
    }

    public boolean hasImgItem(){
        return imgItem.isDisplayed();
    }

    public String getNameItem() {
        return itemName.getText();
    }

    public String getDescriptionItem() {
        return itemDescription.getText();
    }

    public String getPrice() {
        return itemPrice.getText();
    }

    public void clickBackHome(){
        backToProductsButton.click();
    }

}
