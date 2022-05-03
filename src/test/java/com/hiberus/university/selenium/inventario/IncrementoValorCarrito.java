package com.hiberus.university.selenium.inventario;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncrementoValorCarrito {
    private static WebDriver driver;
    public static void main(String[] args) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(driver, Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);
        Metodos.quitarElementosCarro(driver);

        WebElement boltTShirtButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_BOLT_TSHIRT));
        boltTShirtButton.click();

        WebElement carritoElement = driver.findElement(By.className(Consts.CLASS_SHOPPING_CART));

        boolean hay1ElementoCarro = false;
        try {
            hay1ElementoCarro = carritoElement.findElement(By.xpath("//span")).getText().equals("1");
        } catch (Exception e) {
            System.out.println("PRUEBA FALLIDA: No se ha añadido correctamente el elemento al carro");
            driver.close();
            return;
        }

        if (hay1ElementoCarro)
            System.out.println("PRUEBA PASADA: Se ha añadido correcatamente en el carro");
        else
            System.out.println("PRUEBA FALLIDA: Hay un número distinto a 1 en el carrito");

        driver.close();
    }
}
