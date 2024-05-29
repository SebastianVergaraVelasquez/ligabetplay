package com.campussebastianvergara.funciones;

import java.util.ArrayList;
import java.util.Scanner;
import com.campussebastianvergara.models.Equipo;

public class Fecha {
    public static void registrarFecha(ArrayList<Equipo> Equipos) {
        //Con esta función se piden ambos equipos y sus goles, para luego hacer el llamado a las otras funciones
        // y actualizar la información del objeto dentro de la lista
        Scanner sc = new Scanner(System.in);
        String resultadoLocal, resultadoVisitante;
        System.out.println("Ingrese el nombre del equipo local");
        String nombreLocal = sc.nextLine();
        System.out.println("Ingrese la cantidad de goles del local");
        int golesLocal = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre del equipo visitante");
        String nombreVisitante = sc.nextLine();
        System.out.println("Ingrese la cantidad de goles del visitante");
        int golesVisitante = sc.nextInt();

        if (golesLocal > golesVisitante){
            resultadoLocal = "victoria";
            resultadoVisitante = "derrota";
        }
        else if (golesLocal < golesVisitante){
            resultadoLocal = "derrota";
            resultadoVisitante = "victoria";
        }
        else{
            resultadoLocal = "empate";
            resultadoVisitante = "empate";
        }
        Equipo equipoLocal = FuncionesEquipo.encontrarEquipo(Equipos, nombreLocal);
        FuncionesEquipo.actualizarInfo(equipoLocal, resultadoLocal, golesLocal, golesVisitante);
        Equipo equipoVisitante = FuncionesEquipo.encontrarEquipo(Equipos, nombreVisitante);
        FuncionesEquipo.actualizarInfo(equipoVisitante, resultadoVisitante, golesVisitante, golesLocal);

    }
}
