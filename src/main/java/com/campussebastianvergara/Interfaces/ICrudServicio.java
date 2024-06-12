package com.campussebastianvergara.Interfaces;

public interface ICrudServicio<T>{
    boolean registrar(T objeto);
    T buscarPorId(String id);
}
