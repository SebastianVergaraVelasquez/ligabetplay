package com.campussebastianvergara.Servicios;



import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.IPerMedServicio;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.PersonaMedica;

public class PerMedServicio implements IPerMedServicio{
    public boolean registrar(PersonaMedica personaMedica){
        boolean saved = false;
        for (Equipo equipo : DataBase.equipos) {
            if (equipo.getNombre().equals(personaMedica.getNombreEquipo())) {
                int i = DataBase.equipos.indexOf(equipo);
                DataBase.equipos.get(i).setCuerpoMedico(personaMedica);
                saved = true;
            }
        }
        return saved;
    }

    public PersonaMedica buscarPorId(String nombre){
        for (Equipo equipo : DataBase.equipos) {
            for (PersonaMedica personaMedica : equipo.getCuerpoMedico()) {
                if (personaMedica.getId().equals(nombre)) {
                    return personaMedica;
                }
            }
        }
        return null;
    }
}
