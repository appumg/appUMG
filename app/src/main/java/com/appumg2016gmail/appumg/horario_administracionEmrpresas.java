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
public class horario_administracionEmrpresas extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_horario adaptador;
    ArrayList<hora_hor> hora_curso;


    public horario_administracionEmrpresas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_horario_administracion_emrpresas, container, false);

        listaExpandible=(ExpandableListView)v.findViewById(R.id.ListaExpansibleHorario_administracionEmpresas);
        horario_semestre=datos_lista_horarioAdministracionEmpresas.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        hora_curso.add(new hora_hor("7:00 a 9:00","9:00 a 11:00","11:00 a 13:00","14:00 a 16:00","16:00 a 18:00"));



        List<List<String>> catedraticos = new ArrayList<List<String>>();
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(0).add("Lic. Gloria Catalan de Marroquin");
        catedraticos.get(0).add("Lic. Heidy Jilissa Chan Pineda");
        catedraticos.get(0).add("Lic. Carlos Betancourt");
        catedraticos.get(0).add("Lic. José Luis Zapata Hernández");
        catedraticos.get(0).add("Lic. Erick Estuardo Castellanos");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Lic. Carlos Betancourt");
        catedraticos.get(1).add("Lic. Gloria Catalan de Marroquin");
        catedraticos.get(1).add("Lic. José Luis Zapata Hernández");
        catedraticos.get(1).add("Lic. Erick Estuardo Castellanos");
        catedraticos.get(1).add("Lic. Eick Ariel Batres Ramos");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(2).add("Lic. Jackeline Camacho");
        catedraticos.get(2).add("Lic. Oniel Benitez");
        catedraticos.get(2).add("Lic. Gustavo Arnoldo Ara Arriola");
        catedraticos.get(2).add("Lic. Eick Ariel Batres Ramos");
        catedraticos.get(2).add("Lic. Vilma Pereira");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(3).add("--------------------");
        catedraticos.get(3).add("Lic. Herbert Vinicio Garcia");
        catedraticos.get(3).add("Lic. Ramiro Menéndez Ordoñez");
        catedraticos.get(3).add("Lic. José Emilio Madrid Cruz");
        catedraticos.get(3).add("Ing. Rodolfo González Romero");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(4).add("--------------------");
        catedraticos.get(4).add("Lic. Ludwing Rubén Romero");
        catedraticos.get(4).add("Ing. Rodolfo Gonzáles Romero");
        catedraticos.get(4).add("Lic. Ramiro Menéndez Ordoñez");
        catedraticos.get(4).add("Lic. Gustavo Arnoldo Ara Arriola");

        adaptador=new adapter_lista_horario(getContext(),horario_semestre,horario_lista,hora_curso,catedraticos);
        listaExpandible.setAdapter(adaptador);

        return v;
    }

}
