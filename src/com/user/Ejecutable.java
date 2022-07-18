package com.user;

import com.user.datos.AccesoDatosImpl;
import com.user.datos.IAccesoDatos;
import com.user.domain.*;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.*;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_AGENCIAS;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_DISTRIBUIDORES;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MARCAS;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MODELOS;
import java.util.*;

public class Ejecutable {

    public static void main(String[] args) throws AccesoDatosEx {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        Marca marca = new Marca();
        Modelo modelo = new Modelo();
        CaracteristicasTec caracteristica = new CaracteristicasTec();
        Distribuidor distribuidor = new Distribuidor();
        Agencia agencia = new Agencia();

        IAccesoDatos datos = new AccesoDatosImpl();

        IAccionesComerciales accion = new AccionesComercialesImpl();

        int opcion = -1;

        do {
            System.out.println("""
                               
                               Ingrese una opcion:
                               1  - Iniciar archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                               2  - Agregar datos a uno de los archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                               3  - Vender Vehiculo
                               4  - Ingresar al service de garantia
                               5  - Servicio mecanico externo
                               6  - Listar Marcas
                               7  - Listar Modelos
                               8  - Listar Caracteristicas Tecnicas
                               9  - Listar Distribuidores
                               10 - Listar Agencias
                               11 - Buscar Modelo
                               12 - Buscar Distribuidor
                               13 - Buscar Agencia
                               14 - Borrar Archivo
                               15 - Test
                               0  - Salir
                               """);

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) { //Iniciar archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                case 1 ->
                    accion.iniciarArchivo();
                case 2 -> { //Agregar Marca, Modelo, Caracteristica tecnica, distribuidor, agencia.
                    System.out.println("Ingrese el nombre del archivo: ");
                    var nombreArchivo = inputString.nextLine();
                    if (null != nombreArchivo) 
                    switch (nombreArchivo) {
                    case "Marcas.txt" -> {
                        System.out.println("Ingrese el nombre de la marca: ");
                        var nombre = inputString.nextLine();
                        marca.setNombre(nombre);
                        System.out.println("Ingrese el origen de la marca: ");
                        var origen = inputString.nextLine();
                        marca.setOrigen(origen);
                        System.out.println("Ingrese el logo de la marca: ");
                        var logo = inputString.nextLine();
                        marca.setLogo(logo);
                        accion.agregar(nombreArchivo, marca);
                        }
                    case "Modelos.txt" -> {
                        System.out.println("Ingrese el tipo de vehiculo (auto, camionesta, moto, camion): ");
                        var tipoVehiculo = inputString.nextLine();
                        System.out.println("Ingrese la denominacion del modelo: ");
                        var denominacion = inputString.nextLine();
                        System.out.println("Ingrese la cantidad de unidades: ");
                        var cantidad = Integer.parseInt(input.nextLine());
                        accion.agregar(nombreArchivo, modelo);
                        }
                    case "Caracteristicas Tecnicas.txt" -> {
                        System.out.println("Ingrese la denominacion del modelo: ");
                        var modeloDenominacion = inputString.nextLine();
                        System.out.println("Ingrese el tipo de motor (Nafta, gasoil): ");
                        var tipoMotor = inputString.nextLine();
                        System.out.println("Ingrese la cantidad de cilindros: ");
                        var cilindros = inputString.nextLine();
                        System.out.println("Ingrese la cilindrada: ");
                        var cilindrada = Integer.parseInt(input.nextLine());
                        System.out.println("Ingrese la potencia del motor en HP: ");
                        var HP = Integer.parseInt(input.nextLine());
                        System.out.println("Ingrese las caracteristicas de la caja (Manual o automatica y la cantidad de velocidades): ");
                        var caja = inputString.nextLine();
                        System.out.println("Ingrese el nivel de equipamiento (base o full): ");
                        var equipamiento = inputString.nextLine();
                        System.out.println("Ingrese el tipo de carroceria (auto, camioneta, SUV, cantidad de puertas, camion, moto)");
                        var carroceria = inputString.nextLine();
                        System.out.println("Ingrese el id del vehiculo: ");
                        var id = inputString.nextLine();
                        accion.agregar(nombreArchivo, caracteristica);
                        }
                    case "Distribuidores.txt" -> {
                        System.out.println("Ingrese el nombre del distribuidor: ");
                        var nombreDistribuidor = inputString.nextLine();
                        System.out.println("Ingrese el pais donde se localiza la sede: ");
                        var pais = inputString.nextLine();
                        accion.agregar(nombreArchivo, opcion);
                        }
                    case "Agencias.txt" -> {
                        System.out.println("Ingrese el nombre de la agencia: ");
                        var nombreAgencia = inputString.nextLine();
                        System.out.println("Ingrese la ciudad donde se ubica la agencia: ");
                        var ciudad = inputString.nextLine();
                        System.out.println("Ingrese el nombre de la marca que comercializa la agencia: ");
                        var marcaComercializada = inputString.nextLine();
                        accion.agregar(nombreArchivo, opcion);
                        }
                    default -> {
                        }
                }
//                    System.out.println("Ingrese el nombre de la Marca: ");
//                    var nombre = inputString.nextLine();
//                    System.out.println("Ingrese el origen de la Marca: ");
//                    var origen = inputString.nextLine();
//                    System.out.println("Ingrese el logo de la marca: ");
//                    var logo = inputString.nextLine();
//                    accion.agregarMarca(ARCHIVO_MARCAS, nombre, origen, logo);
                    

                }

//                case 3 ->{ //Agregar Modeo
//                    System.out.println("Ingrese el tipo de vehiculo (auto, camionesta, moto, camion): ");
//                    var tipoVehiculo = inputString.nextLine();
//                    System.out.println("Ingrese la denominacion del modelo: ");
//                    var denominacion = inputString.nextLine();
//                    System.out.println("Ingrese la cantidad de unidades: ");
//                    var cantidad = Integer.parseInt(input.nextLine());
////                    accion.agregarModelos(ARCHIVO_MODELOS, tipoVehiculo, denominacion, cantidad);
//                    
//                }
//                
//                case 4 ->{ //Agregar Caracteristicas Tecnicas
//                    System.out.println("Ingrese la denominacion del modelo: ");
//                    var modeloDenominacion = inputString.nextLine();
//                    System.out.println("Ingrese el tipo de motor (Nafta, gasoil): ");
//                    var tipoMotor = inputString.nextLine();
//                    System.out.println("Ingrese la cantidad de cilindros: ");
//                    var cilindros = inputString.nextLine();
//                    System.out.println("Ingrese la cilindrada: ");
//                    var cilindrada = Integer.parseInt(input.nextLine());
//                    System.out.println("Ingrese la potencia del motor en HP: ");
//                    var HP = Integer.parseInt(input.nextLine());
//                    System.out.println("Ingrese las caracteristicas de la caja (Manual o automatica y la cantidad de velocidades): ");
//                    var caja = inputString.nextLine();
//                    System.out.println("Ingrese el nivel de equipamiento (base o full): ");
//                    var equipamiento = inputString.nextLine();
//                    System.out.println("Ingrese el tipo de carroceria (auto, camioneta, SUV, cantidad de puertas, camion, moto)");
//                    var carroceria = inputString.nextLine();
//                    System.out.println("Ingrese el id del vehiculo: ");
//                    var id = inputString.nextLine();
////                    accion.agregarCaracteristicasTecnicas(ARCHIVO_CARACTERISTICAS_TEC, tipoMotor, cilindros, cilindrada, HP, caja, equipamiento, carroceria, id, modeloDenominacion);
//                }
//                
//                case 5 ->{ //Agregar Distribuidor
//                    System.out.println("Ingrese el nombre del distribuidor: ");
//                    var nombreDistribuidor = inputString.nextLine();
//                    System.out.println("Ingrese el pais donde se localiza la sede: ");
//                    var pais = inputString.nextLine();
////                    accion.agregarDistribuidor(ARCHIVO_DISTRIBUIDORES, nombreDistribuidor, pais);
//                }
//                
//                case 6 ->{ //Agregar Agencia
//                    System.out.println("Ingrese el nombre de la agencia: ");
//                    var nombreAgencia = inputString.nextLine();
//                    System.out.println("Ingrese la ciudad donde se ubica la agencia: ");
//                    var ciudad = inputString.nextLine();
//                    System.out.println("Ingrese el nombre de la marca que comercializa la agencia: ");
//                    var marcaComercializada = inputString.nextLine();
////                    accion.agregarAgencia(ARCHIVO_AGENCIAS, nombreAgencia, ciudad, marcaComercializada);
//                }
                case 3 -> { //Vender Vehiculo
                    System.out.println("Ingrese los datos del modelo: ");
                    System.out.println("Ingrese el tipo de vehiculo: ");
                    var tipoVehiculo = inputString.nextLine();
                    System.out.println("Ingrese la denominacion del vehiculo: ");
                    var denominacion = inputString.nextLine();
                    System.out.println("Ingrese la cantidad de vehiculos en existencia: ");
                    var cantidad = modelo.getCantidad();
                    modelo = new Modelo(tipoVehiculo, denominacion, cantidad);
                    System.out.println("Hay en existencia del modelo " + modelo.getDenominacion() + " " + modelo.getCantidad() + " unidades\n");
                    accion.venderVehiculo(modelo);
                }

                case 4 -> { //Ingresar al service de garantia

                }

                case 5 -> { //Servicio mecanico externo

                }

                case 6 -> { //Listar Marcas
                    //marca = new Marca();
                    accion.listarArchivo(ARCHIVO_MARCAS);
                }

                case 7 -> {
                    //Listar Modelos
                    //modelo = new Modelo();
                    accion.listarArchivo(ARCHIVO_MODELOS);
                }

                case 8 -> { //Listar Caracteristicas Tecnicas
                    //caracteristicas = new CaracteristicasTec();
                    accion.listarArchivo(ARCHIVO_CARACTERISTICAS_TEC);
                }

                case 9 -> { //Listar Distribuidores
                    //distribuidor = new Distribuidor();
                    accion.listarArchivo(ARCHIVO_DISTRIBUIDORES);
                }

                case 10 -> { //Listar Agencias
                    //agencia = new Agencia();
                    accion.listarArchivo(ARCHIVO_AGENCIAS);
                }

                case 11 -> { //Buscar Modelo
                    System.out.println("Ingrese la deniminacion del modelo: ");
                    var denominacion = inputString.nextLine();
                    System.out.println(datos.buscar(ARCHIVO_MODELOS, modelo.getDenominacion()));
                }

                case 12 -> { //Buscar Distribuidor
                    System.out.println("Ingrese el nombre del distribuidor: ");
                    var nombreDistribuidor = inputString.nextLine();
                    System.out.println(datos.buscar(ARCHIVO_DISTRIBUIDORES, distribuidor.getNombreDistribuidor()));

                }

                case 13 -> { //Buscar Agencia
                    System.out.println("Ingrese el nombre de la agencia: ");
                    var nombreAgencia = inputString.nextLine();
                    System.out.println(datos.buscar(ARCHIVO_AGENCIAS, agencia.getNombreAgencia()));
                }

                case 14 -> { //Borrar Archivo
                    System.out.println("Ingrese el nombre del archivo a eliminar: ");
                    var nombreArchivo = inputString.nextLine();
                    accion.borrarArchivo(nombreArchivo);
                    System.out.println("El archivo " + nombreArchivo + " ha sido borrado!");
                }

                case 15 -> { //Testeo

                }

                case 0 -> { //Salir
                    System.out.println("Hasta pronto!");
                    System.exit(0);
                }

                default -> { //Como evitar la excepcion si no ingreso un valor y solo ingreso enter?

                    System.out.println("La opcion ingresada no existe! , ingrese una opcion valida! ");

                }
            }

        } while (opcion != 0);

    }

}
