package com.appumg2016gmail.appumg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Manuel on 11/11/2016.
 */

public class datos_pensum_auditoria {


    public static LinkedHashMap<String, List<String >> getInformacion(){
        LinkedHashMap<String, List<String>> horario_semestreDetalle=new LinkedHashMap<String, List<String>>();

        List<String>  Sem1=new ArrayList<String>();
        Sem1.add("Curso");
        Sem1.add("Tecnicas de Investigación");
        Sem1.add("Matemática I");
        Sem1.add("Introducción a la Economia");
        Sem1.add("Desarrollo Humano y Profecional");

        List<String>  Sem2=new ArrayList<String>();;
        Sem2.add("Curso");
        Sem2.add("Contabilidad Basica");
        Sem2.add("Introducción al Derecho");
        Sem2.add("Micro Economia I");
        Sem2.add("Matematica II");



        List<String>  Sem3=new ArrayList<String>();;
        Sem3.add("Curso");
        Sem3.add("Miro Economia II");
        Sem3.add("Normas Internacionales de Información Financiera I");
        Sem3.add("Contabilidad de Sociedades");
        Sem3.add("Legislación Mercantil");

        List<String>  Sem4=new ArrayList<String>();;
        Sem4.add("Curso");
        Sem4.add("Matemática Financiera I");
        Sem4.add("Metodos Estadisticos I");
        Sem4.add("Normas Internacioneas de Información Financiera II");
        Sem4.add("Contabilidad Avanzada I");

        List<String>  Sem5=new ArrayList<String>();;
        Sem5.add("Curso");
        Sem5.add("Metodos Estadisticos II");
        Sem5.add("Matemática Financiera II");
        Sem5.add("Contabilidad Avanzada II");
        Sem5.add("Nomras Internacionales de Auditoria I");

        List<String>  Sem6=new ArrayList<String>();;
        Sem6.add("Curso");
        Sem6.add("Finanzas Publicas");
        Sem6.add("Contabilidad de Costos I");
        Sem6.add("Auditoria I");
        Sem6.add("Normas Internacionales de Auditoria II");

        List<String>  Sem7=new ArrayList<String>();;
        Sem7.add("Curso");
        Sem7.add("Moneda y Banca");
        Sem7.add("Legislación Tributaria");
        Sem7.add("Contabilidad de Costos II");
        Sem7.add("Auditoria II");

        List<String>  Sem8=new ArrayList<String>();;
        Sem8.add("Curso");
        Sem8.add("Presupuestos");
        Sem8.add("Legislación Laboral");
        Sem8.add("Analisis e Interpretación de Estados Financieros");
        Sem8.add("Auditoria III");

        List<String>  Sem9=new ArrayList<String>();;
        Sem9.add("Curso");
        Sem9.add("Teoria Administrativa");
        Sem9.add("Etica Profecional");
        Sem9.add("Contabilidad y Organización Bancaria");
        Sem9.add("Auditoria de Sistemas de Información");

        List<String>  Sem10=new ArrayList<String>();;
        Sem10.add("Curso");
        Sem10.add("Procedimientos Legales y Administrativos");
        Sem10.add("Redacción de Informes Tecnicos");
        Sem10.add("Contabilidades Especiales");
        Sem10.add("Auditoria Administrativa");

        List<String>  Sem11=new ArrayList<String>();;
        Sem11.add("Curso");
        Sem11.add("Propedeutica de Tesis");
        Sem11.add("Elaboración y Evaluación de Proyectos");
        Sem11.add("Administración y Gestion de Riesgos");
        Sem11.add("Seminario de Contabilidad");
        Sem11.add("Seminario de Auditoria");


        List<String>  Cordinador=new ArrayList<String>();;
        Cordinador.add("Licenciado Armando Muralles");


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
        horario_semestreDetalle.put("Decimo Primer Semestre", Sem11);
        horario_semestreDetalle.put("Coordinador", Cordinador);


        return horario_semestreDetalle;


    }
}
