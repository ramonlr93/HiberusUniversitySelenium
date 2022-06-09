package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//div[contains(@class, 'product-layout')]")
    private List<WebElement> featuredContainer;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement okMessage;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return featuredContainer.get(0);
    }

    public int getFeatureContainerSize(){
        return featuredContainer.size();
    }

    public boolean hasOkAddToCartProduct(){
        return okMessage.isDisplayed();
    }

    public void getAddToCartByName(String productName) {
        String xpath = String.format("//h4/a[contains(text(),'"+productName+"')]/../../../div[@class='button-group']/button[contains(@onclick, 'cart.add')]");
        clickButton(xpath);
    }

    private void clickButton(String xpath) {
        WebElement itemElement = getDriver().findElement(By.xpath(xpath));
        itemElement.click();
    }

}
