package com.sangeetagupta.expensemanager;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sangeetagupta.expensemanager.adapter.ExpenseItemAdapter;
import com.sangeetagupta.expensemanager.data.ExpenseItem;
import com.sangeetagupta.expensemanager.databinding.ActivityExpenseListBinding;

import java.util.ArrayList;
import java.util.List;

public class ExpenseListActivity extends AppCompatActivity {

    List<ExpenseItem> expenseItemList;
    ExpenseItemAdapter expenseItemAdapter;
    ActivityExpenseListBinding expenseListBinding;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    public void initialize(){
        expenseItemList = new ArrayList<>();
        expenseItemList.add(new ExpenseItem("ABC",100.0F,"00:00",10));
        expenseItemList.add(new ExpenseItem("ABC",100.0F,"00:00",10));
        expenseItemList.add(new ExpenseItem("ABC",100.0F,"00:00",10));
        expenseItemList.add(new ExpenseItem("ABC",100.0F,"00:00",10));
        expenseItemList.add(new ExpenseItem("ABC",100.0F,"00:00",10));

        expenseListBinding = DataBindingUtil.setContentView(this,R.layout.activity_expense_list);

        if(expenseItemList.size() == 0 ||  expenseItemList == null){
            expenseListBinding.recyclerView.setVisibility(View.INVISIBLE);
            expenseListBinding.flagTextView.setVisibility(View.VISIBLE);
        } else{
            expenseListBinding.recyclerView.setVisibility(View.VISIBLE);
            expenseListBinding.flagTextView.setVisibility(View.INVISIBLE);
        }

        layoutManager = new LinearLayoutManager(this);

        expenseItemAdapter = new ExpenseItemAdapter(expenseItemList);
        expenseItemAdapter.notifyDataSetChanged();

        expenseListBinding.recyclerView.setLayoutManager(layoutManager);
        expenseListBinding.recyclerView.setAdapter(expenseItemAdapter);

    }
}
