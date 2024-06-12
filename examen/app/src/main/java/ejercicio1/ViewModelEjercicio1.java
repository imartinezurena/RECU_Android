package ejercicio1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class ViewModelEjercicio1 extends ViewModel {
    String poema[] = {
            "Si", "hay", "hombres", "que", "contienen", "un", "alma", "sin", "fronteras,",
            "una", "esparcida", "frente", "de", "mundiales", "cabellos,",
            "cubierta", "de", "horizontes,", "barcos", "y", "cordilleras,",
            "con", "arena", "y", "con", "nieve,", "tú", "eres", "uno", "de", "aquellos.",
            "FIN"
    };
    public static final int SLEEP_BASE = 160;

    public static final int SLEEP = 400 - SLEEP_BASE;


    int contador;

    MutableLiveData<String> palabra;


    public LiveData<String> getPoema() {
        if (palabra == null) {
            palabra = new MutableLiveData<>();
            contador = 0;
        }
        return palabra;
    }
//    "palabra" es un MutableLiveData que se usa para almacenar y observar la palabra actual del poema.
//    LiveData es una clase de datos observables que respeta el ciclo de vida,
//    lo que significa que actualiza a los observadores (como actividades o fragmentos) solo cuando están en estado activo.
//Este método devuelve una instancia de LiveData que contiene la palabra actual del poema. Si palabra es null, se inicializa junto con contador.

    public void getVerso(int inicio) {
        contador = inicio;
        new Thread(() -> {
            try {
                while (contador < poema.length) {
                    long dormir = (long) new Random().nextInt(SLEEP);
                    dormir += SLEEP_BASE;
                    Thread.sleep(dormir);
                    String enviar = poema[contador];
                    palabra.postValue(enviar);
                    contador++;

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
