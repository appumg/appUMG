package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 11/11/2016.
 */

public class datos_pensum_psicologia {

    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Filosofia");
        Sem1.add("Dersarrollo Humano y Profecional");
        Sem1.add("Biologia Humana");
        Sem1.add("Sociologia General");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Antropologia General");
        Sem2.add("Logica Formal");
        Sem2.add("Psicologia General");
        Sem2.add("Metodologia de la Investigación");

        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Anatomia y Fisiologia del Sistema Nervioso");
        Sem3.add("Estadistica Fundamental");
        Sem3.add("Psicologia Evolutiva del Niño");
        Sem3.add("Semiologia Psicologica");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Psicometria I");
        Sem4.add("Teorias de la Personalidad");
        Sem4.add("Estadistica Aplicada a la Psicologia");
        Sem4.add("Psicologia Evolutiva del Adulto");


        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Psicometria II");
        Sem5.add("Psicologia del Deporte y la Recreacion");
        Sem5.add("Psicologia Social");
        Sem5.add("Neurofisiologia");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Psicologia Clinica");
        Sem6.add("Introducción a la Psicologia Forense");
        Sem6.add("Introducción a la Psicologia Industrial/Organizacional");
        Sem6.add("Fundamentos de Informatica");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Sistemas de Psicoterapia");
        Sem7.add("Psiconeuroendocrinologia");
        Sem7.add("Psicoterapia del Adulto I");
        Sem7.add("Psicoterapia del Niño");
        Sem7.add("Fundamentos Teoricos de la Terapia Analitica");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Proceso Terapeutico Analitico");
        Sem8.add("Tecnicas de Modificacón de Conductas");
        Sem8.add("Psicoterapia del Niño");
        Sem8.add("Psicometria III");

        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("Curso");
        Sem9.add("Fundamentos de Psicofamacologia");
        Sem9.add("Elaboración de Trabajo de Graduación I");
        Sem9.add("Psicoeducación en Transtornos Mentales");
        Sem9.add("Practica I");
        Sem9.add("Modelo PsicoTerapeutico Cognitivo Conductual");

        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Curso");
        Sem10.add("Modelo Psicoterapeutico Humanistico Existencial");
        Sem10.add("Psicoterapia de Grupo");
        Sem10.add("Psicoterapia de Pareja Familiar");
        Sem10.add("Practica II");
        Sem10.add("Elaboración de Trabajo de Graduación II");

        List<String>  Cordinador=new ArrayList<String>();;
        Cordinador.add("Licenciada Candy Lisely Barrios\n");


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
        horario_semestreDetalle.put("Coordinador", Cordinador);



        return horario_semestreDetalle;


    }
}
