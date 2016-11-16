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
public class pensum_carrera_Criminologia extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum_SC adaptador;
    ArrayList<horario_pensum> hora_curso;


    public pensum_carrera_Criminologia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pensum_carrera__criminologia, container, false);


        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum_criminologia);
        horario_semestre=datos_pensum_criminologia.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();


        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("2554001");
        CodigoCurso.add("2554002");
        CodigoCurso.add("2554003");
        CodigoCurso.add("2554004");
        CodigoCurso.add("2554005");



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



        CodigoCurso1.add("2554006");
        CodigoCurso1.add("2554007");
        CodigoCurso1.add("2554008");
        CodigoCurso1.add("2554009");
        CodigoCurso1.add("2554010");



        requisitos1.add("-------");
        requisitos1.add("2554002");
        requisitos1.add("2554003");
        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso1,requisitos1));


        //DATA TERECER SEMESTRE
        ArrayList<String>CodigoCurso2=new ArrayList<>();
        ArrayList<String>requisitos2=new ArrayList<>();

        CodigoCurso2.add("Codigo\n");
        requisitos2.add("Requisito\n");


        CodigoCurso2.add("2554011");
        CodigoCurso2.add("2554012");
        CodigoCurso2.add("2554013");
        CodigoCurso2.add("2554014");
        CodigoCurso2.add("2554051");

        requisitos2.add("-------");
        requisitos2.add("2554007");
        requisitos2.add("2554008");
        requisitos2.add("-------");
        requisitos2.add("-------");
        requisitos2.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("2554016");
        CodigoCurso3.add("2554020");
        CodigoCurso3.add("2554052");
        CodigoCurso3.add("2554053");
        CodigoCurso3.add("2554054");

        requisitos3.add("-------");
        requisitos3.add("-------");
        requisitos3.add("-------");
        requisitos3.add("2554051");
        requisitos3.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("2554021");
        CodigoCurso4.add("2554025");
        CodigoCurso4.add("2554055");
        CodigoCurso4.add("2554056");
        CodigoCurso4.add("2554057");



        requisitos4.add("-------");
        requisitos4.add("2554053");
        requisitos4.add("2554053");
        requisitos4.add("-------");
        requisitos4.add("-------");


        hora_curso.add(new horario_pensum(CodigoCurso4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("2554026");
        CodigoCurso5.add("2554030");
        CodigoCurso5.add("2554058");
        CodigoCurso5.add("2554059");
        CodigoCurso5.add("2554060");

        requisitos5.add("-------");
        requisitos5.add("-------");
        requisitos5.add("2554053");
        requisitos5.add("2554053");
        requisitos5.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("2554031 ");
        CodigoCurso6.add("2554062 ");
        CodigoCurso6.add("2554063 ");
        CodigoCurso6.add("2554064 ");
        CodigoCurso6.add("2554065 ");


        requisitos6.add("-------");
        requisitos6.add("-------");
        requisitos6.add("-------");
        requisitos6.add("-------");
        requisitos6.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso6,requisitos6));

        //DATA OCTAVO SEMESTRE

        ArrayList<String>CodigoCurso7=new ArrayList<>();
        ArrayList<String>requisitos7=new ArrayList<>();

        CodigoCurso7.add("Codigo\n");
        requisitos7.add("Requisito\n");

        CodigoCurso7.add("2554040");
        CodigoCurso7.add("2554061");
        CodigoCurso7.add("2554066");
        CodigoCurso7.add("2554067");
        CodigoCurso7.add("2554068");


        requisitos7.add("-------");
        requisitos7.add("-------");
        requisitos7.add("2554012");
        requisitos7.add("-------");
        requisitos7.add("-------");



        hora_curso.add(new horario_pensum(CodigoCurso7,requisitos7));

        //DATA NOVENO SEMESTRE

        ArrayList<String>CodigoCurso8=new ArrayList<>();
        ArrayList<String>requisitos8=new ArrayList<>();

        CodigoCurso8.add("Codigo\n");
        requisitos8.add("Requisito\n");

        CodigoCurso8.add("2554041 ");

        requisitos8.add("Aprobados 8 Ciclos");

        hora_curso.add(new horario_pensum(CodigoCurso8,requisitos8));

        //DATA DECIMO SEMESTRE

        ArrayList<String>CodigoCurso9=new ArrayList<>();
        ArrayList<String>requisitos9=new ArrayList<>();

        CodigoCurso9.add("Codigo\n");
        requisitos9.add("Requisito\n");

        CodigoCurso9.add("2554042 ");

        requisitos9.add("Aprobados 9 Ciclos");

        hora_curso.add(new horario_pensum(CodigoCurso9,requisitos9));


        adaptador=new adapter_lista_pensum_SC(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);



        return v;
    }

}
