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
public class horario_contaduriaYauditoria extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_horario adaptador;
    ArrayList <hora_hor>hora_curso;



    public horario_contaduriaYauditoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_horario_contaduria_yauditoria, container, false);

        listaExpandible=(ExpandableListView)v.findViewById(R.id.ListaExpansible_horarioAuditoria);
        horario_semestre=datos_lista_horario_auditoria.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        hora_curso.add(new hora_hor("9:00 a 11:00","11:00 a 13:00","14:00 a 16:00","16:00 a 18:00","18:00 a 20:00"));



        List<List<String>> catedraticos = new ArrayList<List<String>>();
        catedraticos.add(new ArrayList<String>());
        catedraticos.get(0).add("Licda. Leticia Marilú Barrios Gabriel");
        catedraticos.get(0).add("Lic. Erick Ariel Batres Ramos");
        catedraticos.get(0).add("Lic. Rodolfo Gonzáles Romero");
        catedraticos.get(0).add("Lic. Calderón Becerra");
        catedraticos.get(0).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(1).add("Lic. Erick Estuardo Castellanos");
        catedraticos.get(1).add("Licda. Iris Balvina Ramos Súñiga");
        catedraticos.get(1).add("Lic. José Armando Muralles Maldonado");
        catedraticos.get(1).add("Lic. Herbert Vinicio García");
        catedraticos.get(1).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(2).add("Ing. Rodolfo Gonzáles Romero");
        catedraticos.get(2).add("Lic. Herbert Vinicio Garcia");
        catedraticos.get(2).add("Lic. Ludwing Rubén Romero");
        catedraticos.get(2).add("Lic. Wilson Giovanni Molina");
        catedraticos.get(2).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(3).add("Lic. José Armando Muralles Maldonado");
        catedraticos.get(3).add("Lic. Wilson Giovanni Molina");
        catedraticos.get(3).add("Lic. Tobias Valle");
        catedraticos.get(3).add("Lic. Lino Andino Diaz");
        catedraticos.get(3).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(4).add("Lic. Amado Nery Morales Ruiz");
        catedraticos.get(4).add("Lic. Tobias Valle");
        catedraticos.get(4).add("Lic. Lino Andino Diaz");
        catedraticos.get(4).add("Licda. Fabiola Peche");
        catedraticos.get(4).add("--------------------");

        catedraticos.add(new ArrayList<String>());
        catedraticos.get(5).add("Lic. Wilson Giovanni Molina");
        catedraticos.get(5).add("Lic. José Armando Muralles Maldonado");
        catedraticos.get(5).add("Lic. Herbert Vinicio Garcia");
        catedraticos.get(5).add("Lic. Ludwing Rubén Romero");
        catedraticos.get(5).add("Lic. Gustavo Arnoldo Ara Arriola");



        adaptador=new adapter_lista_horario(getContext(),horario_semestre,horario_lista,hora_curso,catedraticos);
        listaExpandible.setAdapter(adaptador);


        return v;
    }

}
