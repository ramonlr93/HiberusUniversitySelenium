package es.david.practica.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@title, 'My Account')]")
    private WebElement myAccount;

    @FindBy(xpath = "//a[text() = 'Login']")
    private WebElement login;


    BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickMyAccount(){
        wait.until(ExpectedConditions.visibilityOf(myAccount)).click();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOf(login)).click();
    }

}
