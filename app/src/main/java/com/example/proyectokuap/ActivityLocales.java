package com.example.proyectokuap;

public class ActivityLocales {
    private int id_local;
    private String nombre;
    private String horario;
    private String descripcion;

    public ActivityLocales(int id_local, String nombre, String horario, String descripcion) {
        this.id_local = id_local;
        this.nombre = nombre;
        this.horario = horario;
        this.descripcion = descripcion;
    }

    public int getId_local() {
        return id_local;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
