package com.example.codewithsafy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DB extends SQLiteOpenHelper {
    static String name ="database";
    static int version=1;

    String createTable ="CREATE TABLE if not exists \"user\" (\n" +
            "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"Name\"\tTEXT,\n" +
            "\t\"age\"\tTEXT,\n" +
            "\t\"email\"\tTEXT,\n" +
            "\t\"password\"\tTEXT,\n" +
            "\t\"gender\"\tTEXT\n" +
            ")";


    public DB(Context context ) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTable);
    }
    public void insertuser(ContentValues contentValues){
        getWritableDatabase().insert("user",null,contentValues);
    }
    public boolean isloginvalid(String username, String password){
        String sql= "Select count(*) from user where email='"+username+"' and password='" +password+"'";
        SQLiteStatement statement= getReadableDatabase().compileStatement(sql);
        long l= statement.simpleQueryForLong();
        statement.close();
        if(l==1){
            return  true;
        }
        else
        {
            return  false;
        }
    }
public boolean checkuser( String email){
SQLiteDatabase db= this.getWritableDatabase();
    Cursor cursor= db.rawQuery("select * from user where email=?" , new String[]{email});
    if( cursor.getCount()>0){
        return  true;

    }
    else{
         return  false;
    }
}


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
