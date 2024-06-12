package com.campussebastianvergara.models;

import java.util.ArrayList;

public class Equipo {
    String nombre;
    int partidosJugados;
    int partidosGanados;
    int partidosPerdidos;
    int partidosEmpatados;
    int golesFavor;
    int golesContra;
    int totalPuntos;
    ArrayList<Jugador> jugadores;
    ArrayList<PersonaTecnica> cuerpoTecnico;
    ArrayList<PersonaMedica> cuerpoMedico;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public Equipo() {
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
        this.cuerpoMedico = new ArrayList<>();
    }

    public Equipo(String nombre, int partidosJugados, int partidosGanados, int partidosPerdidos, int partidosEmpatados,
            int golesFavor, int golesContra, int totalPuntos) {
        this.nombre = nombre;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.totalPuntos = totalPuntos;
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
        this.cuerpoMedico = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public ArrayList<PersonaTecnica> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void setCuerpoTecnico(PersonaTecnica personaTecnica) {
        this.cuerpoTecnico.add(personaTecnica);
    }

    public ArrayList<PersonaMedica> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public void setCuerpoMedico(PersonaMedica personaMedica){
        this.cuerpoMedico.add(personaMedica);
    }
}
