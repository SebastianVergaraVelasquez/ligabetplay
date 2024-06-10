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
    public void tomarDatos(String nombreEquipo){
        System.out.println("iwi");
    }

    @Override
    public void guardarEnLista(Equipo equipoEncontrado){
        System.out.println("owo");
    }
}
