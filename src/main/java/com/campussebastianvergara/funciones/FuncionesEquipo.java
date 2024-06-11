package com.campussebastianvergara.funciones;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.Interfaces.Registrar;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesEquipo implements Registrar {

    public void regristro(ArrayList<Equipo> Equipos){

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


}
