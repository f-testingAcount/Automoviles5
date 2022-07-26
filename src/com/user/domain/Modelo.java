package com.user.domain;

import java.util.*;


public class Modelo {
    
    private String tipoVehiculo; //Auto, camioneta, SUV, Moto, camion
    String denominacion;
    private int cantidad;
    private ArrayList<CaracteristicasTec> caracteristicas = new ArrayList<>();

    public Modelo() {}

    public Modelo(String denominacion) {
        this.denominacion = denominacion;
    }
    
    public Modelo(String denominacion, int cantidad){
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }
    
    public Modelo(String tipoVehiculo, String denominacion){
        this.tipoVehiculo = tipoVehiculo;
        this.denominacion = denominacion;
    }

    public Modelo(String tipoVehiculo, String denominacion, int cantidad) {
        this.tipoVehiculo = tipoVehiculo;
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<CaracteristicasTec> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<CaracteristicasTec> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    public void agregarCaracteristicaAModelo(CaracteristicasTec caracteristica){
        caracteristicas.add(caracteristica);
    }
    
    public CaracteristicasTec buscarModeloPorID(String id){
        CaracteristicasTec encontrado = null;
        for (int i = 0; i < caracteristicas.size(); i++) {
            if (id.equalsIgnoreCase(caracteristicas.get(i).getId())) {
                encontrado = caracteristicas.get(i);
            }
        }
        return encontrado;
    }
    
    public CaracteristicasTec buscarModeloPorDenominacion(String denominacion){
        CaracteristicasTec encontrado = null;
        for (int i = 0; i < caracteristicas.size(); i++) {
            if (denominacion.equalsIgnoreCase(caracteristicas.get(i).getId())) {
                encontrado = caracteristicas.get(i);
            }
        }
        return encontrado;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Vehiculo: ").append(tipoVehiculo);
        sb.append(" | Denominacion: ").append(denominacion);
        sb.append(" | Cantidad: ").append(cantidad);
        sb.append(" -");
        sb.append("\n");
        return sb.toString();
    }
           
}
