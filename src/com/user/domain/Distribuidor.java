
package com.user.domain;

import java.util.*;


public class Distribuidor {
    
    private String nombreDistribuidor;
    private String pais;
    private String marcaDistribuida;
    private List<Agencia> agencias = new ArrayList<>(); 

    public Distribuidor() {}

    public Distribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public Distribuidor(String nombreDistribuidor, String pais, String marcaDistribuida) {
        this.nombreDistribuidor = nombreDistribuidor;
        this.pais = pais;
        this.marcaDistribuida = marcaDistribuida;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMarcaDistribuida() {
        return marcaDistribuida;
    }

    public void setMarcaDistribuida(String marcaDistribuida) {
        this.marcaDistribuida = marcaDistribuida;
    }
    
    

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }
    
    public void agregarAgencia(Agencia agencia){
        agencias.add(agencia);
    }
    
    
    
//    public Agencia buscarAgenciaPorNombre(String nombreAgencia){
//        Agencia encontrada = null;
//        for (int i = 0; i < agencias.size(); i++) {
//            if (nombreAgencia.equalsIgnoreCase(agencias.get(i).getNombreAgencia())) {
//                encontrada = agencias.get(i);
//            }
//        }
//        return encontrada;
//    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreDistribuidor);
        sb.append(" | Pais: ").append(pais);
        sb.append(" | Marca Distribuida: ").append(marcaDistribuida);
        sb.append(" -");
        //sb.append("\n");
        return sb.toString();
    }
}
