package org.example.models;

import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

public class Trabajador {

    private int id;
    private String nombre;
    private int edad;
    private String puesto;
    private double salario;
    private List<Cuadrilla> lista;


    public Trabajador(int id, String nombre, int edad, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Trabajador(String nombre, int edad, String puesto, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
    }

    public void setLista(List<Cuadrilla> lista) {
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public List<Cuadrilla> getLista() {
        return lista;
    }
}
