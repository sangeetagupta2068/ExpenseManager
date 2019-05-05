package com.sangeetagupta.expensemanager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sangeetagupta.expensemanager.data.ExpenseItem;
import com.sangeetagupta.expensemanager.databinding.ExpenseItemBinding;

import java.util.List;

public class ExpenseItemAdapter extends RecyclerView.Adapter<ExpenseItemAdapter.ExpenseItemViewHolder> {

    private List<ExpenseItem> expenseItemList;

    public ExpenseItemAdapter(List<ExpenseItem> expenseItems) {
        this.expenseItemList = expenseItems;
    }

    @NonNull
    @Override
    public ExpenseItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ExpenseItemBinding expenseItemBinding = ExpenseItemBinding.inflate(layoutInflater, viewGroup, false);
        return new ExpenseItemViewHolder(expenseItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseItemViewHolder expenseItemViewHolder, int i) {
        expenseItemViewHolder.setExpenseItemBinding(expenseItemList.get(i));
    }

    @Override
    public int getItemCount() {
        return expenseItemList.size();
    }

    public class ExpenseItemViewHolder extends RecyclerView.ViewHolder {

        ExpenseItemBinding expenseItemBinding;

        public ExpenseItemViewHolder(@NonNull ExpenseItemBinding expenseItemBinding) {
            super(expenseItemBinding.getRoot());
            this.expenseItemBinding = expenseItemBinding;

        }

        public void setExpenseItemBinding(ExpenseItem expenseItem) {
            expenseItemBinding.itemNameQuantity.setText(expenseItem.getItemName());
            expenseItemBinding.itemPrice.setText(String.valueOf(expenseItem.getItemPrice()));
            expenseItemBinding.itemPrice.setText(expenseItem.getItemTime());
            expenseItemBinding.executePendingBindings();
        }
    }

}
