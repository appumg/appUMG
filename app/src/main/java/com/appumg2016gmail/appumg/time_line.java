package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class time_line extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int id=0;//=R.id.nav_timeLine;
    private boolean semaforo=false;
    private static FloatingActionsMenu boton_accion;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // onNavigationItemSelected(null);
        globales.manager=getSupportFragmentManager();
        boton_accion=(FloatingActionsMenu)findViewById(R.id.fab_menu);
        //galeria=(GridView) findViewById(R.id.galeria);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        id=R.id.nav_timeLine;
       // semaforo=true;
        onNavigationItemSelected(null);

    }

     public static void ocultar(){
         if (globales.mostrarFloating){
             boton_accion.setVisibility(View.VISIBLE);

         }else{
             boton_accion.setVisibility(View.INVISIBLE);
         }
     }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        ocultar();
        if(item!=null) {

            id = item.getItemId();
        }
        Fragment fragment=null;
        boolean estado=false;
        if (id == R.id.nav_timeLine) {
            fragment=new fragment_timeLine();
                toolbar.setTitle("Noticias");

            estado=true;
        } else if (id == R.id.nav_gallery) {
            Intent i=new Intent(time_line.this, carrerasU.class);
            startActivity(i);
        }  else if (id == R.id.menu_sobreUMG) {
            Intent i=new Intent(time_line.this, info_u.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(time_line.this, creditos.class));

        }else if(id==R.id.nav_login){


            if (globales.mostrarFloating){
                globales.mostrarFloating=false;
                SQLiteDatabase db;
                db_login login=db_login.llamada(getApplicationContext());
                db=login.getWritableDatabase();
                db.delete("login",null,null);
                ocultar();
            }else {
                startActivity(new Intent(time_line.this, login.class));
            }
        }
        if(estado){
            getFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void evento(View view) {
        Intent llamada = new Intent(time_line.this, agregar_item_line.class);
        startActivity(llamada);
        Snackbar.make(view, "trabajamos en esta opcion!! gracias! ", Snackbar.LENGTH_LONG).show();
    }

    public void noticia(View v) {
       startActivity(new Intent(time_line.this,eliminar.class));
    }


}
