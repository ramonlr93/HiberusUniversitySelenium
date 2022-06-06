package com.opencart.support;

import com.opencart.model.InventoryItem;
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
