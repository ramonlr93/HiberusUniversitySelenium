package com.hiberus.university.selenium.utils;

public enum NavBar {
    PHONE("fa-phone"),
    MY_ACCOUNT("fa-user"),
    WISH_LIST("fa-hearth"),
    SHOPPING_CART("fa-shopping-cart"),
    CHECKOUT("fa-share");

    public final String value;
    NavBar(String value) {
        this.value = value;
    }
}
