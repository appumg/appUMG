package com.appumg2016gmail.appumg;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
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
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class time_line extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private GridView galeria;
    private ArrayList<Uri> imagenes=new ArrayList<>();
    private ListView TimeLine;
    private AdaptadorContentTimeLine adaptadorContentTimeLine;
    private LinearLayout beahavior;
///----- creamos objetos de la base de datos y de la clase que crea la base de datos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        TimeLine = (ListView) findViewById(R.id.Ttimeline);
        beahavior=(LinearLayout) findViewById(R.id.behavior);
        final BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from(beahavior);
        cargar_items_a_la_linea();

        //se le agrega el evento on click para capturar las pulsaciones
        TimeLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        galeria=(GridView) findViewById(R.id.galeria);
       galeria.setAdapter(new galeria_adaptador(this,imagenes));
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_timeLine) {
            Toast.makeText(this, " time line", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, " galeria", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, " sliders", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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

    private void cargar_items_a_la_linea() {

        adaptadorContentTimeLine = new AdaptadorContentTimeLine(this);

        TimeLine.setAdapter(adaptadorContentTimeLine);

    }
}
