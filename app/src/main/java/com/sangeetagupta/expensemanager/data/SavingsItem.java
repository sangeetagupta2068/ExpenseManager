package com.sangeetagupta.expensemanager.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "savings_table", foreignKeys = @ForeignKey(entity = ExpenseItem.class, parentColumns = "itemId", childColumns = "expenseId", onDelete = CASCADE))
public class SavingsItem {
    private int amount;
    private String date;
    private int expenseId;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int savingsId;

    SavingsItem(int amount, String date, int savingsId, int expenseId) {
        this.amount = amount;
        this.date = date;
        this.savingsId = savingsId;
        this.expenseId = expenseId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(int savingsId) {
        this.savingsId = savingsId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
}
