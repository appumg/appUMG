package com.appumg2016gmail.appumg;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by zombozo on 20/10/2016.
 */

public class fragment_timeLine extends Fragment {
    private ListView TimeLine;
    private LinearLayout beahavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view;
        view=inflater.inflate(R.layout.content_time_line,viewGroup,false);
        TimeLine = (ListView) view.findViewById(R.id.Ttimeline);
        TimeLine.setAdapter(new AdaptadorContentTimeLine(getActivity()));
        beahavior=(LinearLayout) view.findViewById(R.id.behavior);
        TimeLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bottonflotante bottonflotante=new bottonflotante();
                bottonflotante.show(globales.manager,"botton shet");
                globales.id_imagen=i;
            }
        });
        return  view;
    }
}
