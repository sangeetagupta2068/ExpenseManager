package com.sangeetagupta.expensemanager;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sangeetagupta.expensemanager.adapter.ExpenseItemAdapter;
import com.sangeetagupta.expensemanager.data.ExpenseItem;
import com.sangeetagupta.expensemanager.database.ExpenseViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExpenseListActivity extends AppCompatActivity {

    public static List<ExpenseItem> expenseItems;
    ExpenseItemAdapter expenseItemAdapter;
    RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.flag_text_view)
    TextView flagTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {

        expenseItems = new ArrayList<>();

        layoutManager = new LinearLayoutManager(this);

        expenseItemAdapter = new ExpenseItemAdapter();
        expenseItemAdapter.notifyDataSetChanged();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(expenseItemAdapter);

        setUpViewModel();

    }

    private void displayViews() {
        if (expenseItems.size() == 0) {
            recyclerView.setVisibility(View.INVISIBLE);
            flagTextView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            flagTextView.setVisibility(View.INVISIBLE);
        }

    }

    private void setUpViewModel() {
        ExpenseViewModel expenseViewModel = ViewModelProviders.of(this).get(ExpenseViewModel.class);
        expenseViewModel.getExpenseItems().observe(this, new Observer<List<ExpenseItem>>() {
            @Override
            public void onChanged(@Nullable List<ExpenseItem> expenseItemList) {
                expenseItems.clear();
                expenseItems = (ArrayList) expenseItemList;
                displayViews();
            }
        });
    }

}
