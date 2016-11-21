package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zombozo on 12/10/2016.
 */

public class db_timeLine extends SQLiteOpenHelper {
    private static db_timeLine db_timeLines=null;

    public static db_timeLine llamada(Context context){
        if (db_timeLines==null){
            db_timeLines=new db_timeLine(context.getApplicationContext());
        }

        return db_timeLines;
    }
    private  db_timeLine(Context context){
        super(context,Strings_db.string_db_timeline.nombre,null,Strings_db.string_db_timeline.version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Strings_db.string_db_timeline.creaDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("crop if exists timeline ");
        db.execSQL(Strings_db.string_db_timeline.creaDB);
    }
}
