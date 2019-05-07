package com.sangeetagupta.expensemanager;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sangeetagupta.expensemanager.data.ExpenseItem;
import com.sangeetagupta.expensemanager.database.AppExecutors;
import com.sangeetagupta.expensemanager.database.ExpenseAppDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AddExpenseActivity extends AppCompatActivity {

    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.quantity)
    EditText quantity;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.item_name)
    EditText itemName;
    private String expenseItemName;
    private float expenseItemPrice;
    private int expenseItemQuanity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        ButterKnife.bind(this);
        setListeners();
    }

    public void setListeners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseItemName = itemName.getText().toString();
                expenseItemQuanity = Integer.parseInt(quantity.getText().toString());
                expenseItemPrice = Float.parseFloat(price.getText().toString());

                onAddButtonClick(expenseItemName, expenseItemQuanity, expenseItemPrice);

                Toast.makeText(getApplicationContext(), expenseItemName + expenseItemQuanity + expenseItemPrice, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onAddButtonClick(final String expenseItemName, final int expenseItemQuanity, final float expenseItemPrice) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {

            String expenseItemDate = "";
            final ExpenseItem expenseItem = new ExpenseItem(expenseItemName, expenseItemPrice, expenseItemDate, expenseItemQuanity);

            @Override
            public void run() {
                ExpenseAppDatabase.getInstance(AddExpenseActivity.this).expenseItemDao().insertExpenseItem(expenseItem);
                Log.i("Database insert: ", "Successful!");
                finish();
            }
        });
    }
}
