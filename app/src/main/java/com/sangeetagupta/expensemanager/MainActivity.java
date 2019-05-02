package com.sangeetagupta.expensemanager;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sangeetagupta.expensemanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setListeners();
    }

    public void initialize(){
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
    }

    public void setListeners(){
        activityMainBinding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });
        activityMainBinding.addSavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddSavingsActivity.class);
                startActivity(intent);
            }
        });
        activityMainBinding.balanceAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BalanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
