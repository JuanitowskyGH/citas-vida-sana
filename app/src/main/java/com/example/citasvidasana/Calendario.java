package com.example.citasvidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.citasvidasana.databinding.ActivityCalendarioBinding;

public class Calendario extends DrawerBasePaciente {

    ActivityCalendarioBinding activityCalendarioBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCalendarioBinding = ActivityCalendarioBinding.inflate(getLayoutInflater());
        setContentView(activityCalendarioBinding.getRoot());
    }
}