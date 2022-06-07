package com.opencart.practicafinal.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/account";

    AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

}
