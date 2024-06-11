package com.example.recuperacionfinal.EjemploRyM;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRyM {
    private static ServiceRyM instancia;
    private static RyMRepo repo;
    private ServiceRyM(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo  = retrofit.create(RyMRepo.class);
    }
    public static RyMRepo getRepo(){
        return repo;
    }
    public static ServiceRyM getInstancia(){
        if (instancia==null){
            instancia=new ServiceRyM();
        }
        return instancia;
    }
}