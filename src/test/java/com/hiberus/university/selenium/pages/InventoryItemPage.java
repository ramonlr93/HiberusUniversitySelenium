package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryItemPage extends BasePage {

    @FindBy(xpath = "//select[@class='form-control']")
    List<WebElement> listSelects;
    @FindBy(id = "button-cart")
    WebElement buttonAddToCart;
    public InventoryItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return buttonAddToCart;
    }

    public void select(int index,int value){
        Select select = new Select(listSelects.get(index));
        select.selectByIndex(value);
    }
    public void clickAddToCart(){
        buttonAddToCart.click();
    }
}
