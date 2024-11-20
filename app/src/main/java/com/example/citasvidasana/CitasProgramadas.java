package com.example.citasvidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.citasvidasana.databinding.ActivityCitasProgramadasBinding;

public class CitasProgramadas extends DrawerBasePaciente {

    ActivityCitasProgramadasBinding activityCitasProgramadasBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCitasProgramadasBinding = ActivityCitasProgramadasBinding.inflate(getLayoutInflater());
        setContentView(activityCitasProgramadasBinding.getRoot());
    }
}