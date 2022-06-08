package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[normalize-space()='Your Store']")
    private WebElement homeButton;

   @Override
    public WebElement getPageLoadedTestElement() {
        return homeButton;
    }

    public void clickOnHomeButton(){
        click(homeButton);
    }

}
