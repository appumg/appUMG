package com.appumg2016gmail.appumg;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class agregar_item_line extends AppCompatActivity {
private ImageButton agregar;
    private String direccion_imagen;
    private EditText titulo;
    private EditText descripcion;
    private EditText imagenes;
    private Spinner tipo_evento;
    private Spinner publics;
    private int contador=0;
    private TextView fechas;


    // objeto para la clase guardar_online
    private guardar_online guardarlo;

    private final int SELECT_PICTURE=300;
    private final String[] opciones={"tipo de publicacion","evento proximo","noticia"};
    private final String[] publico={"la facultad ","ingenieria","todas las facultades"};
    private ArrayList<String> listaImagenesOnline=new ArrayList<>();
    private ImageButton botonCalendario;
    private LayoutInflater contieneCalendario;
    private String V_fecha="",tiempos="";
    private int hora;
    private int id_actualTimeLine=1;
    private int idActualizar=1;
    /// ---------------------------todas las variables que se guardaran en la base de datos;
    private String BD_titulo;
    private int DB_tipoPublicacion;
    private String DB_facultad;
    private String DB_descripcion;
    private String DB_fecha="";
    private String DB_hora="";
    private int DB_idImagenes=2;
    private int DB_diaActual;
    private int DB_mesActual;
    private int DB_yearActual;
    private String DB_fechaActual;
    private String DB_horaActual;
    private String DB_publicador=globales.publicador;
    private ArrayList<String> ListaImagenes=new ArrayList<>();
    //------------variables comprobadoras de estados
    private int c_estadoNoticia,c_facultad;


    //----- objetos nesesario para la base de datos
    SQLiteDatabase db_timeline;
    SQLiteDatabase db_imagenesconexion;
    SQLiteDatabase db_itemsTimeLine;

    db_timeLine timeLine;
    db_imagenes imagenesConexion;
    db_itemsTimeLine itemsTimeLine;
    private int version=1;
    String IP = "http://appumg.pe.hu/php";
    String INSERT = IP + "/insertar_item.php";


    //------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
   //----- obteniendo referencias de los objetos
        timeLine= db_timeLine.llamada(this);
        imagenesConexion= db_imagenes.llamada(this);
        itemsTimeLine=new db_itemsTimeLine(this,version);
        db_imagenesconexion=imagenesConexion.getWritableDatabase();
        db_itemsTimeLine=itemsTimeLine.getWritableDatabase();
        db_timeline=timeLine.getWritableDatabase();
        globales.listaImagenesOnline.clear();
//------------------agregando referencias a los campos de en la vista
        titulo=(EditText)findViewById(R.id.titulo);
        agregar=(ImageButton)findViewById(R.id.agregar);
        descripcion=(EditText)findViewById(R.id.descripcion);
        botonCalendario=(ImageButton)findViewById(R.id.botonCalendario);
        fechas=(TextView)findViewById(R.id.fecha);
        imagenes=(EditText) findViewById(R.id.imagenes);
        tipo_evento=(Spinner)findViewById(R.id.tipo_evento);
//---------------------preparo los adaptadores para los spinners
        db_tipo_evento eventos=db_tipo_evento.llamada(this);
        ArrayAdapter<String> public_opciones=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, publico);
        ArrayAdapter<String> opcion =new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, opciones);
        //agrego los adatadores a los items
        tipo_evento.setAdapter(opcion);
//------------------- obteniendo valores de los spinners

        tipo_evento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setDB_tipoPublicacion(position+1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

//------------------------metodo que captura el evento del boton agregar imagenes
    public void agregar(View view){
        agregar.setBackgroundResource(R.drawable.ic_pick);
                      Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      intent.setType("image/*");
                      startActivityForResult(Intent.createChooser(intent,"seleccionar la imagen"), SELECT_PICTURE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
                switch (requestCode){
                    case SELECT_PICTURE:

                        Uri direccion=data.getData();
                        contador++;
                        imagenes.append("\n "+ contador +".-"+obtenerDireccionReal(direccion));
                        ListaImagenes.add(obtenerDireccionReal(direccion));
                        String direccionReal=obtenerDireccionReal(direccion);
                        globales.listaImagenesOnline.add(direccionReal);
                        // llamada al metodo que obtiene la direccion fisica en memoria de la imagen
                        break;
                }
        }
    }
//------------------------------ obteniendo la direccion fisica en memoria y carpetas de la imagen seleccionada
    private String obtenerDireccionReal(Uri direccion) {
        Cursor cursor=getContentResolver().query(direccion,null,null,null,null);
        cursor.moveToFirst();
        int indice=cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(indice);
    }
//------------------------------------------ mostrando calendario
    public void calendario(View view){
        final Calendar calendario=Calendar.getInstance();
        DB_diaActual=calendario.get(Calendar.DAY_OF_MONTH);
        DB_mesActual=calendario.get(Calendar.MONTH)+1;
        DB_yearActual=calendario.get(Calendar.YEAR);
        DB_fechaActual=""+DB_yearActual +"-"+DB_mesActual+"-"+DB_diaActual;
        DatePickerDialog dialogoCalendario=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                V_fecha=""+year +"-"+monthOfYear+"-"+dayOfMonth;
                fechas.setText(V_fecha+" "+tiempos);
                DB_fecha=V_fecha;
            }
        }, DB_yearActual, DB_mesActual, DB_diaActual);
        dialogoCalendario.show();

    }
