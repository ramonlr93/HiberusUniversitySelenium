package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ProductPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=57";

    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=product/product&path=57&product_id=49']")
    private static WebElement productLink;

    //public static final String TEXT_PRODUCT_TEXT = productLink.getText();

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add') and contains(@onclick, '49')]")
    private WebElement addToCartTableButton;

    @FindBy(id = "cart-total")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=checkout/checkout']")
    private WebElement checkOutButton;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return checkOutButton;
    }


    public void clickAddToCart() {
        log.info("Adding to cart...");
        try {
            addToCartTableButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout adding to cart: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking adding to cart, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickCartButton() {
        log.info("Clicking to cart...");
        try {
            cartButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking to cart: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking clicking to cart, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickCheckOut() {
        log.info("CheckOut...");
        try {
            checkOutButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout checkOut: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking checkout, caught exception, type=" + e.getClass().getSimpleName());
        }
    }
}