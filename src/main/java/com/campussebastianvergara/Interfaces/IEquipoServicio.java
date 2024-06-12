package com.campussebastianvergara.Interfaces;

import com.campussebastianvergara.models.Equipo;

public interface IEquipoServicio {
    boolean registrar(Equipo equipo);
    Equipo buscarPorId(String id);
    void actualizarInfo (Equipo equipo, String resultado, int golesFavor, int golesContra);
}
