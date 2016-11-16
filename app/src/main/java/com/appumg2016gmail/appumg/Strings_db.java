package com.appumg2016gmail.appumg;

/**
 * Created by zombozo on 25/10/2016.
 */

public class Strings_db {
    public static String clavesPrimarias=" integer primary key autoincrement,";
    public static String intTipe=" integer,";
    public static String stringTipe=" text,";
    public static String stringTipeFin= " text";
    public static String intTipeFin=" integer";

    //----------- strings para la base de datos de las imagenes
    public static class string_db_imagenes{
        public static String nombre="imagenes";
        public static int version=1;
        public static String id_imagen="id_imagen";
        public static String direccion="direccion_de_laImagen";
        public static String numeroImagen="numero";
        public static String creaDB="create table "+string_db_imagenes.nombre+"("+id_imagen+" integer,"+direccion+" text not null,"+numeroImagen+" integer primary key autoincrement)";
    }


    public static class string_db_timeline{
        public static int version=1;

        public static String nombre="timeline";
        public static String id="id_item";
        public static String tipo="tipo_publicacion";
        public static String titulo="titulo_del_Evento";
        public static String descripcion="descripcion";
        public static String fecha_publicacion="FechaDePublicacion";
        public static String fecha_evento="fecha_aRealizarse";
        public static String publicador="publicadoPor";
        public static String numero="numero";
        public static String creaDB="create table "+nombre+"("+id+intTipe+tipo+intTipe+titulo+stringTipe+descripcion+stringTipe+fecha_publicacion+stringTipe+
                fecha_evento+stringTipe+publicador+stringTipeFin+","+numero+" integer primary key autoincrement)";
    }


    public static class string_db_tipo_evento{
        public static int version=1;
        public static String nombre="tipos_eventos";
        public static String id="id_tipo";
        public static String nombreTipo="nombre";
        public static String creaDB="create table "+nombre+"("+id+clavesPrimarias+nombreTipo+stringTipeFin+")";
    }
}
