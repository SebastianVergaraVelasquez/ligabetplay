package com.campussebastianvergara.funciones;

import java.util.ArrayList;
import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.PersonaMedica;

public class PerMedFunciones {
    public static void registrarJugador(ArrayList<Equipo> equipos) {
        Scanner scanner = new Scanner(System.in);
        Equipo equipoEncontrado = new Equipo();
        PersonaMedica nuevaPerMedica = new PersonaMedica();
        System.out.println("Ingrese el nombre del equipo del que va a ser parte");
        String nombreEquipo = scanner.nextLine();
        equipoEncontrado = FuncionesEquipo.encontrarEquipo(equipos, nombreEquipo);
        nuevaPerMedica.tomarDatos(nombreEquipo);
        nuevaPerMedica.guardarEnLista(equipoEncontrado);
        System.out.println(equipos.get(0).getJugadores().get(0).getNombre());
    }
}
