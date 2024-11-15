package org.example.models;

import java.util.List;

public class Cuadrilla {

    private int id;
    private String nombre;
    private int supervisorId;
    private List<Trabajador> trabajadorList;
    private List<Olivar> olivarList;

    @Override
    public String toString() {
        return "Cuadrilla{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", supervisorId=" + supervisorId +
                '}';
    }

    public Cuadrilla(int id, String nombre, int supervisorId) {
        this.id = id;
        this.nombre = nombre;
        this.supervisorId = supervisorId;
    }

    public Cuadrilla(int id, String nombre, int supervisorId, List<Trabajador> trabajadorList, List<Olivar> olivarList) {
        this.id = id;
        this.nombre = nombre;
        this.supervisorId = supervisorId;
        this.trabajadorList = trabajadorList;
        this.olivarList = olivarList;
    }

    public Cuadrilla(String nombre, int supervisorId) {
        this.nombre = nombre;
        this.supervisorId = supervisorId;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    public void setOlivarList(List<Olivar> olivarList) {
        this.olivarList = olivarList;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public List<Olivar> getOlivarList() {
        return olivarList;
    }
}
