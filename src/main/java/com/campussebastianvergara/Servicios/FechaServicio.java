package com.campussebastianvergara.Servicios;

import com.campussebastianvergara.DataBase;
import com.campussebastianvergara.Interfaces.ICrudServicio;
import com.campussebastianvergara.Interfaces.IFechaServicio;
import com.campussebastianvergara.models.Fecha;
import com.campussebastianvergara.models.Liga;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FechaServicio implements ICrudServicio<Fecha>, IFechaServicio{

    private static final String FILE_PATH = "ligaBetplay.json";
    private List<Fecha> fechas;
    private Gson gson;

    public FechaServicio(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        fechas = new ArrayList<>(loadFechas());
    }

    private List<Fecha> loadFechas(){
        try(Reader reader = new FileReader(FILE_PATH)){
            Type listType = new TypeToken<ArrayList<Fecha>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); //Devuelve una lista vacia si el archivo no existe  
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveFechas(){
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(fechas,writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean registrar(Fecha fecha) {
        fechas.add(fecha);
        saveFechas();
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

