package com.campussebastianvergara.models;

import java.util.ArrayList;

public class Jugador extends Persona {

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

    @Override
    public void guardarEnLista() {   
    }
    
    public void guardarEnLista(ArrayList<Jugador> jugadores){
        
    }
}
