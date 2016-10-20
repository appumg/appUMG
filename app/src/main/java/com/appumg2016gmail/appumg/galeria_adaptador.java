package com.appumg2016gmail.appumg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UAI on 18/10/2016.
 */

public class galeria_adaptador extends BaseAdapter {

    LayoutInflater inflater;
    public Context context;
    ArrayList<Uri> lista=new ArrayList<>();


    private int id;

    ImageView imageView;
    public galeria_adaptador(Context contexto,int id){
       this.id=id;
        context=contexto;
       cargar();

    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(R.layout.galeria_adaptador,parent,false);
        imageView=(ImageView)view.findViewById(R.id.imagen_galeria);
        imageView.setImageURI(lista.get(position));
        return view;
    }

    public void cargar(){
        SQLiteDatabase db;

        db_imagenes db_imagenes=new db_imagenes(context,1);
        db=db_imagenes.getWritableDatabase();
        Cursor galeria=db.rawQuery("select  direccion from imagen where id_pub="+id,null);
        if (galeria.moveToFirst()){
            do{
                lista.add(Uri.parse(galeria.getString(0)));
            }while (galeria.moveToNext());
        }
    }
}
