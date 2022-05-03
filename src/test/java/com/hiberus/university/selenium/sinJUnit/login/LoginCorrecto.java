package com.hiberus.university.selenium.sinJUnit.login;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.WebDriver;

public class LoginCorrecto {

    private static WebDriver driver;

    public static void main(String args[]) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);

        boolean correcto = driver.getCurrentUrl().equals(Consts.PAGINA_INVENTARIO);

        System.out.println("Login " + (correcto ? "correcto" : "incorrecto"));

        driver.close();
    }

}
