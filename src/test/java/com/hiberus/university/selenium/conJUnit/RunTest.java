package com.hiberus.university.selenium.conJUnit;

import com.hiberus.university.selenium.conJUnit.inventory.TestInventory;
import com.hiberus.university.selenium.conJUnit.login.TestLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLogin.class,
        TestInventory.class
})
public class RunTest {
}
