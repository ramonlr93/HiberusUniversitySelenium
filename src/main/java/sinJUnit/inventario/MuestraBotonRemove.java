/*package sinJUnit.inventario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MuestraBotonRemove {
    public static WebDriver driver;

    public static void main(String[] args) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.initDriver(Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);
        Metodos.quitarElementosCarro(driver);

        WebElement addOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        WebElement removeOnesieButton;
        try {
             removeOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_REMOVE_ONESIE));
        } catch (Exception e) {
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: No se ha encontrado el botón de quitar del carrito");
            driver.close();
            return;
        }

        if (removeOnesieButton.isDisplayed())
            System.out.println(Consts.COLOR_VERDE + "PRUEBA PASADA: Se ve el botón de quitar del carrito");
        else
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: No se ve el botón de quitar del carrito");

        driver.close();
    }

}*/
