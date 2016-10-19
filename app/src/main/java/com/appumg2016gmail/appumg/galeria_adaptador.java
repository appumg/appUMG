package com.appumg2016gmail.appumg;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by UAI on 18/10/2016.
 */

public class galeria_adaptador extends BaseAdapter {

    LayoutInflater inflater;
    public Context context;

    ArrayList<Uri> lista=new ArrayList<>();

    ImageView imageView;
    public galeria_adaptador(Context contexto,ArrayList<Uri> listas){
        this.lista=listas;

        context=contexto;
    }

    @Override
    public int getCount() {
        return 8;
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
        for (int a=0;a<lista.size();a++) {
            imageView.setImageURI(lista.get(a));
        }
        return view;
    }
}
