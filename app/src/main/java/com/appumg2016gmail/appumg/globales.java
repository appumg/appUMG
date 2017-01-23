package com.appumg2016gmail.appumg;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zombozo on 20/10/2016.
 */

public class globales {
    public static Context context=null;

    public static int idItemActual;
    public static int itemSeleccionado;
    public static ArrayList<Integer> id_item=new ArrayList<>();
    public static ArrayList<Integer> id_imagenes=new ArrayList<>();

    public static ArrayList<Bitmap> ListaImagenes=new ArrayList<>();
    public static int id_imagen;
    public static FragmentManager manager;
    public static boolean semaforo=true;
    public static boolean semaforoImagenes=true;
    public static String publicador;
    public static boolean mostrarFloating =false;

    public globales (String i){
        semaforo=false;
        System.out.println("la clase de inicio--");
        String IPS = "http://appumg.pe.hu/php";
        String INSERTS = IPS + "/obtener_apartir.php";
        guardar_online obtener = new guardar_online();
        obtener.execute(INSERTS, "7",i);
    }
    public globales (int i){
        System.out.println("la clase de inicio del servicio--");
        context.startService(new Intent(context,notificaciones.class));
    }

    // variables que guardaran los datos que se estan subiendo online
    public static ArrayList<String> listaImagenesOnline=new ArrayList<>();

    public static void guardarImagenes(){
        if (semaforo) {
            ArrayList<String> id_actuales = new ArrayList<>();
            String INSERTS = "http://appumg.pe.hu/php/web_imagenes.php";
            System.out.println("entro a guardar las imagenes");
            temporal_imagenes temporal = temporal_imagenes.llamada(globales.context);
            SQLiteDatabase db = temporal.getWritableDatabase();
            Cursor cursor = db.rawQuery("select id_auto from temporal_imagenes", null);
            System.out.println("---1");
            while (cursor.moveToNext()) {
                id_actuales.add(cursor.getString(0));
            }
            if (id_actuales.isEmpty() == false) {
                Cursor cursor1 = db.rawQuery("select * from temporal_imagenes where id_auto=" + id_actuales.get(0), null);
                System.out.println("---2  --" + id_actuales.get(0));
                String imagen = "";
                String id = "";
                String id_auto = "";
                if (cursor1.moveToFirst()) {
                    do {
                        id_auto = cursor1.getString(0);
                        imagen = cursor1.getString(1);
                        id = cursor1.getString(2);

                        System.out.println(id + "------" + id_auto);
                    } while (cursor1.moveToNext());

                    System.out.println("se esta intentando guardar la imagen " + id_auto);
                    guardar_online guardarImagenes = new guardar_online();
                    guardarImagenes.execute(INSERTS, "6", imagen, id, id_auto);
                    Toast.makeText(context.getApplicationContext(), "Las Imagenes se estan guardando el linea!", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

    public static void obtenerItem(){
        String IPS = "http://appumg.pe.hu/php";
        String INSERTS = IPS + "/obtener_id_ultimo_item.php";
        guardar_online guardarImagenes=new guardar_online();
        guardarImagenes.execute(INSERTS,"4");
    }

    public static  void descargarImagenes(String id){
        if (semaforo) {
            String IPs = "http://appumg.pe.hu/php";
            final String OBTENERIMAGENES = IPs + "/obtener_imagenes_id.php";
            guardar_online imagenes = new guardar_online();
            imagenes.execute(OBTENERIMAGENES, "8", id);
        }
    }
}
