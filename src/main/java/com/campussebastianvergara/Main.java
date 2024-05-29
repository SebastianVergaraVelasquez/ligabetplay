package com.campussebastianvergara;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.funciones.FuncionesEquipo;
import com.campussebastianvergara.funciones.Fecha;
import com.campussebastianvergara.funciones.Reportes;
import com.campussebastianvergara.funciones.Tabla;

public class Main {
    public static void main(String[] args) {
        ArrayList<Equipo> Equipos = new ArrayList<>();
        String opcion, opcion2;
        opcion = "";
        opcion2 = "";
        Scanner sc = new Scanner(System.in);

        //Menú
        do {
            System.out.println("***LigaBetplay***\n\nEscoja una opción");
            System.out.println("1.Registrar equipo\n2.Registrar fecha\n3.Reportes\n4.Salir");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    FuncionesEquipo.registrarEquipo(Equipos);
                    break;
                case "2":
                    Fecha.registrarFecha(Equipos);
                    Tabla.ordenamiento(Equipos);
                    break;
                case "3":
                //Menu de reportes
                    System.out.println("***Modulo de reportes*\n\nEscoja una opción");
                    System.out.println("1.Equipo con mas goles\n2.Equipo con mas puntos\n3.Equipo con mas partidos ganados");
                    System.out.println("\n4.Total de goles en la liga\n5.Promedio de goles en la liga\n6.Tabla de posiciones\n7.Salir");
                    opcion2 = sc.nextLine();
                    switch (opcion2) {
                        case "1":
                            Reportes.masGoles(Equipos);
                            break;
                        case "2":
                            Reportes.masPuntos(Equipos);
                            break;
                        case "3":
                            Reportes.masVictorias(Equipos);
                            break;
                        case "4":
                            Reportes.totalGoles(Equipos);
                            break;
                        case "5":
                            Reportes.promedioGoles(Equipos);
                            break;
                        case "6":
                            Tabla.imprimirTabla(Equipos);
                            break;
                        default:
                            System.out.println("Opción incorrecta. Ingrese un valor de los mostrados en el menú");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese un valor de los mostrados en el menú");
                    break;
            }
        } while (!opcion.equalsIgnoreCase("4"));
        System.out.println("Saliendo...");
        
    }
}



