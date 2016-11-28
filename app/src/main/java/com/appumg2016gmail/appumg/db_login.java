package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zombozo on 23/11/16.
 */

public class db_login extends SQLiteOpenHelper {
    public static db_login login=null;
    public static db_login llamada(Context context){
        if (login==null){
            login=new db_login(context);
        }
        return login;
    }


    public db_login(Context context){
        super(context,"login",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(idadministrador text,nombre text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
