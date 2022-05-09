package com.hiberus.university.selenium.run;

import com.hiberus.university.selenium.login.LoginSuiteTest;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuiteTest.class,
        InventarioSuiteTest.class,
})

public class RunTest {

}
