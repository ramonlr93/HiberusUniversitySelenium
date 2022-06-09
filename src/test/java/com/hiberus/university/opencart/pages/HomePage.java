package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(id = "common-home")
    private WebElement homeContainer;

    @FindBy(xpath = "//ul[@class='list-inline']/descendant::li[@class='dropdown']")
    private WebElement myAccountButton;


    @FindBy(xpath = "//ul[@class='list-inline']/descendant::span[@class='hidden-xs hidden-sm hidden-md' and text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@id='logo']/descendant::a[text()='Your Store']")
    private WebElement yourStoreLink;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    private WebElement registerLink;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' and text()=' Success: You have added ']")
    private WebElement productAddedConfirmationMessage;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement items;

    public int getItemCount() {
        String itemsNum = items.getText();
        String itemCount = itemsNum.substring(0, 1).trim();
        return Integer.parseInt(itemCount);
    }

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLink() {
        log.info("clicking...");
        try {
            registerLink.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking registerLink: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking registerLink, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickLoginLink() {
        log.info("clicking...");
        try {
            loginLink.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking loginLink: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking loginLink, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickMyAccountButton() {
        log.info("clicking...");
        try {
            myAccountButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking myAccountButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking myAccountButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickCheckoutButton() {
        log.info("clicking...");
        try {
            checkoutButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking checkoutButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking checkoutButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickYourStoreLink() {
        log.info("clicking...");
        try {
            yourStoreLink.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking yourStoreLink: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking yourStoreLink, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void addItemToCartByName(String itemName) {
        String xpath =
                String.format("//a[contains(., '%s')]/parent::h4/parent::div/following-sibling::div/button/span",
                        itemName);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public boolean productAddedConfirmation() {
        return productAddedConfirmationMessage.isDisplayed();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return homeContainer;
    }
}