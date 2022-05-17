package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete extends AbstractPage {

    @FindBy(className = "title")
    private WebElement checkoutCompleteMessage;

    @FindBy(className = "complete-text")
    private WebElement completedOrder;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    CheckoutComplete(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public String getCheckoutCompleteMessage() {
        return checkoutCompleteMessage.getText();
    }

    public String getCompletedOrderText() {
        return completedOrder.getText();
    }

    public void backToProducts() {
        backToProductsButton.click();
    }

}
