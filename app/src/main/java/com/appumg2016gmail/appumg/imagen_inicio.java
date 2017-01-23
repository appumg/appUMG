
package com.appumg2016gmail.appumg;

import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class imagen_inicio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_inicio);
        globales.context=getApplicationContext();
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null){
            NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancel(getIntent().getExtras().getInt("id"));
        }

        SQLiteDatabase db;
        db_login login=db_login.llamada(getApplicationContext());
        db=login.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from login",null);
        while (cursor.moveToNext()){
            String prueba=cursor.getString(0);
            if (prueba.isEmpty()==false) {
                globales.publicador = cursor.getString(1);
                globales.mostrarFloating=true;
                Toast.makeText(globales.context,"Bienvenido "+globales.publicador,Toast.LENGTH_LONG).show();
            }
        }

        Thread tiempo = new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                    sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    Intent pantallaprincipal = new Intent(imagen_inicio.this, time_line.class);
                    startActivity(pantallaprincipal);
                    new globales(1);
                    finish();
                }
            }
        });
        tiempo.start();
    }

}
