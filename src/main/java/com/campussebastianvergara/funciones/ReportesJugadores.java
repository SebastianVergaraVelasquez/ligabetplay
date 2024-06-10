package com.campussebastianvergara.funciones;

import java.util.ArrayList;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;

public class ReportesJugadores {
    public static void jugadorConMasGoles (ArrayList<Equipo> Equipos){
        Jugador goleador = new Jugador();
        goleador = Equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : Equipos) {
            ArrayList<Jugador> jugadores;
            jugadores = equipo.getJugadores();
            for (Jugador jugador : jugadores) {
                if(jugador.getGolesAnotados() > goleador.getGolesAnotados()){
                    goleador = jugador;
                }
            }
        }
        System.out.println(String.format("El goleador de la liga es %s, del equipo %s", goleador.getNombre(), goleador.getNombreEquipo()));
    }

    public static void jugadorConMasAmarillas (ArrayList<Equipo> Equipos){
        Jugador masAmarillas = new Jugador();
        masAmarillas = Equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : Equipos) {
            ArrayList<Jugador> jugadores;
            jugadores = equipo.getJugadores();
            for (Jugador jugador : jugadores) {
                if(jugador.getTotalTarjetasAmarillas() > masAmarillas.getTotalTarjetasAmarillas()){
                    masAmarillas = jugador;
                }
            }
        }
        System.out.println(String.format("El jugador con más amarillas de la liga es %s, del equipo %s", masAmarillas.getNombre(), masAmarillas.getNombreEquipo()));
    }

    public static void jugadorConMasRojas (ArrayList<Equipo> Equipos){
        Jugador masRojas = new Jugador();
        masRojas = Equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : Equipos) {
            ArrayList<Jugador> jugadores;
            jugadores = equipo.getJugadores();
            for (Jugador jugador : jugadores) {
                if(jugador.getTotalTarjetasRojas() > masRojas.getTotalTarjetasRojas()){
                    masRojas = jugador;
                }
            }
        }
        System.out.println(String.format("El jugador con más rojas de la liga es %s, del equipo %s", masRojas.getNombre(), masRojas.getNombreEquipo()));
    }
}
