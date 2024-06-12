package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.ICrudServicio;
import com.campussebastianvergara.Interfaces.IFechaServicio;
import com.campussebastianvergara.models.Fecha;

public class FechaServicio implements ICrudServicio<Fecha>, IFechaServicio{

    public boolean registrar(Fecha fecha) {
        DataBase.fechas.add(fecha);
        return true;
    }

    public Fecha buscarPorId(String id) {
       for (Fecha fecha : DataBase.fechas) {
            if (fecha.getId().equals(id)) {
                return fecha;
            }
       }
       return null;
    }

    public String[] determinarGanador(Fecha fecha){
        
        String resultadoLocal = "";
        String resultadoVisitante = "";
        if (fecha.getGolesLocal() > fecha.getGolesVisitante()){
            resultadoLocal = "victoria";
            resultadoVisitante = "derrota";
        }
        else if (fecha.getGolesLocal() < fecha.getGolesVisitante()){
            resultadoLocal = "derrota";
            resultadoVisitante = "victoria";
        }
        else{
            resultadoLocal = "empate";
            resultadoVisitante = "empate";
        }
        return new String[]{resultadoLocal, resultadoVisitante};
    }
}

