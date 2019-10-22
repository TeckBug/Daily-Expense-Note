package com.example.asus.dailyexpensenotes.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.dailyexpensenotes.R;
import com.example.asus.dailyexpensenotes.model_class.Expense;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<Expense> expenseList;
    private Context context;
    private TextView expenseType,expenseAmount,expenseDate,expenseTime;
    private Button showDocumentBtn;

    public ExpenseAdapter() {

    }

    public ExpenseAdapter(List<Expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_design,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final Expense expense = expenseList.get(position);

        viewHolder.expenseTypeTV.setText(expense.getExpenseType());
        viewHolder.expenseDateTV.setText(expense.getExpenseDate());
        viewHolder.expenseAmountTV.setText(expense.getExpenseAmount());
        
    }


    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView expenseTypeTV,expenseDateTV,expenseAmountTV;
        private ImageView moreIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            expenseTypeTV = itemView.findViewById(R.id.expenseTypeTVId);
            expenseDateTV = itemView.findViewById(R.id.expenseDateTVId);
            expenseAmountTV = itemView.findViewById(R.id.expenseAmountTVId);
            moreIV = itemView.findViewById(R.id.moreIVId);
        }
    }
}

