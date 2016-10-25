package com.appumg2016gmail.appumg;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zombozo on 20/10/2016.
 */

public class bottonflotante extends BottomSheetDialogFragment {
    SQLiteDatabase db_items;
    String string_titulo;
    String string_descripcion;
    String string_publico;
    TextView titulo,descripcion,publico;
    static BottomSheetDialogFragment newInstances(){

        return new BottomSheetDialogFragment();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        cargar();
        View view=inflater.inflate(R.layout.layout_flotante,viewGroup,false);
        GridView galerias = (GridView) view.findViewById(R.id.galeria);
        galerias.setAdapter(new galeria_adaptador(getContext()));
        titulo=(TextView)view.findViewById(R.id.titulo);
        descripcion=(TextView)view.findViewById(R.id.descripcion);
        titulo.setText(string_titulo);
        descripcion.setText(string_descripcion);
        return view;
    }


    private void cargar(){
        db_timeLine db_timeLine=new db_timeLine(getContext(),1);
        db_items=db_timeLine.getWritableDatabase();
        int id=globales.id_imagen;
        Cursor items=db_items.rawQuery("select * from timeline where id="+id,null);
        if (items.moveToFirst()){
            string_titulo=items.getString(2);
            string_descripcion="\""+items.getString(3)+"\"";
        }
    }

}
