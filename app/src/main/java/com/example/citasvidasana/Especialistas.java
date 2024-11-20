package com.example.citasvidasana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.citasvidasana.databinding.ActivityEspecialistasBinding;

import java.util.ArrayList;

public class Especialistas extends DrawerBasePaciente {
    RecyclerView recyclerView;
    ArrayList<String> nombre, apellidop, apellidom, telefono, correo, especialidad, cedula;
    AdminSQLOpenHelper bd;
    AdapterEspecialistas adapterEspecialistas;
    ActivityEspecialistasBinding activityEspecialistasBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEspecialistasBinding = ActivityEspecialistasBinding.inflate(getLayoutInflater());
        setContentView(activityEspecialistasBinding.getRoot());

        nombre = new ArrayList<>();
        apellidop = new ArrayList<>();
        apellidom = new ArrayList<>();
        telefono = new ArrayList<>();
        correo = new ArrayList<>();
        especialidad = new ArrayList<>();
        cedula = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewEspecialistas);
        adapterEspecialistas = new AdapterEspecialistas(this, nombre, apellidop, apellidom, telefono, correo, especialidad, cedula);
        recyclerView.setAdapter(adapterEspecialistas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mostrarDatos();

    }

    private void mostrarDatos() {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this, "basedatos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor filaE = bd.rawQuery("Select nombre, apellidop, apellidom, telefono, correo, especialidad, cedula from especialistas", null);

        if (filaE.getCount()==0){
            Toast.makeText(this, "Aún no hay especialistas registrados.", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (filaE.moveToNext()){
                nombre.add(filaE.getString(0));
                apellidop.add(filaE.getString(1));
                apellidom.add(filaE.getString(2));
                telefono.add(filaE.getString(3));
                correo.add(filaE.getString(4));
                especialidad.add(filaE.getString(5));
                cedula.add(filaE.getString(6));
            }
        }
    }
}