package com.appumg2016gmail.appumg;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by zombozo on 11/10/2016.
 */

public class ArrayTimeLine {
    private ArrayList<String> fechaEvento;
    private ArrayList<String> fechaPublicacion;
    private ArrayList<Uri>    imagen;
    private ArrayList<String> administrador;

    public ArrayList<String> getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(ArrayList<String> fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public ArrayList<String> getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(ArrayList<String> fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public ArrayList<Uri> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Uri> imagen) {
        this.imagen = imagen;
    }

    public ArrayList<String> getAdministrador() {
        return administrador;
    }

    public void setAdministrador(ArrayList<String> administrador) {
        this.administrador = administrador;
    }
}
