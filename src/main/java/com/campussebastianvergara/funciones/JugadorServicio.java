package com.campussebastianvergara.funciones;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.ICrudServicio;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;

public class JugadorServicio implements ICrudServicio<Jugador> {

    // public void registrarJugador(ArrayList<Equipo> equipos) {
    //     Scanner scanner = new Scanner(System.in);
    //     Equipo equipoEncontrado = new Equipo();
    //     Jugador nuevoJugador = new Jugador();
    //     System.out.println("Ingrese el nombre del equipo dónde va a jugar");
    //     String nombreEquipo = scanner.nextLine();
    //     equipoEncontrado = FuncionesEquipo.encontrarEquipo(equipos, nombreEquipo);
    //     nuevoJugador.tomarDatos(nombreEquipo);
    //     nuevoJugador.guardarEnLista(equipoEncontrado);
    //     System.out.println(equipos.get(0).getJugadores().get(0).getNombre());
    // }

    // public Jugador encontrarJugador (Equipo equipo, String nombreJugador){
    //     Jugador jugadorEncontrado = null;
    //     ArrayList<Jugador> listaJugadores;
    //     listaJugadores = equipo.getJugadores();
    //     for (Jugador jugador : listaJugadores) {
    //         if (jugador.getNombre().equals(nombreJugador)){
    //             jugadorEncontrado = jugador;
    //             break;
    //         } 
    //     }
    //     if (jugadorEncontrado.equals(null)){
    //         System.out.println("Jugador no registrado en este equipo");
    //     }
    //     return jugadorEncontrado;
    // }

    public boolean registrar(Jugador jugador) {
        //TO-DO:
        boolean saved = false;
        for (Equipo equipo : DataBase.equipos) {
            if(equipo.getNombre().equals(jugador.getNombreEquipo())){
                int i = DataBase.equipos.indexOf(equipo);
                DataBase.equipos.get(i).setJugador(jugador);
                saved = true;
            }
        }
        return saved;
    }

    public Jugador buscarPorId(String id) {
        for (Equipo equipo : DataBase.equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if(jugador.getId().equals(id)){
                    return jugador;
                }
            }
        }
        return null;
    }
}
