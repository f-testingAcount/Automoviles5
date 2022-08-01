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
                               \nIngrese una opcion:
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
                               11 - Buscar Marca
                               12 - Buscar Modelo
                               13 - Buscar Caracteristica Tecnica
                               14 - Buscar Distribuidor
                               15 - Buscar Agencia
                               16 - Borrar Archivo
                               17 - Test Control stock
                               18 - Test Buscar indice
                               19 - Test Buscar desde metodo en clase
                               20 - Test Enviar pedido / Recibir unidades
                               0  - Salir
                               """);

        opcion = Integer.parseInt(input.nextLine());

            switch (opcion) { //Iniciar archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                case 1 ->
                    accion.iniciarArchivo();
                case 2 -> { //Agregar Marca, Modelo, Caracteristica tecnica, distribuidor, agencia.
                    var seleccion = 0;
                    System.out.println("""                                        
                                        Ingrese el nombre del archivo: 
                                        1 - Marcas.txt
                                        2 - Modelos.txt
                                        3 - Caracteristicas Tecnicas.txt
                                        4 - Distribuidores.txt
                                        5 - Agencias.txt
                                        """);
                    seleccion = Integer.parseInt(input.nextLine());
                    switch (seleccion) {
                        case 1 -> {
                            String nombreArchivo = "Marcas.txt";
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
                        case 2 -> {
                            String nombreArchivo = "Modelos.txt";
                            System.out.println("Ingrese la marca: ");
                            var nombreMarca = inputString.nextLine();
                            modelo.setNombreMarca(nombreMarca);
                            System.out.println("Ingrese el tipo de vehiculo (auto, camioneta, moto, camion): ");
                            var tipoVehiculo = inputString.nextLine();
                            modelo.setTipoVehiculo(tipoVehiculo);
                            System.out.println("Ingrese la denominacion del modelo: ");
                            var denominacion = inputString.nextLine();
                            modelo.setDenominacion(denominacion);
                            System.out.println("Ingrese la cantidad de unidades: ");
                            var cantidad = Integer.parseInt(input.nextLine());
                            modelo.setCantidad(cantidad);
                            accion.agregar(nombreArchivo, modelo);
                        }
                        case 3 -> {
                            String nombreArchivo = "Caracteristicas Tecnicas.txt";
                            System.out.println("Ingrese la denominacion del modelo: ");
                            var modeloDenominacion = inputString.nextLine();
                            caracteristica.setModeloDenominacion(modeloDenominacion);
                            System.out.println("Ingrese el tipo de motor (Nafta, gasoil): ");
                            var tipoMotor = inputString.nextLine();
                            caracteristica.setTipoMotor(tipoMotor);
                            System.out.println("Ingrese la cantidad de cilindros: ");
                            var cilindros = inputString.nextLine();
                            caracteristica.setCilindros(cilindros);
                            System.out.println("Ingrese la cilindrada: ");
                            var cilindrada = Integer.parseInt(input.nextLine());
                            caracteristica.setCilindrada(cilindrada);
                            System.out.println("Ingrese la potencia del motor en HP: ");
                            var HP = Integer.parseInt(input.nextLine());
                            caracteristica.setHP(HP);
                            System.out.println("Ingrese las caracteristicas de la caja (Manual o automatica y la cantidad de velocidades): ");
                            var caja = inputString.nextLine();
                            caracteristica.setCaja(caja);
                            System.out.println("Ingrese el nivel de equipamiento (base o full): ");
                            var equipamiento = inputString.nextLine();
                            caracteristica.setEquipamiento(equipamiento);
                            System.out.println("Ingrese el tipo de carroceria (auto, camioneta, SUV, cantidad de puertas, camion, moto)");
                            var carroceria = inputString.nextLine();
                            caracteristica.setCarroceria(carroceria);
                            System.out.println("Ingrese el id del vehiculo: ");
                            var id = inputString.nextLine();
                            caracteristica.setId(id);
                            accion.agregar(nombreArchivo, caracteristica);
                        }
                        case 4 -> {
                            String nombreArchivo = "Distribuidores.txt";
                            System.out.println("Ingrese el nombre del distribuidor: ");
                            var nombreDistribuidor = inputString.nextLine();
                            distribuidor.setNombreDistribuidor(nombreDistribuidor);
                            System.out.println("Ingrese el pais donde se localiza la sede: ");
                            var pais = inputString.nextLine();
                            distribuidor.setPais(pais);
                            System.out.println("Ingrse la marca distribuida: ");
                            var marcaDistribuida = inputString.nextLine();
                            distribuidor.setMarcaDistribuida(marcaDistribuida);
                            accion.agregar(nombreArchivo, distribuidor);
                        }
                        case 5 -> {
                            String nombreArchivo = "Agencias.txt";
                            System.out.println("Ingrese el nombre de la agencia: ");
                            var nombreAgencia = inputString.nextLine();
                            agencia.setNombreAgencia(nombreAgencia);
                            System.out.println("Ingrese la ciudad donde se ubica la agencia: ");
                            var ciudad = inputString.nextLine();
                            agencia.setCiudad(ciudad);
                            System.out.println("Ingrese el nombre de la marca que comercializa la agencia: ");
                            var marcaComercializada = inputString.nextLine();
                            agencia.setMarcaComercializada(marcaComercializada);
                            accion.agregar(nombreArchivo, agencia);
                        }
                        default -> {
                            System.out.println("La opcion ingresada no existe, ingrese una opcion valida!");
                        }
                    }
                }

                case 3 -> { //Vender Vehiculo
                    System.out.println("A continuacion se solicitan los datos que se le solicitan del vehiculo que desea adquirir: ");
                    System.out.println("Ingrese el tipo de vehiculo (auto, camioneta, moto, camion): ");
                    var tipoVehiculo = inputString.nextLine();
                    modelo.setTipoVehiculo(tipoVehiculo);
                    System.out.println("Ingrese la denominacion del modelo: ");
                    var denominacionModelo = inputString.nextLine();
                    modelo.setDenominacion(denominacionModelo);
                    accion.venderVehiculo(ARCHIVO_MODELOS, denominacionModelo);
                }

                case 4 -> { //Ingresar al service de garantia
                }

                case 5 -> { //Servicio mecanico externo
                }

                case 6 -> { //Listar Marcas
                    accion.listarArchivo(ARCHIVO_MARCAS, marca);
                }

                case 7 -> {
                    accion.listarArchivo(ARCHIVO_MODELOS, modelo);
                }

                case 8 -> { //Listar Caracteristicas Tecnicas
                    accion.listarArchivo(ARCHIVO_CARACTERISTICAS_TEC, caracteristica);
                }

                case 9 -> { //Listar Distribuidores
                    accion.listarArchivo(ARCHIVO_DISTRIBUIDORES, distribuidor);
                }

                case 10 -> { //Listar Agencias
                    accion.listarArchivo(ARCHIVO_AGENCIAS, agencia);
                }
                
                case 11 -> { //Buscar Marca
                    System.out.println("Ingrese el nombre de la marca a buscar:");
                    var nombre = inputString.nextLine();
                    marca.setNombre(nombre);                    
                    System.out.println(datos.buscar(ARCHIVO_MARCAS, marca));
                }

                case 12 -> { //Buscar Modelo
                    System.out.println("Ingrese la deniminacion del modelo: ");
                    var denominacion = inputString.nextLine();
                    modelo.setDenominacion(denominacion);
                    System.out.println(datos.buscar(ARCHIVO_MODELOS, modelo));
                }
                
                case 13 -> { //Buscar Caracteristica Tecnica
                    System.out.println("Ingrese la deniminacion del modelo del cual desea saber las caracteristicas: ");
                    var modeloDenominacion = inputString.nextLine();
                    caracteristica.setModeloDenominacion(modeloDenominacion);
                    System.out.println(datos.buscar(ARCHIVO_CARACTERISTICAS_TEC, caracteristica));
                }

                case 14 -> { //Buscar Distribuidor
                    System.out.println("Ingrese el nombre del distribuidor: ");
                    var nombreDistribuidor = inputString.nextLine();
                    distribuidor.setNombreDistribuidor(nombreDistribuidor);
                    System.out.println(datos.buscar(ARCHIVO_DISTRIBUIDORES, distribuidor));
                }

                case 15 -> { //Buscar Agencia
                    System.out.println("Ingrese el nombre de la agencia: ");
                    var nombreAgencia = inputString.nextLine();
                    agencia.setNombreAgencia(nombreAgencia);
                    System.out.println(datos.buscar(ARCHIVO_AGENCIAS, agencia));
                }

                case 16 -> { //Borrar Archivo
                    var seleccion = 0;
                    System.out.println(""" 
                                        Ingrese el nombre del archivo: 
                                        1 - Marcas.txt
                                        2 - Modelos.txt
                                        3 - Caracteristicas Tecnicas.txt
                                        4 - Distribuidores.txt
                                        5 - Agencias.txt
                                        """);
                    
                    seleccion = Integer.parseInt(input.nextLine());
                    
                    switch (seleccion){
                        case 1 -> {
                            accion.borrarArchivo(ARCHIVO_MARCAS);
                            System.out.println("El archivo Marcas.txt ha sido borrado!");
                        }
                        case 2 -> {
                            accion.borrarArchivo(ARCHIVO_MODELOS);
                            System.out.println("El archivo Modelos.txt ha sido borrado!");
                        }
                        case 3 -> {
                            accion.borrarArchivo(ARCHIVO_CARACTERISTICAS_TEC);
                            System.out.println("El archivo Caracteristicas Tecnicas.txt ha sido borrado!");
                        }
                        case 4 -> {
                            accion.borrarArchivo(ARCHIVO_DISTRIBUIDORES);
                            System.out.println("El archivo Distribuidores.txt ha sido borrado!");
                        }
                        case 5 -> {
                            accion.borrarArchivo(ARCHIVO_AGENCIAS);
                            System.out.println("El archivo Agencias.txt ha sido borrado!");
                        }
                        default -> System.out.println("La opcion ingresada no existe!, ingrese una opcion valida");
                    }
                }

                case 17 -> { //Test control stock
                    System.out.println("Control de stock");
                    System.out.println("Ingrese el modelo: ");
                    var denominacionModelo = inputString.nextLine();
                    modelo.setDenominacion(denominacionModelo);
                    datos.stockModelo(ARCHIVO_MODELOS, denominacionModelo);
                }
                
                case 18 -> { //Test Buscar por indice
                    System.out.println("Ingrese el nombre del modelo a indexar: ");
                    var modeloDenominacion = inputString.nextLine();
                    modelo.setDenominacion(modeloDenominacion);
                    System.out.println(datos.buscarIndice(ARCHIVO_MODELOS, modelo, modeloDenominacion));
                }
                
                case 19 -> { // Test buscar desde metodo en clase
//                    System.out.println("Ingrese el nombre de la agencia: ");
//                    var nombreAgencia = inputString.nextLine();
//                    System.out.println(distribuidor.buscarAgenciaPorNombre(nombreAgencia));
                }
                
                case 20 -> { // Test Solicitar / Recibir unidades
                    System.out.println("Ingrese el nombre del modelo del cual se necesita stock: ");
                    var denominacionModelo = inputString.nextLine();
                    System.out.println("Ingrese la cantidad de unidades solicitadas a incorporar en stock: ");
                    var unidadesRecibidas = Integer.parseInt(input.nextLine());
                    accion.enviarRecibirPedidoDeFabricante(ARCHIVO_MODELOS, modelo, denominacionModelo, unidadesRecibidas);
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
