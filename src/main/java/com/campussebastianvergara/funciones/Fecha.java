package com.campussebastianvergara.funciones;

import java.util.ArrayList;
import java.util.Scanner;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;

public class Fecha  {

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

        //Registro de goles por jugador

        if (golesLocal > 0) {
            for (int i = 1; i <= golesLocal; i++){
                Jugador jugadorEncontrado = new Jugador();
                System.out.println("***Equipo Local***");
                System.out.println(String.format("Ingrese el nombre del jugador que hizo el gol n° %s", i));
                String jugadorBuscado = sc.nextLine();
                jugadorEncontrado = JugadorFunciones.encontrarJugador(equipoLocal, jugadorBuscado);
                jugadorEncontrado.setGolesAnotados(jugadorEncontrado.getGolesAnotados()+1);
            }
        }

        if (golesVisitante > 0) {
            for (int i = 1; i <= golesVisitante; i++){
                Jugador jugadorEncontrado = new Jugador();
                System.out.println("***Equipo visitante***");
                System.out.println(String.format("Ingrese el nombre del jugador que hizo el gol n° %s", i));
                String jugadorBuscado = sc.nextLine();
                jugadorEncontrado = JugadorFunciones.encontrarJugador(equipoLocal, jugadorBuscado);
                jugadorEncontrado.setGolesAnotados(jugadorEncontrado.getGolesAnotados()+1);
            }
        }

        //Registro de tarjetas amarillas

        String nuevoAmonestado;
        do {
            Jugador jugadorEncontrado = new Jugador();
            Equipo equipoEncontrado = new Equipo();
            System.out.println("Ingrese el nombre del jugador amonestado con tarjeta amarilla");
            String jugadorBuscado = sc.nextLine();
            System.out.println("Ingrese el nombre del equipo de este jugador");
            String equipoBuscado = sc.nextLine();
            equipoEncontrado = FuncionesEquipo.encontrarEquipo(Equipos, equipoBuscado);
            jugadorEncontrado = JugadorFunciones.encontrarJugador(equipoEncontrado, jugadorBuscado);
            jugadorEncontrado.setTotalTarjetasAmarillas(jugadorEncontrado.getTotalTarjetasAmarillas()+1);
            while (true) {
                System.out.println("Desea hacer otro registro de amonestación?. Ingrese 1 (Si), Ingrese 2(No)");
                nuevoAmonestado = sc.nextLine();
                if (nuevoAmonestado.equalsIgnoreCase("1")) {
                    break;
                }
                else if (nuevoAmonestado.equalsIgnoreCase("2")) {
                    break;
                }
                else {
                    System.out.println("Opción no válida. Por favor, ingrese 1 (Si) o 2 (No)");
                }
            }
        } while(nuevoAmonestado.equalsIgnoreCase("1"));

        //Registro de tarjetas rojas

        do {
            Jugador jugadorEncontrado = new Jugador();
            Equipo equipoEncontrado = new Equipo();
            System.out.println("Ingrese el nombre del jugador amonestado con tarjeta roja");
            String jugadorBuscado = sc.nextLine();
            System.out.println("Ingrese el nombre del equipo de este jugador");
            String equipoBuscado = sc.nextLine();
            equipoEncontrado = FuncionesEquipo.encontrarEquipo(Equipos, equipoBuscado);
            jugadorEncontrado = JugadorFunciones.encontrarJugador(equipoEncontrado, jugadorBuscado);
            jugadorEncontrado.setTotalTarjetasAmarillas(jugadorEncontrado.getTotalTarjetasAmarillas()+1);
            while (true) {
                System.out.println("Desea hacer otro registro de amonestación?. Ingrese 1 (Si), Ingrese 2(No)");
                nuevoAmonestado = sc.nextLine();
                if (nuevoAmonestado.equalsIgnoreCase("1")) {
                    break;
                }
                else if (nuevoAmonestado.equalsIgnoreCase("2")) {
                    break;
                }
                else {
                    System.out.println("Opción no válida. Por favor, ingrese 1 (Si) o 2 (No)");
                }
            }
        } while(nuevoAmonestado.equalsIgnoreCase("1"));
    }
}
