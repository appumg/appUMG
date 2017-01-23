package com.appumg2016gmail.appumg;

import android.content.ContentValues;
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
import java.io.ByteArrayOutputStream;
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
                System.out.println(params[6]+"  fechas  "+params[7]);
                HttpURLConnection urlConn=conexion(cadena);
                //Creo el Objeto JSON
                JSONObject jsonParam=new JSONObject();

                jsonParam.put("id_tipo",params[2]);
                jsonParam.put("id_admin",params[3]);
                jsonParam.put("titulo",params[4]);
                jsonParam.put("descripcion",params[5]);
                jsonParam.put("fecha_pub",params[6]);
                jsonParam.put("fecha_evento",params[7]);
                jsonParam.put("id_imagen",params[8]);
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
                        devuelve = "Imagen insertada correctamente";
                        obtenerItemActual=true;
                        globales.semaforo=true;
                       System.out.println(devuelve);
                    } else if (resultJSON == "2") {
                        globales.semaforo=true;
                        devuelve = "La imagen no pudo insertarse";
                        System.out.println(devuelve);
                    }
                }
            } catch (MalformedURLException e) {
               devuelve="A ocurrido un error intente nuevamente!";
            } catch (IOException e) {
                devuelve="ERROR: el evento Pudo no haberse subido, se intentara en breve";
            } catch (JSONException e) {
                devuelve="ERROR: no se pudo leer el valor del servidor";
            }catch (Exception e){
                devuelve="ERROR:"+e.getMessage();
            }
            return devuelve;
        }
             if(params[1]=="4"){    // Consulta la ultima id del item recien insertado

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
                        JSONArray itemsJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<itemsJSON.length();i++){
                            globales.idItemActual=Integer.parseInt(itemsJSON.getJSONObject(i).getString("id_item"));
                            System.out.println(globales.idItemActual+" esta es la item obtenida!! ----------------");
                            estadoParaGuardarImagenes=true;
                            temporal_imagenes temporal=temporal_imagenes.llamada(globales.context);
                            SQLiteDatabase db=temporal.getWritableDatabase();
                            for (int a=0;a<globales.listaImagenesOnline.size();a++) {
                                ContentValues valores = new ContentValues();
                                valores.put("Imagen", globales.listaImagenesOnline.get(a));
                                valores.put("id", globales.idItemActual);
                                db.insert("temporal_imagenes", null, valores);
                            }
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
            }catch (Exception e){
                e.printStackTrace();
            }
            return devuelve;
        }
        if (params[1] == "6") {   // enviamos la imagen al servidor
            estadoParaGuardarImagenes=false;
            globales.semaforo=false;
            System.out.println("entro a guardar las imagenes");
            temporal_imagenes temporal=temporal_imagenes.llamada(globales.context);
            SQLiteDatabase db=temporal.getWritableDatabase();


                try {
                    HttpURLConnection urlConn=conexion(cadena);
                    //Creo el Objeto JSON
                    JSONObject jsonParam = new JSONObject();
                    String direccionReal=params[2];
                    Bitmap bitmap; // creamos un objeto de tipo bitmap para la imagen
                    BitmapFactory.Options opciones=new BitmapFactory.Options();
                    opciones.inSampleSize=3;
                    bitmap= BitmapFactory.decodeFile(direccionReal,opciones); //creamos la imagen con la direccion real
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
                    byte[] imagebyte=baos.toByteArray();
                    String encondeImage = Base64.encodeToString(imagebyte, Base64.DEFAULT);
                    jsonParam.put("image", encondeImage);
                    System.out.print("se a cargado la imagen al json------------------------"+direccionReal);
                    jsonParam.put("id", params[3]);
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
                        System.out.println(result.toString() + " este error ocurrio ------------");
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados
                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                        if (resultJSON == "1") {      // hay un alumno que mostrar
                            globales.semaforo = true;
                            db.delete("temporal_imagenes", "id_auto=" + params[4], null);
                            devuelve = "imagen  insertada correctamente";
                            System.out.println(devuelve);
                        } else if (resultJSON == "2") {
                            globales.semaforo = true;
                            devuelve = "la imagen no pudo insertarse";
                            System.out.println(devuelve);
                        }
                    }
                } catch (MalformedURLException e) {
                    devuelve="";
                } catch (IOException e) {
                    devuelve="";
                } catch (JSONException e) {
                    devuelve="";
                }catch (Exception e){
                    devuelve="ERROR:"+e.getMessage();
                }
                db.close();
            return devuelve;
        }
        if (params[1]=="7"){  // obteniendo los items
            try {
               // descargarImagenes=true;
                System.out.println("entro a asynctask items");
                HttpURLConnection urlConn=conexion(cadena);
                //Creo el Objeto JSON
                JSONObject jsonParam=new JSONObject();
                        jsonParam.put("id_itemActual", params[2]);
                        System.out.println(params[2]+ "---");

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
                        JSONArray itemsJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<itemsJSON.length();i++){
                            System.out.println(itemsJSON);
                            db_timeline.execSQL("insert into "+Strings_db.string_db_timeline.nombre+"("+Strings_db.string_db_timeline.id+","+Strings_db.string_db_timeline.tipo+","+Strings_db.string_db_timeline.titulo+
                                    " ,"+Strings_db.string_db_timeline.descripcion+","+Strings_db.string_db_timeline.fecha_publicacion+","+Strings_db.string_db_timeline.fecha_evento+","+
                                    Strings_db.string_db_timeline.publicador+") values('"+
                                    itemsJSON.getJSONObject(i).getString("id_item")+"','"+
                                    itemsJSON.getJSONObject(i).getString("id_tipo")+"','"+
                                    itemsJSON.getJSONObject(i).getString("titulo")+"','"+
                                    itemsJSON.getJSONObject(i).getString("descripcion")+
                                    "','"+itemsJSON.getJSONObject(i).getString("fecha_pub")+
                                    "','"+itemsJSON.getJSONObject(i).getString("fecha_evento")+
                                    "','"+itemsJSON.getJSONObject(i).getString("id_admin")+"')");
                        }
                       devuelve="descargar completada";

                    } else if (resultJSON == "2") {
                        devuelve = "Error de descarga, se Intentara nuevamente!!";
                        System.out.println(devuelve);
                    }
                }
            } catch (MalformedURLException e) {
                System.out.println("Errores:"+e.getMessage()+e.getCause()+"----------------------------------");
            } catch (IOException e) {
                devuelve=e.getMessage();
            } catch (JSONException e) {
                devuelve="El servidor No respondio Correctamente - "+e.getMessage();
            } catch (Exception e){
                devuelve="ocurrio un error al obtener item, se intentara mas tarde";
                e.printStackTrace();
            }
            return devuelve;
        }


        if (params[1]=="8"){  // guardando las imagenes de un nuevo item
            try {
                globales.semaforo=false;
                System.out.println("entro a asynctask imagenes");
                HttpURLConnection urlConn=conexion(cadena);
                //Creo el Objeto JSON
                JSONObject jsonParam=new JSONObject();
                        jsonParam.put("id_itemActual", params[2]);
                        System.out.println(params[2] + "---valor de la tabla imagenes");
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
                        JSONArray itemsJSON = respuestaJSON.getJSONArray("items");   // estado es el nombre del campo en el JSON
                        for(int i=0;i<itemsJSON.length();i++){
                            System.out.println(itemsJSON);
                               // estado es el nombre del campo en el JSON
                                System.out.println(itemsJSON.getJSONObject(i).getString("Idimage"));
                                System.out.println(itemsJSON.getJSONObject(i).getString("Imagen"));
                                Bitmap foto;
                                String ids = itemsJSON.getJSONObject(i).getString("id");
                                String data = itemsJSON.getJSONObject(i).getString("Imagen");
                                String numero=itemsJSON.getJSONObject(i).getString("Idimage");
                                //data = alumnosJSON.getString(i);
                                System.out.println(devuelve + " datos devueltos");
                                byte[] cadenas = Base64.decode(data, Base64.DEFAULT);
                                foto = BitmapFactory.decodeByteArray(cadenas, 0, cadenas.length);
                                globales.ListaImagenes.add(foto);
                                String direccionReal = guardarImagen(globales.context, "img-" + ids + numero, foto);
                                System.out.println(direccionReal);
                                db_imagenesconexion.execSQL("insert into " + Strings_db.string_db_imagenes.nombre + "(" +
                                        Strings_db.string_db_imagenes.id_imagen + "," + Strings_db.string_db_imagenes.direccion +
                                        ","+Strings_db.string_db_timeline.numero+") values(" +
                                        ids +
                                        ",'" + direccionReal + "','"+numero+"')");
                            globales.semaforoImagenes=true;


                        }

                    } else if (resultJSON == "2") {
                        globales.semaforoImagenes=true;
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
            catch (Exception e){
                devuelve="error, se intentara descargar la imagen nuevamente en breve";
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
        if (s!=""){
            Toast.makeText(globales.context,s,Toast.LENGTH_LONG).show();
        }
        if (estadoParaGuardarImagenes){
            globales.guardarImagenes();
        }

        else if(obtenerItemActual){
            globales.obtenerItem();
        }
        else if (descargarImagenes){
           // globales.descargarImagenes();
        }
        globales.semaforo=true;
        globales.semaforoImagenes=true;
        fragment_timeLine.recargar();
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

    public HttpURLConnection conexion(String cadena) throws MalformedURLException {
        HttpURLConnection urlConn;
        URL url = new URL(cadena);
        try {
            urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestProperty("Content-Type", "application/json");
        urlConn.setRequestProperty("Accept", "application/json");
            urlConn.connect();
        } catch (IOException e) {
            urlConn=null;
           return urlConn;
        }

        return urlConn;
    }
}

