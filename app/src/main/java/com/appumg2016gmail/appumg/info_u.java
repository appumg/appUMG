package com.appumg2016gmail.appumg;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class info_u extends AppCompatActivity {


    Toolbar toolbar;
    android.support.design.widget.TabLayout TabLayout;
    ViewPager viewPager;
    adaptador_viewPager viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.Tematab);/// Ponemos un tema especial para este activity, evita el duplicado de la barra de titulo
        setContentView(R.layout.activity_info_u);


        toolbar=(Toolbar)findViewById(R.id.toolBar);//Creamos una instancia de la barrita que contendra un enlace a los fragment y sera los encabezados
        setSupportActionBar(toolbar);///supongo que le enviamos el soporte para que se comporte como una actionBar

        TabLayout= (android.support.design.widget.TabLayout) findViewById(R.id.tabLayout);//tabLayout es el layout que contendra los elementos
        viewPager=(ViewPager)findViewById(R.id.viewPager);//visor de paginas

        viewPagerAdapter=new adaptador_viewPager(getSupportFragmentManager());//Instacia del adaptador de los fragments
        viewPagerAdapter.addFramnets(new historia_u(),"Historia UMG");//Agregamos framgens al adaptador
        viewPagerAdapter.addFramnets(new himno_u(),"Himno");
        viewPagerAdapter.addFramnets(new centros_u(),"Centros UMG");

        viewPager.setAdapter(viewPagerAdapter);//enviamos el adaptadora al visor de paginas
        TabLayout.setupWithViewPager(viewPager);//enviamos el visor de paginas al TabLayout






    }
}
