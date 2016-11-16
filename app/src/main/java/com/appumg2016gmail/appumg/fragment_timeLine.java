package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by zombozo on 20/10/2016.
 */

public class fragment_timeLine extends Fragment {
    private ListView TimeLine;
    private LinearLayout beahavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view;
        globales.context=getActivity();
        view=inflater.inflate(R.layout.content_time_line,viewGroup,false);
        /*String IPs = "http://appumg.pe.hu/php";
        final String OBTENERIMAGENES = IPs + "/obtener_imagenes.php";
        guardar_online obtener=new guardar_online();
        obtener.execute(OBTENERIMAGENES,"3"); */
        TimeLine = (ListView) view.findViewById(R.id.Ttimeline);
        registerForContextMenu(TimeLine);

        TimeLine.setAdapter(new AdaptadorContentTimeLine(getActivity()));
        beahavior=(LinearLayout) view.findViewById(R.id.behavior);
        TimeLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                globales.id_imagen=globales.id_item.get(i);
              //  Toast.makeText(getActivity(), "la seleccionada es:" , Toast.LENGTH_SHORT).show();
                bottonflotante bottonflotante=new bottonflotante();
                bottonflotante.show(globales.manager,"botton shet");

            }
        });
        /* String IP = "http://appumg.pe.hu/php";
        final String OBTENERIMAGENES = IP + "/obtener_imagenes.php";
        String OBTENERItem = IP + "/obtener_apartir.php";
        guardar_online obtener = new guardar_online();
        obtener.execute(OBTENERItem, "7");
        guardar_online obtenerlos=new guardar_online();
        obtenerlos.execute(OBTENERIMAGENES,"3");
        */
        //globales glo=new globales();
        return  view;
    }

    @Override
    public  void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo){
       int position;
        if (v.getId()==R.id.Ttimeline){
            position=((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            contextMenu.setHeaderTitle(TimeLine.getAdapter().getItem(position).toString());
            getActivity().getMenuInflater().inflate(R.menu.time_line,contextMenu);

        }
        super.onCreateContextMenu(contextMenu,v,menuInfo);

    }

}
