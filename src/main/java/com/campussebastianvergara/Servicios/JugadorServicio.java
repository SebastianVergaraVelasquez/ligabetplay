package com.campussebastianvergara.Servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.IJugadorServicio;
import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Jugador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JugadorServicio implements IJugadorServicio {

     private static final String FILE_PATH = "equipos.json";
    private List<Equipo> equipos;
    private Gson gson;

    public JugadorServicio(){
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

    public boolean registrar(Jugador jugador) {
        // TO-DO:
        boolean saved = false;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(jugador.getNombreEquipo())) {
                int i = equipos.indexOf(equipo);
                equipos.get(i).setJugador(jugador);
                saved = true;
            }
        }
        saveEquipos();
        return saved;
    }

    public Jugador buscarPorId(String id) {
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getNombre().equals(id)) {
                    return jugador;
                }
            }
        }
        return null;
    }

    public void sumarGol(Jugador jugador) {
        jugador.setGolesAnotados(jugador.getGolesAnotados() + 1);
        saveEquipos();
    }

    public void sumarTarjetaAmarilla(Jugador jugador) {
        jugador.setTotalTarjetasAmarillas(jugador.getTotalTarjetasAmarillas() + 1);
        saveEquipos();
    }

    public void sumarTarjetaRoja(Jugador jugador) {
        jugador.setTotalTarjetasRojas(jugador.getTotalTarjetasRojas()+1);
        saveEquipos();
    }
}
