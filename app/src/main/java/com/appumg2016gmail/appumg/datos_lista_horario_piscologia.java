package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 10/11/2016.
 */

public class datos_lista_horario_piscologia {

    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Filosofia");
        Sem1.add("Biologia Humana");
        Sem1.add("Desarrollo Humano y Profecional");
        Sem1.add("Sociologia General");


        List<String>  Sem1A=new ArrayList<String>();;
        Sem1A.add("Anatomia y Fisiologia del Sistema Nervioso");
        Sem1A.add("Psicologia Evolutiva del Niño y del Adolecente");
        Sem1A.add("Seminologia Psicologica");
        Sem1A.add("Estadistica Fundamental");


        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Psicologia Social");
        Sem3.add("Neurofisiologia");
        Sem3.add("Psicometria II");
        Sem3.add("Psicologia del Deporte y la Recreación");


        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Psiconeuroendocrinologia");
        Sem5.add("Fundamentos Teoricos de la Analitica");
        Sem5.add("Psicopatologia del Adulto I");
        Sem5.add("Psicopatologia del Niño y del Adolecente");
        Sem5.add("Sistemas de Psicoterapia");
/*
        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Compiladores");
        Sem5.add("Sistemas Operativos");
        Sem5.add("Base de Datos II");
        Sem5.add("Análisis de Sistemas I");
        Sem5.add("Arquitectura de Computadoras I");
*/
        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Metodologia de la Elaboración de una Tesis");
        Sem6.add("Piscoterapia de Grupo");
        Sem6.add("Psicoterapia de Familia con Orientación a Padres");
        Sem6.add("Practica de Campo y Supervisión Psicoterapeutica");

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
  //      horario_semestreDetalle.put("Decimo Primer Ciclo", Sem7);
//        horario_semestreDetalle.put("Octavo Semestre", Sem8);
        //     horario_semestreDetalle.put("Noveno Semestre", Sem9);
//        horario_semestreDetalle.put("Decimo Semestre", Sem10);
        //   horario_semestreDetalle.put("Onceavo Semestre", Sem11);
        //      horario_semestreDetalle.put("Doceavo Semestre", Sem12);

        return horario_semestreDetalle;


    }
}
