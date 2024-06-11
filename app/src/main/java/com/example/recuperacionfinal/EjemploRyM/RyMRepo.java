package com.example.recuperacionfinal.EjemploRyM;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RyMRepo {
   // @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("/character/")
    Call<List<PersonajeRyM>>getListaPersonajes() ;

}
