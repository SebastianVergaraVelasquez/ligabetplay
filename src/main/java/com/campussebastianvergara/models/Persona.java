package com.campussebastianvergara.models;

public abstract class Persona {
    protected String id;
    protected String nombre;
   
    protected Persona() {
    }

    protected Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
