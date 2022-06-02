package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.model.InventoryItem;
import java.util.ArrayList;
import java.util.List;

public class CheckoutContext {

  private static final List<InventoryItem> inventoryItemList = new ArrayList<>();

  public static void addItem(InventoryItem item) {
    inventoryItemList.add(item);
  }

  public static List<InventoryItem> getInventoryItemList() {
    return inventoryItemList;
  }
}
