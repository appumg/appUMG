package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UAI on 18/10/2016.
 */

public class db_itemsTimeLine extends SQLiteOpenHelper {
    final static String NombreDB="itemsTimeLine";

    public db_itemsTimeLine(Context context,int version){
        super(context.getApplicationContext(),NombreDB,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NombreDB+"(id_"+NombreDB+" integer primary key autoincrement, id_publicacion integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
