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
public class pensumCarrera_ingenieriaSistemas extends Fragment {

    LinkedHashMap<String, List<String>> horario_semestre;
    List<String> horario_lista;
    ExpandableListView listaExpandible;
    adapter_lista_pensum adaptador;
    ArrayList <horario_pensum>hora_curso;


    public pensumCarrera_ingenieriaSistemas() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pensum_ingenieria_sistemas2014, container, false);

        listaExpandible=(ExpandableListView)v.findViewById(R.id.lista_pensum);
        horario_semestre=datos_pensum2014_sistemas.getInformacion();
        horario_lista=new ArrayList<String>(horario_semestre.keySet());




        hora_curso=new ArrayList<>();
        ArrayList<String>CodigoCurso=new ArrayList<>();
        ArrayList<String>creditos=new ArrayList<>();
        ArrayList<String>requisitos=new ArrayList<>();



        //DATA PRIMER SEMESTRE
        CodigoCurso.add("Codigo\n");
        CodigoCurso.add("1690001");
        CodigoCurso.add("1690002");
        CodigoCurso.add("1690003");
        CodigoCurso.add("1690004");
        CodigoCurso.add("1690005");

        creditos.add("Creditos\n");
        creditos.add("4");
        creditos.add("5");
        creditos.add("5");
        creditos.add("5");
        creditos.add("5");

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



        CodigoCurso1.add("1690006");
        CodigoCurso1.add("1690007");
        CodigoCurso1.add("1690008");
        CodigoCurso1.add("1690009");
        CodigoCurso1.add("1690010");

        creditos1.add("5");
        creditos1.add("5");
        creditos1.add("5");
        creditos1.add("5");
        creditos1.add("5");

        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");
        requisitos1.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso1,creditos1,requisitos1));


        //DATA TERECER SEMESTRE
        ArrayList<String>CodigoCurso2=new ArrayList<>();
        ArrayList<String>creditos2=new ArrayList<>();
        ArrayList<String>requisitos2=new ArrayList<>();

        CodigoCurso2.add("Codigo\n");
        creditos2.add("Creditos\n");
        requisitos2.add("Requisito\n");


        CodigoCurso2.add("1690011");
        CodigoCurso2.add("1690012");
        CodigoCurso2.add("1690013");
        CodigoCurso2.add("1690014");
        CodigoCurso2.add("1690015");

        creditos2.add("5");
        creditos2.add("5");
        creditos2.add("5");
        creditos2.add("4");
        creditos2.add("5");

        requisitos2.add("1690006");
        requisitos2.add("1690008");
        requisitos2.add("1690006");
        requisitos2.add("-------");
        requisitos2.add("-------");

        hora_curso.add(new horario_pensum(CodigoCurso2,creditos2,requisitos2));

        //DATA CUARTO SEMESTRE
        ArrayList<String>CodigoCurso3=new ArrayList<>();
        ArrayList<String>creditos3=new ArrayList<>();
        ArrayList<String>requisitos3=new ArrayList<>();

        CodigoCurso3.add("Codigo\n");
        creditos3.add("Creditos\n");
        requisitos3.add("Requisito\n");

        CodigoCurso3.add("1690016");
        CodigoCurso3.add("1690017");
        CodigoCurso3.add("1690018");
        CodigoCurso3.add("1690019");
        CodigoCurso3.add("1690020");

        creditos3.add("5");
        creditos3.add("5");
        creditos3.add("5");
        creditos3.add("4");
        creditos3.add("5");

        requisitos3.add("-------");
        requisitos3.add("1690012");
        requisitos3.add("1690013");
        requisitos3.add("------");
        requisitos3.add("------");

        hora_curso.add(new horario_pensum(CodigoCurso3,creditos3,requisitos3));


        //DATA QUINTO SEMESTRE
        ArrayList<String>CodigoCurso4=new ArrayList<>();
        ArrayList<String>creditos4=new ArrayList<>();
        ArrayList<String>requisitos4=new ArrayList<>();

        CodigoCurso4.add("Codigo\n");
        creditos4.add("Creditos\n");
        requisitos4.add("Requisito\n");

        CodigoCurso4.add("1690021");
        CodigoCurso4.add("1690022");
        CodigoCurso4.add("1690023");
        CodigoCurso4.add("1690024");
        CodigoCurso4.add("1690025");

        creditos4.add("5");
        creditos4.add("5");
        creditos4.add("5");
        creditos4.add("4");
        creditos4.add("5");

        requisitos4.add("70 Cred.");
        requisitos4.add("1690017");
        requisitos4.add("------");
        requisitos4.add("1690020");
        requisitos4.add("1690019");

        hora_curso.add(new horario_pensum(CodigoCurso4,creditos4,requisitos4));

        //DATA SEXTO SEMESTRE
        ArrayList<String>CodigoCurso5=new ArrayList<>();
        ArrayList<String>creditos5=new ArrayList<>();
        ArrayList<String>requisitos5=new ArrayList<>();

        CodigoCurso5.add("Codigo\n");
        creditos5.add("Creditos\n");
        requisitos5.add("Requisito\n");

        CodigoCurso5.add("1690026");
        CodigoCurso5.add("1690027");
        CodigoCurso5.add("1690028");
        CodigoCurso5.add("1690029");
        CodigoCurso5.add("1690030");

        creditos5.add("5");
        creditos5.add("5");
        creditos5.add("5");
        creditos5.add("4");
        creditos5.add("5");

        requisitos5.add("80 Cred.");
        requisitos5.add("1690022");
        requisitos5.add("80 Cred.");
        requisitos5.add("80 Cred.");
        requisitos5.add("1690024");

        hora_curso.add(new horario_pensum(CodigoCurso5,creditos5,requisitos5));

        //DATA SEPTIMO SEMESTRE

        ArrayList<String>CodigoCurso6=new ArrayList<>();
        ArrayList<String>creditos6=new ArrayList<>();
        ArrayList<String>requisitos6=new ArrayList<>();

        CodigoCurso6.add("Codigo\n");
        creditos6.add("Creditos\n");
        requisitos6.add("Requisito\n");

        CodigoCurso6.add("1690031");
        CodigoCurso6.add("1690032");
        CodigoCurso6.add("1690033");
        CodigoCurso6.add("1690034");
        CodigoCurso6.add("1690035");

        creditos6.add("5");
        creditos6.add("5");
        creditos6.add("5");
        creditos6.add("5");
        creditos6.add("5");

        requisitos6.add("1690027");
        requisitos6.add("100 Cred.");
        requisitos6.add("1690029");
        requisitos6.add("100 Cred.");
        requisitos6.add("1690028");

        hora_curso.add(new horario_pensum(CodigoCurso6,creditos6,requisitos6));

        //DATA OCTAVO SEMESTRE

        ArrayList<String>CodigoCurso7=new ArrayList<>();
        ArrayList<String>creditos7=new ArrayList<>();
        ArrayList<String>requisitos7=new ArrayList<>();

        CodigoCurso7.add("Codigo\n");
        creditos7.add("Creditos\n");
        requisitos7.add("Requisito\n");

        CodigoCurso7.add("1690036");
        CodigoCurso7.add("1690037");
        CodigoCurso7.add("1690038");
        CodigoCurso7.add("1690039");
        CodigoCurso7.add("1690040");

        creditos7.add("5");
        creditos7.add("5");
        creditos7.add("5");
        creditos7.add("4");
        creditos7.add("5");

        requisitos7.add("1690031");
        requisitos7.add("1690032");
        requisitos7.add("125 Cred.");
        requisitos7.add("100 Cred.");
        requisitos7.add("1690034");

        hora_curso.add(new horario_pensum(CodigoCurso7,creditos7,requisitos7));

        //DATA NOVENO SEMESTRE
        ArrayList<String>CodigoCurso8=new ArrayList<>();
        ArrayList<String>creditos8=new ArrayList<>();
        ArrayList<String>requisitos8=new ArrayList<>();

        CodigoCurso8.add("Codigo\n");
        creditos8.add("Creditos\n");
        requisitos8.add("Requisito\n");

        CodigoCurso8.add("1690041");
        CodigoCurso8.add("1690042");
        CodigoCurso8.add("1690043");
        CodigoCurso8.add("1690044");
        CodigoCurso8.add("1690045");

        creditos8.add("5");
        creditos8.add("5");
        creditos8.add("6");
        creditos8.add("5");
        creditos8.add("5");

        requisitos8.add("150 Cred.");
        requisitos8.add("150 Cred.");
        requisitos8.add("150 Cred.");
        requisitos8.add("1690038");
        requisitos8.add("150 Cred.");

        hora_curso.add(new horario_pensum(CodigoCurso8,creditos8,requisitos8));

        //DATA DECIMO SEMESTRE
        ArrayList<String>CodigoCurso9=new ArrayList<>();
        ArrayList<String>creditos9=new ArrayList<>();
        ArrayList<String>requisitos9=new ArrayList<>();

        CodigoCurso9.add("Codigo\n");
        creditos9.add("Creditos\n");
        requisitos9.add("Requisito\n");

        CodigoCurso9.add("1690041");
        CodigoCurso9.add("1690042");
        CodigoCurso9.add("1690043");
        CodigoCurso9.add("1690044");
        CodigoCurso9.add("1690045");

        creditos9.add("5");
        creditos9.add("6");
        creditos9.add("5");
        creditos9.add("6");
        creditos9.add("5");

        requisitos9.add("175 Cred.");
        requisitos9.add("175 Cred.");
        requisitos9.add("175 Cred.");
        requisitos9.add("1690043");
        requisitos9.add("175 Cred.");

        hora_curso.add(new horario_pensum(CodigoCurso9,creditos9,requisitos9));


        //DATA COORDINADOR
        ArrayList<String>codCOrd=new ArrayList<>();
        codCOrd.add("");
        hora_curso.add(new horario_pensum(codCOrd,codCOrd,codCOrd));




        adaptador=new adapter_lista_pensum(getContext(),horario_semestre,horario_lista,hora_curso);
        listaExpandible.setAdapter(adaptador);


        return v;
    }

}
