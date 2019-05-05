package com.sangeetagupta.expensemanager;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sangeetagupta.expensemanager.databinding.ActivityAddSavingsBinding;

public class AddSavingsActivity extends AppCompatActivity {

    private ActivityAddSavingsBinding activityAddSavingsBinding;
    private float savingsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setListeners();
    }

    public void initialize() {
        activityAddSavingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_savings);
    }

    public void setListeners() {
        activityAddSavingsBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savingsAmount = Float.parseFloat(activityAddSavingsBinding.addAmountEditText.getText().toString());
            }
        });
    }
}
