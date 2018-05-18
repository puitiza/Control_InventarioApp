package com.example.apuitiza.control_inventarioapp.models;

import java.io.Serializable;

/**
 * Created by wfloresv on 17/05/2018.
 */

public class Movimiento implements Serializable{

    private int id;
    private int tipo;
    private Producto producto;
    private String fechaHora;
    private int cantidad;

    public Movimiento(){}

    public Movimiento(int id, int tipo, Producto producto, String fechaHora, int cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.producto = producto;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
