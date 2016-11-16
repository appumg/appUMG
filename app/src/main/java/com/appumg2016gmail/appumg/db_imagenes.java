package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UAI on 13/10/2016.
 */

public class db_imagenes extends SQLiteOpenHelper {

    public static db_imagenes llamada(Context context){
        db_imagenes db_imagenes=null;
        if (db_imagenes==null){
            db_imagenes=new db_imagenes(context);
        }

        return db_imagenes;
    }



    private db_imagenes(Context context){
        super(context,Strings_db.string_db_imagenes.nombre,null,Strings_db.string_db_imagenes.version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Strings_db.string_db_imagenes.creaDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
