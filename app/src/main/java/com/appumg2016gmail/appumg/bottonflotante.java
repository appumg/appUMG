package com.appumg2016gmail.appumg;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zombozo on 20/10/2016.
 */

public class bottonflotante extends BottomSheetDialogFragment {
    SQLiteDatabase db_items;
    String string_titulo;
    String string_descripcion;
    String string_publico;
    TextView titulo,descripcion,editar,eliminar;
    static BottomSheetDialogFragment newInstances(){

        return new BottomSheetDialogFragment();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        cargar();

        View view=inflater.inflate(R.layout.layout_flotante,viewGroup,false);
        final GridView galerias = (GridView) view.findViewById(R.id.galeria);
        galerias.setAdapter(new galeria_adaptador(getContext()));
        galerias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animation ampliar= AnimationUtils.loadAnimation(getContext(),R.anim.ampliar);
                ampliar.reset();
                galerias.startAnimation(ampliar);

            }
        });
        galerias.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                galerias.deferNotifyDataSetChanged();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                galerias.deferNotifyDataSetChanged();
            }
        });
        titulo=(TextView)view.findViewById(R.id.titulo);
        descripcion=(TextView)view.findViewById(R.id.descripcion);
        titulo.setText(string_titulo);
        descripcion.setText(string_descripcion);
      // eliminar=(TextView)view.findViewById(R.id.borrar);
       // editar=(TextView)view.findViewById(R.id.editar);
        return view;
    }


    private void cargar(){
        db_timeLine db_timeLines= db_timeLine.llamada(getContext());
        db_items=db_timeLines.getWritableDatabase();
        int id=globales.id_imagen;
        Cursor items=db_items.rawQuery("select * from "+Strings_db.string_db_timeline.nombre+" where "+Strings_db.string_db_timeline.id+"="+globales.id_imagen,null);
        if (items.moveToFirst()){
            string_titulo=items.getString(2);
            string_descripcion="\""+items.getString(3)+"\"";
        }
    }

}
