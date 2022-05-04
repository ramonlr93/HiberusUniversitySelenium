package com.hiberus.university.selenium.run;

import com.hiberus.university.selenium.inventario.InventarioSuite;
import com.hiberus.university.selenium.login.LoginSuite;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuite.class,
        InventarioSuite.class,
})

public class RunTest {

}
