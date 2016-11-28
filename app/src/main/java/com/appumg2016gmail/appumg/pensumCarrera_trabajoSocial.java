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
public class pensumCarrera_trabajoSocial extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum_SC adaptador;
    ArrayList<horario_pensum> hora_curso;



    public pensumCarrera_trabajoSocial() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_pensum_carrera_trabajo_social, container, false);

        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum_trabajoSocial);
        horario_semestre=datos_pensum_trabajoSocial.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();


        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("0977401");
        CodigoCurso.add("0977402");
        CodigoCurso.add("0977403");
        CodigoCurso.add("0977404");


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



        CodigoCurso1.add("0977405");
        CodigoCurso1.add("0977406");
        CodigoCurso1.add("0977407");
        CodigoCurso1.add("0977408");



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


        CodigoCurso2.add("0977409 ");
        CodigoCurso2.add("0977410 ");
        CodigoCurso2.add("0977411 ");
        CodigoCurso2.add("0977412 ");

        requisitos2.add("-------");
        requisitos2.add("-------");
        requisitos2.add("-------");
        requisitos2.add("-------");
        requisitos2.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("0977413");
        CodigoCurso3.add("0977414");
        CodigoCurso3.add("0977415");
        CodigoCurso3.add("0977416");

        requisitos3.add("-------");
        requisitos3.add("-------");
        requisitos3.add("-------");
        requisitos3.add("0977411");

        hora_curso.add(new horario_pensum(CodigoCurso3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("0977418");
        CodigoCurso4.add("0977419");
        CodigoCurso4.add("0977420");
        CodigoCurso4.add("0977421");


        requisitos4.add("-------");
        requisitos4.add("0977413");
        requisitos4.add("-------");
        requisitos4.add("0977415");


        hora_curso.add(new horario_pensum(CodigoCurso4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("0977422");
        CodigoCurso5.add("0977424");
        CodigoCurso5.add("0977425");
        CodigoCurso5.add("0977426");

        requisitos5.add("-------");
        requisitos5.add("0977421");
        requisitos5.add("-------");
        requisitos5.add("0977416");

        hora_curso.add(new horario_pensum(CodigoCurso5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("0977427");
        CodigoCurso6.add("0977428");
        CodigoCurso6.add("0977429");
        CodigoCurso6.add("0977430");


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

        CodigoCurso7.add("0977431");
        CodigoCurso7.add("0977432");
        CodigoCurso7.add("0977433");
        CodigoCurso7.add("0977434");

        requisitos7.add("-------");
        requisitos7.add("-------");
        requisitos7.add("0977428");
        requisitos7.add("Aprobados 7 Ciclos");


        hora_curso.add(new horario_pensum(CodigoCurso7,requisitos7));

        //DATA NOVENO SEMESTRE

        ArrayList<String>CodigoCurso8=new ArrayList<>();
        ArrayList<String>requisitos8=new ArrayList<>();

        CodigoCurso8.add("Codigo\n");
        requisitos8.add("Requisito\n");

        CodigoCurso8.add("0977435");
        CodigoCurso8.add("0977436");
        CodigoCurso8.add("0977437");
        CodigoCurso8.add("0977438");

        requisitos8.add("-------");
        requisitos8.add("-------");
        requisitos8.add("-------");
        requisitos8.add("Aprobados 8 Ciclos");

        hora_curso.add(new horario_pensum(CodigoCurso8,requisitos8));

        //DATA DECIMO SEMESTRE

        ArrayList<String>CodigoCurso9=new ArrayList<>();
        ArrayList<String>requisitos9=new ArrayList<>();

        CodigoCurso9.add("Codigo\n");
        requisitos9.add("Requisito\n");

        CodigoCurso9.add("0977439");
        CodigoCurso9.add("0977440");
        CodigoCurso9.add("0977441");
        CodigoCurso9.add("0977442");

        requisitos9.add("0977436");
        requisitos9.add("-------");
        requisitos9.add("-------");
        requisitos9.add("0977437");

        hora_curso.add(new horario_pensum(CodigoCurso9,requisitos9));


        //DATA COORDINADOR
        ArrayList<String>codCOrd=new ArrayList<>();
        codCOrd.add("");
        hora_curso.add(new horario_pensum(codCOrd,codCOrd,codCOrd));



        adaptador=new adapter_lista_pensum_SC(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);



        return v;
    }

}
