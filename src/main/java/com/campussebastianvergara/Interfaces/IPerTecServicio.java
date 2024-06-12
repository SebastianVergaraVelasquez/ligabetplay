package com.campussebastianvergara.Interfaces;

import java.util.ArrayList;

import com.campussebastianvergara.models.PersonaTecnica;

public interface IPerTecServicio {
    boolean registrar(PersonaTecnica personaTecnica);
    PersonaTecnica buscarPorId(String id);
    void listarCuerpoTecnico (ArrayList<PersonaTecnica> cuerpoTecnico);
}
