package com.practicafinal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy (xpath="//img[@class='img-thumbnail']")
    private List<WebElement> items;

    @FindBy (xpath="//button[@class='btn btn-danger']")
    private List<WebElement> deleteBtns;

    @FindBy (xpath="//h2[text()='What would you like to do next?']")
    private WebElement question;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public int numberOfItems(){
        return items.size()/2;
    }

    public void deleteOneItem(){
        deleteBtns.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
