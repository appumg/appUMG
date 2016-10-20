package com.appumg2016gmail.appumg;

import android.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;
import java.util.ArrayList;
public class time_line extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Uri> imagenes=new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private NavigationView menu;
    private int id=2131493035;

///----- creamos objetos de la base de datos y de la clase que crea la base de datos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);


        //se le agrega el evento on click para capturar las pulsaciones

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        globales.manager=getSupportFragmentManager();

        swipeRefreshLayout=(SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Boolean estado=onNavigationItemSelected(null);
                if (estado){
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        menu = (NavigationView) findViewById(R.id.nav_view);
        menu.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int ids = menuItem.getItemId();
                        id=menuItem.getItemId();
                        if (ids == R.id.nav_timeLine) {

                            Toast.makeText(getApplicationContext(), " time line", Toast.LENGTH_SHORT).show();
                        } else if (ids == R.id.nav_gallery) {

                            Toast.makeText(getApplicationContext(), " galeria", Toast.LENGTH_SHORT).show();
                        } else if (ids == R.id.nav_slideshow) {

                            Toast.makeText(getApplicationContext(), " sliders", Toast.LENGTH_SHORT).show();
                        } else if (ids == R.id.nav_login) {

                        } else if (ids == R.id.nav_share) {

                        } else if (ids == R.id.nav_send) {

                        }

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                }
        );
        onNavigationItemSelected(null);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.time_line, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        boolean estado=false;
        //id=item.getItemId();
        Fragment fragment_actual=null;
        if (id == R.id.nav_timeLine) {
            fragment_actual=new fragment_timeLine();
            estado=true;
            Toast.makeText(this, " time line " +id, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, " galeria "+id, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, " sliders "+id, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_login) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        if (estado){
            getFragmentManager().beginTransaction().replace(R.id.contenedor,fragment_actual).commit();
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
        Snackbar.make(v,"felicidades sin querer as creado una base de datos de 5000000 campos ",Snackbar.LENGTH_LONG).show();
    }
}
