package com.hiberus.university.selenium;

import com.hiberus.university.selenium.inventory.TestInventory;
import com.hiberus.university.selenium.login.TestLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLogin.class,
        TestInventory.class
})
public class RunTest {
}
