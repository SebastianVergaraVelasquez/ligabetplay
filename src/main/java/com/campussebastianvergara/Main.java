package com.campussebastianvergara;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;

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
                    registrarEquipo(Equipos);
                    break;
                case "2":
                    registrarFecha(Equipos);
                    ordenamiento(Equipos);
                    break;
                case "3":
                //Menu de reportes
                    System.out.println("***Modulo de reportes*\n\nEscoja una opción");
                    System.out.println("1.Equipo con mas goles\n2.Equipo con mas puntos\n3.Equipo con mas partidos ganados");
                    System.out.println("\n4.Total de goles en la liga\n5.Promedio de goles en la liga\n6.Tabla de posiciones\n7.Salir");
                    opcion2 = sc.nextLine();
                    switch (opcion2) {
                        case "1":
                            masGoles(Equipos);
                            break;
                        case "2":
                            masPuntos(Equipos);
                            break;
                        case "3":
                            masVictorias(Equipos);
                            break;
                        case "4":
                            totalGoles(Equipos);
                            break;
                        case "5":
                            promedioGoles(Equipos);
                            break;
                        case "6":
                            imprimirTabla(Equipos);
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

    public static void registrarEquipo(ArrayList<Equipo> Equipos) {
        String registrarNuevo = "";
        do {
            Equipo nuevoEquipo = new Equipo();
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del equipo");
            nuevoEquipo.setNombre(sc.nextLine());
            Equipos.add(nuevoEquipo);
            while (true) {
                System.out.println("Desea registrar otro equipo. Ingrese 1 (Si), Ingrese 2(No)");
                registrarNuevo = sc.nextLine();
                if (registrarNuevo.equalsIgnoreCase("1")) {
                    break;
                }
                else if (registrarNuevo.equalsIgnoreCase("2")) {
                    break;
                }
                else {
                    System.out.println("Opción no válida. Por favor, ingrese 1 (Si) o 2 (No)");
                }
            }
        } while (registrarNuevo.equalsIgnoreCase("1") );  
    }

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
        Equipo equipoLocal = encontrarEquipo(Equipos, nombreLocal);
        actualizarInfo(equipoLocal, resultadoLocal, golesLocal, golesVisitante);
        Equipo equipoVisitante = encontrarEquipo(Equipos, nombreVisitante);
        actualizarInfo(equipoVisitante, resultadoVisitante, golesVisitante, golesLocal);

    }

    public static Equipo encontrarEquipo(ArrayList<Equipo> Equipos, String nombreEquipo) {
        // Esta función recorre la lista de equipos para verificar si existe el equipo
        // tras ingresar su nombre
        Equipo equipoEncontrado = null;
        for (Equipo equipo : Equipos) {
            // Si existe devuelve el objeto equipo
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipoEncontrado = equipo;
                break;
            }
        }
        if (equipoEncontrado.equals(null)){
            System.out.println("Equipo no registrado");
        }
        return equipoEncontrado;
    }

    public static void actualizarInfo(Equipo equipoEncontrado, String resultado, int golesFavorFecha, int golesContraFecha) {
        // Esta función permite actualizar la información de los atributos del equipo
        // seleccionado
        int partidosJugados = equipoEncontrado.getPartidosJugados();
        int partidosGanados = equipoEncontrado.getPartidosGanados();
        int partidosPerdidos = equipoEncontrado.getPartidosPerdidos();
        int partidosEmpatados = equipoEncontrado.getPartidosEmpatados();
        int golesFavor = equipoEncontrado.getGolesFavor();
        int golesContra = equipoEncontrado.getGolesContra();
        int totalPuntos = equipoEncontrado.getTotalPuntos();

        partidosJugados += 1;
        equipoEncontrado.setPartidosJugados(partidosJugados);

        if (resultado.equalsIgnoreCase("victoria")) {
            partidosGanados += 1;
            equipoEncontrado.setPartidosGanados(partidosGanados);
            totalPuntos += 3;
            equipoEncontrado.setTotalPuntos(totalPuntos);
        } else if (resultado.equalsIgnoreCase("derrota")) {
            partidosPerdidos += 1;
            equipoEncontrado.setPartidosPerdidos(partidosPerdidos);

        } else {
            partidosEmpatados += 1;
            equipoEncontrado.setPartidosEmpatados(partidosEmpatados);
            totalPuntos += 1;
            equipoEncontrado.setTotalPuntos(totalPuntos);
        }
        golesFavor += golesFavorFecha;
        equipoEncontrado.setGolesFavor(golesFavor);
        golesContra += golesContraFecha;
        equipoEncontrado.setGolesContra(golesContra);
    }

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



