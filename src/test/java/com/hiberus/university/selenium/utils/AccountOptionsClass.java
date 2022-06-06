package com.hiberus.university.selenium.utils;


public class AccountOptionsClass {

    public interface AccountOptions {
        String value();
    }

    public enum LoggedAccount implements AccountOptions {
        MY_ACCOUNT("My Account"),
        ORDER_HISTORY("Order History"),
        TRANSACTIONS("Transactions"),
        DOWNLOADS("Downloads"),
        LOGOUT("Logout");

        private final String value;
        LoggedAccount(String value) {
            this.value = value;
        }
        @Override
        public String value() {
            return value;
        }
    }

    public enum UnLoggedAccount implements AccountOptions {
        REGISTER("Register"),
        LOGIN("Login");
        private final String value;
        UnLoggedAccount(String value) {
            this.value = value;
        }
        @Override
        public String value() {
            return value;
        }
    }
}
