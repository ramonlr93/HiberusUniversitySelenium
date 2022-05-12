package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwoPage extends AbstractPage{
    public static final String PAGE_URL = "https://saucedemo.com/checkout-step-two.html";

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement tax;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement total;

    @FindBy(id= "finish")
    private WebElement finishButton;

    public CheckOutStepTwoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return finishButton;
    }

    public String getItemTotal(){
        return itemTotal.getText();
    }

    public String getTax(){
        return tax.getText();
    }

    public String getTotal(){
        return total.getText();
    }

}
