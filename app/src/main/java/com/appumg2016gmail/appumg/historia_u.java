package com.appumg2016gmail.appumg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class historia_u extends Fragment {

    ExpandableListView ELV_umg;
    LinkedHashMap<String, List<String>> data;
    List<String> subData;
    adaptador_sobreUMG adaptador;
    ArrayList<horario_pensum> hora_curso;

    public historia_u() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_historia_u, container, false);
        ELV_umg=(ExpandableListView) vista.findViewById(R.id.ELV_umg);
        data=data_infoUMG.getInformacion();
        subData=new ArrayList<String>(data.keySet());

        adaptador=new adaptador_sobreUMG(getContext(), data,subData);
        ELV_umg.setAdapter(adaptador);

        return vista;
    }

}
