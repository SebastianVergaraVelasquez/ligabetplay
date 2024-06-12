package com.campussebastianvergara.Servicios;

import java.util.ArrayList;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;

public class ReportesJugadores {
    public static void jugadorConMasGoles (){
        Jugador goleador;
        goleador = DataBase.equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : DataBase.equipos) {
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

    public static void jugadorConMasAmarillas (){
        Jugador masAmarillas;
        masAmarillas = DataBase.equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : DataBase.equipos) {
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

    public static void jugadorConMasRojas (){
        Jugador masRojas;
        masRojas = DataBase.equipos.get(0).getJugadores().get(0);
        for (Equipo equipo : DataBase.equipos) {
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
