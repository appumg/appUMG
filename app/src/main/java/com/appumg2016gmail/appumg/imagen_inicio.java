package com.appumg2016gmail.appumg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class imagen_inicio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_inicio);
        globales.context=getApplicationContext();

        Thread tiempo = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    globales globales=new globales(1);
                    Intent pantallaprincipal = new Intent(imagen_inicio.this, time_line.class);
                    startActivity(pantallaprincipal);
                    finish();
                }
            }
        });
        tiempo.start();
    }

}
