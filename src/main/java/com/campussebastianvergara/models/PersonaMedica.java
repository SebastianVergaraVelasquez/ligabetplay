package com.campussebastianvergara.models;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonaMedica extends Persona {

    //Principio Open-Closed

    //Extiende de Persona: Jugador, PersonaTecnica, PersonaMedica

    String rol;

    public PersonaMedica() {

    }

    public PersonaMedica(String id, String nombre, String nombreEquipo, String rol) {
        super(id, nombre);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

     //Principio de sustitución de Liskov

    //No se rompe el principio de sustitución debido a que las tres clases que extienden de Persona no tienen problema 
    //con implementar cada uno de los métodos. Por ejemplo, No se presenta un método que sea aplicable para una sola clase
    //hija mientras que en las otras dos no; en las tres clases hijas los métodos tomarDatos y guardarEnLista son aplicables.

    public void tomarDatos(String nombreEquipo){
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Registro Cuerpo Médico");

        System.out.println("Ingrese el nombre de la persona");
        this.setNombre(scanner.nextLine());

        System.out.println("Ingrese el documento de identidad");
        this.setId(scanner.nextLine());
       
        System.out.println("Cual es su rol");
        this.setRol(scanner.nextLine());
    }

    public void guardarEnLista(Equipo equipoEncontrado) {
        ArrayList<PersonaMedica> personalMedico = equipoEncontrado.getCuerpoMedico();
        personalMedico.add(this);
        equipoEncontrado.setCuerpoMedico(personalMedico);
    }

}
