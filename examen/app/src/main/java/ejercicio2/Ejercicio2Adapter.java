package ejercicio2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen2.R;

import java.util.ArrayList;

public class Ejercicio2Adapter extends RecyclerView.Adapter<Ejercicio2Adapter.ViewHolder>{

    ArrayList<Cripto> criptos;

    final String DINERO="Dinero: ";

    final String NOMBRE="Nombre: ";

    final String ESTAFADOS="Estafados:\n";

    final String EUROS=" €";

    public Ejercicio2Adapter(){
        criptos=new ArrayList<>();
    }

    public void  setCriptos(Cripto datos){
        criptos=new ArrayList<>();
        criptos.add(datos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_recicler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getDinero().setText(DINERO+Double.toString(criptos.get(position).euros)+EUROS);
        holder.getNombre().setText(NOMBRE+criptos.get(position).nombre);
        ArrayList<Estafado> lista=criptos.get(position).estafados;
        int cont=0;
        String texto=ESTAFADOS;
        while(cont<lista.size()){
            texto+="\t-"+lista.get(cont).nombre+"\n";
            cont++;
        }
        holder.getGente().setText(texto);
    }

    @Override
    public int getItemCount() {
        return criptos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{



        TextView dinero;
        TextView nombre;
        TextView gente;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dinero = (TextView) itemView.findViewById(R.id.idDinero);
            nombre = (TextView) itemView.findViewById(R.id.idnombre);
            gente = (TextView) itemView.findViewById(R.id.idGente);
        }
        public TextView getDinero() {
            return dinero;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getGente() {
            return gente;
        }
    }
}
