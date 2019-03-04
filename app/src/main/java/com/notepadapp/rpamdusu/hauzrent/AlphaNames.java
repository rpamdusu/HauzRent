package com.notepadapp.rpamdusu.hauzrent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class AlphaNames extends SQLiteOpenHelper   {

    
     public static final String CLIENTDATABASE_NAME = "clientNames.db";
     public static final String CLIENT_TABLLE = "clientNames_Table";
     public static final String COL_1 = "ID";
     public static final String COL_2 = "FIRST_NAME";
     public static final String COL_3 = "SURNAME";
     public static final String COL_4 = "EMAIL";
     public static final String COL_5 = "PASSWORD";

     public  static final int DATABASE_VERSION = 1;


    public AlphaNames( Context context) {
        super(context, CLIENTDATABASE_NAME, null, 1);
        //for logging
        SQLiteDatabase db = this.getWritableDatabase();



    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+CLIENT_TABLLE+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT UNIQUE NOT NULL,SURNAME TEXT UNIQUE NOT NULL," +
                "EMAIL TEXT UNIQUE NOT  NULL, PASSWORD TEXT UNIQUE NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method sub
    db.execSQL("DROP TABLE  IF EXISTS users"+CLIENTDATABASE_NAME);
   // create fresh books table
    onCreate(db);
    }

    public boolean insertData(String first_name,String surname,String email,String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,first_name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5, password);
        long result = db.insert(CLIENTDATABASE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+CLIENTDATABASE_NAME,null);
        return res;
    }
    public boolean updateData(String id,String first_name,String surname,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,first_name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5, password);

        db.update(CLIENTDATABASE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLIENTDATABASE_NAME, "ID = ?",new String[] {id});
    }

}

