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
public class horario_trabajoSocial extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_horario adaptador;
    ArrayList<hora_hor> hora_curso;



    public horario_trabajoSocial() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_horario_trabajo_social, container, false);


        listaExpandible=(ExpandableListView)v.findViewById(R.id.ListaExpansible_horarioTrabajoSocial);
        horario_semestre=datos_lista_horario_TrabajoSocial.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        hora_curso.add(new hora_hor("8:00 a 10:00","10:00 a 12:00","13:00 a 15:00","15:00 a 17:00","Viernes 18:00 a 20:00"));



        List<List<String>> catedraticos = new ArrayList<List<String>>();
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(0).add("Licda. Ysolda Marlin López Canek");
        catedraticos.get(0).add("Licda. Helen Lisbeth Leiva Calles");
        catedraticos.get(0).add("Licda. Gulyhelmy Patricia Ovando Chim");
        catedraticos.get(0).add("Licda. María de los Ángeles Chinchilla Paiz");
        catedraticos.get(0).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Licda. Marleny Surama Calderón Becerra");
        catedraticos.get(1).add("Lic. Jose Emilio Mardid Cruz");
        catedraticos.get(1).add("Licda. Brenda Mariana Arroyo Esquivel");
        catedraticos.get(1).add("Licda. Gulyhelmy Patricia Ovando Chim");
        catedraticos.get(1).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(2).add("Licda. Gloria Aurora González Velezquez");
        catedraticos.get(2).add("Licda. Gloria Aurora González Velezquez");
        catedraticos.get(2).add("Verena Janette Reyna Baños");
        catedraticos.get(2).add("Licda. Brenda Mariana Arroyo Esquivel");
        catedraticos.get(2).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(3).add("Licda. Helen Lisbeth Leiva Calles");
        catedraticos.get(3).add("Licda. Marleny Surama Calderón Becerra");
        catedraticos.get(3).add("Licda. María de los Ángeles Chinchilla Paiz");
        catedraticos.get(3).add("Verena Janette Reyna Baños");
        catedraticos.get(3).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(4).add("Lic. Jose Emilio Madrid Cruz");
        catedraticos.get(4).add("Licda. Ysolda Marlin López Canek");
        catedraticos.get(4).add("Licda. Gloria Llanira Catalán Puga");
        catedraticos.get(4).add("Licda. Gloria Llanira Catalán Puga");
        catedraticos.get(4).add("Licda. Patricia Judith Reyna Baños");
/*
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(5).add("Lic. Wilson Giovanni Molina");
        catedraticos.get(5).add("Lic. José Armando Muralles Maldonado");
        catedraticos.get(5).add("Lic. Herbert Vinicio Garcia");
        catedraticos.get(5).add("Lic. Ludwing Rubén Romero");
        catedraticos.get(5).add("Lic. Gustavo Arnoldo Ara Arriola");
*/


        adaptador=new adapter_lista_horario(getContext(),horario_semestre,horario_lista,hora_curso,catedraticos);
        listaExpandible.setAdapter(adaptador);


        return v;
    }

}
