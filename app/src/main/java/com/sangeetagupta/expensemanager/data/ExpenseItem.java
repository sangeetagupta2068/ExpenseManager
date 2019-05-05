package com.sangeetagupta.expensemanager.data;

import java.util.Date;

public class ExpenseItem {
    private String itemName;
    private float itemPrice;
    private String itemTime;
    private int itemQuantity;

    public ExpenseItem(String itemName,float itemPrice, String itemTime, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemTime = itemTime;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName + " (" + itemQuantity + ")";
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(Date d){
        //todo item
    }
}
