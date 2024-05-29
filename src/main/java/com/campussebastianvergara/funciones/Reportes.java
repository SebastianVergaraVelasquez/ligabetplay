package com.campussebastianvergara.funciones;

import com.campussebastianvergara.models.Equipo;
import java.util.ArrayList;

public class Reportes {
    
    public static void masGoles(ArrayList<Equipo> Equipos) {
        Equipo equipoMasGoles = Equipos.get(0);
        for (Equipo equipo : Equipos) {
            if (equipo.getGolesFavor() > equipoMasGoles.getGolesFavor()){
                equipoMasGoles = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas goles es: %s", equipoMasGoles.getNombre()));
    }

    public static void masPuntos(ArrayList<Equipo> Equipos) {
        Equipo equipoMasPuntos = Equipos.get(0);
        for (Equipo equipo : Equipos) {
            if (equipo.getTotalPuntos() > equipoMasPuntos.getTotalPuntos()){
                equipoMasPuntos = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas puntos es: %s", equipoMasPuntos.getNombre()));
    }

    public static void masVictorias(ArrayList<Equipo> Equipos) {
        Equipo equipoMasVictorias = Equipos.get(0);
        for (Equipo equipo : Equipos) {
            if (equipo.getPartidosGanados() > equipoMasVictorias.getPartidosGanados()){
                equipoMasVictorias = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas victorias es: %s", equipoMasVictorias.getNombre()));
    }

    public static void totalGoles(ArrayList<Equipo> Equipos) {
        int golesTotales = 0;
        for (Equipo equipo : Equipos) {
            golesTotales += equipo.getGolesFavor();
        }
        System.out.println(String.format("El total de goles marcados es: %s", golesTotales));
    }

    public static void promedioGoles(ArrayList<Equipo> Equipos) {
        int golesTotales = 0;
        float promedioGoles = 0;
        for (Equipo equipo : Equipos) {
            golesTotales += equipo.getGolesFavor();
        }
        promedioGoles = golesTotales/Equipos.size();
        System.out.println(String.format("El promedio de goles marcados es: %s", promedioGoles));
    }
}
