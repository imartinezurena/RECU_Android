package com.example.recuperacionfinal.EjemploRyM;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperacionfinal.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRyM extends RecyclerView.Adapter<AdapterRyM.ViewHolder> {
    private List<PersonajeRyM> listaPersonajes;

    public AdapterRyM() {
        listaPersonajes = new ArrayList<>();
    }

    public interface ItemClickListener {
        void onClick(View view, int position, PersonajeRyM personaje);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvNombre = (TextView) view.findViewById(R.id.nombreDetallerPersonaje);
            view.setOnClickListener(this);
        }

        public void setName(String nombre) {
            tvNombre.setText(nombre);

        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null)
                clickListener.onClick(view, getAdapterPosition(), listaPersonajes.get(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_personajes, parent, false);

        return new ViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonajeRyM personaje = listaPersonajes.get(position);
        holder.setName(personaje.getName());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }
    public void setDatos(ArrayList<PersonajeRyM> personajes) {
        listaPersonajes.clear();
        listaPersonajes.addAll(personajes);
        notifyDataSetChanged();
    }
}
