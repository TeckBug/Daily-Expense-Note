package com.example.asus.dailyexpensenotes.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.recyclerview.widget.RecyclerView;
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

        //recycler view item click event to show details
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = LayoutInflater.from(context).inflate(R.layout.fragment_bottom_sheet, null);
                expenseType = view.findViewById(R.id.expenseTypeTVId);
                expenseAmount = view.findViewById(R.id.expenseAmountTVId);
                expenseDate = view.findViewById(R.id.expenseDateTVId);
                expenseTime = view.findViewById(R.id.expenseTimeTVId);
                showDocumentBtn = view.findViewById(R.id.showDocumentBtnId);

                expenseType.setText(expense.getExpenseType());
                expenseAmount.setText(expense.getExpenseAmount()+" BDT");
                expenseDate.setText(expense.getExpenseDate());

                //time empty checking
                if(expense.getExpenseTime() == null || expense.getExpenseTime().isEmpty()){
                    expenseTime.setText("No Time Added");
                }else {
                    expenseTime.setText(expense.getExpenseTime());
                }

                showDocumentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog builder = new Dialog(context);
                        View  view = LayoutInflater.from(context).inflate(R.layout.image_view_layout_design,null);
                        builder.setTitle("Document of "+expense.getExpenseType());
                        builder.setContentView(view);

                        ImageView imageView = view.findViewById(R.id.imageViewLayoutDesignId);
                        //image empty checking
                        if(expense.getExpenseImage() == null || expense.getExpenseImage().isEmpty()){
                            imageView.setImageResource(R.drawable.ic_assignment_black_24dp);
                        }else {
                            imageView.setImageBitmap(stringToBitmap(expense.getExpenseImage()));
                        }
                        builder.show();
                    }
                });

                BottomSheetDialog dialog = new BottomSheetDialog(context);
                dialog.setContentView(view);
                dialog.show();
            }
        });
    }

    private Bitmap stringToBitmap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
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

