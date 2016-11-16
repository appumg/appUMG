package com.appumg2016gmail.appumg;

import java.util.ArrayList;

/**
 * Created by Manuel on 9/11/2016.
 */

public class horario_pensum {
    ArrayList<String> codigoCurso=new ArrayList<>();
    ArrayList<String> creditos=new ArrayList<>();
    ArrayList<String> requisitos=new ArrayList<>();

    public horario_pensum(ArrayList<String> codigoCurso, ArrayList<String> creditos, ArrayList<String> requisitos) {
        this.codigoCurso = codigoCurso;
        this.creditos = creditos;
        this.requisitos = requisitos;
    }

    public horario_pensum(ArrayList<String> codigoCurso, ArrayList<String> requisitos) {
        this.codigoCurso = codigoCurso;
        this.requisitos = requisitos;
    }

    public String getCodigoCurso(int i) {
        return codigoCurso.get(i);
    }

    public String getCreditos(int i) {
        return creditos.get(i);
    }

    public  String getRequisitos(int i) {
        return requisitos.get(i);
    }

}
