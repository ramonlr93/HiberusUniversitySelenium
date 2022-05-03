package com.hiberus.university.selenium.sinJUnit.inventario;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EliminarProductoCarrito {

    public static WebDriver driver;

    public static void main(String[] args) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);
        Metodos.quitarElementosCarro(driver);

        WebElement addOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_ONESIE));
        addOnesieButton.click();

        WebElement removeOnesieButton = driver.findElement(By.id(Consts.ID_BUTTON_REMOVE_ONESIE));
        removeOnesieButton.click();
        boolean hayElementosCarrito = false;

        try {
            // OBTENEMOS EL TEXTO DEL SPAN, QUE NO ESTA SI NO HAY SPAN SI NO TIENE ELEMENTOS EN EL CARRO
            // ENTONCES SI NO HAY ELEMENTOS EN EL CARRO PASARA POR EL CATCH SINO PONDRA LA VARIABLE hayElementosCarrito A TRUE,
            // QUE PARA QUE PASE LA PRUEBA ESA VARIABLE TIENE QUE ESTAR A FALSE
            driver.findElement(By.className(Consts.CLASS_SHOPPING_CART_NUMBER)).getText();
            hayElementosCarrito = true;
        } catch (Exception e) {}

        if (!hayElementosCarrito) // SI NO HAY ELEMENTOS EN EL CARRITO
            System.out.println(Consts.COLOR_VERDE + "PRUEBA PASADA: No hay icono cuando no hay elementos en el carrito");
        else
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: Si que se ve el icono sin tener elementos en el carrito");

        driver.close();
    }

}
