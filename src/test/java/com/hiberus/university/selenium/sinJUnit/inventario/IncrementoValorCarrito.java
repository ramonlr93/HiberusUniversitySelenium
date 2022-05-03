package com.hiberus.university.selenium.sinJUnit.inventario;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncrementoValorCarrito {
    private static WebDriver driver;
    public static void main(String[] args) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);
        Metodos.quitarElementosCarro(driver);

        WebElement boltTShirtButton = driver.findElement(By.id(Consts.ID_BUTTON_ADD_BOLT_TSHIRT));
        boltTShirtButton.click();


        boolean hay1ElementoCarro = false;
        try {
            hay1ElementoCarro = driver.findElement(By.className(Consts.CLASS_SHOPPING_CART_NUMBER)).getText().equals("1");
        } catch (Exception e) {
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: No se ha añadido correctamente el elemento al carro");
            driver.close();
            return;
        }

        if (hay1ElementoCarro)
            System.out.println(Consts.COLOR_VERDE + "PRUEBA PASADA: Se ha añadido correcatamente en el carro");
        else
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: Hay un número distinto a 1 en el carrito");

        driver.close();
    }
}
