package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.Interfaces.IEquipoServicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EquipoServicio implements IEquipoServicio{

    private static final String FILE_PATH = "equipos.json";
    private List<Equipo> equipos;
    private Gson gson;

    public EquipoServicio(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        equipos = loadEquipos();
    }

    private List<Equipo> loadEquipos(){
        try(Reader reader = new FileReader(FILE_PATH)){
            Type listType = new TypeToken <ArrayList<Equipo>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); //Devuelve una lista vacia si el archivo no existe  
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveEquipos(){
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(equipos,writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean registrar(Equipo equipo) {
        equipos.add(equipo);
        saveEquipos();
        return true;
    }

    public Equipo buscarPorId(String nombre) {
        for (Equipo equipo : equipos) {
            if(equipo.getNombre().equals(nombre)){
                return equipo;
            }
        }
      return null;
    }

    public void actualizarInfo(Equipo equipo, String resultado, int golesFavor, int golesContra) {
        // Esta función permite actualizar la información de los atributos del equipo
        // seleccionado
       
        equipo.setPartidosJugados(equipo.getPartidosJugados()+1);
      
        if (resultado.equalsIgnoreCase("victoria")) {
            equipo.setPartidosGanados(equipo.getPartidosGanados()+1);
            equipo.setTotalPuntos(equipo.getTotalPuntos()+3);
        } else if (resultado.equalsIgnoreCase("derrota")) {
            equipo.setPartidosPerdidos(equipo.getPartidosPerdidos()+1);
        } else {
            equipo.setPartidosEmpatados(equipo.getPartidosEmpatados()+1);
            equipo.setTotalPuntos(equipo.getTotalPuntos()+1);
        }

        equipo.setGolesFavor(equipo.getGolesFavor()+golesFavor);
        equipo.setGolesContra(equipo.getGolesContra()+golesContra);
        saveEquipos();
    }
}
