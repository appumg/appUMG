package com.appumg2016gmail.appumg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class eliminar extends AppCompatActivity {
private ListView items;
    String[] titulos;
    String[] ids;
    int posicion;

    private View mProgressView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        items=(ListView)findViewById(R.id.items);
        mProgressView = findViewById(R.id.login_progress2);
        SQLiteDatabase db;
        db_timeLine time=db_timeLine.llamada(this);
        db=time.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+Strings_db.string_db_timeline.nombre+" where "+Strings_db.string_db_timeline.publicador+"='"+globales.publicador+"'" ,null);
        int contador=0;
        if (cursor.moveToFirst()) {
            titulos=new String[cursor.getCount()];
            ids=new String[cursor.getCount()];

            do {
                //titulos[contador] = new datos();
                titulos[contador]=cursor.getString(2)+cursor.getString(0);
                ids[contador]=cursor.getString(0);
                contador++;
            } while (cursor.moveToNext());
            ArrayAdapter adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titulos);
            items.setAdapter(adapter);
        }

        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                dialogo(position);

            }
        });




    }
    public void dialogo(final int position){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Confirmacion");
        builder.setMessage("¿Seguro que quieres eliminar "+titulos[position]+"? No se puede deshacer los cambios");
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String eliminar = "http://appumg.pe.hu/php/eliminar.php";
                procesar procesar=new procesar();
                Toast.makeText(getApplicationContext(),"pulsaste el item con la id: "+ids[position],Toast.LENGTH_LONG).show();
                showProgress(true);
                posicion=position;
                procesar.execute("1",eliminar,ids[position]);

                String eliminar2 = "http://appumg.pe.hu/php/eliminar_imagenes.php";
                procesar procesar2=new procesar();
                procesar2.execute("2",eliminar2,ids[position]);
            }
        });
        builder.show();
    }
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            items.setVisibility(show ? View.GONE : View.VISIBLE);
            items.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    items.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            items.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
     class  procesar extends AsyncTask<String ,Void,Boolean> {

         @Override
         protected Boolean doInBackground(String... params) {
             String cadena=params[1];
             URL url=null;
             if (params[0]=="1") {
                 try {
                     globales.semaforo = false;
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
                     JSONObject jsonParam = new JSONObject();
                     jsonParam.put("id", params[2]);

                     System.out.println("---valor enviado--" + params[1]);

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
                         System.out.println(result.toString());
                         JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                         //Accedemos al vector de resultados

                         String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                         if (resultJSON == "1") {
                             return true;

                         } else if (resultJSON == "2") {

                             System.out.println("Error al procesar esta Solicitud Intente de nuevo");
                             return true;
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
             else if (params[0]=="2") {
                 try {
                     globales.semaforo = false;
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
                     JSONObject jsonParam = new JSONObject();
                     jsonParam.put("id", params[2]);

                     System.out.println("---valor enviado--" + params[1]);

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
                         System.out.println(result.toString());
                         JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                         //Accedemos al vector de resultados

                         String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                         if (resultJSON == "1") {
                             return true;

                         } else if (resultJSON == "2") {

                             System.out.println("Error al procesar esta Solicitud Intente de nuevo");
                             return true;
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



             return false;
         }

         @Override
         protected void onPostExecute(final  Boolean suces){
             showProgress(false);
             if (suces){
                    titulos[posicion]=titulos[posicion]+"(eliminado)" ;
                    items.deferNotifyDataSetChanged();
                 Toast.makeText(getApplicationContext(),"Se elimino correctamente este evento",Toast.LENGTH_LONG).show();
             }else{
                 Toast.makeText(getApplicationContext(),"Se elimino correctamente este evento",Toast.LENGTH_LONG).show();
             }

         }
     }


}

class datos{
    String titulo;
    public datos(){};
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public String getTitulo(){
        return titulo;
    }
}
