package com.campussebastianvergara.Servicios;

import java.util.ArrayList;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.IPerTecServicio;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.PersonaTecnica;

public class PerTecServicio implements IPerTecServicio{

    public boolean registrar(PersonaTecnica personaTecnica) {
        boolean saved = false;
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getNombre().equals(personaTecnica.getNombreEquipo())) {
                int i = DataBase.equipos.indexOf(equipo);
                DataBase.equipos.get(i).setCuerpoTecnico(personaTecnica);
                saved = true;
            }
        }
        return saved;
    }

    public PersonaTecnica buscarPorId(String id) {
        for (Equipo equipo : DataBase.equipos) {
            for (PersonaTecnica personaTecnica : equipo.getCuerpoTecnico()) {
                if (personaTecnica.getId().equals(id)) {
                    return personaTecnica;
                }
            }
        }
        return null;
    }

    public void listarCuerpoTecnico (ArrayList<PersonaTecnica> cuerpoTecnico){
            for (PersonaTecnica personaTecnica : cuerpoTecnico) {
                System.out.println(personaTecnica.getNombre()+ ", "+personaTecnica.getRol());
            }
        }
}
     

