package com.user.domain;

import java.util.*;


public class Marca {
    
    private String nombre;
    private String origen;
    private String logo;
    private boolean stock;
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();

    public Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca(String nombre, String origen, String logo) {
        this.nombre = nombre;
        this.origen = origen;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    public void agregarModeloAMarca(Modelo modelo){
        modelos.add(modelo);
    }
    
    public Modelo buscarModeloPorDenominacion(String denominacion){
        Modelo encontrado = null;
        for (int i = 0; i < modelos.size(); i++) {
            if (denominacion.equalsIgnoreCase(modelos.get(i).getDenominacion())) {
                encontrado = modelos.get(i);
            }
        }
        return encontrado;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(" | Origen: ").append(origen);
        sb.append(" | Logo: ").append(logo);
        sb.append(" -");
        sb.append("\n");
        return sb.toString();
    }
}