//----------------------- mostrando opciones para mostrar hora
    public void hora(View view){
        int horas,minutos;
        Calendar calendario=Calendar.getInstance();
        horas=calendario.get(Calendar.HOUR_OF_DAY);
        minutos=calendario.get(Calendar.MINUTE);
        if (horas<10) {
            DB_horaActual = "0" + horas + ":" + minutos + ":00";
        }
        else if (minutos<10){
            DB_horaActual = "0" + horas + ":0" + minutos + ":00";
        }
        else{
            DB_horaActual=horas+":"+minutos+":00";
        }
        final TimePickerDialog tiempo=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay<10) {
                    tiempos = "0"+hourOfDay + ":" + minute + ":00";
                }
                else if (minute<10){
                    tiempos = "0"+hourOfDay + ":" + minute + ":00";
                }else{
                    tiempos=hourOfDay+":"+minute+":00";
                }
                   fechas.setText(V_fecha+" "+tiempos);
               DB_hora=tiempos;
                fechas.setTextSize(15);
            }
        },horas,minutos,false);
        tiempo.show();
    }
///-----------evento del boton guardar

    public void guardar(View view){
        setBD_titulo(titulo.getText().toString());
        setDB_descripcion(descripcion.getText().toString());
        boolean estado; /// comprobara el contenido de las variables que se deben guardar
        estado=getBD_titulo().isEmpty();
        estado|=getDB_descripcion().isEmpty();
            estado |=DB_fecha.isEmpty();
            estado|=DB_hora.isEmpty();
        if (ListaImagenes.size()==0){
            estado |=true;
        }
        // si el stado esta en falso todos los campos contienen datos
        if (estado){
            Snackbar.make(view,"alguno de los campos esta vacio, porfavor completelo",Snackbar.LENGTH_LONG).show();
        }else{
            guardar_online guardarlo=new guardar_online();
            guardarlo.execute(INSERT,"1",""+getDB_tipoPublicacion(),""+DB_publicador,getBD_titulo(),getDB_descripcion(),DB_fechaActual+" "+DB_horaActual,V_fecha+" "+tiempos,"1");
            this.finish(); // cerramos la actividad
        }
    }
    //evento carga los registros a la pantalla para actualizarlos
    public void cargarParaActualizar(){
        Cursor items=db_timeline.rawQuery("select * from "+Strings_db.string_db_timeline.nombre,null);
        if (items.moveToFirst()){
            do {
                titulo.setText(items.getString(2));
                fechas.setText(items.getString(6)+ " a las "+items.getString(7));
                descripcion.setText(items.getString(3));
                tipo_evento.setSelection(1);
            }while(items.moveToNext());
        }
    }
///evento para actualizar un registro
    public void actualizar(){
        ContentValues valores=new ContentValues();
        valores.put(Strings_db.string_db_timeline.tipo,getDB_tipoPublicacion());
        valores.put(Strings_db.string_db_timeline.titulo,getBD_titulo());
        valores.put(Strings_db.string_db_timeline.descripcion,getDB_descripcion());
        valores.put(Strings_db.string_db_timeline.fecha_publicacion,DB_fechaActual);
        valores.put(Strings_db.string_db_timeline.fecha_evento,getDB_fecha());
        valores.put(Strings_db.string_db_timeline.publicador,getDB_publicador());
        db_timeline.update(Strings_db.string_db_timeline.nombre,valores,Strings_db.string_db_timeline.id+"="+idActualizar,null);
    }
    public void cancelar(View vi){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("¿Seguro que quieres salir sin guardar?");
        builder.setNegativeButton("no quiero salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Si, quiero salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cerrar();
            }
        });
        builder.show();
    }
    public void cerrar(){
        this.finish();
    }
    ///----------------- geters y setters de las variables para la base de datos
    public String getBD_titulo() {
        return BD_titulo;
    }
    public void setBD_titulo(String BD_titulo) {
        this.BD_titulo = BD_titulo;
    }
    public int getDB_tipoPublicacion() {
        return DB_tipoPublicacion;
    }
    public void setDB_tipoPublicacion(int DB_tipoPublicacion) {this.DB_tipoPublicacion = DB_tipoPublicacion;}
    public String getDB_descripcion() {
        return DB_descripcion;
    }
    public void setDB_descripcion(String DB_descripcion) {
        this.DB_descripcion = DB_descripcion;
    }
    public String getDB_fecha() {
        return DB_fecha;
    }
     public String getDB_publicador() {
        return DB_publicador;
    }




}
