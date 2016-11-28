package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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

import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class info_u extends AppCompatActivity {


    Toolbar toolbar;
    android.support.design.widget.TabLayout TabLayout;
    ViewPager viewPager;
    adaptador_viewPager viewPagerAdapter;
    DrawerLayout drl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.Tematab);/// Ponemos un tema especial para este activity, evita el duplicado de la barra de titulo
        setContentView(R.layout.info_u_drawerlayout);

        toolbar=(Toolbar)findViewById(R.id.toolBar_tabs);//Creamos una instancia de la barrita que contendra un enlace a los fragment y sera los encabezados
        toolbar.setTitle("Sobre Umg");
        setSupportActionBar(toolbar);///supongo que le enviamos el soporte para que se comporte como una actionBar

        TabLayout= (android.support.design.widget.TabLayout) findViewById(R.id.tabLayout);//tabLayout es el layout que contendra los elementos
        viewPager=(ViewPager)findViewById(R.id.viewPager);//visor de paginas

        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
        viewPagerAdapter.addFramnets(new historia_u(),"Datos UMG");//Agregamos framgens al adaptador
        viewPagerAdapter.addFramnets(new himno_u(),"Himno");
        viewPagerAdapter.addFramnets(new direccionAcademica(),"Direccion Academica");

        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout


        drl=(DrawerLayout)findViewById(R.id.DL_infoU);//Refencia al menu lateral
        NavigationView nav=(NavigationView)findViewById(R.id.NV_infoU);//Referencia al visor

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(//Boton en el actionbar para abrir o cerrar el draweraLayout
                this,drl, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drl.setDrawerListener(toggle);
        toggle.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//Metodo escucha del DrawerLayout
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment=null;
                boolean estado=false;

                switch (item.getItemId()) {
                    case R.id.nav_timeLine:
                        startActivity(new Intent(info_u.this, time_line.class));
                        break;
                    case R.id.nav_gallery:
                        startActivity(new Intent(info_u.this, carrerasU.class));
                        break;
                    case R.id.menu_sobreUMG:
                        drl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_login:


                        break;

                }
                return true;

            }
        });
    }



}
