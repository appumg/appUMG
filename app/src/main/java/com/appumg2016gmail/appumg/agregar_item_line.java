package com.appumg2016gmail.appumg;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class agregar_item_line extends AppCompatActivity {
private Button agregar;
    private String direccion_imagen;

    private String APP_DIRECTORY="MyPictureApp/";
    private String MEDIA_DIRECTORY=APP_DIRECTORY+"PictureApp";

    private final int MI_PERMISSIONS=100;
    private final int PHOTO_CODE=200;
    private final int SELECT_PICTURE=300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        agregar=(Button)findViewById(R.id.agregar);
    }



    public void agregar(View view){
        CharSequence[] opciones={"de la galeria","tomar foto", "cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(agregar_item_line.this);
        builder.setTitle("Elige la opcion");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              switch (which){
                  case 0:
                        tomar_foto();
                      break;
                  case 1:
                      Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      intent.setType("images/*");
                      startActivityForResult(Intent.createChooser(intent,"seleccionar la imagen"),SELECT_PICTURE);
                      break;
                  case 2:
                        dialog.dismiss();
                      break;
                  default:

              }
                builder.show();
            }

            private void tomar_foto() {
                File file=new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
                boolean isDirectoryCreated=file.exists();
                if (isDirectoryCreated){
                        isDirectoryCreated=file.mkdirs();
                }else{
                    Long timestam= System.currentTimeMillis()/1000;
                    String ImageName=timestam.toString()+".jpg";
                    direccion_imagen=Environment.getExternalStorageDirectory()+File.separator+MEDIA_DIRECTORY+file.separator+ImageName;
                    File files=new File(direccion_imagen);
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(files));
                    startActivityForResult(intent,PHOTO_CODE);

                }
            }
        });



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
                    case SELECT_PICTURE:
                        Uri direccion=data.getData();
                        break;
                }
        }
    }
}
