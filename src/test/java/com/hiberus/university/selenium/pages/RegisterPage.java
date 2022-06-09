package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-telephone")
    private WebElement telephonInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmImput;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override

    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void enterFirstName(String firstName){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void enterTelephone(String telephone){
        telephonInput.click();
        telephonInput.sendKeys(telephone);
    }

    public void enterConfirmPassword(String password){
        passwordConfirmImput.click();
        passwordConfirmImput.sendKeys(password);
    }

    public void checkedCheckbox(){
        checkbox.click();
    }

    public void clickContinue(){
        log.info("continued in ...");
        try{
            continueButton.submit();

        } catch (TimeoutException e){
            log.info("Timeout clicking continue: " + e.getClass().getSimpleName());
        } catch (Exception e){
            log.info("Clicking continue, caught exception, type: " + e.getClass().getSimpleName());
        }
    }
}
