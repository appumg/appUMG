package com.appumg2016gmail.appumg;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by zombozo on 15/10/2016.
 */

public class string_timeLine {
    private static int    id_publicador;
    private static String descripcion;
    private static String tipo_item;
    private static String fecha_publicacion;
    private static String hora_publicacion;
    private static String fecha_del_evento;
    private static String hora_del_evento;
    private static String titulo;
    private static String publico;
    private static int    id_imagenes;


    //se crea un objeto del tipo base de datos sqlite para hacer la conexion
    private static SQLiteDatabase db;

    public static int getId_publicador() {
        return id_publicador;
    }

    public static void setId_publicador(int id_publicador) {
        string_timeLine.id_publicador = id_publicador;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
        string_timeLine.descripcion = descripcion;
    }

    public static String getTipo_item() {
        return tipo_item;
    }

    public static void setTipo_item(String tipo_item) {
        string_timeLine.tipo_item = tipo_item;
    }

    public static String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public static void setFecha_publicacion(String fecha_publicacion) {
        string_timeLine.fecha_publicacion = fecha_publicacion;
    }

    public static String getHora_publicacion() {
        return hora_publicacion;
    }

    public static void setHora_publicacion(String hora_publicacion) {
        string_timeLine.hora_publicacion = hora_publicacion;
    }

    public static String getFecha_del_evento() {
        return fecha_del_evento;
    }

    public static void setFecha_del_evento(String fecha_del_evento) {
        string_timeLine.fecha_del_evento = fecha_del_evento;
    }

    public static String getHora_del_evento() {
        return hora_del_evento;
    }

    public static void setHora_del_evento(String hora_del_evento) {
        string_timeLine.hora_del_evento = hora_del_evento;
    }



    public static void setSQLite(SQLiteDatabase dbo){
        setDb(dbo);
    }
    public static void setTitulo(String titulos){
        titulo=titulos;
    }
    public static String getTitulo(){
        return titulo;
    }

    public static boolean guardar(){
        ContentValues valores=new ContentValues();
        valores.put("tipo",tipo_item);
        valores.put("titulo",titulo);
        valores.put("fech_pub",fecha_publicacion);
        valores.put("hora_pub",fecha_publicacion);
        valores.put("fecha_evento",fecha_del_evento);
        valores.put("hora_evento",hora_del_evento);
        valores.put("descripcion",descripcion);
        valores.put("publicador",id_publicador);
        valores.put("publico", getPublico());
        valores.put("id_imagenes",getId_imagenes());

        db.execSQL("insert into timeline "+valores);
        return true;
    }

    public static String getPublico() {
        return publico;
    }

    public static void setPublico(String publico) {
        string_timeLine.publico = publico;
    }

    public static int getId_imagenes() {
        return id_imagenes;
    }

    public static void setId_imagenes(int id_imagenes) {
        string_timeLine.id_imagenes = id_imagenes;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static void setDb(SQLiteDatabase db) {
        string_timeLine.db = db;
    }
}
