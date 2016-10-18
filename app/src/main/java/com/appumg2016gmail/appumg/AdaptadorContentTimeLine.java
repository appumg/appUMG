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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Manuel on 30/09/2016.
 */

public class AdaptadorContentTimeLine extends BaseAdapter {

    //--- variables nesesarias para el layout
    private Context context;
    protected Activity activity;

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
    private ArrayList<Integer> id_publicaciones=new ArrayList<>();

    private SQLiteDatabase    db_items;
    private SQLiteDatabase    db_imagen;
    private db_timeLine       items;
    private db_imagenes       imagenes;
    private int version=1;




    public AdaptadorContentTimeLine(Context activity){
        context=activity;
        items=new db_timeLine(context.getApplicationContext(),version);
        imagenes=new db_imagenes(context.getApplicationContext(),version);
        db_items=items.getWritableDatabase();
        db_imagen=imagenes.getWritableDatabase();

        obtenerDatos();
    }

    @Override
    public int getCount() {
        return A_administrador.size();
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
            miniatura.setMaxWidth(30);
            miniatura.setMaxHeight(40);
        }

        return view1;
    }




    public void obtenerDatos(){
       String SQL="create table timeline(" +
                "id integer primary key autoincrement, " +
                "tipo integer," +
                "titulo text, " +
                "descripcion text, " +
                "fecha_pub integer," +
                "hora_pub integer, " +
                "fecha_evento integer," +
                "hora_evento integer, " +
                "publicador integer)";
        for (int a=0;a<id_publicaciones.size()+1;a++){
               Cursor Cursor_items= db_items.rawQuery("select * from timeline",null);

            if (Cursor_items.moveToFirst()){
                do {
                    A_titulo.add(Cursor_items.getString(1));
                    A_administrador.add("publicado por:"+Cursor_items.getString(8));
                    A_fechaEvento.add("fecha del evento: "+Cursor_items.getString(6)+" a las "+Cursor_items.getString(7));
                    A_fechaPublicacion.add("publicado el : "+Cursor_items.getString(4)+" a las "+Cursor_items.getString(5));
                    String ids=Cursor_items.getString(0);
                    Toast.makeText(context, "la id es "+ids, Toast.LENGTH_SHORT).show();
                    Cursor cursor_imagenes= db_imagen.rawQuery("select direccion from imagen where id_pub='"+ids+"'",null);

                    if (cursor_imagenes.moveToFirst()) {
                        do {

                            String img=cursor_imagenes.getString(0);
                            Uri imag=Uri.parse(img);
                            A_imagen.add(imag);

                        }while(cursor_imagenes.moveToNext());
                    }
                }while(Cursor_items.moveToNext());
            }
        }
    }
}
