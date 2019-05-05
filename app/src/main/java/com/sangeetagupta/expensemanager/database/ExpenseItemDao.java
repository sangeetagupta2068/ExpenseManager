package com.sangeetagupta.expensemanager.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.sangeetagupta.expensemanager.data.ExpenseItem;

import java.util.List;

@Dao
public interface ExpenseItemDao {

    @Query("SELECT * FROM expense_table")
    LiveData<List<ExpenseItem>> loadAllExpenseItems();

    @Insert
    void insertExpenseItem(ExpenseItem expenseItem);

}
