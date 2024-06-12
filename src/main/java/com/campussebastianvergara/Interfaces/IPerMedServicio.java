package com.campussebastianvergara.Interfaces;

import com.campussebastianvergara.models.PersonaMedica;

public interface IPerMedServicio {
    boolean registrar(PersonaMedica personaMedica);
    PersonaMedica buscarPorId(String id);
}
