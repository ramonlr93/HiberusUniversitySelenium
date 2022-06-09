package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class OrderPlacedPage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/success";

    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']")
    private WebElement continueButton;


    public OrderPlacedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void clickContinueButton() {
        log.info("Clicks in continueButton...");
        try {
            continueButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

}