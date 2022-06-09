package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class SuccessAcountPage extends BasePage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=account/success";

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/account']")
    private WebElement continueButton;

    public SuccessAcountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void clickContinueButton() {
        log.info("Clicks on continue button...");
        try {
            continueButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    //https://opencart.abstracta.us/index.php?route=account/account
}
