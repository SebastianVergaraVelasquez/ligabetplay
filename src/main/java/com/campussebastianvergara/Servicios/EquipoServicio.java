package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.models.Equipo;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.IEquipoServicio;

public class EquipoServicio implements IEquipoServicio{

    public boolean registrar(Equipo equipo) {
        DataBase.equipos.add(equipo);
        return true;
    }
    public Equipo buscarPorId(String nombre) {
        for (Equipo equipo : DataBase.equipos) {
            if(equipo.getNombre().equals(nombre)){
                return equipo;
            }
        }
      return null;
    }

    public void actualizarInfo(Equipo equipo, String resultado, int golesFavor, int golesContra) {
        // Esta función permite actualizar la información de los atributos del equipo
        // seleccionado
       
        equipo.setPartidosJugados(equipo.getPartidosJugados()+1);
      
        if (resultado.equalsIgnoreCase("victoria")) {
            equipo.setPartidosGanados(equipo.getPartidosGanados()+1);
            equipo.setTotalPuntos(equipo.getTotalPuntos()+1);
        } else if (resultado.equalsIgnoreCase("derrota")) {
            equipo.setPartidosPerdidos(equipo.getPartidosPerdidos()+1);
        } else {
            equipo.setPartidosEmpatados(equipo.getPartidosEmpatados()+1);
            equipo.setTotalPuntos(equipo.getTotalPuntos()+1);
        }

        equipo.setGolesFavor(equipo.getGolesFavor()+golesFavor);
        equipo.setGolesContra(equipo.getGolesContra()+golesContra);
    }
}



// public static void registrarEquipo(ArrayList<Equipo> Equipos) {
    //     String registrarNuevo = "";
    //     do {
    //         Equipo nuevoEquipo = new Equipo();
    //         Scanner sc = new Scanner(System.in);
    //         System.out.println("Ingrese el nombre del equipo");
    //         nuevoEquipo.setNombre(sc.nextLine());
    //         Equipos.add(nuevoEquipo);
    //         while (true) {
    //             System.out.println("Desea registrar otro equipo. Ingrese 1 (Si), Ingrese 2(No)");
    //             registrarNuevo = sc.nextLine();
    //             if (registrarNuevo.equalsIgnoreCase("1")) {
    //                 break;
    //             }
    //             else if (registrarNuevo.equalsIgnoreCase("2")) {
    //                 break;
    //             }
    //             else {
    //                 System.out.println("Opción no válida. Por favor, ingrese 1 (Si) o 2 (No)");
    //             }
    //         }
    //     } while (registrarNuevo.equalsIgnoreCase("1") );  
    // }