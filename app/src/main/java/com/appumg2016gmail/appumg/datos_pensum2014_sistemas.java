package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 9/11/2016.
 */

public class datos_pensum2014_sistemas {
    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Desarrollo Humano y Profecional");
        Sem1.add("Metodologia de la investigación");
        Sem1.add("Contabilidad I");
        Sem1.add("Introduccion A los sistemas de Computo");
        Sem1.add("Logica de Sistemas");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Precalculo");
        Sem2.add("Algebra Lineal");
        Sem2.add("Algoritmos");
        Sem2.add("Contabilidad II");
        Sem2.add("Matematica Discreta");

        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Fisica I");
        Sem3.add("Programación I");
        Sem3.add("Calculo I");
        Sem3.add("Proceso Administrativo");
        Sem3.add("Derecho Informatico");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Microeconomia");
        Sem4.add("Programación");
        Sem4.add("Calculo II");
        Sem4.add("Estadistica I");
        Sem4.add("Fisica II");

        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Metodos Numericos");
        Sem5.add("Programación III");
        Sem5.add("Emprendedores de Negocio");
        Sem5.add("Electronica Analogica");
        Sem5.add("Estadistica II");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Invetigación de Operaciones");
        Sem6.add("Bae de datos I");
        Sem6.add("Automatas y Lenguajes Fomales");
        Sem6.add("Sistemas Operativos");
        Sem6.add("Electronica Digital");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Base de Datos II");
        Sem7.add("Analisis de Sistemas I");
        Sem7.add("Sistemas Operativos II");
        Sem7.add("Arquitectura de las Computadoras");
        Sem7.add("Compiladores");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Desarrollo Web");
        Sem8.add("Analisis de Sistemas II");
        Sem8.add("Redes de Computadoras");
        Sem8.add("Etica Profecional");
        Sem8.add("Arquitectura de las Computadoras II");

        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("Curso");
        Sem9.add("Admin. de Tecnologias de informacion");
        Sem9.add("Ingenieria del Software");
        Sem9.add("Proyec. de graduación I");
        Sem9.add("Redes de Comp. II");
        Sem9.add("Inteligencia Artificial");

        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Curso");
        Sem10.add("Telecomunicaciones");
        Sem10.add("Seminario de Tecnologias de Informacion");
        Sem10.add("Contabilidad I");
        Sem10.add("Aseguramiento de la Calidad del Software");
        Sem10.add("Logica de Sistemas");

        List<String>  Cordinador=new ArrayList<String>();;
        Cordinador.add("Ingeniero José Remon Girard López");



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
        horario_semestreDetalle.put("Coordinador",Cordinador);

        return horario_semestreDetalle;


    }

}
