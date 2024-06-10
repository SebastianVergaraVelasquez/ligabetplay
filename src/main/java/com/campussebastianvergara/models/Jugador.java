package com.campussebastianvergara.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Persona {

    //Principio Open-Closed

    //Extiende de Persona: Jugador, PersonaTecnica, PersonaMedica

    String dorsal;
    String nacionalidad;
    String fechaIngreso;
    int golesAnotados;
    int totalTarjetasRojas;
    int totalTarjetasAmarillas;

    public Jugador() {

    }

    public Jugador(String id, String nombre, String nombreEquipo, String dorsal, String nacionalidad,
            String fechaIngreso, int golesAnotados, int totalTarjetasRojas, int totalTarjetasAmarillas) {
        super(id, nombre, nombreEquipo);
        this.dorsal = dorsal;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = golesAnotados;
        this.totalTarjetasRojas = totalTarjetasRojas;
        this.totalTarjetasAmarillas = totalTarjetasAmarillas;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getTotalTarjetasRojas() {
        return totalTarjetasRojas;
    }

    public void setTotalTarjetasRojas(int totalTarjetasRojas) {
        this.totalTarjetasRojas = totalTarjetasRojas;
    }

    public int getTotalTarjetasAmarillas() {
        return totalTarjetasAmarillas;
    }

    public void setTotalTarjetasAmarillas(int totalTarjetasAmarillas) {
        this.totalTarjetasAmarillas = totalTarjetasAmarillas;
    }

    //Principio de sustitución de Liskov

    //No se rompe el principio de sustitución debido a que las tres clases que extienden de Persona no tienen problema 
    //con implementar cada uno de los métodos. Por ejemplo, No se presenta un método que sea aplicable para una sola clase
    //hija mientras que en las otras dos no; en las tres clases hijas los métodos tomarDatos y guardarEnLista son aplicables.

    @Override
    public void tomarDatos(String nombreEquipo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el documento del jugador:");
        this.setNombre(scanner.nextLine());

        System.out.println("Ingrese el nombre del jugador:");
        this.setNombre(scanner.nextLine());

        System.out.println("Ingrese la nacionalidad del jugador:");
        this.setNacionalidad(scanner.nextLine());

        this.setNombreEquipo(nombreEquipo);

        System.out.println("Ingrese el dorsal del jugador:");
        this.setDorsal(scanner.nextLine());

        System.out.println("Ingrese la fecha de ingreso del jugador (dd-mm-yyyy):");
        this.setFechaIngreso(scanner.nextLine());

    }

    @Override
    public void guardarEnLista(Equipo equipoEncontrado) {
        ArrayList<Jugador> jugadoresActuales = equipoEncontrado.getJugadores();
        jugadoresActuales.add(this);
        equipoEncontrado.setJugadores(jugadoresActuales);
    }
}
