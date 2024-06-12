package ejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.examen2.R;

public class Ejercicio1 extends AppCompatActivity {


    Button recitar;

    TextView poema;

    ProgressBar pg;

    public static final String VACIO="";
    public static final String FIN="FIN";
    String verso="";


    int inicioPoema=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        recitar=findViewById(R.id.idBtRecitar);
        poema=findViewById(R.id.idTvPoema);
        pg=findViewById(R.id.progressBar);
        ViewModelEjercicio1 vm= new ViewModelProvider(this).get(ViewModelEjercicio1.class);
        vm.getPoema().observe(this,datos-> {
            if(inicioPoema==0){
                pg.setVisibility(View.INVISIBLE);
                inicioPoema++;
            }
            if(datos.equals(FIN)){
                recitar.setEnabled(true);
            }
            else{
                verso+=" "+datos;
                poema.setText(verso);
            }
        });

        recitar.setOnClickListener(v -> {
            pg.setVisibility(View.VISIBLE);
            verso="";
            poema.setText(VACIO);
            inicioPoema=0;
            recitar.setEnabled(false);
            vm.getVerso(inicioPoema);
        });
    }
}