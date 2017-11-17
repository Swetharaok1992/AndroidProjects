package com.example.swetharao.assignment6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by swetha rao on 4/12/2017. This class helps to create a table in the database.
 */

public class MyDatabaseCreator extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";

    public MyDatabaseCreator(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
/* create a table with the following columns*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Employees(name VARCHAR(100),age VARCHAR(3), colors VARCHAR(50), diet VARCHAR(40),food VARCHAR(50), food2 VARCHAR(50), gender VARCHAR(40), salary VARCHAR(60));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      onCreate(sqLiteDatabase);
    }
}
