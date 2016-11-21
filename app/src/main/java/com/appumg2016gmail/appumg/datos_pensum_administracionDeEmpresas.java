package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 11/11/2016.
 */

public class datos_pensum_administracionDeEmpresas {
    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Lenguaje e Investigacion Documentasl");
        Sem1.add("Derecho I");
        Sem1.add("Dersarrollo Humano y Profecional");
        Sem1.add("Administración I");
        Sem1.add("Filosofia Administrativa");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Economia General");
        Sem2.add("Matematica I");
        Sem2.add("Administración II");
        Sem2.add("Derecho II");
        Sem2.add("Contabilidad I");

        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Psicologia Organizacional");
        Sem3.add("Matematica Administrativa");
        Sem3.add("Administración III");
        Sem3.add("Microeconomia");
        Sem3.add("Informatica I");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Administracion IV");
        Sem4.add("Sociologia de los Negocios");
        Sem4.add("Contablidad II");
        Sem4.add("Estadistica I");
        Sem4.add("Macroeconomia");

        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Informatica II");
        Sem5.add("Mercadotecnia I");
        Sem5.add("Administración del Talento Humano");
        Sem5.add("Estadistica II");
        Sem5.add("Administración de Costos");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Invetigación de Operaciones");
        Sem6.add("Mercadotecnia II");
        Sem6.add("Economia Internacional");
        Sem6.add("Derecho III");
        Sem6.add("Gestion de Estados Finincieros");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Administración Industrial");
        Sem7.add("Mercadotecnia III");
        Sem7.add("Matematica Financiera");
        Sem7.add("Proyecto de Graduación");
        Sem7.add("Administración de Presupuestos");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Mercadotecnia IV");
        Sem8.add("Seminario de Competencias Gerenciales");
        Sem8.add("Logistica Administrativa");
        Sem8.add("Elaboracióny Evaluacion de Proyectos");
        Sem8.add("Administración Financiera");

        horario_semestreDetalle.put("Primer Semestre", Sem1);
        horario_semestreDetalle.put("Segundo Semestre", Sem2);
        horario_semestreDetalle.put("Tercer Semestre", Sem3);
        horario_semestreDetalle.put("Cuarto Semestre", Sem4);
        horario_semestreDetalle.put("Quinto Semestre", Sem5);
        horario_semestreDetalle.put("Sexto Semestre", Sem6);
        horario_semestreDetalle.put("Septimo Semestre", Sem7);
        horario_semestreDetalle.put("Octavo Semestre", Sem8);

        return horario_semestreDetalle;


    }
}
