package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class WithEmailAndPasswordPage extends BasePage{


    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    WithEmailAndPasswordPage(WebDriver driver) {
        super(driver);
    }

    public WithEmailAndPasswordPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public WithEmailAndPasswordPage enterPassword(String username) {
        passwordInput.clear();
        passwordInput.sendKeys(username);
        return this;
    }
}
