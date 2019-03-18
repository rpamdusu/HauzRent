package com.notepadapp.rpamdusu.hauzrent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.sql.Date;

public class AlphaNames extends SQLiteOpenHelper   {

    
     public static final String CLIENTDATABASE_NAME = "clientNames.db";
     public static final String CLIENT_TABLLE = "clientNames_Table";
     public static final String COL_1 = "ID";
     public static final String COL_2 = "FIRST_NAME";
     public static final String COL_3 = "SURNAME";
     public static final String COL_4 = "EMAIL";
     public static final String COL_5 = "PASSWORD";

    private String CREATE_CLIENT_TABLE = "create Table"+CLIENT_TABLLE+"("+COL_1+"integer primary key"
            +COL_2+" text unique not null  "
            +COL_3+"long char unique not null"+ COL_4+" long string unique not null"
            + COL_5+"not null string ";


    protected static final String BREAD_TABLE = "PRIVATE_TABLE";
    protected static final String COL_6 = "BVN";
    protected static final String COL_7 = "ADDRESS";
    protected static final String COL_9 = "PHONE";

    private String CREATE_BREAD_TABLE = "create table"+BREAD_TABLE+"("+COL_6+"integer unique not null"
            +COL_7+"long string unique not null"
            + COL_9+"integer unique not null )";


    public static final String RENT_TABLE = "MONEY_TABLE";
    public static final String COL_10 = "RENT_DUE_DATE";
    public static final String COL_11 = "RENT_MONEY";
    public static final String COL_12 = "RENT_MONEY_MONTHLY";


    private String CREATE_RENT_TABLE = "create table"+ RENT_TABLE+"("+ COL_10+"Integer not null  unique"+
            COL_11+"integer not null unique"+COL_12+"integer not null unique)";
     public  static final int DATABASE_VERSION = 1;


    public AlphaNames( Context context) {
        super(context, CLIENTDATABASE_NAME, null, 1);
        //for logging


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLIENT_TABLE);
        db.execSQL(CREATE_BREAD_TABLE);
        db.execSQL(CREATE_RENT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method sub
    db.execSQL("DROP TABLE  IF EXISTS users"+CLIENTDATABASE_NAME);
   // create fresh books table
    onCreate(db);
    }

    public boolean insertData(String first_name,String surname,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,first_name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5, password);


        long result = db.insert(CLIENT_TABLLE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+CLIENT_TABLLE,null);
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

        db.update(CLIENT_TABLLE, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLIENT_TABLLE, "ID = ?",new String[] {id});
    }


    public boolean insertPData(Integer yBVN, String yaddy, Integer yPhone) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_6, yBVN);
    contentValues.put(COL_7, yaddy);
    contentValues.put(COL_9, yPhone);
    long result = db.insert(BREAD_TABLE,null, contentValues);
    if (result ==-1)
    return false;
    else
        return true;
    }


    public boolean insertRData(Integer r_due_date, Integer r_money, Integer rpm  ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_10, r_due_date );
        contentValues.put(COL_11, r_money);
        contentValues.put(COL_12, rpm);
        long result = db.insert(BREAD_TABLE,null, contentValues);
        if (result ==-1)
            return false;
        else
            return true;
    }


}

