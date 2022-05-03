package com.hiberus.university.selenium;

import com.hiberus.university.selenium.Inventario.EliminarProductoCarrrito;
import com.hiberus.university.selenium.Inventario.IncrementoValorCarrito;
import com.hiberus.university.selenium.Inventario.ValidarNumeroResultados;
import com.hiberus.university.selenium.Inventario.VisibilidadBotonEliminarProductoCarrito;
import com.hiberus.university.selenium.Login.LoginCorrect;
import com.hiberus.university.selenium.Login.LoginIncorrect;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws InterruptedException{

        new LoginCorrect().test();
        new LoginIncorrect().test();
        new ValidarNumeroResultados().test();
        new IncrementoValorCarrito().test();
        new VisibilidadBotonEliminarProductoCarrito().test();
        new EliminarProductoCarrrito().test();

    }
}
