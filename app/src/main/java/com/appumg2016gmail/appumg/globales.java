package com.appumg2016gmail.appumg;

import android.content.Context;
import android.content.Intent;
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
    public globales (){
        System.out.println("la clase de inicio--");
        String IPS = "http://appumg.pe.hu/php";
        String INSERTS = IPS + "/obtener_apartir.php";
        guardar_online obtener = new guardar_online();
        obtener.execute(INSERTS, "7");
    }
    public globales (int i){
        System.out.println("la clase de inicio del servicio--");
        context.startService(new Intent(context,notificaciones.class));
        if (context==null){
            System.out.println("el contexto esta null");
        }
    }

    // variables que guardaran los datos que se estan subiendo online
    public static ArrayList<String> listaImagenesOnline=new ArrayList<>();

    public static void guardarImagenes(){
        String IPS = "http://appumg.pe.hu/php";
        String INSERTS = IPS + "/web_imagenes.php";

        for (int a=0;a<listaImagenesOnline.size();a++) {
            guardar_online guardarImagenes=new guardar_online();
            guardarImagenes.execute(INSERTS,"6",listaImagenesOnline.get(a));
            Toast.makeText(context.getApplicationContext(), "Las Imagenes se estan guardando el linea!", Toast.LENGTH_SHORT).show();
        }
        listaImagenesOnline.clear();
    }

    public static void obtenerItem(){
        String IPS = "http://appumg.pe.hu/php";
        String INSERTS = IPS + "/obtener_id_ultimo_item.php";
        guardar_online guardarImagenes=new guardar_online();
        guardarImagenes.execute(INSERTS,"4");
    }

    public static  void descargarImagenes(){
        String IPs = "http://appumg.pe.hu/php";
        final String OBTENERIMAGENES = IPs + "/obtener_imagenes_id.php";
        guardar_online imagenes=new guardar_online();
        imagenes.execute(OBTENERIMAGENES,"8");
    }
}
