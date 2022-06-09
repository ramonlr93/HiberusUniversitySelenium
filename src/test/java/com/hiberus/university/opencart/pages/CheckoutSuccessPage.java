package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutSuccessPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/success";

    @FindBy(xpath = "//ul[@class='breadcrumb']/descendant::a[text()='Shopping Cart']")
    private WebElement checkoutSuccessLink;

    @FindBy(xpath = "//div[@class='buttons']/descendant::div[@class='pull-right']/descendant::a[text()='Continue']")
    private WebElement continueButton;

    CheckoutSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinue() {
        log.info("clicking...");
        try {
            continueButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return checkoutSuccessLink;
    }

}