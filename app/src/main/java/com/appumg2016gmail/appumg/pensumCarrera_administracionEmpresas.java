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
public class pensumCarrera_administracionEmpresas extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum_SC adaptador;
    ArrayList<horario_pensum> hora_curso;



    public pensumCarrera_administracionEmpresas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pensum_carrera_administracion_empresas, container, false);



        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum_AdministracionEmpresas);
        horario_semestre=datos_pensum_administracionDeEmpresas.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();


        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("0218340");
        CodigoCurso.add("0218341");
        CodigoCurso.add("0218342");
        CodigoCurso.add("0218343");
        CodigoCurso.add("0218344");



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



        CodigoCurso1.add("0218345");
        CodigoCurso1.add("0218346");
        CodigoCurso1.add("0218347");
        CodigoCurso1.add("0218349");
        CodigoCurso1.add("0218353");


        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("0218343");
        requisitos1.add("0218341");
        requisitos1.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso1,requisitos1));


        //DATA TERECER SEMESTRE
        ArrayList<String>CodigoCurso2=new ArrayList<>();
        ArrayList<String>requisitos2=new ArrayList<>();

        CodigoCurso2.add("Codigo\n");
        requisitos2.add("Requisito\n");


        CodigoCurso2.add("0218348 ");
        CodigoCurso2.add("0218350 ");
        CodigoCurso2.add("0218351 ");
        CodigoCurso2.add("0218355 ");
        CodigoCurso2.add("0218356 ");

        requisitos2.add("0218347");
        requisitos2.add("0218346");
        requisitos2.add("0218347");
        requisitos2.add("0218345");
        requisitos2.add("0218400");

        hora_curso.add(new horario_pensum(CodigoCurso2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("0218352 ");
        CodigoCurso3.add("0218354 ");
        CodigoCurso3.add("0218357 ");
        CodigoCurso3.add("0218358 ");
        CodigoCurso3.add("0218359 ");

        requisitos3.add("0218351");
        requisitos3.add("0218");
        requisitos3.add("0218353");
        requisitos3.add("0218");
        requisitos3.add("0218355");

        hora_curso.add(new horario_pensum(CodigoCurso3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("0218360");
        CodigoCurso4.add("0218361");
        CodigoCurso4.add("0218362");
        CodigoCurso4.add("0218363");
        CodigoCurso4.add("0218364");

        requisitos4.add("0218356");
        requisitos4.add("0218352");
        requisitos4.add("0218352");
        requisitos4.add("0218358");
        requisitos4.add("0218357");

        hora_curso.add(new horario_pensum(CodigoCurso4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("0218365");
        CodigoCurso5.add("0218366");
        CodigoCurso5.add("0218367");
        CodigoCurso5.add("0218368");
        CodigoCurso5.add("0218369");

        requisitos5.add("0218350");
        requisitos5.add("0218361");
        requisitos5.add("0218359");
        requisitos5.add("0218349");
        requisitos5.add("0218364");

        hora_curso.add(new horario_pensum(CodigoCurso5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("0218370");
        CodigoCurso6.add("0218371");
        CodigoCurso6.add("0218373");
        CodigoCurso6.add("0218374");
        CodigoCurso6.add("0218375");


        requisitos6.add("0218352, 0218365");
        requisitos6.add("0218363, 0218366");
        requisitos6.add("0218350");
        requisitos6.add("Aprobados 6 Ciclos");
        requisitos6.add("0218369");

        hora_curso.add(new horario_pensum(CodigoCurso6,requisitos6));

        //DATA OCTAVO SEMESTRE

        ArrayList<String>CodigoCurso7=new ArrayList<>();
        ArrayList<String>requisitos7=new ArrayList<>();

        CodigoCurso7.add("Codigo\n");
        requisitos7.add("Requisito\n");

        CodigoCurso7.add("0218372");
        CodigoCurso7.add("0218376");
        CodigoCurso7.add("0218377");
        CodigoCurso7.add("0218378");
        CodigoCurso7.add("0218379");

        requisitos7.add("0218371");
        requisitos7.add("Aprobados 7 Ciclos");
        requisitos7.add("0218362, 0218365");
        requisitos7.add("0218370, 0218375");
        requisitos7.add("0218375");

        hora_curso.add(new horario_pensum(CodigoCurso7,requisitos7));


        adaptador=new adapter_lista_pensum_SC(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);



        return v;
    }

}
