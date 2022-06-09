package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class AccountPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/account";

    @FindBy(id = "account-account")
    private WebElement accountContainer;


    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::li/descendant::a[text()='Logout']")
    private WebElement logoutButton;

    AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLogout() {
        log.info("clicking...");
        try {
            logoutButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking logoutButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking logoutButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return accountContainer;
    }

}
