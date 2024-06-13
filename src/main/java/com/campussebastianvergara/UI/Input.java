package com.campussebastianvergara.UI;

import java.util.Scanner;

import com.campussebastianvergara.Interfaces.IJugadorServicio;
import com.campussebastianvergara.Servicios.JugadorServicio;
import com.campussebastianvergara.models.Jugador;

public class Input {

    public static void inputGoles (int goles){
        
        IJugadorServicio jugadorServicio = new JugadorServicio();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= goles; i++) {
            System.out.println(String.format("Ingrese el nombre del jugador que hizo el gol n° %s", i));
            Jugador jugador = jugadorServicio.buscarPorId(sc.nextLine());
            jugadorServicio.sumarGol(jugador);
        }
    }

    public static void inputAmonestado(){
        IJugadorServicio jugadorServicio = new JugadorServicio();
        Scanner sc = new Scanner(System.in);
        String carton = "";

        System.out.println(String.format("Ingrese el nombre del jugador amonestado"));
        Jugador jugador = jugadorServicio.buscarPorId(sc.nextLine());
        System.out.println("Cuál fue la amonestación? 1.Amarilla 2.Roja");
        carton = sc.nextLine();
        if (carton.equalsIgnoreCase("1")) {
            jugadorServicio.sumarTarjetaAmarilla(jugador);
        }
        else if (carton.equalsIgnoreCase("2")){
            jugadorServicio.sumarTarjetaRoja(jugador);
        }
    }
}
