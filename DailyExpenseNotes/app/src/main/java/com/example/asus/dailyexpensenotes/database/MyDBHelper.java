package com.example.asus.dailyexpensenotes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.asus.dailyexpensenotes.model_class.Expense;

import java.util.ArrayList;

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
        try {
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public long insertDataToDatabase(String expenseType,String expenseAmount,String expenseDate,String expenseTime,String stringImage){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(EXPENSE_TYPE,expenseType);
        contentValues.put(EXPENSE_AMOUNT,expenseAmount);
        contentValues.put(EXPENSE_DATE,expenseDate);
        contentValues.put(EXPENSE_TIME,expenseTime);
        contentValues.put(EXPENSE_IMAGE,stringImage);

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return rowId;
    }

    public Cursor getDataFromDatabase(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        return cursor;
    }

    public Cursor getData(String sql) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }

}
