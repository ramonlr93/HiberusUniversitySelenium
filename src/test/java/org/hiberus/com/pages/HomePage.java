package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends BasePage{

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//i[@class='fa fa-user']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    private WebElement registerSelectOption;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")
    private WebElement loginSelectOption;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginSelectOption;
    }

    public void clickMyAccountButton() {
        log.info("MyAccount click...");
        try {
            myAccountButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking myAccount: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking myAccount, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickLoginSelectOption(){
        log.info("Login click...");
        try {
            loginSelectOption.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickRegisterSelectOption(){
        log.info("Register click...");
        try {
            registerSelectOption.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking register: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking register, caught exception, type=" + e.getClass().getSimpleName());
        }
    }


}
