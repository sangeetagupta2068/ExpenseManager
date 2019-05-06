package com.sangeetagupta.expensemanager;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sangeetagupta.expensemanager.data.ExpenseItem;
import com.sangeetagupta.expensemanager.database.AppExecutors;
import com.sangeetagupta.expensemanager.database.ExpenseAppDatabase;
import com.sangeetagupta.expensemanager.database.ExpenseViewModel;
import com.sangeetagupta.expensemanager.databinding.ActivityAddExpenseBinding;

public class AddExpenseActivity extends AppCompatActivity {

    private ActivityAddExpenseBinding activityAddExpenseBinding;
    private String expenseItemName;
    private float expenseItemPrice;
    private int expenseItemQuanity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setListeners();
    }

    public void initialize() {
        activityAddExpenseBinding = DataBindingUtil.setContentView(AddExpenseActivity.this, R.layout.activity_add_expense);
    }

    public void setListeners() {
        activityAddExpenseBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseItemName = activityAddExpenseBinding.itemName.getText().toString();
                expenseItemQuanity = Integer.parseInt(activityAddExpenseBinding.quantity.getText().toString());
                expenseItemPrice = Float.parseFloat(activityAddExpenseBinding.price.getText().toString());

                onAddButtonClick(expenseItemName,expenseItemQuanity,expenseItemPrice);

                Toast.makeText(getApplicationContext(), expenseItemName + expenseItemQuanity + expenseItemPrice, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onAddButtonClick(final String expenseItemName, final int expenseItemQuanity, final float expenseItemPrice){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {

            String expenseItemDate = "";
            final ExpenseItem expenseItem = new ExpenseItem(expenseItemName, expenseItemPrice,expenseItemDate,expenseItemQuanity);
            @Override
            public void run() {
                ExpenseAppDatabase.getInstance(AddExpenseActivity.this).expenseItemDao().insertExpenseItem(expenseItem);
                Log.i("Database insert: ", "Successful!");
                finish();
            }
        });
    }
}
