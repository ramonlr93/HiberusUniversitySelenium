package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainInventoryPage extends BasePage{
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";
    @FindBy(xpath = "//a[contains(text(), 'Phones & PDAs')]")
    WebElement mobileInventoryLink;
    MainInventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void clickOnPhonesAndPDAS(){
        mobileInventoryLink.click();
    }
    public String currentWeb(){
        return getDriver().getCurrentUrl();
    }
}