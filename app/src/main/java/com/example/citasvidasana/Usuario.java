package com.example.citasvidasana;

public class Usuario {
    private String nombre;
    private String apellidop;
    private String apellidom;
    private int telefono;
    private String correo;
    private String pass;


    public Usuario(String nombre, String apellidop, String apellidom, int telefono, String correo, String pass) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.telefono = telefono;
        this.correo = correo;
        this.pass = pass;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }
}
