package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UAI on 13/10/2016.
 */

public class db_imagenes extends SQLiteOpenHelper {
    private String sql="create table "+nombre+"(id_pub integer primary key not null,direccion text not null)";
    private static String nombre="imagen";
    public db_imagenes(Context context,int version){
        super(context,nombre,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}