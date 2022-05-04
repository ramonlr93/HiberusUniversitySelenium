/*package sinJUnit.login;

import static com.hiberus.university.selenium.constantes.Consts.*;
import static com.hiberus.university.selenium.constantes.Metodos.*;
import org.openqa.selenium.WebDriver;

public class LoginCorrecto {

    private static WebDriver driver;

    public static void main(String args[]) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = initDriver(PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        login(driver);

        boolean correcto = driver.getCurrentUrl().equals(PAGINA_INVENTARIO);

        System.out.println("Login " + (correcto ? "correcto" : "incorrecto"));

        driver.close();
    }

}
*/