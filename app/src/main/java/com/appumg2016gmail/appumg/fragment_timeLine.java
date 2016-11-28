package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by zombozo on 20/10/2016.
 */

public class fragment_timeLine extends Fragment {
    private static ListView TimeLine;
    private static Context contexto;
    private LinearLayout beahavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view;
        globales.context=getActivity();
        contexto=getActivity();
        view=inflater.inflate(R.layout.content_time_line,viewGroup,false);
        TimeLine = (ListView) view.findViewById(R.id.Ttimeline);
        TimeLine.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                TimeLine.deferNotifyDataSetChanged();
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                TimeLine.deferNotifyDataSetChanged();
            }
        });
        recargar();

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
        return  view;
    }

    public static boolean recargar() {
        TimeLine.setAdapter(new AdaptadorContentTimeLine(contexto));
        Thread hilo= new Thread(new Runnable() {
            @Override
            public void run() {
                TimeLine.deferNotifyDataSetChanged();
            }
        });
        hilo.start();
        return true;
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
