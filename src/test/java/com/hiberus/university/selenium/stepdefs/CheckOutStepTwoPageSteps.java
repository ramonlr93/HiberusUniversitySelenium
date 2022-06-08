package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
public class CheckOutStepTwoPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    private CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();


}
