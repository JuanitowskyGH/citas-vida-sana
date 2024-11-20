package com.example.citasvidasana;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLOpenHelper extends SQLiteOpenHelper {

    public AdminSQLOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        //Creacion de tablas
        bd.execSQL("create table usuarios(idUsuario integer primary key autoincrement, nombre text, apellidop text, apellidom text, telefono int," +
                "correo text, pass text)");
        bd.execSQL("create table especialistas(idEspecialista integer primary key autoincrement, nombre text, apellidop text, apellidom text, telefono int," +
                "correo text, especialidad text, cedula int, pass text)");
        bd.execSQL("create table resultados(idResultado integer primary key autoincrement, ruta text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        bd.execSQL("drop Table if exists usuarios");
        bd.execSQL("drop Table if exists especialistas");
    }
    /*public Cursor obtenerUsuarios(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select nombre, apellidop, apellidom, telefono, correo, pass from usuarios", null);
        return cursor;
    }*/
}
