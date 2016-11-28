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
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import java.util.ArrayList;
import java.util.Calendar;
public class AdaptadorContentTimeLine extends BaseAdapter {
    //--- variables nesesarias para el layout
    private Context context;
    TextView  titulo;
    TextView  fechaPublicacion;
    TextView  fechaEvento;
    TextView  NombrePublicador;
    CircularImageView miniatura;
// arreglos para contener la lista de los items a mostrar en la linea de tiempo.
    private ArrayList<String> A_id=new ArrayList<>();
    private ArrayList<String> A_titulo=new ArrayList<>();
    private ArrayList<String> A_fechaEvento=new ArrayList<>();
    private ArrayList<String> A_fechaPublicacion=new ArrayList<>();
    private ArrayList<Uri>    A_imagen=new ArrayList<>();
    private ArrayList<String> A_administrador=new ArrayList<>();
    private SQLiteDatabase    db_items;
    private SQLiteDatabase    db_imagen;
    private db_timeLine       items;
    private db_imagenes       imagenes;
    private int version=1;
    public AdaptadorContentTimeLine(Context activity){
        context=activity;
        items= db_timeLine.llamada(context.getApplicationContext());
        imagenes= db_imagenes.llamada(context.getApplicationContext());
        db_items=items.getWritableDatabase();
        db_imagen=imagenes.getWritableDatabase();
        obtenerDatos();
    }
    @Override
    public int getCount() {
        return A_titulo.size();
    }

    @Override
    public Object getItem(int i) {
        return  A_id.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=view;
        if (view1==null) {
                    LayoutInflater inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view1=inflador.inflate(R.layout.list_time_line, viewGroup, false);
        }
        //inicializando botones
        titulo=(TextView)view1.findViewById(R.id.Ttitulo);
         fechaPublicacion=(TextView)view1.findViewById(R.id.TfechaPub);
        fechaEvento=(TextView)view1.findViewById(R.id.TfechaEvento);
        NombrePublicador=(TextView)view1.findViewById(R.id.TNombPublicador);
        miniatura=(CircularImageView) view1.findViewById(R.id.Ttumbl);
        miniatura.setBorderWidth(1);
        // recorriendo arreglos y agregando al item actual
            titulo.setText(A_titulo.get(i));
            fechaPublicacion.setText(A_fechaPublicacion.get(i));
            fechaEvento.setText(A_fechaEvento.get(i));
            NombrePublicador.setText(A_administrador.get(i));
            if (A_imagen.size()!=0) {
                ///convertir el string en imagen
                if (i<A_imagen.size()) {
                    miniatura.setImageURI(A_imagen.get(i));
                }
            }

        return view1;
    }
    public void obtenerDatos(){
        globales.id_item.clear();
               Cursor Cursor_items= db_items.rawQuery("select * from "+Strings_db.string_db_timeline.nombre+" ORDER BY "+Strings_db.string_db_timeline.numero+" DESC",null);
            if (Cursor_items.moveToFirst()){
                do {
                    globales.id_item.add(Cursor_items.getInt(0));
                    A_titulo.add(Cursor_items.getString(2));
                    A_administrador.add(""+Cursor_items.getString(6));
                    String fech=Cursor_items.getString(4);
                    //2015-12-12 00:00:00
                    int anio =Integer.parseInt(fech.substring(0,4));
                    int mes =Integer.parseInt(fech.substring(5,7));
                    int dias =Integer.parseInt(fech.substring(8,10));
                    int horas =Integer.parseInt(fech.substring(11,13));
                    int minutos =Integer.parseInt(fech.substring(14,16));
                    int segundos =Integer.parseInt(fech.substring(17,19));
                    DateTime fechaFinal=new DateTime(anio,mes,dias,horas,minutos,segundos);
                    String dia=obtenerDias(fechaFinal);
                    A_fechaEvento.add("fecha del evento: "+Cursor_items.getString(5));
                    A_fechaPublicacion.add("publicado hace  "+dia);
                    String ids=Cursor_items.getString(0);
                    Cursor cursor_imagenes= db_imagen.rawQuery("select "+Strings_db.string_db_imagenes.direccion+" from "+
                            Strings_db.string_db_imagenes.nombre+" where "+Strings_db.string_db_imagenes.id_imagen+"="+ids,null);
                    if (cursor_imagenes.moveToFirst()) {
                                String img = cursor_imagenes.getString(0);
                                Uri imag = Uri.parse(img);
                                A_imagen.add(imag);
                    }
                }while(Cursor_items.moveToNext());
            }
        }
public String obtenerDias(DateTime inicio){
    Calendar calendar=Calendar.getInstance();
    int dia=calendar.get(Calendar.DAY_OF_MONTH);
    int mes=calendar.get(Calendar.MONTH)+1;
    int anio=calendar.get(Calendar.YEAR);
    int horas=calendar.get(Calendar.HOUR_OF_DAY);
    int minutos=calendar.get(Calendar.MINUTE);
    int segundos=calendar.get(Calendar.SECOND);
    DateTime fin=new DateTime(anio,mes,dia,horas,minutos,segundos);
    System.out.println(inicio+" "+fin);
    int hora= Hours.hoursBetween(inicio,fin).getHours();
        int minuto= Minutes.minutesBetween(inicio,fin).getMinutes();
    if (minuto==0){
        return "unos segundos";
    }else if(minuto>0){
        if(minuto>60){
            float hors=minuto/60;
            int or=(int)hors;
            double mins=hors-or;
            int mins1=(int)mins*10;
            if (or<24) {
                return " " + or + " horas  " ;
            }else{
                int dias=(int)or/24;
                return " "+dias+" dias ";
            }


        }else{
            return minuto+" minutos";
        }
    }
    return "";
}


}
