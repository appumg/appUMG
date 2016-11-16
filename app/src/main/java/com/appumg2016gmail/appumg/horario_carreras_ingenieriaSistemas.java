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
public class horario_carreras_ingenieriaSistemas extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_horario adaptador;
    ArrayList <hora_hor>hora_curso;


    public horario_carreras_ingenieriaSistemas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_horario_carreras, container, false);

        listaExpandible=(ExpandableListView)v.findViewById(R.id.ListaExpansible);
        horario_semestre=datos_lista_horario.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        hora_curso.add(new hora_hor("7:00 a 9:00","9:00 a 11:00","11:00 a 13:00","14:00 a 16:00","16:00 a 18:00"));



        List<List<String>> catedraticos = new ArrayList<List<String>>();
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(0).add("-----------");
        catedraticos.get(0).add("Lic. Israel Vitzil");
        catedraticos.get(0).add("Ing. Roberto Carlos Gonzáles");
        catedraticos.get(0).add("Ing. José Francisco Ochaeta");
        catedraticos.get(0).add("Ing. Alan Camey");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Lic. Israel Vitzil");
        catedraticos.get(1).add("Ing. Alan Camey");
        catedraticos.get(1).add("Ing. Jorge Ibarra");
        catedraticos.get(1).add("Ing. Roberto Carlos Gonzáles");
        catedraticos.get(1).add("-----------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Lic. Israel Vitzil");
        catedraticos.get(1).add("Ing. Alan Camey");
        catedraticos.get(1).add("Ing. Jorge Ibarra");
        catedraticos.get(1).add("Ing. Roberto Carlos Gonzáles");
        catedraticos.get(1).add("-----------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(2).add("Ing. José Francisco Ochaeta");
        catedraticos.get(2).add("Ing. Julio López");
        catedraticos.get(2).add("Ing. Remon Girard");
        catedraticos.get(2).add("Lic. Azucena Castellanos");
        catedraticos.get(2).add("Lic. Abel Santos");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(3).add("Ing. José Contreras");
        catedraticos.get(3).add("Ing. Jorge Ibarra");
        catedraticos.get(3).add("Ing. José Francisco Ochaeta");
        catedraticos.get(3).add("Ing. Edson Barrios");
        catedraticos.get(3).add("Lic. Azucena Castellanos");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(4).add("Ing. Roberto Carlos Gonzáles");
        catedraticos.get(4).add("Ing. Remon Girard");
        catedraticos.get(4).add("Ing. Alan Camey");
        catedraticos.get(4).add("Ing. Jorge Ibarra");
        catedraticos.get(4).add("Lic. Edson Barrios");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(5).add("-----------");
        catedraticos.get(5).add("Ing. Remon Girard");
        catedraticos.get(5).add("Ing. Azucena Castellanos");
        catedraticos.get(5).add("Ing. Julio López");
        catedraticos.get(5).add("Lic. Jorge Ibarra");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(6).add("-----------");
        catedraticos.get(6).add("Ing. Roberto Carlos Gonzáles");
        catedraticos.get(6).add("Ing. Edson Barrios");
        catedraticos.get(6).add("Ing. Alan Camey");
        catedraticos.get(6).add("Ing. Abel Santos");



        adaptador=new adapter_lista_horario(getContext(),horario_semestre,horario_lista,hora_curso,catedraticos);
        listaExpandible.setAdapter(adaptador);
        return v;
    }



}
