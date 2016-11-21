package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 14/11/2016.
 */

public class datos_pensum_trabajoSocial {
    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Filosofia General");
        Sem1.add("Ogigen y Desarrollo del Trabajo Social");
        Sem1.add("Historia Politica Y Social de Guatemala");
        Sem1.add("Herramientas de la Comunicación Social");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Introducción a las Ciencias Sociales");
        Sem2.add("Estudio de la Realidad Social en Guatemala");
        Sem2.add("Psicologia Social");
        Sem2.add("Logica");

        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Estadistica Aplicad al Trabajo Social");
        Sem3.add("Teoria del Estado Moderno");
        Sem3.add("Investigación Cientifica Enfocada a las Ciencias Sociales I");
        Sem3.add("Metodologia Para la Intervención Individual y Familiar");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Legislación Social y Derechos Humanos I");
        Sem4.add("Desarrollo Humano y Profecional");
        Sem4.add("Metodologia para la Intervención Grupal");
        Sem4.add("Investigación Cientifica Enfocada a las Ciencias Sociales II");


        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Metodologia para la Intervencion Comunitaria");
        Sem5.add("Legislación Social y Derechos Humanos II");
        Sem5.add("Formulación de Proyectos");
        Sem5.add("Ejercicio Tecnico Supervisado I");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Interculturalidad de Guatemala");
        Sem6.add("Ejercicio Tecnico Supervisado II");
        Sem6.add("Economia Politica");
        Sem6.add("Seminario de Trabajo Social");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Principios Filosoficos del Trabajo Social");
        Sem7.add("Gerencia Social I");
        Sem7.add("Politicas Publicas y Sociales");
        Sem7.add("Investigación y Trabajo Social");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Campos de Intervención de Trabajo Social");
        Sem8.add("Evaluación y Monitoreo de Proyectos");
        Sem8.add("Gerencia Social II");
        Sem8.add("Taller: Sistematización de Experiencias de Trabajo Social");

        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("Curso");
        Sem9.add("Antropologia Social");
        Sem9.add("Planificación del Desarrollo Social I");
        Sem9.add("Trabajo de Graduación I");
        Sem9.add("Practica Profecional I");

        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Curso");
        Sem10.add("Planificación del Desarrollo Social II");
        Sem10.add("Auditoria Social");
        Sem10.add("Evaluación y Resolución de Conflictos");
        Sem10.add("Trabajo de Graduación II");

        horario_semestreDetalle.put("Primer Semestre", Sem1);
        horario_semestreDetalle.put("Segundo Semestre", Sem2);
        horario_semestreDetalle.put("Tercer Semestre", Sem3);
        horario_semestreDetalle.put("Cuarto Semestre", Sem4);
        horario_semestreDetalle.put("Quinto Semestre", Sem5);
        horario_semestreDetalle.put("Sexto Semestre", Sem6);
        horario_semestreDetalle.put("Septimo Semestre", Sem7);
        horario_semestreDetalle.put("Octavo Semestre", Sem8);
        horario_semestreDetalle.put("Noveno Semestre", Sem9);
        horario_semestreDetalle.put("Decimo Semestre", Sem10);

        return horario_semestreDetalle;

    }
}
