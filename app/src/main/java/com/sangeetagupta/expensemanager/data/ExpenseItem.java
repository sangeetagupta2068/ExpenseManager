package com.sangeetagupta.expensemanager.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
        return itemName;
    }
    public float getItemPrice() {
        return itemPrice;
    }
    public String getItemTime() {
        return itemTime;
    }
    public int getItemQuantity(){ return itemQuantity;}
    public int getItemId(){ return itemId; }

    public void setItemId(int itemId) {this.itemId = itemId;}
    public void setItemPrice(int itemPrice) {this.itemPrice = itemPrice;}
    public void setItemTime(String itemTime){this.itemTime = itemTime;}
    public void setItemQuantity(int itemQuantity){this.itemQuantity = itemQuantity;}
    public void setItemName(String itemName) {this.itemName = itemName;}
}
