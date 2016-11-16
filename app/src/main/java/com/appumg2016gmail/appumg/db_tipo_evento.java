package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zombozo on 25/10/2016.
 */

public class db_tipo_evento extends SQLiteOpenHelper{
    private static db_tipo_evento evento=null;
    public static db_tipo_evento llamada(Context contexto){
        if (evento==null){
            evento=new db_tipo_evento(contexto.getApplicationContext());
        }
        return evento;
    }

    private db_tipo_evento(Context context){
        super(context,Strings_db.string_db_tipo_evento.nombre,null,Strings_db.string_db_tipo_evento.version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Strings_db.string_db_tipo_evento.creaDB);
        db.execSQL("insert into "+Strings_db.string_db_tipo_evento.nombre+" ("+Strings_db.string_db_tipo_evento.nombreTipo+") values('noticia')");
        db.execSQL("insert into "+Strings_db.string_db_tipo_evento.nombre+" ("+Strings_db.string_db_tipo_evento.nombreTipo+") values('evento')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
