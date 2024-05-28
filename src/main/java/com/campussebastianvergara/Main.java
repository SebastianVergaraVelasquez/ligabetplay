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
                            int totalEquipos = Equipos.size();
                            ordenamiento(Equipos, 0, totalEquipos-1);
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
        Equipo nuevoEquipo = new Equipo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del equipo");
        nuevoEquipo.setNombre(sc.nextLine());
        Equipos.add(nuevoEquipo);
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

    public static void ordenamiento(ArrayList<Equipo> Equipos, int izquierda, int derecha) {
        ArrayList<Equipo> EquiposPorPuntos = new ArrayList<>();
        int pivote = Equipos.get(izquierda).getTotalPuntos();

        int i = izquierda;
        int j = derecha;
        int aux;

        while (i<j) {
            while (equipoi.getTotalPuntos() <= pivote && i < j ) {
                i++;
            }
            Equipo equipoj = Equipos.get(j);
            while (equipoj.getTotalPuntos() > pivote) {
                j--;
            }
            if(i<j){

            }
            
        }
    }
}



