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
public class horario_psiclogioClinica extends Fragment {


    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_horario adaptador;
    ArrayList<hora_hor> hora_curso;


    public horario_psiclogioClinica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_horario_psiclogio_clinica, container, false);
        listaExpandible=(ExpandableListView)v.findViewById(R.id.ListaExpansible_horarioPiscologia);
        horario_semestre=datos_lista_horario_piscologia.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        hora_curso.add(new hora_hor("7:00 a 9:00","9:00 a 11:00","11:00 a 13:00","14:00 a 16:00","16:00 a 18:00"));

        List<List<String>> catedraticos = new ArrayList<List<String>>();
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(0).add("Lic. Amilcar Calderon");
        catedraticos.get(0).add("Dr. Carlos Kuylen");
        catedraticos.get(0).add("--------------------");
        catedraticos.get(0).add("Lic. José Pinelo");
        catedraticos.get(0).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Dr. Carlos Kuylen");
        catedraticos.get(1).add("Lic. Donis Lobos");
        catedraticos.get(1).add("Lic. Roberto Castellanos");
        catedraticos.get(1).add("Ing. José Contreras");
        catedraticos.get(1).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(2).add("Lic. Donis Lobos");
        catedraticos.get(2).add("Dr. José Flores");
        catedraticos.get(2).add("Licda. Ibdy Rodas");
        catedraticos.get(2).add("Lic. Roberto Castellanos");
        catedraticos.get(2).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(3).add("Lic. José Flores");
        catedraticos.get(3).add("Licda. Jacqueline Camacho");
        catedraticos.get(3).add("Licda. Candy Barrios");
        catedraticos.get(3).add("Licda. Gladys Ovando");
        catedraticos.get(3).add("Licda. Ibdy Rodas");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(4).add("Licda. Gladys Ovando");
        catedraticos.get(4).add("Licda. Candy Barrios");
        catedraticos.get(4).add("Licda. Gladys Ovando");
        catedraticos.get(4).add("Licda. Candy Barrios");
        catedraticos.get(4).add("--------------------");
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
