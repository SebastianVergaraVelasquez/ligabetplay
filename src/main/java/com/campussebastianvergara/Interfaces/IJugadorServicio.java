package com.campussebastianvergara.Interfaces;

import com.campussebastianvergara.models.Jugador;

public interface IJugadorServicio {
    boolean registrar(Jugador jugador);
    Jugador buscarPorId(String id);
}
