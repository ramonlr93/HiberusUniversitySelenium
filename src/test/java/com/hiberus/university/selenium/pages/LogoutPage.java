package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    public static final String LOGOUT_PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/logout";

    @FindBy(xpath = "//div[@id='content']")
    private WebElement accountLogoutContainer;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return accountLogoutContainer;
    }
}

