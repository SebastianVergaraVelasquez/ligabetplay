package com.campussebastianvergara.models;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String nombreEquipo;

    protected Persona() {
    }

    protected Persona(String id, String nombre, String nombreEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreEquipo = nombreEquipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    protected abstract void tomarDatos(String nombreEquipo);

    protected abstract void guardarEnLista(Equipo equipoEncontrado);
}
