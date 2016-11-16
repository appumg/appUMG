package com.appumg2016gmail.appumg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class carrerasU extends AppCompatActivity {

    Toolbar toolbar;
    android.support.design.widget.TabLayout TabLayout;
    ViewPager viewPager;
    adaptador_viewPager viewPagerAdapter;


    AlertDialog levelDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.Tematab);/// Ponemos un tema especial para este activity, evita el duplicado de la barra de titulo
        setContentView(R.layout.activity_carreras_u);

        toolbar=(Toolbar)findViewById(R.id.toolBar);//Creamos una instancia de la barrita que contendra un enlace a los fragment y sera los encabezados
        setSupportActionBar(toolbar);///supongo que le enviamos el soporte para que se comporte como una actionBar

        TabLayout= (android.support.design.widget.TabLayout) findViewById(R.id.tabLayout_carreras);//tabLayout es el layout que contendra los elementos
        viewPager=(ViewPager)findViewById(R.id.viewPager_carreras);//visor de paginas


// Opciones del AlertDialog
        final CharSequence[] items = {"Ingenieria en Sistemas","Administracion de Empresas","Contraduría Pública y Auditoria","Psicologia Clinica", "Trabajo Social", "Licenciatura en Criminología y Política Criminal"};

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione la Carrare sobre la cual desea Adquirir información");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {


                switch(item)
                {
                    case 0://Ingenieria en sistemas
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_ingenieriaSistemas(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_carreras_ingenieriaSistemas(),"Horarios");
                        viewPagerAdapter.addFramnets(new centros_u_IngenieriaSistemas(),"Centros UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 1://Administracion de empresas
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_administracionEmpresas(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_administracionEmrpresas(),"Horarios");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 2://Auditoria
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_auditoria(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_contaduriaYauditoria(),"Horarios");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 3://Psicologia
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_psicologia(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_psiclogioClinica(),"Horarios");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;

                    case 4://Trabajo social
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                         viewPagerAdapter.addFramnets(new pensumCarrera_trabajoSocial(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_trabajoSocial(),"Horarios");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 5://Criminologia
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensum_carrera_Criminologia(),"Pensum");//Agregamos framgens al adaptador
                        //viewPagerAdapter.addFramnets(new horario_trabajoSocial(),"Horarios");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;

                }
                levelDialog.dismiss();
            }
        });
        levelDialog = builder.create();
        levelDialog.show();




    }
}
