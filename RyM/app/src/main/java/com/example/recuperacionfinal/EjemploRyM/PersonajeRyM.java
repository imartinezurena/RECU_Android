package com.example.recuperacionfinal.EjemploRyM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonajeRyM implements Serializable {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ArrayList<PersonajeRyM> generador(ArrayList<PersonajeRyM> listadoPersonaje) {

        ArrayList<PersonajeRyM> listadoApi = new ArrayList<PersonajeRyM>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoPersonaje != null && !listadoPersonaje.isEmpty()) {
            listadoApi.addAll(listadoPersonaje);
        }

        return listadoApi;
    }


}
