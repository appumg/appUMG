package com.appumg2016gmail.appumg;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
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

import static java.lang.Thread.sleep;

public class notificaciones extends IntentService {
    private NotificationManager notifacciones;
    public notificaciones() {
        super("WorkingIntentService");
    }

   @Override
   public void onCreate(){
       super.onCreate();
       Toast.makeText(this, "El servicio se a creado", Toast.LENGTH_SHORT).show();
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
        String OBTENER = IP + "/obtener_apartir.php";
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
                    Cursor cursor=db_timeline.rawQuery(" select max("+Strings_db.string_db_timeline.numero+") as "+Strings_db.string_db_timeline.numero+","+Strings_db.string_db_timeline.id+" from "+Strings_db.string_db_timeline.nombre+" ",null);
                    if (cursor.moveToFirst()) {
                        if ( cursor.getString(1)==null){
                            jsonParam.put("id_itemActual","0");
                        }else {
                            jsonParam.put("id_itemActual", cursor.getString(1));
                            System.out.println(cursor.getString(1) + "---");
                        }
                    }
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
                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                        if (resultJSON == "1") {      // hay un alumno que mostrar
                            notificacion(1,R.drawable.ic_umg,"Universidad Mariano Gálvez","Se publico un nuevo Evento!");
                            System.out.println("Se a publicado un nuevo evento! ");
                            new globales();
                        } else if (resultJSON == "2") {
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
                }




        }

    public void notificacion(int id, int icoId,String titulo,String contenido){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(globales.context).setSmallIcon(icoId)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.umg_logo))
                .setContentTitle(titulo)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentText(contenido)
                .setColor(getResources().getColor(R.color.colorPrimaryDark));

            notifacciones.notify(id,builder.build());
    }


    }





