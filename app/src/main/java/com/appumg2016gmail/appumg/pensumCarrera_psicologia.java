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
public class pensumCarrera_psicologia extends Fragment {
    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum_SC adaptador;
    ArrayList<horario_pensum> hora_curso;




    public pensumCarrera_psicologia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pensum_carrera_psicologia, container, false);


        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum_psicologia);
        horario_semestre=datos_pensum_psicologia.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();


        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("3017100");
        CodigoCurso.add("3017101");
        CodigoCurso.add("3017102");
        CodigoCurso.add("3017103");


        requisitos.add("Requisito\n");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");

        hora_curso.add(new horario_pensum(CodigoCurso,requisitos));


        //DATA SEGUNDO SEMESTRE
        ArrayList<String>CodigoCurso1=new ArrayList<>();
        ArrayList<String>requisitos1=new ArrayList<>();

        CodigoCurso1.add("Codigo\n");
        requisitos1.add("Requisito\n");



        CodigoCurso1.add("3017104");
        CodigoCurso1.add("3017105");
        CodigoCurso1.add("3017106");
        CodigoCurso1.add("3017107");



        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso1,requisitos1));


        //DATA TERECER SEMESTRE
        ArrayList<String>CodigoCurso2=new ArrayList<>();
        ArrayList<String>requisitos2=new ArrayList<>();

        CodigoCurso2.add("Codigo\n");
        requisitos2.add("Requisito\n");


        CodigoCurso2.add("3017108");
        CodigoCurso2.add("3017109");
        CodigoCurso2.add("3017110");
        CodigoCurso2.add("3017111");

        requisitos2.add("3017102");
        requisitos2.add("3017107");
        requisitos2.add("-------");
        requisitos2.add("-------");
        requisitos2.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("3017112  ");
        CodigoCurso3.add("3017113  ");
        CodigoCurso3.add("3017114  ");
        CodigoCurso3.add("3017115  ");

        requisitos3.add("-------");
        requisitos3.add("-------");
        requisitos3.add("3017109");
        requisitos3.add("3017110");

        hora_curso.add(new horario_pensum(CodigoCurso3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("3017116");
        CodigoCurso4.add("3017117");
        CodigoCurso4.add("3017118");
        CodigoCurso4.add("3017119");


        requisitos4.add("3017112");
        requisitos4.add("-------");
        requisitos4.add("-------");
        requisitos4.add("3017108");


        hora_curso.add(new horario_pensum(CodigoCurso4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("3017120 ");
        CodigoCurso5.add("3017121 ");
        CodigoCurso5.add("3017122 ");
        CodigoCurso5.add("3017123 ");

        requisitos5.add("3017118");
        requisitos5.add("-------");
        requisitos5.add("-------");
        requisitos5.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("3017124");
        CodigoCurso6.add("3017125");
        CodigoCurso6.add("3017126");
        CodigoCurso6.add("3017127");
        CodigoCurso6.add("3017128");


        requisitos6.add("3017120");
        requisitos6.add("3017119");
        requisitos6.add("3017115");
        requisitos6.add("3017110");
        requisitos6.add("3017120");

        hora_curso.add(new horario_pensum(CodigoCurso6,requisitos6));

        //DATA OCTAVO SEMESTRE

        ArrayList<String>CodigoCurso7=new ArrayList<>();
        ArrayList<String>requisitos7=new ArrayList<>();

        CodigoCurso7.add("Codigo\n");
        requisitos7.add("Requisito\n");

        CodigoCurso7.add("3017129 ");
        CodigoCurso7.add("3017130 ");
        CodigoCurso7.add("3017131 ");
        CodigoCurso7.add("3017132 ");
        CodigoCurso7.add("3017133 ");

        requisitos7.add("3017128");
        requisitos7.add("-------");
        requisitos7.add("3017126");
        requisitos7.add("3017127");
        requisitos7.add("3017116");

        hora_curso.add(new horario_pensum(CodigoCurso7,requisitos7));

        //DATA NOVENO SEMESTRE

        ArrayList<String>CodigoCurso8=new ArrayList<>();
        ArrayList<String>requisitos8=new ArrayList<>();

        CodigoCurso8.add("Codigo\n");
        requisitos8.add("Requisito\n");

        CodigoCurso8.add("3017134");
        CodigoCurso8.add("3017135");
        CodigoCurso8.add("3017136");
        CodigoCurso8.add("3017137");
        CodigoCurso8.add("3017138");

        requisitos8.add("-------");
        requisitos8.add("3017114");
        requisitos8.add("3017131");
        requisitos8.add("3017132");
        requisitos8.add("3017130");

        hora_curso.add(new horario_pensum(CodigoCurso8,requisitos8));

        //DATA DECIMO SEMESTRE

        ArrayList<String>CodigoCurso9=new ArrayList<>();
        ArrayList<String>requisitos9=new ArrayList<>();

        CodigoCurso9.add("Codigo\n");
        requisitos9.add("Requisito\n");

        CodigoCurso9.add("3017139");
        CodigoCurso9.add("3017140");
        CodigoCurso9.add("3017141");
        CodigoCurso9.add("3017142");
        CodigoCurso9.add("3017143");

        requisitos9.add("3017138");
        requisitos9.add("3017136");
        requisitos9.add("3017136");
        requisitos9.add("3017137");
        requisitos9.add("3017135");

        hora_curso.add(new horario_pensum(CodigoCurso9,requisitos9));


        adaptador=new adapter_lista_pensum_SC(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);


        return v;
    }

}
