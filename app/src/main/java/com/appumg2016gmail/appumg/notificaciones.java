package com.appumg2016gmail.appumg;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class notificaciones extends IntentService {
    private NotificationManager notifacciones;
    int idnotificacion=1;


    public notificaciones() {
        super("WorkingIntentService");
    }

   @Override
   public void onCreate(){
       super.onCreate();
       notifacciones=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
   }

    @Override
    public void onDestroy(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            for (;;) {
                handleActionRun();
                obtenerImagenes();
                guardarImagenes();
                sleep(10000);
            }
        }catch(Exception e){

        }
    }

    private void handleActionRun(){
        db_timeLine timeline=db_timeLine.llamada(globales.context);
        SQLiteDatabase db_timeline;
        db_timeline=timeline.getWritableDatabase();
        System.out.println("el servicio se ejecuta cada : 1o segundos ");
        String IP = "http://appumg.pe.hu/php";
        String OBTENER = IP + "/obtener_cadena.php";
        String cadena= OBTENER;
        URL url=null;
        String devuelve="";
                try {
                    System.out.println("entro a asynctask items");
                    HttpURLConnection urlConn;
                    url = new URL(cadena);
                    urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();
                    //Creo el Objeto JSON
                    JSONObject jsonParam=new JSONObject();

                    // Envio los parámetros post.
                    OutputStream os = urlConn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();
                    int respuesta = urlConn.getResponseCode();
                    StringBuilder result = new StringBuilder();
                    if (respuesta == HttpURLConnection.HTTP_OK) {
                        String line;
                        BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            result.append(line);
                            //response+=line;
                        }
                        System.out.println(result.toString());
                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                        if (resultJSON == "1") {      // hay un alumno que mostrar
                            JSONArray listanube=respuestaJSON.getJSONArray("items");
                            ArrayList<String> idnube=new ArrayList<>();
                            ArrayList<String> idlocal=new ArrayList<>();
                            db_timeLine timeLine=db_timeLine.llamada(this);
                            SQLiteDatabase dbitems=timeLine.getWritableDatabase();
                            Cursor cursor=db_timeline.rawQuery("select "+Strings_db.string_db_timeline.id+" from "+Strings_db.string_db_timeline.nombre,null);
                            while (cursor.moveToNext()){
                                if (cursor.getString(0)==null){
                                    idlocal.add("0");
                                 }else{
                                    idlocal.add(cursor.getString(0));
                                }}


                            for (int a=0;a<listanube.length();a++){
                                boolean estado=false;
                              String id=listanube.getJSONObject(a).getString("id_item");
                                for (int b=0;b<idlocal.size();b++){
                                    if (idlocal.get(b).equals(id)){
                                        estado=true;
                                    }
                                }
                                if (estado==false){
                                    System.out.println("la id "+id+" no existe en local");
                                    if (globales.semaforo) {
                                        notificacion(1,R.drawable.ic_umg,"Universidad Mariano Gálvez","Se publico un nuevo Evento!");
                                        new globales(id);
                                    }
                                }
                            }

                            for (int a=0 ;a<idlocal.size();a++){
                                boolean estado=false;
                                String id=idlocal.get(a);
                                for (int b=0;b<listanube.length();b++){
                                    if (id.equals(listanube.getJSONObject(b).getString("id_item"))){
                                       estado=true;
                                    }

                                }

                                if (estado==false){
                                    System.out.println("la id "+id+" no existe en la nube se borrara");
                                    db_timeline.delete(Strings_db.string_db_timeline.nombre,"id_item="+id,null);

                                }
                            }



                        } else if (resultJSON == "2") {
                            db_timeline.delete(Strings_db.string_db_timeline.nombre,null,null);
                            devuelve = "No hay evento nuevos";
                            System.out.println(devuelve);
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }catch(Exception e){

                }




        }

    public void notificacion(int id, int icoId,String titulo,String contenido){

        Intent a=new Intent(this,imagen_inicio.class);
        a.putExtra("id",id);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,a,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(globales.context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(icoId)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.umg_logo))
                .setContentTitle(titulo)
                .addAction(icoId,contenido,pendingIntent)
                .setVibrate(new long[]{100,250,100,500})
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentText(contenido)
                .setColor(getResources().getColor(R.color.colorPrimaryDark));

            notifacciones.notify(id,builder.build());
    }

    public String obtenerImagenes() {
        try {
            String IPs = "http://appumg.pe.hu/php";
            final String OBTENERIMAGENES = IPs + "/obtener_imagenes_id_1.php";
            db_imagenes dbImagenes = db_imagenes.llamada(globales.context);
            SQLiteDatabase db_imagenes2 = dbImagenes.getWritableDatabase();
            System.out.println("entro a notificaciones de imagenes");
            HttpURLConnection urlConn;
            URL url;
            url = new URL(OBTENERIMAGENES);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.connect();
            //Creo el Objeto JSON
            JSONObject jsonParam = new JSONObject();
            // Envio los parámetros post.
            OutputStream os = urlConn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();
            int respuesta = urlConn.getResponseCode();
            StringBuilder result = new StringBuilder();
            if (respuesta == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    result.append(line);
                    //response+=line;
                }
                //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                //Accedemos al vector de resultados
                SQLiteDatabase dbimagenes;
                db_imagenes imagenes=db_imagenes.llamada(this);
                dbimagenes=imagenes.getWritableDatabase();
                String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                if (resultJSON == "1") {      // hay un alumno que mostrar

                    ArrayList<String> imageneslocal=new ArrayList<>();
                    JSONArray imagenesNube=respuestaJSON.getJSONArray("items");
                    Cursor cursor=dbimagenes.rawQuery("select "+Strings_db.string_db_imagenes.numeroImagen+" from "+Strings_db.string_db_imagenes.nombre,null);
                    while (cursor.moveToNext()){
                        imageneslocal.add(cursor.getString(0));
                    }
                    for (int a=0;a<imagenesNube.length();a++){
                        boolean estado=false;
                        String id=imagenesNube.getJSONObject(a).getString("Idimage");
                        for (int b=0;b<imageneslocal.size();b++){
                            if (id.equals(imageneslocal.get(b))){
                                estado=true;
                            }
                        }
                        if (estado==false){
                            System.out.println(" la imagen no existe localmente se descargara");
                            System.out.println("hay imagenes nuevas!");
                            if (globales.semaforo) {
                                System.out.println("semaforo esta en verde");
                                globales.descargarImagenes(id);

                            }else{
                                System.out.println("semaforo esta en rojo");
                            }
                        }

                    }

                    for (int a=0;a<imageneslocal.size();a++){
                        boolean estado=false;
                        String id=imageneslocal.get(a);
                        for (int b=0;b<imagenesNube.length();b++){
                            if (id.equals(imagenesNube.getJSONObject(b).getString("Idimage"))){
                                estado=true;
                            }
                        }
                        if (estado==false){
                            System.out.println(" la imagen "+id+" no existe en el servidor, se eliminaran");
                            dbimagenes.delete(Strings_db.string_db_imagenes.nombre,Strings_db.string_db_imagenes.numeroImagen+"="+id,null);
                        }

                    }




                } else if (resultJSON == "2") {
                    String devuelve = "no se an podido obtener las imagenes!!";
                    dbimagenes.delete(Strings_db.string_db_imagenes.nombre,null,null);
                    System.out.println(devuelve);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    public static void guardarImagenes(){
        ArrayList<String> id_actuales=new ArrayList<>();
        temporal_imagenes temporal=temporal_imagenes.llamada(globales.context);
        SQLiteDatabase db=temporal.getWritableDatabase();
        Cursor cursor =db.rawQuery("select id_auto from temporal_imagenes",null);
        System.out.println("-----0");
        while(cursor.moveToNext()){
            id_actuales.add(cursor.getString(0));
        }

        if (id_actuales.isEmpty()==false){
            globales.guardarImagenes();

        }else{
            System.out.println("no hay imagenes para guardar");
        }

    }

    }





