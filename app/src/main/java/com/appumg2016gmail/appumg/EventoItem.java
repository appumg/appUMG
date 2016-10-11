package com.appumg2016gmail.appumg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class EventoItem extends BaseAdapter{
    public String titulo;
    public String fechaPublicacion;
    public String fechaEvento;
    public String Publicador;
    private LayoutInflater inflater;
    private Context contexto;
   // private Drawable img;
    public EventoItem(String titulo, String fechaPublicacion, String fechaEvento, String publicador) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaEvento = fechaEvento;
        this.Publicador = publicador;
    //    this.img=img;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;
        inflater=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view1=inflater.inflate(R.layout.list_time_line,viewGroup,false);



        return null;
    }
}
