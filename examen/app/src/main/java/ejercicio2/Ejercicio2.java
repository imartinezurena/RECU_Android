package ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.examen2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ejercicio2 extends AppCompatActivity {

    Button bitcoin;

    Button ethe;

    CriptoService service;
    RecyclerView rv;
    ProgressBar pg;

    Spinner lista;

    TextView error;

    final String BITCOIN="bitcoin";
    final String ETHERUM="etherum";
    final String ERRO_AL_RECUPERAR="Ha habido un problema al recuperar los datos";

    final int ID_NO_COINCIDE=0;

    final int ID_BITCOIN=1;
    final int ID_ETHERUM=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        bitcoin=findViewById(R.id.btBit);
        rv=findViewById(R.id.lista);
        pg=findViewById(R.id.progressBar2);
        lista=findViewById(R.id.spinner);
        service=CriptoService.getInstance();
        error=findViewById(R.id.tvError);
        LinearLayoutManager lm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(lm);
        Ejercicio2Adapter adapter=new Ejercicio2Adapter();
        rv.setAdapter(adapter);
        bitcoin.setOnClickListener(v -> {
            pg.setVisibility(View.VISIBLE);
            error.setText("");
            int id=transformador(lista.getSelectedItem().toString());
            Call<Cripto> llamada= service.getRepo().getCriptoById(id);
            llamada.enqueue(new Callback<Cripto>() {
                @Override
                public void onResponse(Call<Cripto> call, Response<Cripto> response) {
                    Cripto dato= response.body();
                    pg.setVisibility(View.INVISIBLE);
                    Ejercicio2Adapter ad=(Ejercicio2Adapter)rv.getAdapter();
                    ad.setCriptos(dato);
                }

                @Override
                public void onFailure(Call<Cripto> call, Throwable t) {
                    pg.setVisibility(View.INVISIBLE);
                    rv.setAdapter(new Ejercicio2Adapter());
                    error.setTextColor(Color.RED);
                    error.setText(ERRO_AL_RECUPERAR);
                    error.append("\n"+t.getMessage());
                }
            });
        });
    }

    private int transformador(String nombre){
        int res=ID_NO_COINCIDE;
        if(nombre.equals(BITCOIN)){
            res=ID_BITCOIN;
        } else if (nombre.equals(ETHERUM)) {
            res=ID_ETHERUM;
        }
        else{
            res=ID_NO_COINCIDE;
        }
        return res;
    }
}