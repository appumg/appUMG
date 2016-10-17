package com.appumg2016gmail.appumg;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
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

    //--- variables nesesarias para el layout
    private Context context;
    protected Activity activity;
    protected ArrayList<EventoItem> items;

            /* referenciando los botones */
    private TextView titulo;
    private TextView fechaPublicacion;
    private TextView fechaEvento;
    private TextView NombrePublicador;
    private ImageView miniatura;
// arreglos para contener la lista de los items a mostrar en la linea de tiempo.
    private ArrayList<String> A_titulo=new ArrayList<>();
    private ArrayList<String> A_fechaEvento=new ArrayList<>();
    private ArrayList<String> A_fechaPublicacion=new ArrayList<>();
    private ArrayList<Uri>    A_imagen=new ArrayList<>();
    private ArrayList<String> A_administrador=new ArrayList<>();
    private SQLiteDatabase    db;
    private db_timeLine       time;


    public AdaptadorContentTimeLine(Context activity){
        context=activity;
      //  time=new db_timeLine(activity,1);
      //  db=time.getWritableDatabase();
    }

    @Override
    public int getCount() {
        return A_administrador.size()+1;
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


        //inicializando botones

        TextView titulo=(TextView)view1.findViewById(R.id.Ttitulo);
        TextView fechaPublicacion=(TextView)view1.findViewById(R.id.TfechaPub);
        TextView  fechaEvento=(TextView)view1.findViewById(R.id.TfechaEvento);
        TextView  NombrePublicador=(TextView)view1.findViewById(R.id.TNombPublicador);
        ImageView miniatura=(ImageView)view1.findViewById(R.id.Ttumbl);

        // recorriendo arreglos y agregando al item actual
        for(int a=0;a<A_administrador.size();a++){
            titulo.setText(A_titulo.get(a));
            fechaPublicacion.setText(A_fechaEvento.get(a));
            fechaEvento.setText(A_fechaEvento.get(a));
            NombrePublicador.setText(A_administrador.get(a));
            miniatura.setImageURI(A_imagen.get(a));
        }

        return view1;
    }


    public void cargar(){
        Cursor cursor=db.rawQuery("select * from timeline",null);
        while(cursor.moveToNext()){
                A_titulo.add(cursor.getString(3));
                A_administrador.add(cursor.getString(8));
                A_fechaEvento.add(cursor.getString(5));
                A_fechaPublicacion.add(cursor.getString(4));
                A_imagen.add(Uri.parse(cursor.getString(9)));

        }
    }
}
