package com.campussebastianvergara.models;

public class PersonaMedica extends Persona {

    //Principio Open-Closed

    //Extiende de Persona: Jugador, PersonaTecnica, PersonaMedica

    String rol;
    String nombreEquipo;

    public PersonaMedica() {

    }

    public PersonaMedica(String id, String nombre, String nombreEquipo, String rol) {
        super(id, nombre);
        this.nombreEquipo = nombreEquipo;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    //Principio de sustitución de Liskov

    //No se rompe el principio de sustitución debido a que las tres clases que extienden de Persona no tienen problema 
    //con implementar cada uno de los métodos. Por ejemplo, No se presenta un método que sea aplicable para una sola clase
    //hija mientras que en las otras dos no; en las tres clases hijas los métodos tomarDatos y guardarEnLista son aplicables.

}
