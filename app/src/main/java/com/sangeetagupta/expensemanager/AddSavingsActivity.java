package com.sangeetagupta.expensemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddSavingsActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.add_amount_edit_text)
    EditText addAmountEditText;
    private float savingsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings);
        ButterKnife.bind(this);
        setListeners();
    }

    public void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savingsAmount = Float.parseFloat(addAmountEditText.getText().toString());
            }
        });
    }
}
