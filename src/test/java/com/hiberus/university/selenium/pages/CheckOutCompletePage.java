package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(className = "title")
    private WebElement textTitleItem;

    @FindBy(className = "complete-header")
    private WebElement textHeaderItem;

    @FindBy(className = "complete-text")
    private WebElement textCompleteItem;

    @FindBy(className = "pony_express")
    private WebElement imgItem;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    CheckOutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return textTitleItem;
    }

    public String getTitleText() {
        return textTitleItem.getText();
    }

    public String getHeaderText() {
        return textHeaderItem.getText();
    }

    public String getCompleteText() {
        return textCompleteItem.getText();
    }

    public boolean textCompleteIsPresent(){
        return textCompleteItem.isDisplayed();
    }

    public void clickBackHome(){
        backHomeButton.click();
    }

    public boolean hasImgItem(){
        return imgItem.isDisplayed();
    }

}
