package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zombozo on 12/10/2016.
 */

public class db_timeLine extends SQLiteOpenHelper {

    private static String  nombreDB="time_line";
    private static int     version=1;
    private static String SQL="create table timeline(id integer primary key autoincrement, tipo integer,titulo text, fecha_pub text,hora_pub text, " +
            "fecha_evento text,hora_evento text, descripcion text, publicador text, publico integer, id_imagenes integer)";


    public db_timeLine(Context context, int ver){
        super(context,nombreDB,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("crop if exists timeline ");
        db.execSQL(SQL);
    }
}
