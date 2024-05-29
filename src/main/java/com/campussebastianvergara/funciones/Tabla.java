package com.campussebastianvergara.funciones;

import com.campussebastianvergara.models.Equipo;
import java.util.ArrayList;

public class Tabla {
    public static void ordenamiento(ArrayList<Equipo> Equipos) {
        int n = Equipos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Equipos.get(j).getTotalPuntos() < Equipos.get(j + 1).getTotalPuntos()) {

                    Equipo temp = Equipos.get(j);
                    Equipos.set(j, Equipos.get(j + 1));
                    Equipos.set(j + 1, temp);
                }
            }
        }
    }

    public static void imprimirTabla(ArrayList<Equipo> equipos) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n", 
                          "Nombre", "P. Jugados", "P. Ganados", "P. Perdidos", "P. Empatados", "Goles a Favor", "Goles en Contra", "Total Puntos");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        for (Equipo equipo : equipos) {
            System.out.printf("%-15s %-15d %-15d %-15d %-15d %-15d %-15d %-15d%n", 
                              equipo.getNombre(), equipo.getPartidosJugados(), equipo.getPartidosGanados(), equipo.getPartidosPerdidos(), 
                              equipo.getPartidosEmpatados(), equipo.getGolesFavor(), equipo.getGolesContra(), equipo.getTotalPuntos());
        }
    }
}
