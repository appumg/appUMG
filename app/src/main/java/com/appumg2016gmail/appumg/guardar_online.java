package com.appumg2016gmail.appumg;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zombozo on 01/11/2016.
 */

public class guardar_online extends AsyncTask<String,Void , String> {
    //----- objetos nesesario para la base de datos
    SQLiteDatabase db_timeline;
    SQLiteDatabase db_imagenesconexion;
    SQLiteDatabase db_itemsTimeLine;

    db_timeLine timeLine;
    db_imagenes imagenesConexion;
    db_itemsTimeLine itemsTimeLine;
    private boolean estadoParaGuardarImagenes=false;
    private boolean obtenerItemActual=false;
    private boolean descargarImagenes=false;
    @Override
    protected String doInBackground(String... params) {
        //----- obteniendo referencias de los objetos
        int version=1;
        timeLine= db_timeLine.llamada(globales.context);
        imagenesConexion= db_imagenes.llamada(globales.context);
        itemsTimeLine=new db_itemsTimeLine(globales.context,version);
        db_imagenesconexion=imagenesConexion.getWritableDatabase();
        db_imagenes dbImagenes=db_imagenes.llamada(globales.context);
        SQLiteDatabase db_imagenes2=dbImagenes.getWritableDatabase();
        db_itemsTimeLine=itemsTimeLine.getWritableDatabase();
        db_timeline=timeLine.getWritableDatabase();
        String cadena= params[0];
        URL url=null;
        String devuelve="";
        if (params[1]=="1"){  // guardando los datos de un nuevo item
            try {
                obtenerItemActual=true;
                HttpURLConnection urlConn;
                DataOutputStream printout;
                DataInputStream input;
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

                jsonParam.put("id_tipo",params[2]);
                jsonParam.put("id_admin",params[3]);
                jsonParam.put("titulo",params[4]);
                jsonParam.put("descripcion",params[5]);
                jsonParam.put("fecha_pub",params[6]);
                jsonParam.put("fecha_evento",params[7]);
                jsonParam.put("id_imagen",params[8]);  /*
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nombre", "gerson");
                jsonParam.put("direccion", "olivares"); */
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
                        devuelve = "Alumno insertado correctamente";
                       System.out.println(devuelve);
                    } else if (resultJSON == "2") {
                        devuelve = "El alumno no pudo insertarse";
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
            return devuelve;
        }


             if(params[1]=="4"){    // Consulta la ultima id del item recien insertado
            estadoParaGuardarImagenes=true;
            try {
                url = new URL(cadena);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abrir la conexión
                connection.setRequestProperty("User-Agent", "Mozilla/5.0" +
                        " (Linux; Android 1.5; es-ES) Ejemplo HTTP");
                //connection.setHeader("content-type", "application/json");
                int respuesta = connection.getResponseCode();
                StringBuilder result = new StringBuilder();
                if (respuesta == HttpURLConnection.HTTP_OK){
                    InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader
                    // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                    // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                    // StringBuilder.
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);        // Paso toda la entrada al StringBuilder
                    }
                    //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                    JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                    //Accedemos al vector de resultados
                    String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                    if (resultJSON=="1"){      // hay alumnos a mostrar
                        JSONArray alumnosJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<alumnosJSON.length();i++){
                            globales.idItemActual=Integer.parseInt(alumnosJSON.getJSONObject(i).getString("id_item"));
                            System.out.println(alumnosJSON.getJSONObject(i).getString("id_item")+" esta es la item obtenida!! ----------------");
                        }
                        System.out.println(devuelve);
                    }
                    else if (resultJSON=="2"){
                        devuelve = "No hay alumnos";
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return devuelve;
        }
        if (params[1] == "6") {   // enviamos la imagen al servidor
            estadoParaGuardarImagenes=false;
            try {
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
                jsonParam.put("funcion","setImage");
                jsonParam.put("image",params[2]);
                jsonParam.put("id",""+globales.idItemActual+"");
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
                        devuelve = "imagen  insertada correctamente";
                        System.out.println(devuelve);
                    } else if (resultJSON == "2") {
                        devuelve = "la imagen no pudo insertarse";
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
            return devuelve;
        }
        if (params[1]=="7"){  // obteniendo los items
            try {
                descargarImagenes=true;
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
                        JSONArray alumnosJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<alumnosJSON.length();i++){
                            System.out.println(alumnosJSON);
                            db_timeline.execSQL("insert into "+Strings_db.string_db_timeline.nombre+"("+Strings_db.string_db_timeline.id+","+Strings_db.string_db_timeline.tipo+","+Strings_db.string_db_timeline.titulo+
                                    " ,"+Strings_db.string_db_timeline.descripcion+","+Strings_db.string_db_timeline.fecha_publicacion+","+Strings_db.string_db_timeline.fecha_evento+","+
                                    Strings_db.string_db_timeline.publicador+") values('"+
                                    alumnosJSON.getJSONObject(i).getString("id_item")+"','"+
                                    alumnosJSON.getJSONObject(i).getString("id_tipo")+"','"+
                                    alumnosJSON.getJSONObject(i).getString("titulo")+"','"+
                                    alumnosJSON.getJSONObject(i).getString("descripcion")+
                                    "','"+alumnosJSON.getJSONObject(i).getString("fecha_pub")+
                                    "','"+alumnosJSON.getJSONObject(i).getString("fecha_evento")+
                                    "','"+alumnosJSON.getJSONObject(i).getString("id_admin")+"')");
                        }
                        //  globales.cargarImagenes();

                    } else if (resultJSON == "2") {
                        devuelve = "no se an podido obtener las imagenes!!";
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
            return devuelve;
        }


        if (params[1]=="8"){  // guardando las imagenes de un nuevo item
            try {
                System.out.println("entro a asynctask imagenes");
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
                Cursor cursor=db_imagenes2.rawQuery(" select max("+Strings_db.string_db_imagenes.numeroImagen+") as "+Strings_db.string_db_imagenes.numeroImagen+","+Strings_db.string_db_imagenes.id_imagen+" from "+Strings_db.string_db_imagenes.nombre,null);
                if (cursor.moveToFirst()) {
                    if ( cursor.getString(1)==null){
                        jsonParam.put("id_itemActual","0");
                    }else {
                        jsonParam.put("id_itemActual", cursor.getString(1));
                        System.out.println(cursor.getString(1) + "---valor de la tabla imagenes");
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
                        JSONArray alumnosJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<alumnosJSON.length();i++){
                            System.out.println(alumnosJSON);
                               // estado es el nombre del campo en el JSON

                                System.out.println(alumnosJSON.getJSONObject(i).getString("Idimage"));
                                System.out.println(alumnosJSON.getJSONObject(i).getString("Imagen"));
                                Bitmap foto;
                                String ids = alumnosJSON.getJSONObject(i).getString("id");
                                String data = alumnosJSON.getJSONObject(i).getString("Imagen");
                                //data = alumnosJSON.getString(i);
                                System.out.println(devuelve + " datos devueltos");
                                byte[] cadenas = Base64.decode(data, Base64.DEFAULT);
                                foto = BitmapFactory.decodeByteArray(cadenas, 0, cadenas.length);
                                globales.ListaImagenes.add(foto);
                                String direccionReal = guardarImagen(globales.context, "img-" + ids + i, foto);
                                System.out.println(direccionReal);
                                db_imagenesconexion.execSQL("insert into " + Strings_db.string_db_imagenes.nombre + "(" +
                                        Strings_db.string_db_imagenes.id_imagen + "," + Strings_db.string_db_imagenes.direccion +
                                        ") values(" +
                                        ids +
                                        ",'" + direccionReal + "')");

                        }

                    } else if (resultJSON == "2") {
                        devuelve = "no se an podido obtener las imagenes!!";
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
            return devuelve;
        }


        return null;
    }
    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }
    @Override
    protected void onPostExecute(String s) {
        System.out.println(s);
        if (estadoParaGuardarImagenes){
            globales.guardarImagenes();
        }

        else if(obtenerItemActual){
            globales.obtenerItem();
        }
        else if (descargarImagenes){
            globales.descargarImagenes();
        }
        //super.onPostExecute(s);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    private String guardarImagen (Context context, String nombre, Bitmap imagen){
        ContextWrapper cw = new ContextWrapper(context);
        File dirImages = cw.getDir("Imagenes", Context.MODE_PRIVATE);
        File myPath = new File(dirImages, nombre + ".jpg");

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(myPath);
            imagen.compress(Bitmap.CompressFormat.JPEG, 10, fos);
            fos.flush();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return myPath.getAbsolutePath();
    }
}

