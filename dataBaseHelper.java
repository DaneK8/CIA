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
    public boolean insertData(String item_name,String description ,String condition) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,item_name);
        contentValues.put(COL_4, description);
        contentValues.put(COL_5, condition);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
