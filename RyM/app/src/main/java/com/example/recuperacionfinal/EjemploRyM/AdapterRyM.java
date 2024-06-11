package com.example.recuperacionfinal.EjemploRyM;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperacionfinal.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRyM extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PersonajeRyM> personajes;
    public AdapterRyM() {
        personajes = new ArrayList<>();
    }
    public interface ItemClickListener {
        void onClick(View view, int position, PersonajeRyM personaje);
    }
    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_personajes, parent, false);

        return new RecyclerView.ViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PersonajeRyM personaje = personajes.get(position);
        holder.setInfo(personaje.getName());
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }
}
