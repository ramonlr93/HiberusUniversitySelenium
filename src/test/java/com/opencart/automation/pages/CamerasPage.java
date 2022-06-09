package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamerasPage extends BasePage {
    public CamerasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]/div/div[2]/div[2]/button[1]")
    private WebElement cameraNikon;

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickAddToCartCameraNikkon() {
        click(cameraNikon);
    }

}
