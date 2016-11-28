package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 9/11/2016.
 */

public class datos_lista_horario {

    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Desarrollo Humano y profecional");
        Sem1.add("Contabilidad I");
        Sem1.add("Introduccion a los sistemas de Computo");
        Sem1.add("Metodología de la investigación");
        Sem1.add("Lógica de Sistemas");

        List<String>  Sem1A=new ArrayList<String>();;
        Sem1A.add("Contabilidad I");
        Sem1A.add("Logica de Sistemas");
        Sem1A.add("Metodología de la investigación");
        Sem1A.add("Introduccion A los sistemas de Computo");
        Sem1A.add("Desarrollo Humano y Profecional");


        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Física I");
        Sem3.add("Cálculo I");
        Sem3.add("Programación I");
        Sem3.add("Proceso Administrativo");
        Sem3.add("Derecho Informático");

        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Estadística II");
        Sem5.add("Programación III");
        Sem5.add("Métodos Numericos");
        Sem5.add("Electrónica Analógica");
        Sem5.add("Emprendedores de Negocio");
/*
        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Compiladores");
        Sem5.add("Sistemas Operativos");
        Sem5.add("Base de Datos II");
        Sem5.add("Análisis de Sistemas I");
        Sem5.add("Arquitectura de Computadoras I");
*/
        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Investigación de Operaciones");
        Sem6.add("Automatas");
        Sem6.add("Electronica Digital");
        Sem6.add("Sistemas Operativos");
        Sem6.add("Base de datos I");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Compiladores");
        Sem7.add("Sistemas Operativos");
        Sem7.add("Base de Datos II");
        Sem7.add("Análisis de Sistemas I");
        Sem7.add("Arquitectura de Computadoras I");
/*
        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Desarrollo Humano y profecional");
        Sem8.add("Metodologia de la investigación");
        Sem8.add("Contabilidad I");
        Sem8.add("Introduccion A los sistemas de Computo");
        Sem8.add("Logica de Sistemas");
*/
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
        List<String>  Sem11=new ArrayList<String>();;
        Sem11.add("-----------------------------");
        Sem11.add("Ingenieria de Proyectos");
        Sem11.add("Comunicaciones");
        Sem11.add("Ingeniería del Software");
        Sem11.add("Legislación Laboral y Mercantil");
/*
        List<String>  Sem12=new ArrayList<String>();;
        Sem12.add("Desarrollo Humano y profecional");
        Sem12.add("Metodologia de la investigación");
        Sem12.add("Contabilidad I");
        Sem12.add("Introduccion A los sistemas de Computo");
        Sem12.add("Logica de Sistemas");
*/

        horario_semestreDetalle.put("Primer Semestre Seccion A", Sem1);
        horario_semestreDetalle.put("Primer Semestre Seccion B", Sem1A);
        horario_semestreDetalle.put("Tercer Semestre", Sem3);
        //  horario_semestreDetalle.put("Cuarto Semestre", Sem4);
        horario_semestreDetalle.put("Quinto Semestre", Sem5);
        //    horario_semestreDetalle.put("Sexto Semestre", Sem6);
        horario_semestreDetalle.put("Septimo Semestre", Sem7);
//        horario_semestreDetalle.put("Octavo Semestre", Sem8);
        horario_semestreDetalle.put("Noveno Semestre", Sem9);
//        horario_semestreDetalle.put("Decimo Semestre", Sem10);
        horario_semestreDetalle.put("Onceavo Semestre", Sem11);
        //      horario_semestreDetalle.put("Doceavo Semestre", Sem12);

        return horario_semestreDetalle;


    }

}
