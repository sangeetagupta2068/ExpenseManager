package com.sangeetagupta.expensemanager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sangeetagupta.expensemanager.ExpenseListActivity;
import com.sangeetagupta.expensemanager.R;
import com.sangeetagupta.expensemanager.data.ExpenseItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpenseItemAdapter extends RecyclerView.Adapter<ExpenseItemAdapter.ExpenseItemViewHolder> {

    @NonNull
    @Override
    public ExpenseItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.expense_item, viewGroup, false);
        return new ExpenseItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseItemViewHolder expenseItemViewHolder, int i) {
        expenseItemViewHolder.setExpenseItem(ExpenseListActivity.expenseItems.get(i));
    }

    @Override
    public int getItemCount() {
        return ExpenseListActivity.expenseItems.size();
    }

    public class ExpenseItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_name_quantity) TextView itemNameQuantity;
        @BindView(R.id.item_price) TextView itemPrice;
        @BindView(R.id.item_time) TextView itemTime;

        View view;

        public ExpenseItemViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setExpenseItem(ExpenseItem expenseItem) {
            itemNameQuantity.setText(String.format("%s (%d)", expenseItem.getItemName(), expenseItem.getItemQuantity()));
            itemPrice.setText(String.valueOf(expenseItem.getItemPrice()));
            itemTime.setText(expenseItem.getItemTime());
        }
    }

}
