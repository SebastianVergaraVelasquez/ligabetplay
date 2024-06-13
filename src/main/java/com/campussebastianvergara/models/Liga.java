package com.campussebastianvergara.models;

import java.util.ArrayList;

public class Liga {
    private  ArrayList<Equipo> equipos;
    private  ArrayList<Fecha> fechas;
    
    public Liga(){
        this.equipos = new ArrayList<>();
        this.fechas = new ArrayList<>();
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Fecha> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<Fecha> fechas) {
        this.fechas = fechas;
    }
}
