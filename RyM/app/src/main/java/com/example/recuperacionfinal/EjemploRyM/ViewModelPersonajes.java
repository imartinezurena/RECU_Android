package com.example.recuperacionfinal.EjemploRyM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelPersonajes extends ViewModel {
    MutableLiveData<ArrayList<PersonajeRyM>> misDatos;//se crea una lista del tipo de dato a usar (POJO)
    ServiceRyM sr; //se crea una instancia del Service

    public LiveData<ArrayList<PersonajeRyM>> getDatos() {//este dato cual tiene que ser??
        if (misDatos == null) {
            misDatos = new MutableLiveData<ArrayList<PersonajeRyM>>();
            sr = ServiceRyM.getInstancia();
            addDatos();
        }
        return misDatos;
    }

    //a partir de aquí es el metodo que gestiona la llamada,
    private void addDatos() {
        new Thread(()->{
            ServiceRyM ser = ServiceRyM.getInstancia();
            Call<List<PersonajeRyM>> llamada = ser.getRepo().getListaPersonajes();
            llamada.enqueue(new Callback<List<PersonajeRyM>>() {
                @Override
                public void onResponse(Call<List<PersonajeRyM>> call, Response<List<PersonajeRyM>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<PersonajeRyM> listaPersonajes = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<PersonajeRyM> personajesProcesados = PersonajeRyM.generador(listaPersonajes);
                        misDatos.postValue(personajesProcesados);
                    }
                }

                @Override
                public void onFailure(Call<List<PersonajeRyM>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });


        }).start();
    }


}

