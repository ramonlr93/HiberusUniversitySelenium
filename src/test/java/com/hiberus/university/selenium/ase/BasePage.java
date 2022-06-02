package com.hiberus.university.selenium.ase;

import com.opencart.utils.MyFluentWait;
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

    protected Wait<WebDriver> wait;
    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'Currency')]//ancestor::button")
    private WebElement choseCurrency;

    @FindBy(xpath = "//div[@id='top-links']/ul/li[0]")
    private WebElement contactUs;
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropdown;

    @FindBy(xpath = "//div[@id='top-links']/ul/li[3]")
    private WebElement contactUs;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new MyFluentWait<>(driver)
                .withTimeout(10, ChronoUnit.SECONDS)
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

    public void clickGoToLogin() {
        myAccountDropdown.click();
        myAccountDropdown.findElement(By.xpath(".//a[text()='Register']")).click();

    }

    public void clickGoToRegister() {
        myAccountDropdown.click();
        myAccountDropdown.findElement(By.xpath(".//a[text()='Login']")).click();

    }


}