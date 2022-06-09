package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.utils.MyFluentWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.time.temporal.ChronoUnit;

@Slf4j
public abstract class BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    protected Wait<WebDriver> wait;
    private final WebDriver driver;

    @FindBy(xpath = "//i[contains(@class,'fa-user')]")
    private WebElement myAcounts;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(linkText = "Shopping Cart")
    private WebElement cartLink;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new MyFluentWait<>(driver)
                .withTimeout(60, ChronoUnit.SECONDS)
                .pollingEvery(2, ChronoUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public abstract WebElement getPageLoadedTestElement();

    protected WebDriver getDriver() {
        return driver;
    }

    protected Wait<WebDriver> getWait() {
        return wait;
    }

    protected void setWait(Wait<WebDriver> wait) {
        this.wait = wait;
    }

    public void waitForPageLoad() {
        WebElement testElement = getPageLoadedTestElement();
        wait.until(ExpectedConditions.visibilityOf(testElement));
    }

    protected void moveTo(WebElement elem) {
        if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
        } else {
            Actions actions = new Actions(driver);
            actions.moveToElement(elem).build().perform();
        }
    }

    protected boolean isPageLoaded(WebElement elem) {
        boolean isLoaded = false;

        try {
            isLoaded = elem.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return isLoaded;
    }

    public void navigateTo(String url) {
        WebDriver driver = getDriver();

        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            if (e instanceof TimeoutException) {
                log.info("Timeout loading home page");
            } else if (e instanceof ScriptTimeoutException) {
                log.info("Script Timeout loading home page");
            } else {
                log.error(e.getMessage());
            }
        }
    }

    public void goToRegister() {
        myAcounts.click();
        registerLink.click();
    }

    public void goToLogin() {
        myAcounts.click();
        loginLink.click();
    }

    public void logout() {
        myAcounts.click();
        logoutLink.click();
    }

    public void goToShoppingCart() {
        cartLink.click();
    }
}
