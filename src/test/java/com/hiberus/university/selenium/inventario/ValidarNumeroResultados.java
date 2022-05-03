package com.hiberus.university.selenium.inventario;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ValidarNumeroResultados {
    private static WebDriver driver;
    public static void main(String[] args) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(driver, Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver);
        List<WebElement> inventoryElements = driver.findElements(By.className(Consts.CLASS_INVENTORY_ITEM));

        if (inventoryElements.size() != 6)
            System.out.println(Consts.COLOR_VERDE + "PRUEBA PASADA: hay 6 elementos en la página");
        else
            System.out.println(Consts.COLOR_ROJO + "PRUEBA FALLIDA: no hay 6 elementos en la página");


        driver.close();
    }
}
