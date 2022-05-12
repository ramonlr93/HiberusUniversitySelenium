package com.hiberus.university.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        loginSuiteTest.class,
        inventorySuiteTest.class,
        cartSuiteTest.class,
        checkoutSuiteTest.class,
        loginSuiteTest.class
})
public class RunTests
{
}
