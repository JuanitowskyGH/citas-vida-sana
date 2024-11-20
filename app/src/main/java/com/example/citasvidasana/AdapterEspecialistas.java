package com.example.citasvidasana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterEspecialistas extends RecyclerView.Adapter<AdapterEspecialistas.EspecialistasViewHolder> {
    private Context context;
    private ArrayList nombre_id, apellidop_id, apellidom_id, telefono_id, correo_id, especialidad_id, cedula_id;

    public AdapterEspecialistas(Context context, ArrayList nombre_id, ArrayList apellidop_id, ArrayList apellidom_id, ArrayList telefono_id, ArrayList correo_id, ArrayList especialidad_id, ArrayList cedula_id) {
        this.context = context;
        this.nombre_id = nombre_id;
        this.apellidop_id = apellidop_id;
        this.apellidom_id = apellidom_id;
        this.telefono_id = telefono_id;
        this.correo_id = correo_id;
        this.especialidad_id = especialidad_id;
        this.cedula_id = cedula_id;
    }

    @NonNull
    @Override
    public EspecialistasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.especialistaentry, parent, false);
        return new EspecialistasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEspecialistas.EspecialistasViewHolder holder, int position) {
        holder.nombre_id.setText(String.valueOf((nombre_id.get(position))));
        holder.apellidop_id.setText(String.valueOf((apellidop_id.get(position))));
        holder.apellidom_id.setText(String.valueOf((apellidom_id.get(position))));
        holder.telefono_id.setText(String.valueOf((telefono_id.get(position))));
        holder.correo_id.setText(String.valueOf((correo_id.get(position))));
        holder.especialidad_id.setText(String.valueOf((especialidad_id.get(position))));
        holder.cedula_id.setText(String.valueOf((cedula_id.get(position))));

    }

    @Override
    public int getItemCount() {
        return nombre_id.size();
    }

    public class EspecialistasViewHolder extends RecyclerView.ViewHolder {
        TextView nombre_id, apellidop_id, apellidom_id, telefono_id, correo_id, especialidad_id, cedula_id;
        public EspecialistasViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_id = itemView.findViewById(R.id.Nombre);
            apellidop_id = itemView.findViewById(R.id.Apellidop);
            apellidom_id = itemView.findViewById(R.id.Apellidom);
            telefono_id = itemView.findViewById(R.id.Telefono);
            correo_id = itemView.findViewById(R.id.Correo);
            especialidad_id = itemView.findViewById(R.id.Especialidad);
            cedula_id = itemView.findViewById(R.id.Cedula);
        }
    }
}
