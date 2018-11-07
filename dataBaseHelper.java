package com.example.owner.cia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CIA.db";
    public static final String TABLE_NAME = "inventory_t";
    public static final String COL_1 = "item_id";
    public static final String COL_2 = "item_name";
    public static final String COL_3 = "location";
    public static final String COL_4 = "description";
    public static final String COL_5 = "condition";

    public dataBaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this. getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +COL_1 + "INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_2 +" TEXT, "+ COL_3 + "TEXT, "+ COL_4 +" TEXT, "+COL_5+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
