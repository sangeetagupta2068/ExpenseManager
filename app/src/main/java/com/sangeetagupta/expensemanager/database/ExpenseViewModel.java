package com.sangeetagupta.expensemanager.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sangeetagupta.expensemanager.data.ExpenseItem;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private static final String TAG = ExpenseViewModel.class.getSimpleName();

    private LiveData<List<ExpenseItem>> expenseItems;

    public ExpenseViewModel(Application application) {
        super(application);
        ExpenseAppDatabase database = ExpenseAppDatabase.getInstance(this.getApplication());
        expenseItems = database.expenseItemDao().loadAllExpenseItems();
    }

    public LiveData<List<ExpenseItem>> getExpenseItems() {
        return expenseItems;
    }
}
