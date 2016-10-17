package com.appumg2016gmail.appumg;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class agregar_item_line extends AppCompatActivity {
private ImageButton agregar;
    private String direccion_imagen;
    private EditText descripcion,fecha,imagenes;
    private Spinner tipo_evento,publics;
    private int contador=0;

    private String APP_DIRECTORY="MyPictureApp/";
    private String MEDIA_DIRECTORY=APP_DIRECTORY+"PictureApp";

    private final int MI_PERMISSIONS=100;
    private final int PHOTO_CODE=200;
    private final int SELECT_PICTURE=300;
    private final String[] opciones={"seleccione el tipo de publicacion","evento proximo","noticia"};
    private final String[] publico={"seleccione una facultad ","ingenieria","todas las facultades"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //agregando referencias a botonoes de la view
        agregar=(ImageButton)findViewById(R.id.agregar);
        descripcion=(EditText)findViewById(R.id.descripcion);
        fecha=(EditText)findViewById(R.id.fecha);
        imagenes=(EditText) findViewById(R.id.imagenes);
        tipo_evento=(Spinner)findViewById(R.id.tipo_evento);
        publics=(Spinner)findViewById(R.id.publico);
        //preparo los adaptadores para los spinners
        ArrayAdapter<String> public_opciones=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,publico);
        ArrayAdapter<String> opcion =new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,opciones);
        //agrego los adatadores a los items
        tipo_evento.setAdapter(opcion);
        publics.setAdapter(public_opciones);


        //agregando efectos a edittext
        fecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    v.setBackgroundResource(R.drawable.bordes);
                }else{
                    v.setBackgroundResource(R.drawable.perdio_focus_borde);
                }
            }
        });

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
    }


//metodo que captura el evento del boton agregar imagenes
    public void agregar(View view){
        agregar.setBackgroundResource(R.drawable.ic_sube);
        CharSequence[] opciones={"de la galeria","tomar foto", "cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(agregar_item_line.this);
        builder.setTitle("Elige la opcion");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              switch (which){
                  case 0:
                      Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      intent.setType("image/*");
                      startActivityForResult(Intent.createChooser(intent,"seleccionar la imagen"),SELECT_PICTURE);

                      break;
                  case 1:
                      tomar_foto();
                      break;
                  case 2:
                        dialog.dismiss();
                      break;
                  default:

              }

            }


            

        });
        builder.show();

        agregar.setBackgroundResource(R.drawable.ic_pick);
    }
    private void tomar_foto() {
        File file=new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
        boolean isDirectoryCreated=file.exists();
        if (isDirectoryCreated){
            isDirectoryCreated=file.mkdirs();
        }else{
            Long timestam= System.currentTimeMillis()/1000;
            String ImageName=timestam.toString()+".jpg";

           /* if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())||!Environment.isExternalStorageRemovable()) {
                if (Environment.getExternalStorageDirectory()!=null) {*/
                    direccion_imagen = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + file.separator + ImageName;
            //    }
         //   }else{
               // if(Environment.getExternalStorageDirectory()!=null){
               //     direccion_imagen= Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + file.separator + ImageName;
              //  }
            }
            File files=new File(direccion_imagen);
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(files));
            startActivityForResult(intent,PHOTO_CODE);

        //}
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
                switch (requestCode){
                    case PHOTO_CODE:
                        MediaScannerConnection.scanFile(this, new String[]{direccion_imagen}, null, new MediaScannerConnection.OnScanCompletedListener() {
                            @Override
                            public void onScanCompleted(String path, Uri uri) {
                                Log.i("",""+path);

                            }

                        });
                       // imagenes.append("\n "+contador++ +" .-"+direccion_imagen);
                        break;
                    case SELECT_PICTURE:
                        Uri direccion=data.getData();
                        contador++;
                        imagenes.append("\n "+contador+".-"+obtenerDireccionReal(direccion));
                        // llamada al metodo que obtiene la direccion fisica en memoria de la imagen
                        Toast.makeText(this, obtenerDireccionReal(direccion), Toast.LENGTH_SHORT).show();
                        break;
                }
        }
    }

    private String obtenerDireccionReal(Uri direccion) {
        Cursor cursor=getContentResolver().query(direccion,null,null,null,null);
        cursor.moveToFirst();
        int indice=cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(indice);
    }
}
