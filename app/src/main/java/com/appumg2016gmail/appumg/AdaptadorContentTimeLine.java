package com.appumg2016gmail.appumg;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manuel on 30/09/2016.
 */

public class AdaptadorContentTimeLine extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<EventoItem> items;

    private Context context;
    TextView titulo,fechaPublicacion, fechaEvento,NombrePublicador;
    ImageView miniatura;
    public AdaptadorContentTimeLine(Context activity){
        context=activity;
    }

    @Override
    public int getCount() {
        return 4;
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
        View view1;//Vista
        LayoutInflater inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view1=inflador.inflate(R.layout.list_time_line,viewGroup,false);


        //view1=layoutInflater.inflate(R.layout.list_time_line,viewGroup,false);

        TextView titulo=(TextView)view1.findViewById(R.id.Ttitulo);
        titulo.setText("Titulo");

        TextView fechaPublicacion=(TextView)view1.findViewById(R.id.TfechaPub);
        fechaPublicacion.setText("Fecha Publicacion:");

        TextView  fechaEvento=(TextView)view1.findViewById(R.id.TfechaEvento);
        fechaEvento.setText("fecha Evento:");

        TextView  NombrePublicador=(TextView)view1.findViewById(R.id.TNombPublicador);
        NombrePublicador.setText("Publicar");

        ImageView miniatura=(ImageView)view1.findViewById(R.id.Ttumbl);



        return view1;
    }
}
