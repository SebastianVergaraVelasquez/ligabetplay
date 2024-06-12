package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.models.Equipo;
import java.util.ArrayList;

public class Tabla {
    public static void ordenamiento() {
        ArrayList<Equipo> equipos = DataBase.equipos;
        int n = equipos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (equipos.get(j).getTotalPuntos() < equipos.get(j + 1).getTotalPuntos()) {

                    Equipo temp = equipos.get(j);
                    equipos.set(j, equipos.get(j + 1));
                    equipos.set(j + 1, temp);
                }
            }
        }
    }

    public static void imprimirTabla() {
        ArrayList<Equipo> equipos = DataBase.equipos;
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
