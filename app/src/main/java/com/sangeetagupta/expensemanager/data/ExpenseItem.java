package com.sangeetagupta.expensemanager.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "expense_table")
public class ExpenseItem {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int itemId;

    private String itemName;
    private float itemPrice;
    private String itemTime;
    private int itemQuantity;

    public ExpenseItem(String itemName, float itemPrice, String itemTime, int itemQuantity) {
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

    public void setItemTime(Date d) {
        //todo item
    }
}
