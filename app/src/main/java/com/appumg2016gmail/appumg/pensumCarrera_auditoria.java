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
public class pensumCarrera_auditoria extends Fragment {
    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum adaptador;
    ArrayList<horario_pensum> hora_curso;



    public pensumCarrera_auditoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pensum_carrera_auditoria, container, false);


        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum_Auditoria);
        horario_semestre=datos_pensum_auditoria.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());


        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>creditos=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();


        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("0325168 ");
        CodigoCurso.add("0325169 ");
        CodigoCurso.add("0325170 ");
        CodigoCurso.add("0325171 ");


        creditos.add("Creditos\n");
        creditos.add("4");
        creditos.add("4");
        creditos.add("4");
        creditos.add("4");

        requisitos.add("Requisito\n");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");
        requisitos.add("------");

        hora_curso.add(new horario_pensum(CodigoCurso,creditos,requisitos));


        //DATA SEGUNDO SEMESTRE
        ArrayList<String>CodigoCurso1=new ArrayList<>();
        ArrayList<String>creditos1=new ArrayList<>();
        ArrayList<String>requisitos1=new ArrayList<>();

        CodigoCurso1.add("Codigo\n");
        creditos1.add("Creditos\n");
        requisitos1.add("Requisito\n");



        CodigoCurso1.add("0325172");
        CodigoCurso1.add("0325173");
        CodigoCurso1.add("0325174");
        CodigoCurso1.add("0325175");


        creditos1.add("5");
        creditos1.add("4");
        creditos1.add("5");
        creditos1.add("4");


        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("0325169, 0325170");
        requisitos1.add("0325169");


        hora_curso.add(new horario_pensum(CodigoCurso1,creditos1,requisitos1));


        //DATA TERECER SEMESTRE
        ArrayList<String>CodigoCurso2=new ArrayList<>();
        ArrayList<String>creditos2=new ArrayList<>();
        ArrayList<String>requisitos2=new ArrayList<>();

        CodigoCurso2.add("Codigo\n");
        creditos2.add("Creditos\n");
        requisitos2.add("Requisito\n");


        CodigoCurso2.add("0325179");
        CodigoCurso2.add("0325900");
        CodigoCurso2.add("0325901");
        CodigoCurso2.add("0325902");

        creditos2.add("5");
        creditos2.add("5");
        creditos2.add("5");
        creditos2.add("4");

        requisitos2.add("0325174");
        requisitos2.add("0325172");
        requisitos2.add("0325172");
        requisitos2.add("0325173");

        hora_curso.add(new horario_pensum(CodigoCurso2,creditos2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>creditos3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        creditos3.add("Creditos\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("0325178");
        CodigoCurso3.add("0325180");
        CodigoCurso3.add("0325903");
        CodigoCurso3.add("0325904");

        creditos3.add("4");
        creditos3.add("4");
        creditos3.add("5");
        creditos3.add("5");

        requisitos3.add("0325175");
        requisitos3.add("0325175");
        requisitos3.add("0325900");
        requisitos3.add("0325901");

        hora_curso.add(new horario_pensum(CodigoCurso3,creditos3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>creditos4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        creditos4.add("Creditos\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("0325182 ");
        CodigoCurso4.add("0325905 ");
        CodigoCurso4.add("0325906 ");
        CodigoCurso4.add("0325907 ");

        creditos4.add("5");
        creditos4.add("4");
        creditos4.add("5");
        creditos4.add("5");

        requisitos4.add("0325180");
        requisitos4.add("0325178");
        requisitos4.add("0325904");
        requisitos4.add("0325903, 0325904");

        hora_curso.add(new horario_pensum(CodigoCurso4,creditos4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>creditos5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        creditos5.add("Creditos\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("0325185 ");
        CodigoCurso5.add("0325908 ");
        CodigoCurso5.add("0325910 ");
        CodigoCurso5.add("0325911 ");


        creditos5.add("4");
        creditos5.add("5");
        creditos5.add("5");
        creditos5.add("5");


        requisitos5.add("0325179");
        requisitos5.add("0325906");
        requisitos5.add("0325906");
        requisitos5.add("0325907");

        hora_curso.add(new horario_pensum(CodigoCurso5,creditos5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>creditos6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        creditos6.add("Creditos\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("0325186");
        CodigoCurso6.add("0325909");
        CodigoCurso6.add("0325912");
        CodigoCurso6.add("0325914");

        creditos6.add("4");
        creditos6.add("4");
        creditos6.add("5");
        creditos6.add("5");;

        requisitos6.add("0325185");
        requisitos6.add("0325902");
        requisitos6.add("0325908");
        requisitos6.add("0325910");

        hora_curso.add(new horario_pensum(CodigoCurso6,creditos6,requisitos6));

        //DATA OCTAVO SEMESTRE

        ArrayList<String>CodigoCurso7=new ArrayList<>();
        ArrayList<String>creditos7=new ArrayList<>();
        ArrayList<String>requisitos7=new ArrayList<>();

        CodigoCurso7.add("Codigo\n");
        creditos7.add("Creditos\n");
        requisitos7.add("Requisito\n");

        CodigoCurso7.add("0325187 ");
        CodigoCurso7.add("0325913 ");
        CodigoCurso7.add("0325915 ");
        CodigoCurso7.add("0325917 ");

        creditos7.add("4");
        creditos7.add("4");
        creditos7.add("4");
        creditos7.add("5");


        requisitos7.add("0325912");
        requisitos7.add("0325909");
        requisitos7.add("0325912");
        requisitos7.add("0325914");

        hora_curso.add(new horario_pensum(CodigoCurso7,creditos7,requisitos7));

        //DATA NOVENO SEMESTRE
        ArrayList<String>CodigoCurso8=new ArrayList<>();
        ArrayList<String>creditos8=new ArrayList<>();
        ArrayList<String>requisitos8=new ArrayList<>();

        CodigoCurso8.add("Codigo\n");
        creditos8.add("Creditos\n");
        requisitos8.add("Requisito\n");

        CodigoCurso8.add("0325176 ");
        CodigoCurso8.add("0325177 ");
        CodigoCurso8.add("0325918 ");
        CodigoCurso8.add("0325921 ");


        creditos8.add("4");
        creditos8.add("4");
        creditos8.add("5");
        creditos8.add("5");

        requisitos8.add("--------");
        requisitos8.add("0325171");
        requisitos8.add("0325186, 0325912");
        requisitos8.add("0325917");

        hora_curso.add(new horario_pensum(CodigoCurso8,creditos8,requisitos8));

        //DATA DECIMO SEMESTRE
        ArrayList<String>CodigoCurso9=new ArrayList<>();
        ArrayList<String>creditos9=new ArrayList<>();
        ArrayList<String>requisitos9=new ArrayList<>();

        CodigoCurso9.add("Codigo\n");
        creditos9.add("Creditos\n");
        requisitos9.add("Requisito\n");

        CodigoCurso9.add("0325916 ");
        CodigoCurso9.add("0325919 ");
        CodigoCurso9.add("0325920 ");
        CodigoCurso9.add("0325922 ");

        creditos9.add("5");
        creditos9.add("4");
        creditos9.add("5");
        creditos9.add("5");

        requisitos9.add("0325913");
        requisitos9.add("0325917");
        requisitos9.add("0325912");
        requisitos9.add("0325917");

        hora_curso.add(new horario_pensum(CodigoCurso9,creditos9,requisitos9));


        ArrayList<String>CodigoCurso10=new ArrayList<>();
        ArrayList<String>creditos10=new ArrayList<>();
        ArrayList<String>requisitos10=new ArrayList<>();

        CodigoCurso10.add("Codigo\n");
        creditos10.add("Creditos\n");
        requisitos10.add("Requisito\n");

        CodigoCurso10.add("0325190  ");
        CodigoCurso10.add("0325191  ");
        CodigoCurso10.add("0325193  ");
        CodigoCurso10.add("0325923  ");
        CodigoCurso10.add("0325924   ");


        creditos10.add("5");
        creditos10.add("5");
        creditos10.add("5");
        creditos10.add("5");
        creditos10.add("5");


        requisitos10.add("181 Créditos");
        requisitos10.add("0325187");
        requisitos10.add("0325918");
        requisitos10.add("0325918, 0325920");
        requisitos10.add("0325919, 0325921,0325922");

        hora_curso.add(new horario_pensum(CodigoCurso10,creditos10,requisitos10));



        adaptador=new adapter_lista_pensum(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);


        return v;
    }

}
