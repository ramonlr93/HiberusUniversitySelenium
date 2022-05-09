package com.hiberus.university.selenium.inventario;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventarioSuite {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Primera línea");
    }

    @Test
    public void testArraysEquals() throws InterruptedException
    {
        String[] nombresEsperados = {"Manuel", "M"};
        String[] nombresActuales = {"Manuel", "Manolo"};

        System.out.println("Método de prueba @Test");
        Assert.assertArrayEquals( "FALLO - NO SON LOS MISMOS ARRAYS", nombresEsperados, nombresActuales );
    }

    @Test
    public void testEquals() throws InterruptedException
    {
        Assert.assertEquals( "FALLO - NO SON LOS MISMOS VALORES", (1 + 1), 1 );
    }
}
