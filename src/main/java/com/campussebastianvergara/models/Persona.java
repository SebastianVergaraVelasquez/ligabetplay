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

    public abstract void guardarEnLista();
}


