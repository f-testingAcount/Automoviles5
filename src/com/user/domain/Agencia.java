package com.user.domain;

import com.user.domain.personal.*;
import java.util.*;


public class Agencia {
    private String nombreAgencia;
    private String ciudad;
    private String marcaComercializada;
    private List<Modelo> modelos = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();
    private List<Vendedor> vendedor = new ArrayList<>();
    private List<Recepcionista> recepcionista = new ArrayList<>();
    private List<Mecanico> mecanico = new ArrayList<>();
    private List<Mantenimiento> mantenimiento = new ArrayList<>();

    public Agencia() {}

    public Agencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public Agencia(String nombreAgencia, String ciudad, String marcaComercializada) {
        this.nombreAgencia = nombreAgencia;
        this.ciudad = ciudad;
        this.marcaComercializada = marcaComercializada;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarcaComercializada() {
        return marcaComercializada;
    }

    public void setMarcaComercializada(String marcaComercializada) {
        this.marcaComercializada = marcaComercializada;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public List<Vendedor> getVendedor() {
        return vendedor;
    }

    public void setVendedor(List<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }

    public List<Recepcionista> getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(List<Recepcionista> recepcionista) {
        this.recepcionista = recepcionista;
    }

    public List<Mecanico> getMecanico() {
        return mecanico;
    }

    public void setMecanico(List<Mecanico> mecanico) {
        this.mecanico = mecanico;
    }

    public List<Mantenimiento> getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(List<Mantenimiento> mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
                
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreAgencia);
        sb.append(" | Ciudad: ").append(ciudad);
        sb.append(" | Marca: ").append(marcaComercializada);
        sb.append(" -");
        //sb.append("\n");
        return sb.toString();
    }
}
