package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 14/11/2016.
 */

public class datos_pensum_criminologia {

    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Intoducción al Derecho");
        Sem1.add("Criminalistica I*");
        Sem1.add("Criminologia I");
        Sem1.add("Sociologia Aplicdad");
        Sem1.add("Desarrollo Humano y Profecional");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Teoria del Delito");
        Sem2.add("Criminalistica II");
        Sem2.add("Criminologia II");
        Sem2.add("Derechos Humanos");
        Sem2.add("Oratoria Forense");


        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Derecho Penal");
        Sem3.add("Criminalistica Aplicada*");
        Sem3.add("Criminologia Aplicada");
        Sem3.add("Matematica");
        Sem3.add("Psicologia Forense");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Derecho Procesal Penal");
        Sem4.add("Metodologia de la Investigación Cientifica");
        Sem4.add("Politica Criminal");
        Sem4.add("Psiquiatria Forense");
        Sem4.add("Seguridad Publica y Privada");


        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Derecho Constitucional");
        Sem5.add("Tecnicas de Investigación Criminal");
        Sem5.add("Victimologia");
        Sem5.add("Criminogenesis");
        Sem5.add("Violencia Infantil y de Genero");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Derecho Internacional Publico");
        Sem6.add("Informatica y Manejo de la Evidencia Digital*");
        Sem6.add("Enfoque Psicologico del Acoso");
        Sem6.add("Psicopatologias Criminales");
        Sem6.add("Religión, Su Incidencia en la Vitimologia y Delincuencia");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Auditoria Forense");
        Sem7.add("Analisis Tipologico Criminal");
        Sem7.add("Tecnicas de Mediación de Conflictos y Controversias");
        Sem7.add("Procesamiento y Manejo de Base de Datos");
        Sem7.add("Sistema Penitenciario y Politicas de Reinserción");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Gerencia y Administración");
        Sem8.add("Aplicación de la Pena, Medidas Sustitutivas, Imputabilidad");
        Sem8.add("Analisis de la Evidencia Fisica*");
        Sem8.add("Analisis y Prevención del Terrorismo Contemporaneo");
        Sem8.add("Introducción a la Arquitectura y Antropologia Social");

        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("Curso");
        Sem9.add("Electivo Nacional o Internacional");

        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Curso");
        Sem10.add("Practica Profecional Asistida");

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
