package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class StorePage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/account";


    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=product/category&path=57']")
    private WebElement tabletsButton;


    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return tabletsButton;
    }

    public void clickTabletsButton() {
        log.info("Clicks in tabletsButton...");
        try {
            tabletsButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking tabletsButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking tabletsButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }
}
