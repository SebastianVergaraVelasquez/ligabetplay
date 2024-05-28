package com.campussebastianvergara;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;

public class Main {
    public static void main(String[] args) {
        ArrayList<Equipo> Equipos = new ArrayList<>();
        String opcion;
        opcion = "";
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
                    System.out.println("En proceso...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese un valor de los mostrados en el menú");
                    break;
            }
        } while (!opcion.equalsIgnoreCase("4"));
        
        // registrarEquipo(Equipos);
        // Equipos.forEach(Equipo -> {
        //     System.out.println(String.format("El nombre del equipo es: %s \nPartidos jugados: %d", Equipo.getNombre(),
        //             Equipo.getPartidosJugados()));
        // });
        // registrarFecha(Equipos);

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
        Equipo equipoLocal = recorrerListaEquipos(Equipos, nombreLocal);
        actualizarInfo(equipoLocal, resultadoLocal, golesLocal, golesVisitante);
        Equipo equipoVisitante = recorrerListaEquipos(Equipos, nombreLocal);
        actualizarInfo(equipoVisitante, resultadoVisitante, golesVisitante, golesLocal);

    }

    public static Equipo recorrerListaEquipos(ArrayList<Equipo> Equipos, String nombreEquipo) {
        // Esta función recorre la lista de equipos para verificar si existe el equipo
        // tras ingresar su nombre
        Equipo equipoEncontrado = null;
        for (Equipo equipo : Equipos) {
            // Si existe devuelve el objeto equipo
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipoEncontrado = equipo;
                break;
            }
            // Si no existe devuelve este mensaje
            else {
                System.out.println("Equipo no registrado");
            }
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

}