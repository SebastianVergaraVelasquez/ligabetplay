package com.campussebastianvergara.funciones;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.PersonaTecnica;

public class PerTecFunciones {
     public static void registrarJugador(ArrayList<Equipo> equipos) {
        Scanner scanner = new Scanner(System.in);
        Equipo equipoEncontrado = new Equipo();
        PersonaTecnica nuevaPerTecnica = new PersonaTecnica();
        System.out.println("Ingrese el nombre del equipo del que va a ser parte");
        String nombreEquipo = scanner.nextLine();
        equipoEncontrado = FuncionesEquipo.encontrarEquipo(equipos, nombreEquipo);
        nuevaPerTecnica.tomarDatos(nombreEquipo);
        nuevaPerTecnica.guardarEnLista(equipoEncontrado);
        System.out.println(equipos.get(0).getJugadores().get(0).getNombre());
    }

    public static void listarCuerpoTecnico(ArrayList<Equipo> equipos){
        Scanner scanner = new Scanner(System.in);
        Equipo equipoEncontrado = new Equipo();
        System.out.println("Escriba el nombre del equipo para listar su cuerpo técnico");
        String nombreEquipo = scanner.nextLine();
        equipoEncontrado = FuncionesEquipo.encontrarEquipo(equipos, nombreEquipo);
        ArrayList<PersonaTecnica> cuerpoTecnico = equipoEncontrado.getCuerpoTecnico();
        System.out.println(String.format("Cuerpo técnico del equipo %s:", nombreEquipo));
        for (PersonaTecnica personaTecnica : cuerpoTecnico) {
            System.out.println(String.format("%s : %s", personaTecnica.getNombre(), personaTecnica.getRol()));
        } 
    }
}
