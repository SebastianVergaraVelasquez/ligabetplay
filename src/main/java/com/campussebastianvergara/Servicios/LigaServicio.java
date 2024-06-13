package com.campussebastianvergara.Servicios;


import com.campussebastianvergara.models.Liga;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LigaServicio {
    
    private static final String FILE_PATH = "ligaBetplay.json";
    private Liga liga;
    private Gson gson;
    
    public LigaServicio(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        liga = new Liga();
    }

    private void saveLiga(){
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(liga,writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean registrar() {
        System.out.println("Cargando datos de la liga");
        saveLiga();
        return true;
    }
}
