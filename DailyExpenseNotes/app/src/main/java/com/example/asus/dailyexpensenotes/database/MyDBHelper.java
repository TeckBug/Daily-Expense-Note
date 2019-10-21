package com.example.asus.dailyexpensenote.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "daily_expense_note_db";
    private static final int VERSION = 3;

    private static final String TABLE_NAME = "expense";
    private static final String ID = "id";
    private static final String EXPENSE_TYPE = "expense_type";
    private static final String EXPENSE_AMOUNT = "expense_amount";
    private static final String EXPENSE_DATE = "expense_date";
    private static final String EXPENSE_TIME = "expense_time";
    private static final String EXPENSE_IMAGE = "expense_image";

    private static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+EXPENSE_TYPE+" TEXT, "+EXPENSE_AMOUNT+" TEXT, "+EXPENSE_DATE+" TEXT, "+EXPENSE_TIME+" TEXT,"+EXPENSE_IMAGE+" TEXT) ";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
