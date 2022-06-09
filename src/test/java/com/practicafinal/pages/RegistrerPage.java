package com.practicafinal.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrerPage extends BasePage  {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "account")
    private WebElement fieldSet;

    @FindBy(xpath = "//input[@class='form-control']")
    private List<WebElement> fieldsForm;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement acceptPrivacy;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    RegistrerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return fieldSet;
    }

    public void fillFields (DataTable data){
        List<String> dataForm = data.asList(String.class);
        for(int i=0;i<fieldsForm.size();i++){
            fieldsForm.get(i).click();
            fieldsForm.get(i).sendKeys(dataForm.get(i));
        }
    }

    public void register (){
        acceptPrivacy.click();
        continueButton.click();
    }

    public boolean wrongRegistration(){
        return errorMessage.isDisplayed();
    }
}
