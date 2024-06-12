package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.models.Equipo;

public class Reportes {

    public static void masGoles() {

        Equipo equipoMasGoles = DataBase.equipos.get(0);
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getGolesFavor() > equipoMasGoles.getGolesFavor()){
                equipoMasGoles = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas goles es: %s", equipoMasGoles.getNombre()));
    }

    public static void masPuntos() {
        Equipo equipoMasPuntos = DataBase.equipos.get(0);
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getTotalPuntos() > equipoMasPuntos.getTotalPuntos()){
                equipoMasPuntos = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas puntos es: %s", equipoMasPuntos.getNombre()));
    }

    public static void masVictorias() {
        Equipo equipoMasVictorias = DataBase.equipos.get(0);
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getPartidosGanados() > equipoMasVictorias.getPartidosGanados()){
                equipoMasVictorias = equipo;
            }
        }
        System.out.println(String.format("El equipo con mas victorias es: %s", equipoMasVictorias.getNombre()));
    }

    public static void totalGoles() {
        int golesTotales = 0;
        for (Equipo equipo : DataBase.equipos) {
            golesTotales += equipo.getGolesFavor();
        }
        System.out.println(String.format("El total de goles marcados es: %s", golesTotales));
    }

    public static void promedioGoles() {
        double golesTotales = 0;
        double promedioGoles = 0;
        for (Equipo equipo : DataBase.equipos) {
            golesTotales += equipo.getGolesFavor();
        }
        promedioGoles = golesTotales/DataBase.equipos.size();
        System.out.println(String.format("El promedio de goles marcados es: %s", promedioGoles));
    }
}
