package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamerasStore extends BasePage {
    public CamerasStore(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add') and contains(@onclick, '30', '1')]")
    private WebElement canonEOS;


    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickAddToCArt() {
        super.click(canonEOS);
    }
}
