package com.campussebastianvergara.Interfaces;

import com.campussebastianvergara.models.Fecha;

public interface IFechaServicio {
    boolean registrar(Fecha fecha);
    Fecha buscarPorId(String id);
    String[] determinarGanador(Fecha fecha);
}
