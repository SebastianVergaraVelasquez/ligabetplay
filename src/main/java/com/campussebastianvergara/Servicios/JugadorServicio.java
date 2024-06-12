package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.IJugadorServicio;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;

public class JugadorServicio implements IJugadorServicio {

    public boolean registrar(Jugador jugador) {
        // TO-DO:
        boolean saved = false;
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getNombre().equals(jugador.getNombreEquipo())) {
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
                if (jugador.getId().equals(id)) {
                    return jugador;
                }
            }
        }
        return null;
    }

    public void sumarGol(Jugador jugador) {
        jugador.setGolesAnotados(jugador.getGolesAnotados() + 1);
    }

    public void sumarTarjetaAmarilla(Jugador jugador) {
        jugador.setTotalTarjetasAmarillas(jugador.getTotalTarjetasAmarillas() + 1);
    }

    public void sumarTarjetaRoja(Jugador jugador) {
        jugador.setTotalTarjetasRojas(jugador.getTotalTarjetasRojas()+1);
    }
}
