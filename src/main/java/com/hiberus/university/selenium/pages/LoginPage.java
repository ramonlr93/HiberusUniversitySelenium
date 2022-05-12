package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends AbstractPage{ // Extendemos de la abstractPage para tener toda su funcinoalidad
    public static final String PAGE_URL = "https://www.saucedemo.com";


    @FindBy(id = "user-name") // Se puede usar xpath, id, css...
            private WebElement usernameInput;

    @FindBy (id = "password")
            private WebElement passwordInput;

    @FindBy (id = "login-button")
            private WebElement loginButton;

    @FindBy (xpath = "//h3[@data-test='error']")
            private WebElement errorMessage;


    LoginPage(WebDriver driver) { // A la hora de incializar est página se la pasamos al PAgeFactory
        super(driver); // Primero metemos el super y luego hacemos lo que tengamos que hacer en cada página.
        PageFactory.initElements(driver, this);
    }

    @Override // Nos obliga a hacer override y el constructor de la clase
    public WebElement getPageLoadedTestElement() { // Esto queremos que nos devuelva si está cargada la página en base a un elemento, le pasamos uno cualqueira
        return loginButton; // Si está cargada nos devuelve el loginButton
    }

    public void enterPassword (String password){
        passwordInput.click(); // El click es por asegurarnos de que escribe ahí
        passwordInput.sendKeys(password);
    }

    public void enterUsername (String username){
        usernameInput.click();
        usernameInput.sendKeys(username);
    }

    public void clickLogin() {
        log.info("logging in..."); // Para usar el log.info necesitamos poner arriba antes de la clase lo del @s4lfj
        try { // Con esto nos curamos en salud por si hubiera un error al hacer clic en el login
            loginButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clkicking login caught exception type: " + e.getClass().getSimpleName());
        }
    }

    public boolean hasError(){
        return errorMessage.isDisplayed(); // si hay un error se ve en la pantalla, eso es lo que devolvemos.
    }
}
