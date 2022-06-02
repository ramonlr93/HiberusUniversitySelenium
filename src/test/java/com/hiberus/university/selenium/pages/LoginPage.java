package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name") //WebElement usernameImput = driver.findElement(driver.findElement(By.id("user-name"))
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordImput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override

    //Metodo de apoyo, se coge un elemento clave de la pagina para validar si estamos en la pagina correcta y cargada al 100%
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }

    public void enterUsername(String username){
        usernameInput.click();  //Algunas paginas necesita clicar en el recuadro para poder escribir
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordImput.click();
        passwordImput.sendKeys(password);
    }

    public void clickLogin(){
        log.info("logging in ...");
        try{
            loginButton.click();

        } catch (TimeoutException e){
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());
        } catch (Exception e){
            log.info("Clicking login, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public boolean hasUsernamePasswordError(){
        return errorMessage.isDisplayed();
    }

    //inventoryList.get(0).findElement(By.xpath(".//button"))

}
