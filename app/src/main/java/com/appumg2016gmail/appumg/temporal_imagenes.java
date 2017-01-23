package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zombozo on 22/11/16.
 */

public class temporal_imagenes extends SQLiteOpenHelper{
    public static temporal_imagenes imagenes=null;

    public static temporal_imagenes llamada(Context context){
        if (imagenes==null){
            imagenes=new temporal_imagenes(context);
        }
        return  imagenes;
    }

    private temporal_imagenes(Context context){
        super(context,"temporal_imagenes",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table temporal_imagenes(id_auto integer primary key autoincrement,Imagen text,id text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
