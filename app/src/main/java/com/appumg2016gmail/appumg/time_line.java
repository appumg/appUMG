package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
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
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class time_line extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView TimeLine;
    private ArrayAdapter<String> adaptador;
    private AdaptadorContentTimeLine adaptadorContentTimeLine;
    private LinearLayout beahavior;
    private GridView galeria;
    private ArrayList<Integer> id_items=new ArrayList<>();
    private SwipeRefreshLayout refrescar;

    private ArrayList<Uri> imagenes=new ArrayList<>();
///----- creamos objetos de la base de datos y de la clase que crea la base de datos
    private SQLiteDatabase itemsConenedor;
    private db_itemsTimeLine db_itemsTimeLine;
    private int version=1;
    private int id=2131493068;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        onNavigationItemSelected(null);
        globales.manager=getSupportFragmentManager();
        galeria=(GridView) findViewById(R.id.galeria);
        refrescar=(SwipeRefreshLayout)findViewById(R.id.swipe);
        refrescar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                boolean estado=onNavigationItemSelected(null);
                if (estado){
                    refrescar.setRefreshing(false);
                }
            }
        });
/// ---- cargando las bases de datos




        galeria.setAdapter(new galeria_adaptador(this));


        beahavior=(LinearLayout) findViewById(R.id.behavior);
        final BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from(beahavior);

       // ArrayList<Uri> imagenes=new ArrayList<Uri>(){};

        // asignnando el adaptador al listview principal
        TimeLine = (ListView) findViewById(R.id.Ttimeline);
        //---- llamamos el metodo que cargar la linea de tiempo
        cargar_items_a_la_linea();




        //se le agrega el evento on click para capturar las pulsaciones
        TimeLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              globales.id_imagen=i+1;
             //   bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
      navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem item) {
               id = item.getItemId();
              if (id == R.id.nav_timeLine) {
                  Toast.makeText(time_line.this, ""+id, Toast.LENGTH_SHORT).show();
              } else if (id == R.id.nav_gallery) {




                  Intent i=new Intent(time_line.this, carrerasU.class);
                  startActivity(i);

              } else if (id == R.id.nav_slideshow) {


              } else if (id == R.id.menu_sobreUMG) {

                  Intent i=new Intent(time_line.this, info_u.class);
                  startActivity(i);


              } else if (id == R.id.nav_share) {

              } else if (id == R.id.nav_send) {

              }

                  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
      });

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
        // int id = item.getItemId();

        Fragment fragment=null;
        boolean estado=false;
        if (id == R.id.nav_timeLine) {
            fragment=new fragment_timeLine();
            estado=true;
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.menu_sobreUMG) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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
        db_timeLine time = new db_timeLine(this, 1);
        SQLiteDatabase db;
        db = time.getWritableDatabase();
        Snackbar.make(v,"felicidades sin querer as creado una base de datos de 5000000 campos ",Snackbar.LENGTH_LONG).show();
    }

    ///------ metodo que se ejecuta para cargar los items que se muestran en la linea de tiempo
    private void cargar_items_a_la_linea() {

        adaptadorContentTimeLine = new AdaptadorContentTimeLine(this);

        TimeLine.setAdapter(adaptadorContentTimeLine);

    }
}
