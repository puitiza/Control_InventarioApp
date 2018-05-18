package com.example.apuitiza.control_inventarioapp.models;

import java.io.Serializable;

public class Producto implements Serializable{

    private int id;
    private String nombre;
    private int stock;
    private String url;
    private String codigoBarra;

    public Producto(){}

    public Producto(String nombre){
        this.nombre = nombre;
    }

    public Producto(int id, String nombre, int stock, String url,String codigoBarra) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.url = url;
        this.codigoBarra = codigoBarra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
