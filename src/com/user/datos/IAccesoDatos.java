package com.user.datos;

import com.user.domain.CaracteristicasTec;
import com.user.domain.Marca;
import com.user.domain.Modelo;
import com.user.exceptions.AccesoDatosEx;
import java.util.List;

public interface IAccesoDatos <T> {
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    void escribir(T object, String nombreArchivo) throws AccesoDatosEx;
    
//    void escribir(T object, String nombreArchivo) throws AccesoDatosEx;
    
//    void sobreEscribir(T variable, String nombreArchivo) throws AccesoDatosEx;

    List<T> listar(T object, String nombreArchivo) throws AccesoDatosEx;
    
    T buscar(String nombreArchivo, Object object) throws AccesoDatosEx;
    
//    T buscar(String nombreArchivo, String object) throws AccesoDatosEx;
    
//    void vincularMarcaModeloCarcTec(Marca marca, Modelo modelo, CaracteristicasTec caracteristica);
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
        
}
