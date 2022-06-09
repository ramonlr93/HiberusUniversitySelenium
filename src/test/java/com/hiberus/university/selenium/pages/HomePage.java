package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/";
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private WebElement myAccountComboBox;
    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    private WebElement registerSelection;
    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")
    private WebElement loginSelection;

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return registerSelection;
    }
    public void clicRegister() {
        log.info("Entering register page...");

        myAccountComboBox.click();
        registerSelection.click();
    }

    public void clicLogin(){
        log.info("Entering login page...");
        myAccountComboBox.click();
        loginSelection.click();
    }
    public String currentPage(){
        return getDriver().getCurrentUrl();
    }
}