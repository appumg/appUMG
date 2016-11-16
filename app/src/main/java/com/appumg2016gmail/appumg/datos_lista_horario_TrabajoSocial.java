package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 10/11/2016.
 */

public class datos_lista_horario_TrabajoSocial {
    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Herramientas de Comunicación Social");
        Sem1.add("Filosifía General");
        Sem1.add("Origen y Desarrollo del Trabajo Social");
        Sem1.add("Historia Política y Social de Guatemala");

        List<String>  Sem1A=new ArrayList<String>();;
        Sem1A.add("Teoría del Estado Moderno");
        Sem1A.add("Estadística Aplicada al Trabajo Social");
        Sem1A.add("Metodología para la Intervención Individual y Familia");
        Sem1A.add("Investigación Cientifica Enfocada a las Ciencias Social I");



        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Metodología para la Intervención Comunitaria");
        Sem3.add("Formulación de Proyectos");
        Sem3.add("Legislación de Proyectos ");
        Sem3.add("Ejercicio Supervisado I");


        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Investigación y Trabajo Social");
        Sem5.add("Gerencia Social I");
        Sem5.add("Principios Filosóficos del Trabajo Social");
        Sem5.add("Políticas Publicas y Sociles");
        

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Estadística Aplicada al Trabajo Social");
        Sem6.add("Práctica Profecional I");
        Sem6.add("Interculturalidad de Guatemala");
        Sem6.add("Evaluación y Resolución de Conflictos");
        Sem6.add("Planificación y Desarrollo Social I");
/*
        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Seminario de Auditoria");
        Sem7.add("Seminario de Contabilidad");
        Sem7.add("Administración y Gestión de Riesgos");
        Sem7.add("Elaboración y Evalución de Proyectos");
        Sem7.add("Propedéutica de tesis");
/*
        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Desarrollo Humano y profecional");
        Sem8.add("Metodologia de la investigación");
        Sem8.add("Contabilidad I");
        Sem8.add("Introduccion A los sistemas de Computo");
        Sem8.add("Logica de Sistemas");
*/
/*
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
 /*       List<String>  Sem11=new ArrayList<String>();;
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

        horario_semestreDetalle.put("Primer Ciclo", Sem1);
        horario_semestreDetalle.put("Terecer Ciclo", Sem1A);
        horario_semestreDetalle.put("Quinto Ciclo", Sem3);
        //  horario_semestreDetalle.put("Cuarto Semestre", Sem4);
        horario_semestreDetalle.put("Septimo Ciclo", Sem5);
        horario_semestreDetalle.put("Noveno Ciclo", Sem6);
//        horario_semestreDetalle.put("Decimo Primer Ciclo", Sem7);
//        horario_semestreDetalle.put("Octavo Semestre", Sem8);
        //     horario_semestreDetalle.put("Noveno Semestre", Sem9);
//        horario_semestreDetalle.put("Decimo Semestre", Sem10);
        //   horario_semestreDetalle.put("Onceavo Semestre", Sem11);
        //      horario_semestreDetalle.put("Doceavo Semestre", Sem12);

        return horario_semestreDetalle;


    }
}
