package com.hiberus.university.selenium.run.run;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testArraysEquals()  {
        String[] nombresEsperados = {"Manuel", "Manolo"};
        String[] nombresActuales = {"Manuel", "Manolo"};

        Assert.assertArrayEquals("FALLO - NO SON LOS MISMOS ARRAYS", nombresEsperados, nombresActuales);

    }
    @Test
    public void testEquals()  {
          Assert.assertEquals("FALLO - NO SON LOS MISMOS VALORES", (1 +1), 2);
        }

     @Test
    public void testFalse()  {
        //boolean input = false;
        Assert.assertTrue( "FALLO - NO SON LOS MISMOS VALORES", true);
        //Assert.assertTrue( "asasassdasdasda" input);
        Assert.assertTrue( "FALLO - NO SON LOS MISMOS VALORES", false);


        //@Test
            //            public void testFirst()throws InterruptedException {
            //        String[] nombreEsperados = {"Manuel", "M"};
            //        String[] nombreActuales = {"Manuel", "Manolo"};
            //        Assert.assertArrayEquals("FALLO - NO SON LOS MISMOS ARRAYS", nombreEsperados, nombreActuales);
            //    }
            //@Test
            //public void testEquals()throws InterruptedException {
            //        Assert.assertEquals("FALLO - NO SON LOS MISMOS ARRAYS", (1 +1), 2);
            //}
            //@Test
            //public void testFalse()throws InterruptedException {
            //    boolean input = true;
            //    Assert.assertFalse("FALLO - NO SON LOS MISMOS ARRAYS", !input);

        }
}
