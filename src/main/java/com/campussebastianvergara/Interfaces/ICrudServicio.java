package com.campussebastianvergara.Interfaces;

import com.campussebastianvergara.models.Jugador;

public interface ICrudServicio<T>{
    boolean registrar(T objeto);
    T buscarPorId(String id);
}
