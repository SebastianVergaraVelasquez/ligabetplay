package com.campussebastianvergara.models;

public class PersonaMedica extends Persona{

    String rol;

    public PersonaMedica(){

    }

    public PersonaMedica(String id, String nombre, String nombreEquipo, String rol){
        super(id, nombre, nombreEquipo);
        this.rol = rol;
    }

    @Override
    public void guardarEnLista() {
        // TODO Auto-generated method stub
        
    }
}
