package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 10/11/2016.
 */

public class datos_lista_horarioAdministracionEmpresas {
    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Lenguaje e Investigación");
        Sem1.add("Adminitración I");
        Sem1.add("Desarrollo Humano y Profecional");
        Sem1.add("Filosofía Administrdativa");
        Sem1.add("Derecho I");

        List<String>  Sem1A=new ArrayList<String>();;
        Sem1A.add("Desarrollo Humano y Profecional");
        Sem1A.add("Lenguaje e Investigación");
        Sem1A.add("Filosofía Administrativa");
        Sem1A.add("Derecho I");
        Sem1A.add("Adminitración I");


        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Psicología Organizacional");
        Sem3.add("Microeconomía");
        Sem3.add("Matemática Administrativa");
        Sem3.add("Administración III");
        Sem3.add("Contabilidad II");

        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Mercadotecnia");
        Sem5.add("Administración de Costos");
        Sem5.add("Informática");
        Sem5.add("Administración del Talento Humano");
        Sem5.add("Estadística II");
/*
        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Compiladores");
        Sem5.add("Sistemas Operativos");
        Sem5.add("Base de Datos II");
        Sem5.add("Análisis de Sistemas I");
        Sem5.add("Arquitectura de Computadoras I");
*/
        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("--------------------");
        Sem6.add("Administración de Costos de Producción");
        Sem6.add("Mercadotecnia II");
        Sem6.add("Economia Internacional");
        Sem6.add("Investigación de Operaciones");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("--------------------");
        Sem7.add("Administración de Presupuestos");
        Sem7.add("Matemática Financiera");
        Sem7.add("Mercadotecnia IV");
        Sem7.add("Técnicas de Investigación y Propedéutica de Tesis");
/*
        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Desarrollo Humano y profecional");
        Sem8.add("Metodologia de la investigación");
        Sem8.add("Contabilidad I");
        Sem8.add("Introduccion A los sistemas de Computo");
        Sem8.add("Logica de Sistemas");
*//*
        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("-----------------------------");
        Sem9.add("Sistemas Operativos Abiertos");
        Sem9.add("Investigación de Mercados");
        Sem9.add("Investigacion de Operaciones");
        Sem9.add("Diseño de Sistemas");
/*
        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Desarrollo Humano y profecional");
        Sem10.add("Metodologia de la investigación");
        Sem10.add("Contabilidad I");
        Sem10.add("Introduccion A los sistemas de Computo");
        Sem10.add("Logica de Sistemas");
*/
    /*    List<String>  Sem11=new ArrayList<String>();;
        Sem11.add("-----------------------------");
        Sem11.add("Ingenieria de Proyectos");
        Sem11.add("Comunicaciones");
        Sem11.add("Ingeniería del Software");
        Sem11.add("Legislación Laboral  y Mercantil");
/*
        List<String>  Sem12=new ArrayList<String>();;
        Sem12.add("Desarrollo Humano y profecional");
        Sem12.add("Metodologia de la investigación");
        Sem12.add("Contabilidad I");
        Sem12.add("Introduccion A los sistemas de Computo");
        Sem12.add("Logica de Sistemas");
*/

        horario_semestreDetalle.put("Primer Ciclo Sección A", Sem1);
        horario_semestreDetalle.put("Primer Ciclo Seccion B", Sem1A);
        horario_semestreDetalle.put("Tecer CicloSemestre", Sem3);
        //  horario_semestreDetalle.put("Cuarto Semestre", Sem4);
        horario_semestreDetalle.put("Quinto Ciclo", Sem5);
        horario_semestreDetalle.put("Septimo Semestre", Sem6);
        horario_semestreDetalle.put("Noveno Ciclo", Sem7);
//        horario_semestreDetalle.put("Octavo Semestre", Sem8);
   //     horario_semestreDetalle.put("Noveno Semestre", Sem9);
//        horario_semestreDetalle.put("Decimo Semestre", Sem10);
     //   horario_semestreDetalle.put("Onceavo Semestre", Sem11);
        //      horario_semestreDetalle.put("Doceavo Semestre", Sem12);

        return horario_semestreDetalle;


    }
}
