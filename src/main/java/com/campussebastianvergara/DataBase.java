package com.campussebastianvergara;

import java.util.ArrayList;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Fecha;

public class DataBase {

    public static ArrayList<Equipo> equipos = new ArrayList<Equipo>(){{add(new Equipo("ab"));}};
    public static ArrayList<Fecha> fechas;
}
