package com.sangeetagupta.expensemanager;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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

    public void initialize(){
        activityAddExpenseBinding = DataBindingUtil.setContentView(AddExpenseActivity.this,R.layout.activity_add_expense);
    }

    public void setListeners(){
        activityAddExpenseBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseItemName = activityAddExpenseBinding.itemName.getText().toString();
                expenseItemQuanity = Integer.parseInt(activityAddExpenseBinding.quantity.getText().toString());
                expenseItemPrice = Float.parseFloat(activityAddExpenseBinding.price.getText().toString());

                Toast.makeText(getApplicationContext(), expenseItemName + expenseItemQuanity + expenseItemPrice,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
