package com.appumg2016gmail.appumg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class carrerasU extends AppCompatActivity {

    Toolbar toolbar;
    android.support.design.widget.TabLayout TabLayout;
    ViewPager viewPager;
    adaptador_viewPager viewPagerAdapter;
    NavigationView nav;

    AlertDialog levelDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.Tematab);/// Ponemos un tema especial para este activity, evita el duplicado de la barra de titulo
        setContentView(R.layout.carreras_u_drawerlayout);

        toolbar=(Toolbar)findViewById(R.id.toolBar_tabs);//Creamos una instancia de la barrita que contendra un enlace a los fragment y sera los encabezados
        setSupportActionBar(toolbar);///supongo que le enviamos el soporte para que se comporte como una actionBar

        TabLayout= (android.support.design.widget.TabLayout) findViewById(R.id.tabLayout_carreras);//tabLayout es el layout que contendra los elementos
        viewPager=(ViewPager)findViewById(R.id.viewPager_carreras);//visor de paginas


// Opciones del AlertDialog
        final CharSequence[] items = {"Ingenieria en Sistemas","Administracion de Empresas","Contraduría Pública y Auditoria","Psicologia Clinica", "Trabajo Social", "Licenciatura en Criminología y Política Criminal"};


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione la Carrare sobre la cual desea Adquirir información");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {


                switch(item)
                {
                    case 0://Ingenieria en sistemas
                        toolbar.setTitle("Ingenieria en Sistemas");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_ingenieriaSistemas(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_carreras_ingenieriaSistemas(),"Horario");
                        viewPagerAdapter.addFramnets(new centros_u_IngenieriaSistemas(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 1://Administracion de empresas
                        toolbar.setTitle("Administracion de Empresas");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_administracionEmpresas(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_administracionEmrpresas(),"Horario");
                        viewPagerAdapter.addFramnets(new centro_auditoriaYadministracion(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 2://Auditoria
                        toolbar.setTitle("Contraduría Pública y Auditoria");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_auditoria(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_contaduriaYauditoria(),"Horario");
                        viewPagerAdapter.addFramnets(new centro_auditoriaYadministracion(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 3://Psicologia
                        toolbar.setTitle("Psicologia Clinica");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensumCarrera_psicologia(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_psiclogioClinica(),"Horario");
                        viewPagerAdapter.addFramnets(new centros_u_IngenieriaSistemas(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;

                    case 4://Trabajo social
                        toolbar.setTitle("Trabajo Social");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                         viewPagerAdapter.addFramnets(new pensumCarrera_trabajoSocial(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_trabajoSocial(),"Horario");
                        viewPagerAdapter.addFramnets(new centros_u_IngenieriaSistemas(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;
                    case 5://Criminologia
                        toolbar.setTitle("Licenciatura en Criminología");
                        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
                        viewPagerAdapter.addFramnets(new pensum_carrera_Criminologia(),"Pensum");//Agregamos framgens al adaptador
                        viewPagerAdapter.addFramnets(new horario_criminologia(),"Horario");
                        viewPagerAdapter.addFramnets(new centros_u_IngenieriaSistemas(),"Centro UMG");

                        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
                        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout
                        break;

                }
                levelDialog.dismiss();
            }
        });
        levelDialog = builder.create();
        levelDialog.show();

        final DrawerLayout drl=(DrawerLayout)findViewById(R.id.DL_carrerasU);//Refencia al menu lateral
        nav=(NavigationView)findViewById(R.id.NV_carrerasU);//Referencia al visor

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(//Boton en el actionbar para abrir o cerrar el draweraLayout
                this,drl, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drl.setDrawerListener(toggle);
        toggle.syncState();



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//Metodo escucha del DrawerLayout
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_timeLine:
                        startActivity(new Intent(carrerasU.this, time_line.class));
                        break;
                    case R.id.nav_gallery:
                        //startActivity(new Intent(carrerasU.this, carrerasU.class));
                        drl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.menu_sobreUMG:
                        startActivity(new Intent(carrerasU.this, info_u.class));
                        break;
                    case R.id.nav_login:
                        Toast.makeText(carrerasU.this, "Login!!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
  }
}
