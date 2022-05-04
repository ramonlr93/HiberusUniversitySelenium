package com.hiberus.university.selenium.model;

public class InventoryItem {

  private String name;
  private String description;
  private String price;

  public InventoryItem(String name, String description, String price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public InventoryItem(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
