package com.example.recuperacionfinal.EjemploRyM;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperacionfinal.R;

public class ListaPersonajes extends AppCompatActivity {
    private static final String CLAVE_PERSONAJE = "skere";
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_personajes);
        ViewModelPersonajes modeloVista = new ViewModelProvider(this).get(ViewModelPersonajes.class);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //siempre que se use un RV hacen falta estas 3 lineas
        rv = findViewById(R.id.recyclerPersonajes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        AdapterRyM adapter=new AdapterRyM();
        rv.setAdapter(adapter);


        adapter.setClickListener(new AdapterRyM.ItemClickListener() {
            @Override
            public void onClick(View view, int position, PersonajeRyM personaje ) {
                Intent i = new Intent(ListaPersonajes.this, DetallesPersonaje.class);
                i.putExtra(ListaPersonajes.CLAVE_PERSONAJE,personaje);
                startActivity(i);
            }
        });


    }

}