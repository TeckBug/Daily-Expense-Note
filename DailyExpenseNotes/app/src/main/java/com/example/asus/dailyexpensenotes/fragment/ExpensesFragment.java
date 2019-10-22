package com.example.asus.dailyexpensenotes.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.dailyexpensenotes.model_class.Expense;
import com.example.asus.dailyexpensenotes.adapter.ExpenseAdapter;
import com.example.asus.dailyexpensenotes.database.MyDBHelper;
import com.example.asus.dailyexpensenotes.R;
import com.example.asus.dailyexpensenotes.activity.AddDailyExpenseActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpensesFragment extends Fragment {

    private Spinner spinner;
    private String[] spinnerList;
    private ArrayAdapter<String> arrayAdapter;

    private TextView fromDateTV,toDateTV;
    private ImageView fromDateIV,toDateIV;

    private DatePickerDialog.OnDateSetListener mFromDateSetListener;
    private DatePickerDialog.OnDateSetListener mToDateSetListener;

    private FloatingActionButton fab;

    private String fromDate;

    public ExpensesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_expenses, container, false);

        init(view);

        getFromDate();

        getToDate();


        //floating action button actions here to add new expense
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddDailyExpenseActivity.class);
                startActivityForResult(intent,100);
            }
        });

        return view;
    }



    //set date to fromDate TextView by clicking from date icon
    private void getFromDate() {

        fromDateIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mFromDateSetListener,
                        year, month, day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.setTitle("Please select date");
                datePickerDialog.show();
            }
        });

        mFromDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                fromDate = dayOfMonth + "/" + month + "/" + year;
                fromDateTV.setText(fromDate);
            }
        };
    }

    //set date to toDate TextView by clicking to date icon
    private void getToDate() {

            toDateIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Calendar calendar = Calendar.getInstance();
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        int month = calendar.get(Calendar.MONTH);
                        int year = calendar.get(Calendar.YEAR);

                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                getActivity(),
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mToDateSetListener,
                                year, month, day
                        );

                        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        datePickerDialog.setTitle("Please select date");
                        datePickerDialog.show();

                }
            });

            mToDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                    String toDate = dayOfMonth + "/" + month + "/" + year;
                    toDateTV.setText(toDate);

                }
            };
    }



    //initialize all components
    private void init(View view) {

        spinner = view.findViewById(R.id.selectExpenseTypeSpinnerId);
        spinnerList = getResources().getStringArray(R.array.spinner_list);
        arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,spinnerList);
        spinner.setAdapter(arrayAdapter);

        fromDateTV = view.findViewById(R.id.fromDateTVId);
        toDateTV = view.findViewById(R.id.toDateTVId);
        fromDateIV = view.findViewById(R.id.fromDateIVId);
        toDateIV = view.findViewById(R.id.toDateIVId);

        fab = view.findViewById(R.id.fabId);
    }

}
