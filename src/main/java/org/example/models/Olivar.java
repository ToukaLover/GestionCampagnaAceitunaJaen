package org.example.models;


import java.util.List;

public class Olivar {

    private int id;
    private String ubicacion;
    private double hectareas;
    private double produccionAnual;
    private List<Cuadrilla> cuadrillaList;

    @Override
    public String toString() {
        return "Olivar{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", hectareas=" + hectareas +
                ", produccionAnual=" + produccionAnual +
                ", cuadrillaList=" + cuadrillaList +
                '}';
    }

    public Olivar(int id, String ubicacion, double hectareas, double produccionAnual) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
        this.produccionAnual = produccionAnual;
    }

    public Olivar(int id, String ubicacion, double hectareas, double produccionAnual, List<Cuadrilla> cuadrillaList) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
        this.produccionAnual = produccionAnual;
        this.cuadrillaList = cuadrillaList;
    }

    public Olivar(String ubicacion, double hectareas, double produccionAnual) {
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
        this.produccionAnual = produccionAnual;
    }

    public void setCuadrillaList(List<Cuadrilla> cuadrillaList) {
        this.cuadrillaList = cuadrillaList;
    }

    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getHectareas() {
        return hectareas;
    }

    public double getProduccionAnual() {
        return produccionAnual;
    }
}
