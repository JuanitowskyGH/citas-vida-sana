package com.example.citasvidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.citasvidasana.databinding.ActivityResultadosMedicosBinding;

public class ResultadosMedicos extends DrawerBasePaciente {

    ActivityResultadosMedicosBinding activityResultadosMedicosBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityResultadosMedicosBinding = ActivityResultadosMedicosBinding.inflate(getLayoutInflater());
        setContentView(activityResultadosMedicosBinding.getRoot());
    }
}