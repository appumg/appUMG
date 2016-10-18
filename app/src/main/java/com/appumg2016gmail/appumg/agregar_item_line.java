package com.appumg2016gmail.appumg;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class agregar_item_line extends AppCompatActivity {
private ImageButton agregar;
    private String direccion_imagen;
    private EditText descripcion;
    private EditText imagenes;
    private Spinner tipo_evento;
    private Spinner publics;
    private int contador=0;
    private TextView fechas;


    private final int SELECT_PICTURE=300;
    private final String[] opciones={"tipo de publicacion","evento proximo","noticia"};
    private final String[] publico={"la facultad ","ingenieria","todas las facultades"};
    private ImageButton botonCalendario;
    private LayoutInflater contieneCalendario;
    private String V_fecha="",tiempos="";
    private int hora;

    /// ---------------------------todas las variables que se guardaran en la base de datos;
    private String BD_titulo;
    private int DB_tipoPublicacion=-1;
    private int DB_facultad=-1;
    private String DB_descripcion;
    private int DB_fecha=-1;
    private int DB_hora=-1;
    private int DB_idImagenes=2;
    private int DB_diaActual;
    private int DB_mesActual;
    private int DB_yearActual;
    private int DB_fechaActual;
    private int DB_horaActual;
    private int DB_publicador=2;
    //------------variables comprobadoras de estados
    private int c_estadoNoticia,c_facultad;


    //----- objetos nesesario para la base de datos
    SQLiteDatabase db;
    db_timeLine conexion;
    private int version=1;

    //------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
   //----- obteniendo referencias de los objetos
        conexion=new db_timeLine(this,version);
        db=conexion.getWritableDatabase();

//------------------agregando referencias a los campos de en la vista
        agregar=(ImageButton)findViewById(R.id.agregar);
        descripcion=(EditText)findViewById(R.id.descripcion);
        botonCalendario=(ImageButton)findViewById(R.id.botonCalendario);
        fechas=(TextView)findViewById(R.id.fecha);
        imagenes=(EditText) findViewById(R.id.imagenes);
        tipo_evento=(Spinner)findViewById(R.id.tipo_evento);
        publics=(Spinner)findViewById(R.id.publico);


//---------------------preparo los adaptadores para los spinners
        ArrayAdapter<String> public_opciones=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, publico);
        ArrayAdapter<String> opcion =new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, opciones);
        //agrego los adatadores a los items
        tipo_evento.setAdapter(opcion);
        publics.setAdapter(public_opciones);

//--------------- agregando efectos a cuadro descripcion del evento
        descripcion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    v.setBackgroundResource(R.drawable.bordes);
                }else{
                    v.setBackgroundResource(R.drawable.perdio_focus_borde);
                }
            }
        });


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


        publics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setDB_facultad(position+1);
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
        DB_mesActual=calendario.get(Calendar.MONTH);
        DB_yearActual=calendario.get(Calendar.YEAR);
        String tempo=""+DB_diaActual+DB_mesActual+DB_yearActual;
        DB_fechaActual=Integer.parseInt(tempo);
        DatePickerDialog dialogoCalendario=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String tempo=""+dayOfMonth+monthOfYear+year;
                V_fecha=dayOfMonth+"/"+monthOfYear+"/"+year;
                fechas.setText(V_fecha+tiempos);
                setDB_fecha(Integer.parseInt(tempo));
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
        String tempo=""+horas+minutos;
        DB_horaActual=Integer.parseInt(tempo);

        final TimePickerDialog tiempo=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String tempo=""+hourOfDay+minute;
                    tiempos=" a las "+hourOfDay+":"+minute;
                   fechas.setText(V_fecha+tiempos);
                setDB_hora(Integer.parseInt(tempo));
                fechas.setTextSize(15);
            }
        },horas,minutos,false);
        tiempo.show();
    }
///-----------evento del boton guardar

    public void guardar(View view){
        setBD_titulo(descripcion.getText().toString());
        setDB_descripcion(descripcion.getText().toString());
        boolean estado; /// comprobara el contenido de las variables que se deben guardar
        estado=getBD_titulo().isEmpty();
        estado|=getDB_descripcion().isEmpty();
        if (getDB_fecha()  ==-1){
            estado |=true;
        }
        if (getDB_hora()==-1){
            estado|=true;
        }
        if (getDB_idImagenes()==-1){
            estado |=true;
        }
        if (getDB_facultad()==-1){
            estado |=true;
        }
        if (getDB_tipoPublicacion() ==-1){
            estado |=true;
        }
        if (getDB_publicador()==-1){
            estado |=true;
        }


        // si el stado esta en falso todos los campos contienen datos
        if (estado){
            Snackbar.make(view,"alguno de los campos esta vacio, porfavor completelo",Snackbar.LENGTH_LONG).show();
        }else{  String SQL="create table timeline(" +
                "id integer primary key autoincrement, " +
                "tipo integer," +
                "titulo text, " +
                "descripcion text, " +
                "fecha_pub integer," +
                "hora_pub integer, " +
                "fecha_evento integer," +
                "hora_evento integer, " +
                "publicador integer, " +
                "id_imagenes integer)";

            db.execSQL("insert into timeline(tipo,titulo ,descripcion,fecha_pub,hora_pub,fecha_evento,hora_evento,publicador,id_imagenes ) values("+
            getDB_tipoPublicacion()+",'"+getBD_titulo()+"','"+getDB_descripcion()+"',"+DB_fechaActual+","+DB_fechaActual+","+getDB_fecha()+","+getDB_hora()+","+
            getDB_publicador()+","+getDB_idImagenes()+")");
            Toast.makeText(this, "Se guardo Correctamente el nuevo evento", Toast.LENGTH_SHORT).show();
            this.finish();

        }
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

    public void setDB_tipoPublicacion(int DB_tipoPublicacion) {
        this.DB_tipoPublicacion = DB_tipoPublicacion;
    }

    public int getDB_facultad() {
        return DB_facultad;
    }

    public void setDB_facultad(int DB_facultad) {
        this.DB_facultad = DB_facultad;
    }

    public String getDB_descripcion() {
        return DB_descripcion;
    }

    public void setDB_descripcion(String DB_descripcion) {
        this.DB_descripcion = DB_descripcion;
    }

    public int getDB_fecha() {
        return DB_fecha;
    }

    public void setDB_fecha(int DB_fecha) {
        this.DB_fecha = DB_fecha;
    }

    public int getDB_hora() {
        return DB_hora;
    }

    public void setDB_hora(int DB_hora) {
        this.DB_hora = DB_hora;
    }

    public int getDB_idImagenes() {
        return DB_idImagenes;
    }

    public void setDB_idImagenes(int DB_idImagenes) {
        this.DB_idImagenes = DB_idImagenes;
    }


    public int getDB_publicador() {
        return DB_publicador;
    }

    public void setDB_publicador(int DB_publicador) {
        this.DB_publicador = DB_publicador;
    }
}
