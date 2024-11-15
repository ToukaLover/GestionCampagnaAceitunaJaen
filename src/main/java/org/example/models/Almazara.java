package org.example.models;

import org.example.conexion.Conexion;
import org.example.dao.AlmazaraDAO;

import java.sql.Connection;
import java.util.List;

public class Almazara {

    private int id;
    private String nombre;
    private String ubicacion;
    private double capacidad;

    @Override
    public String toString() {
        return "Almazara{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    public Almazara(int id, String nombre, String ubicacion, double capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public Almazara(String nombre, String ubicacion, double capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getCapacidad() {
        return capacidad;
    }
}
