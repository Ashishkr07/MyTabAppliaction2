package com.example.ashish.mytabapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ashish on 1/8/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME ="mytable";
    public static final String DATABASE_NAME ="scheduler.db";
    public static final String COL1 ="ID";
    public static final String COL2 ="NAME";
    public static final String COL3 ="DATE";
    public static final String COL4 ="DETAILS";





    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1 );
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DATE TEXT,DETAILS,TEXT)");
    }


    public  boolean insertData(String name, String date, String details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,date);
        contentValues.put(COL4,details);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getallData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME,null);
        return cursor;
    }




    public int deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"NAME = ?",new String[] {id});

    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
