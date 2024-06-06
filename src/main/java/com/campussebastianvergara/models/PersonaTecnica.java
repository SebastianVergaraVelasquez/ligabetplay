package com.campussebastianvergara.models;

public class PersonaTecnica extends Persona {

    String rol;

    public PersonaTecnica() {
    }

    public PersonaTecnica(String id, String nombre, String nombreEquipo, String rol) {
        super(id, nombre, nombreEquipo);
        this.rol = rol;
    }

    @Override
    public void guardarEnLista() {
        // TODO Auto-generated method stub
        
    }
}
