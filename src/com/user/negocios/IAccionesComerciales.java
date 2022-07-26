
package com.user.negocios;

import com.user.domain.CaracteristicasTec;
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
    
//    void agregarMarca(String nombreArchivo, String nombre, String origen, String logo);
//    
//    void agregarModelos(String nombreArchivo, String tipoVehiculo, String denominacion, int cantidad); 
//    
//    void agregarCaracteristicasTecnicas(String nombreArchivo, String tipoMotor, String cilindros, int cilindrada, int HP, String caja, String equipamiento, String carroceria, String id, String modeloDenominacion);
//    
//    void agregarDistribuidor(String nombreArchivo, String nombreDistribuidor, String pais);
//    
//    void agregarAgencia(String nombreArchivo, String nombreAgencia, String ciudad, String marcaComercializada);
    
    void listarArchivo(String nombreArchivo, T object);
    
    void enviarPedidoAFabricante(Marca marca, int unidades);
    
    Integer stock(String nombreArchivo, String nombreMarca, String denominacionModelo);
    
    void venderVehiculo(Marca marca, Modelo modelo, CaracteristicasTec caracteristicas, boolean stock); 
    
    void ingresarAlService(String ID);
    
    void enviarUnidadesAAgencia(Marca marca, Modelo modelo);
    
    void vincularMarcaModelo(Marca marca, Modelo modelo);
    
    void vincularModeloCaracteristicasTec(Modelo modelo, CaracteristicasTec caracteristica);
    
//    void buscarInfo(String nombreArchivo, String dato);
    
    void borrarArchivo(String nombreArchivo);
            
}
