
package com.user.negocios;

import com.user.domain.Marca;
import com.user.domain.Modelo;


public interface IAccionesComerciales <T>{
    
    public static final String ARCHIVO_MARCAS = "Marcas.txt";
    public static final String ARCHIVO_MODELOS = "Modelos.txt";
    public static final String ARCHIVO_CARACTERISTICAS_TEC = "Caracteristicas Tecnicas.txt";
    public static final String ARCHIVO_DISTRIBUIDORES = "Distribuidores.txt";
    public static final String ARCHIVO_AGENCIAS = "Agencias.txt";
    
    void iniciarArchivo();
    
    void agregar(String nombreArchivo, T object);
    
    void listarArchivo(String nombreArchivo, T object);
    
    void enviarRecibirPedidoDeFabricante(String nombreArchivo, Modelo modelo, String denominacionModelo, int unidades);
    
    void venderVehiculo(String nombreArchivo, String denominaicionModelo); 
    
    void ingresarAlService(String ID);
    
    void enviarUnidadesAAgencia(Marca marca, Modelo modelo);
    
    void borrarArchivo(String nombreArchivo);
            
}
