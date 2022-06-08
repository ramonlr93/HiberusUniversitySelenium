package com.opencart.utils;

public class Enums {
    public interface FilterOptionList {
        String value();
    }

    public enum HomePageItems {
        product_43("MacBook"),
        product_40("iPhone"),
        product_42("Apple Cinema 30\""),
        product_30("Canon EOS 5D"),
        product_49("Samsung Galaxy Tab 10.1");

        public final String value;

        HomePageItems(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum PaymentOptions {
        transfer("Bank Transfer"),
        cash("Cash On Delivery");

        public final String value;

        PaymentOptions(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


}

